-- Exercise 1: Control Structures

-- Scenario 1: Apply 1% discount on loan interest rate for customers above 60

BEGIN
    FOR c IN (SELECT CustomerID, DOB FROM Customers) LOOP
        IF MONTHS_BETWEEN(SYSDATE, c.DOB) / 12 > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = c.CustomerID;
        END IF;
    END LOOP;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Done. Discount applied for senior customers.');
END;
/


-- Scenario 2: Mark customers as VIP if their balance is more than 10000

BEGIN
    FOR c IN (SELECT CustomerID, Balance FROM Customers) LOOP
        IF c.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = c.CustomerID;
        END IF;
    END LOOP;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('VIP status updated.');
END;
/


-- Scenario 3: Print reminder for loans due in next 30 days

BEGIN
    FOR l IN (
        SELECT l.LoanID, c.Name, l.EndDate
        FROM Loans l
        JOIN Customers c ON c.CustomerID = l.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: ' || l.Name || ', your loan ID ' || l.LoanID || ' is due on ' || TO_CHAR(l.EndDate, 'DD-MON-YYYY'));
    END LOOP;
END;
/


-- Exercise 2: Error Handling

-- Scenario 1: Transfer funds safely between two accounts

CREATE OR REPLACE PROCEDURE SafeTransferFunds(
    fromAcc IN NUMBER,
    toAcc IN NUMBER,
    amt IN NUMBER
)
AS
    bal NUMBER;
    low_balance EXCEPTION;
BEGIN
    SELECT Balance INTO bal
    FROM Accounts
    WHERE AccountID = fromAcc
    FOR UPDATE;

    IF bal < amt THEN
        RAISE low_balance;
    END IF;

    UPDATE Accounts SET Balance = Balance - amt WHERE AccountID = fromAcc;
    UPDATE Accounts SET Balance = Balance + amt WHERE AccountID = toAcc;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Transfer done. Amount: ' || amt);

EXCEPTION
    WHEN low_balance THEN
        ROLLBACK;
        INSERT INTO ErrorLog(ErrorMsg) VALUES('Not enough balance in account ' || fromAcc);
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Error: Not enough balance.');
    WHEN OTHERS THEN
        ROLLBACK;
        INSERT INTO ErrorLog(ErrorMsg) VALUES(SQLERRM);
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Something went wrong: ' || SQLERRM);
END SafeTransferFunds;
/


-- Scenario 2: Update employee salary, handle if employee not found

CREATE OR REPLACE PROCEDURE UpdateSalary(
    empId IN NUMBER,
    pct IN NUMBER
)
AS
    cnt NUMBER;
BEGIN
    SELECT COUNT(*) INTO cnt FROM Employees WHERE EmployeeID = empId;

    IF cnt = 0 THEN
        RAISE NO_DATA_FOUND;
    END IF;

    UPDATE Employees
    SET Salary = Salary + (Salary * pct / 100)
    WHERE EmployeeID = empId;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Salary updated for employee ' || empId);

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        INSERT INTO ErrorLog(ErrorMsg) VALUES('Employee ' || empId || ' not found');
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Error: Employee not found.');
    WHEN OTHERS THEN
        INSERT INTO ErrorLog(ErrorMsg) VALUES(SQLERRM);
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END UpdateSalary;
/


-- Scenario 3: Add new customer, handle if ID already exists

CREATE OR REPLACE PROCEDURE AddNewCustomer(
    cid IN NUMBER,
    cname IN VARCHAR2,
    cdob IN DATE,
    cbal IN NUMBER
)
AS
    already_exists EXCEPTION;
    PRAGMA EXCEPTION_INIT(already_exists, -00001);
BEGIN
    INSERT INTO Customers(CustomerID, Name, DOB, Balance, LastModified)
    VALUES(cid, cname, cdob, cbal, SYSDATE);

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Customer added: ' || cname);

EXCEPTION
    WHEN already_exists THEN
        INSERT INTO ErrorLog(ErrorMsg) VALUES('Customer ID ' || cid || ' already exists');
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Error: Customer ID already exists.');
    WHEN OTHERS THEN
        INSERT INTO ErrorLog(ErrorMsg) VALUES(SQLERRM);
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END AddNewCustomer;
/


-- Exercise 3: Stored Procedures

-- Scenario 1: Add 1% interest to all savings accounts

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
AS
BEGIN
    UPDATE Accounts
    SET Balance = Balance * 1.01,
        LastModified = SYSDATE
    WHERE AccountType = 'Savings';

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Interest added to savings accounts. Rows: ' || SQL%ROWCOUNT);
END ProcessMonthlyInterest;
/


-- Scenario 2: Give bonus to employees in a department

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    dept IN VARCHAR2,
    bonusPct IN NUMBER
)
AS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * bonusPct / 100)
    WHERE Department = dept;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Bonus given to ' || SQL%ROWCOUNT || ' employees in ' || dept);
