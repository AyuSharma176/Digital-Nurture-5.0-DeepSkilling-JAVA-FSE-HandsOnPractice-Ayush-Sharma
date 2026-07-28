# Digital Nurture 5.0 — Deep Skilling: Java Full Stack Engineering
### Hands-On Practice | Ayush Sharma

---

## 📋 Overview

This repository contains all hands-on practice assignments completed as part of the **Digital Nurture 5.0 Deep Skilling Program** for Java Full Stack Engineering. The work covers core engineering concepts, design patterns, algorithms, data structures, Spring backend, REST APIs, microservices, PL/SQL, testing frameworks, and frontend development with React and Angular.

---

## 🗂️ Repository Structure

```
root/
├── Engineering concepts/
│   ├── Algorithms_Data Structures/
│   │   ├── EcommerceSearchExample
│   │   ├── EmployeeManagementSystem
│   │   ├── FinancialForecasting
│   │   ├── InventoryManagementSystem
│   │   ├── LibraryManagementSystem
│   │   ├── SortingCustomerOrders
│   │   └── TaskManagementSystem
│   └── DesignPatternandPrinciples/
│       ├── AdapterPatternExample
│       ├── BuilderPatternExample
│       ├── CommandPatternExample
│       ├── DecoratorPatternExample
│       ├── DependencyInjectionExample
│       └── FactoryMethodPatternExample
├── spring-core-maven/
│   ├── Ques1-8/LibraryManagement
│   └── Ques9/LibraryManagement
├── spring-data-jpa-handson/
│   └── orm-learn/
├── spring-rest-handson/
├── Microservices/
├── PLSQLProgramming/
├── JUnit, Mockito and SL4J/
│   └── junit-mockito-practice/
├── React/
├── Angular/
│   └── student-course-portal/
├── GIT/
├── upskilling/
├── .gitignore
└── Readme.md
```

---

## 📅 Weekly Breakdown

### Week 1 — Engineering Concepts ✅

**Folder:** `Engineering concepts/`

Covers fundamental Java engineering concepts split into two categories:

#### Algorithms & Data Structures

| Project | Description |
|---|---|
| `EcommerceSearchExample` | Search algorithms applied to e-commerce product lookup |
| `EmployeeManagementSystem` | Data structure-based employee record management |
| `FinancialForecasting` | Algorithm-driven financial prediction logic |
| `InventoryManagementSystem` | Inventory tracking using efficient data structures |
| `LibraryManagementSystem` | Library catalog management with search & sort |
| `SortingCustomerOrders` | Sorting algorithms applied to customer order data |
| `TaskManagementSystem` | Task scheduling and priority queue implementation |

#### Design Patterns & Principles

| Pattern | Description |
|---|---|
| `AdapterPatternExample` | Structural pattern for interface compatibility |
| `BuilderPatternExample` | Creational pattern for complex object construction |
| `CommandPatternExample` | Behavioral pattern for encapsulating actions |
| `DecoratorPatternExample` | Structural pattern for dynamic behavior extension |
| `DependencyInjectionExample` | IoC principle for loose coupling |
| `FactoryMethodPatternExample` | Creational pattern for object instantiation |

---

### Week 2 — Spring Core (Maven) ✅

**Folder:** `spring-core-maven/`

Hands-on practice with the **Spring Core framework** using Maven as the build tool.

- `Ques1-8/LibraryManagement` — Spring Core concepts covering questions 1 through 8
- `Ques9/LibraryManagement` — Extended Spring Core practice (Question 9)

Topics include Spring beans, dependency injection, application context, and Maven project structure.

---

### Week 3 — Spring Data JPA & ORM ✅

**Folder:** `spring-data-jpa-handson/`

Hands-on practice with **Spring Data JPA**, Object-Relational Mapping (ORM), HQL, and Criteria Query.

Project: `spring-data-jpa-handson/orm-learn`

#### Hands-on Breakdown

| # | Title | Key Concept |
|---|---|---|
| 1 | HQL & JPQL Introduction | Theory — HQL vs JPQL differences |
| 2 | Get All Permanent Employees | `@Query` with HQL, `left join fetch` for single-query optimization |
| 3 | Fetch Quiz Attempt Details | Multi-table HQL join across 6 tables (user, attempt, attempt_question, question, attempt_option, options) |
| 4 | Average Salary by Department | HQL aggregate function `AVG()` with `@Param` binding |
| 5 | Get All Employees (Native Query) | `nativeQuery = true` with raw SQL |
| 6 | Criteria Query | Dynamic query building with `CriteriaBuilder`, `CriteriaQuery`, `Root`, `Predicate`, `TypedQuery` |

#### Entities Created

| Entity | Table |
|---|---|
| `Country` | `country` |
| `Department` | `department` |
| `Employee` | `employee` |
| `Skill` | `skill` |
| `Stock` | `stock` |
| `User` | `user` |
| `Question` | `question` |
| `Options` | `options` |
| `Attempt` | `attempt` |
| `AttemptQuestion` | `attempt_question` |
| `AttemptOption` | `attempt_option` |

