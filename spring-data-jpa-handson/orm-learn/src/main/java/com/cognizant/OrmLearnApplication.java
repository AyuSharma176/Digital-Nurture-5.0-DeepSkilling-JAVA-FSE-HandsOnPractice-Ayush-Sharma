package com.cognizant;

import com.cognizant.model.*;
import com.cognizant.repository.StockRepository;
import com.cognizant.service.AttemptService;
import com.cognizant.service.EmployeeService;
import com.cognizant.service.DepartmentService;
import com.cognizant.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    @Autowired
    private StockRepository stockRepository;

    private static EmployeeService employeeService;
    private static DepartmentService departmentService;
    private static SkillService skillService;

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static AttemptService attemptService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication
                .run(OrmLearnApplication.class, args);

        OrmLearnApplication app = context.getBean(OrmLearnApplication.class);

        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);
        skillService = context.getBean(SkillService.class);

        attemptService = context.getBean(AttemptService.class);
        // Stock tests - comment when testing employee
        // app.testFacebookSeptember2019();
        // app.testGoogleCloseGreaterThan1250();
        // app.testTop3HighestVolume();
        // app.testTop3LowestNetflix();

        // Employee tests - uncomment one at a time
//        testGetEmployee();
//         testAddEmployee();
//         testUpdateEmployee();
//        app.testGetDepartment();
//        app.testAddSkillToEmployee();
//        testGetAllPermanentEmployees();
//        testGetAttemptDetails();
//        testGetAverageSalary();
        testGetAllEmployeesNative();
        testGetEmployeesBySalaryRange();
    }

    // ==================== STOCK METHODS ====================

    public void testFacebookSeptember2019() {
        System.out.println("\n--- Facebook Stocks Sep 2019 ---");
        List<Stock> list = stockRepository.findByCodeAndDateBetween(
                "FB",
                LocalDate.of(2019, 9, 1),
                LocalDate.of(2019, 9, 30)
        );
        list.forEach(s -> System.out.println(
                s.getCode() + " | " + s.getDate() +
                        " | " + s.getOpen() + " | " + s.getClose() +
                        " | " + s.getVolume()));
    }

    public void testGoogleCloseGreaterThan1250() {
        System.out.println("\n--- Google Stocks Close > 1250 ---");
        List<Stock> list = stockRepository
                .findByCodeAndCloseGreaterThan("GOOGL", 1250.0);
        list.forEach(s -> System.out.println(
                s.getCode() + " | " + s.getDate() +
                        " | " + s.getOpen() + " | " + s.getClose() +
                        " | " + s.getVolume()));
    }

    public void testTop3HighestVolume() {
        System.out.println("\n--- Top 3 Highest Volume ---");
        List<Stock> list = stockRepository.findTop3ByOrderByVolumeDesc();
        list.forEach(s -> System.out.println(
                s.getCode() + " | " + s.getDate() +
                        " | " + s.getOpen() + " | " + s.getClose() +
                        " | " + s.getVolume()));
    }

    public void testTop3LowestNetflix() {
        System.out.println("\n--- Top 3 Lowest Netflix Stocks ---");
        List<Stock> list = stockRepository
                .findTop3ByCodeOrderByCloseAsc("NFLX");
        list.forEach(s -> System.out.println(
                s.getCode() + " | " + s.getDate() +
                        " | " + s.getOpen() + " | " + s.getClose() +
                        " | " + s.getVolume()));
    }

    // ==================== EMPLOYEE METHODS ====================

    private static void testGetEmployee() {
        System.out.println("\n--- Get Employee ---");
        Employee employee = employeeService.get(2);
        System.out.println("Employee: " + employee);
        System.out.println("Department: " + employee.getDepartment());
    }

    private static void testAddEmployee() {
        System.out.println("\n--- Add Employee ---");
        Employee employee = new Employee();
        employee.setName("Ayush");
        employee.setSalary(50000);
        employee.setPermanent(true);
        employee.setDateOfBirth(new Date());
        Department department = departmentService.get(1);
        employee.setDepartment(department);
        employeeService.save(employee);
        System.out.println("Saved: " + employee);
    }

    private static void testUpdateEmployee() {
        System.out.println("\n--- Update Employee ---");
        Employee employee = employeeService.get(2);
        Department department = departmentService.get(2);
        employee.setDepartment(department);
        employeeService.save(employee);
        System.out.println("Updated: " + employee);
    }
    private void testGetDepartment() {
        System.out.println("\n--- Get Department ---");
        Department department = departmentService.get(1);
        System.out.println("Department: " + department.getName());
        System.out.println("Employee count: " + department.getEmployeeList().size());
        department.getEmployeeList()
                .forEach(e -> System.out.println("Employee: " + e.getName()));
    }

    private void testGetEmployeeSkills() {
        System.out.println("\n--- Employee Skills ---");
        Employee employee = employeeService.get(2);
        System.out.println("Employee: " + employee.getName());
        employee.getSkillList()
                .forEach(s -> System.out.println("Skill: " + s.getName()));
    }

    private void testAddSkillToEmployee() {
        System.out.println("\n--- Add Skill to Employee ---");
        Employee employee = employeeService.get(2);
        Skill skill = skillService.get(1);
        employee.getSkillList().add(skill);
        employeeService.save(employee);
        System.out.println("Skill added successfully!");
    }
    private static void testGetAllPermanentEmployees() {
        LOGGER.info("Start");
        List<Employee> employees = employeeService.getAllPermanentEmployees();
        LOGGER.debug("Permanent Employees: {}", employees);
        employees.forEach(e -> LOGGER.debug("Skills: {}", e.getSkillList()));
        LOGGER.info("End");
    }
    private static void testGetAttemptDetails() {
        LOGGER.info("Start");
        Attempt attempt = attemptService.getAttempt(1, 1);
        LOGGER.debug("User: {}", attempt.getUser().getName());
        LOGGER.debug("Date: {}", attempt.getDate());

        attempt.getAttemptQuestionList().forEach(aq -> {
            LOGGER.debug("Question: {}", aq.getQuestion().getText());
            aq.getAttemptOptionList().forEach(ao ->
                    LOGGER.debug("  {})  {}  {}  {}",
                            ao.getOption().getId(),
                            ao.getOption().getText(),
                            aq.getQuestion().getScore(),
                            ao.isSelected())
            );
        });
        LOGGER.info("End");
    }
    private static void testGetAverageSalary() {
        LOGGER.info("Start");
        double avgSalary = employeeService.getAverageSalary(1);
        LOGGER.debug("Average Salary for department 1: {}", avgSalary);
        LOGGER.info("End");
    }

    private static void testGetAllEmployeesNative() {
        LOGGER.info("Start");
        List<Employee> employees = employeeService.getAllEmployeesNative();
        LOGGER.debug("Employees: {}", employees);
        LOGGER.info("End");
    }
    private static void testGetEmployeesBySalaryRange() {
        LOGGER.info("Start");
        List<Employee> employees = employeeService.getAllEmployeesBySalaryRange(40000, 60000);
        LOGGER.debug("Employees in salary range: {}", employees);
        LOGGER.info("End");
    }
}