END UpdateEmployeeBonus;
/


-- Scenario 3: Transfer money between accounts after checking balance

CREATE OR REPLACE PROCEDURE TransferFunds(
    fromAcc IN NUMBER,
    toAcc IN NUMBER,
    amt IN NUMBER
)
AS
    bal NUMBER;
BEGIN
    SELECT Balance INTO bal
    FROM Accounts
    WHERE AccountID = fromAcc
    FOR UPDATE;

    IF bal < amt THEN
        RAISE_APPLICATION_ERROR(-20001, 'Not enough balance in account ' || fromAcc);
    END IF;

    UPDATE Accounts SET Balance = Balance - amt WHERE AccountID = fromAcc;
    UPDATE Accounts SET Balance = Balance + amt WHERE AccountID = toAcc;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Transferred ' || amt || ' from acc ' || fromAcc || ' to acc ' || toAcc);

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Account not found.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END TransferFunds;
/


-- Exercise 4: Functions

-- Scenario 1: Calculate age of customer from date of birth

CREATE OR REPLACE FUNCTION CalculateAge(dob IN DATE)
RETURN NUMBER
AS
BEGIN
    RETURN FLOOR(MONTHS_BETWEEN(SYSDATE, dob) / 12);
END CalculateAge;
/


-- Scenario 2: Calculate monthly EMI for a loan

CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    loanAmt IN NUMBER,
    rate IN NUMBER,
    years IN NUMBER
)
RETURN NUMBER
AS
    monthlyRate NUMBER;
    months NUMBER;
    emi NUMBER;
BEGIN
    monthlyRate := rate / (12 * 100);
    months := years * 12;

    IF monthlyRate = 0 THEN
        emi := loanAmt / months;
    ELSE
        emi := loanAmt * (monthlyRate * POWER(1 + monthlyRate, months)) / (POWER(1 + monthlyRate, months) - 1);
    END IF;

    RETURN ROUND(emi, 2);
END CalculateMonthlyInstallment;
/


-- Scenario 3: Check if account has enough balance

CREATE OR REPLACE FUNCTION HasSufficientBalance(
    accId IN NUMBER,
    amt IN NUMBER
)
RETURN NUMBER
AS
    bal NUMBER;
BEGIN
    SELECT Balance INTO bal FROM Accounts WHERE AccountID = accId;

    IF bal >= amt THEN
        RETURN 1;
    ELSE
        RETURN 0;
    END IF;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 0;
END HasSufficientBalance;
/


-- Exercise 5: Triggers

-- Scenario 1: Auto update LastModified when customer record changes

CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
    :NEW.LastModified := SYSDATE;
END UpdateCustomerLastModified;
/


-- Scenario 2: Save a log every time a transaction is added

CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog(TransactionID, AccountID, Amount, TransactionType, LogDate)
    VALUES(:NEW.TransactionID, :NEW.AccountID, :NEW.Amount, :NEW.TransactionType, SYSDATE);
END LogTransaction;
/


-- Scenario 3: Block invalid deposits and withdrawals

CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
    bal NUMBER;
BEGIN
    IF :NEW.TransactionType = 'Deposit' AND :NEW.Amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20002, 'Deposit amount must be positive.');
    END IF;

    IF :NEW.TransactionType = 'Withdrawal' THEN
        SELECT Balance INTO bal FROM Accounts WHERE AccountID = :NEW.AccountID;
        IF bal < :NEW.Amount THEN
            RAISE_APPLICATION_ERROR(-20003, 'Not enough balance to withdraw.');
        END IF;
    END IF;