#### Key Takeaways
- `join` links tables in HQL but does **not** populate Java beans
- `join fetch` links tables **and** populates beans — results in a single optimized SQL query
- Using `List` for multiple `fetch` joins causes `MultipleBagFetchException` — use `Set` instead
- Bidirectional relationships require `@EqualsAndHashCode.Exclude` on back-references to prevent `StackOverflowError`
- Native queries bypass HQL entirely and use raw SQL directly — useful but reduces DB portability
- Criteria Query enables fully dynamic `WHERE` clauses built programmatically at runtime

---

### Week 4 — Spring REST ✅

**Folder:** `spring-rest-handson/`

Hands-on practice building **RESTful APIs** using Spring Boot.

Topics include:
- REST controllers with `@RestController`, `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`
- Path variables and request params with `@PathVariable`, `@RequestParam`
- Request/response body handling with `@RequestBody`
- Global exception handling with `@ControllerAdvice` and `@ExceptionHandler`
- HTTP status codes and `ResponseEntity`

---

### Week 5 — Microservices ✅

**Folder:** `Microservices/`

Hands-on practice with **Microservices Architecture** using Spring Cloud.

Topics include:
- Microservices design principles and patterns
- Eureka Service Registry and Discovery
- Spring Cloud API Gateway
- Inter-service REST communication with `RestTemplate` / `WebClient`
- Centralized configuration

---

### Week 6 — PL/SQL Programming ✅
**Folder:** `React/`

Hands-on practice building **frontend applications** with React.

Topics include:
- Functional components and JSX
- `useState` and `useEffect` hooks
- Props and component composition
- Conditional rendering and lists
- API integration with `fetch` / `axios`

**Folder:** `PLSQLProgramming/`

Hands-on practice with **Oracle PL/SQL** for database-side programming.

Topics include:
- Anonymous and named PL/SQL blocks
- Stored procedures and functions
- Implicit and explicit cursors
- Triggers (BEFORE / AFTER)
- Exception handling in PL/SQL

---

### Week 7 — JUnit, Mockito & SLF4J ✅

**Folder:** `JUnit, Mockito and SL4J/junit-mockito-practice/`

Hands-on practice with **unit testing and logging** in Java.

Topics include:
- Writing unit tests with **JUnit 5** (`@Test`, `@BeforeEach`, `@AfterEach`, assertions)
- Mocking dependencies with **Mockito** (`@Mock`, `@InjectMocks`, `when()`, `verify()`, `ArgumentCaptor`)
- Logging with **SLF4J** and Logback

---

## 🛠️ Technologies Used

- **Language:** Java 17+
- **Frameworks:** Spring Core, Spring Data JPA, Spring Boot, Spring REST, Spring Cloud
- **Frontend:** React, Angular
- **Database:** MySQL 8.0, Oracle (PL/SQL)
- **ORM:** Hibernate / JPA
- **Build Tool:** Maven (including Maven Wrapper `mvnw`)
- **Testing:** JUnit 5, Mockito
- **Logging:** SLF4J, Logback
- **Libraries:** Lombok, HikariCP
- **Version Control:** Git & GitHub

---

## 🚀 Getting Started

### Prerequisites
- Java 17+
- Maven 3.6+
- MySQL 8.0+ / Oracle DB (for PL/SQL)
- Node.js & npm (for React & Angular)
- IDE (IntelliJ IDEA / Eclipse / VS Code)

### Clone the Repository

```bash
git clone https://github.com/AyuSharma176/Digital-Nurture-5.0-DeepSkilling-JAVA-FSE-HandsOnPractice-Ayush-Sharma.git
cd Digital-Nurture-5.0-DeepSkilling-JAVA-FSE-HandsOnPractice-Ayush-Sharma
```

### Run a Spring Project

```bash
cd spring-rest-handson
mvn clean install
mvn spring-boot:run
```

### Run React App

```bash
cd React
npm install
npm start
```

### Run Angular App

```bash
cd Angular/student-course-portal
npm install
ng serve
```

### Database Config (Spring JPA/REST projects)

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ormlearn
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=validate
```

---

## 👤 Author

**Ayush Sharma**
GitHub: [@AyuSharma176](https://github.com/AyuSharma176)

---

## 📌 Program Details

| Detail | Info |
|---|---|
| Program | Digital Nurture 5.0 |
| Track | Java Full Stack Engineering (FSE) |
| Type | Deep Skilling — Hands-On Practice |
| Total Commits | 59+ |
| Status | Week 1 ✅ \| Week 2 ✅ \| Week 3 ✅ \| Week 4 ✅ \| Week 5 ✅ \| Week 6 ✅ \| Week 7 ✅|