END CheckTransactionRules;
/


-- Exercise 6: Cursors

-- Scenario 1: Print monthly statement for each customer

DECLARE
    CURSOR GenerateMonthlyStatements IS
        SELECT c.Name, t.TransactionID, t.TransactionDate, t.Amount, t.TransactionType
        FROM Transactions t
        JOIN Accounts a ON a.AccountID = t.AccountID
        JOIN Customers c ON c.CustomerID = a.CustomerID
        WHERE TRUNC(t.TransactionDate, 'MM') = TRUNC(SYSDATE, 'MM')
        ORDER BY c.Name, t.TransactionDate;

    prevName Customers.Name%TYPE := NULL;
BEGIN
    FOR rec IN GenerateMonthlyStatements LOOP
        IF prevName IS NULL OR rec.Name != prevName THEN
            DBMS_OUTPUT.PUT_LINE('--- ' || rec.Name || ' ---');
            prevName := rec.Name;
        END IF;
        DBMS_OUTPUT.PUT_LINE(TO_CHAR(rec.TransactionDate, 'DD-MON-YYYY') || ' | ' || rec.TransactionType || ' | ' || rec.Amount);
    END LOOP;
END;
/


-- Scenario 2: Deduct annual fee from all accounts

DECLARE
    fee NUMBER := 50;
    CURSOR ApplyAnnualFee IS
        SELECT AccountID FROM Accounts FOR UPDATE;
BEGIN
    FOR acc IN ApplyAnnualFee LOOP
        UPDATE Accounts
        SET Balance = Balance - fee,
            LastModified = SYSDATE
        WHERE AccountID = acc.AccountID;
        DBMS_OUTPUT.PUT_LINE('Fee deducted from account: ' || acc.AccountID);
    END LOOP;
    COMMIT;
END;
/


-- Scenario 3: Update interest rates on all loans based on duration

DECLARE
    CURSOR UpdateLoanInterestRates IS
        SELECT LoanID, StartDate, EndDate FROM Loans FOR UPDATE;

    newRate NUMBER;
    dur NUMBER;
BEGIN
    FOR loan IN UpdateLoanInterestRates LOOP
        dur := MONTHS_BETWEEN(loan.EndDate, loan.StartDate) / 12;

        IF dur <= 5 THEN
            newRate := 6.5;
        ELSE
            newRate := 7.5;
        END IF;

        UPDATE Loans SET InterestRate = newRate WHERE LoanID = loan.LoanID;
        DBMS_OUTPUT.PUT_LINE('Loan ' || loan.LoanID || ' new rate: ' || newRate || '%');
    END LOOP;
    COMMIT;
END;
/


-- Exercise 7: Packages

-- Scenario 1: Package for customer operations

CREATE OR REPLACE PACKAGE CustomerManagement AS
    PROCEDURE AddCustomer(cid IN NUMBER, cname IN VARCHAR2, cdob IN DATE, cbal IN NUMBER);
    PROCEDURE UpdateCustomer(cid IN NUMBER, cname IN VARCHAR2, cbal IN NUMBER);
    FUNCTION GetBalance(cid IN NUMBER) RETURN NUMBER;
END CustomerManagement;
/

CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

    PROCEDURE AddCustomer(cid IN NUMBER, cname IN VARCHAR2, cdob IN DATE, cbal IN NUMBER) AS
    BEGIN
        INSERT INTO Customers(CustomerID, Name, DOB, Balance, LastModified)
        VALUES(cid, cname, cdob, cbal, SYSDATE);
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Customer added: ' || cname);
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Error: Customer ID already exists.');
    END AddCustomer;

    PROCEDURE UpdateCustomer(cid IN NUMBER, cname IN VARCHAR2, cbal IN NUMBER) AS
    BEGIN
        UPDATE Customers
        SET Name = cname, Balance = cbal, LastModified = SYSDATE
        WHERE CustomerID = cid;

        IF SQL%ROWCOUNT = 0 THEN
            DBMS_OUTPUT.PUT_LINE('Customer not found.');
        ELSE
            COMMIT;
            DBMS_OUTPUT.PUT_LINE('Customer updated.');
        END IF;
    END UpdateCustomer;

    FUNCTION GetBalance(cid IN NUMBER) RETURN NUMBER AS
        bal NUMBER;
    BEGIN
        SELECT Balance INTO bal FROM Customers WHERE CustomerID = cid;
        RETURN bal;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN RETURN NULL;
    END GetBalance;

END CustomerManagement;
/


-- Scenario 2: Package for employee operations

CREATE OR REPLACE PACKAGE EmployeeManagement AS
    PROCEDURE HireEmployee(eid IN NUMBER, ename IN VARCHAR2, epos IN VARCHAR2, esal IN NUMBER, edept IN VARCHAR2, ehire IN DATE);
    PROCEDURE UpdateEmployee(eid IN NUMBER, epos IN VARCHAR2, esal IN NUMBER, edept IN VARCHAR2);
    FUNCTION AnnualSalary(eid IN NUMBER) RETURN NUMBER;
END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

    PROCEDURE HireEmployee(eid IN NUMBER, ename IN VARCHAR2, epos IN VARCHAR2, esal IN NUMBER, edept IN VARCHAR2, ehire IN DATE) AS
    BEGIN
        INSERT INTO Employees(EmployeeID, Name, Position, Salary, Department, HireDate)
        VALUES(eid, ename, epos, esal, edept, ehire);
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Employee hired: ' || ename);
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Error: Employee ID already exists.');
    END HireEmployee;

    PROCEDURE UpdateEmployee(eid IN NUMBER, epos IN VARCHAR2, esal IN NUMBER, edept IN VARCHAR2) AS
    BEGIN
        UPDATE Employees
        SET Position = epos, Salary = esal, Department = edept
        WHERE EmployeeID = eid;

        IF SQL%ROWCOUNT = 0 THEN
            DBMS_OUTPUT.PUT_LINE('Employee not found.');
        ELSE
            COMMIT;
            DBMS_OUTPUT.PUT_LINE('Employee updated.');
        END IF;
    END UpdateEmployee;

    FUNCTION AnnualSalary(eid IN NUMBER) RETURN NUMBER AS
        sal NUMBER;
    BEGIN
        SELECT Salary INTO sal FROM Employees WHERE EmployeeID = eid;
        RETURN sal * 12;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN RETURN NULL;
    END AnnualSalary;

END EmployeeManagement;
/


-- Scenario 3: Package for account operations

CREATE OR REPLACE PACKAGE AccountOperations AS
    PROCEDURE OpenAccount(aid IN NUMBER, cid IN NUMBER, atype IN VARCHAR2, bal IN NUMBER);
    PROCEDURE CloseAccount(aid IN NUMBER);
    FUNCTION TotalBalance(cid IN NUMBER) RETURN NUMBER;
END AccountOperations;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations AS

    PROCEDURE OpenAccount(aid IN NUMBER, cid IN NUMBER, atype IN VARCHAR2, bal IN NUMBER) AS
    BEGIN
        INSERT INTO Accounts(AccountID, CustomerID, AccountType, Balance, LastModified)
        VALUES(aid, cid, atype, bal, SYSDATE);
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Account opened: ' || aid);
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Error: Account ID already exists.');
    END OpenAccount;

    PROCEDURE CloseAccount(aid IN NUMBER) AS
    BEGIN
        DELETE FROM Accounts WHERE AccountID = aid;

        IF SQL%ROWCOUNT = 0 THEN
            DBMS_OUTPUT.PUT_LINE('Account not found.');
        ELSE
            COMMIT;
            DBMS_OUTPUT.PUT_LINE('Account closed: ' || aid);
        END IF;
    END CloseAccount;

    FUNCTION TotalBalance(cid IN NUMBER) RETURN NUMBER AS
        total NUMBER;
    BEGIN
        SELECT NVL(SUM(Balance), 0) INTO total FROM Accounts WHERE CustomerID = cid;
        RETURN total;
    END TotalBalance;

END AccountOperations;
/
