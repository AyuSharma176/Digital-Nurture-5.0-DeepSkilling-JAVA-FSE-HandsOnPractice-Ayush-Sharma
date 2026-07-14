# Digital Nurture 5.0 — Deep Skilling: Java Full Stack Engineering
### Hands-On Practice | Ayush Sharma

---

## 📋 Overview

This repository contains all hands-on practice assignments completed as part of the **Digital Nurture 5.0 Deep Skilling Program** for Java Full Stack Engineering. The work is organized week-wise across dedicated branches, covering core engineering concepts, design patterns, algorithms, data structures, and Spring-based backend development.

---

## 🗂️ Repository Structure

```
main
├── Week1_Assignment         (branch)
│   └── Engineering concepts/
│       ├── Algorithms_Data Structures/
│       │   ├── EcommerceSearchExample
│       │   ├── EmployeeManagementSystem
│       │   ├── FinancialForecasting
│       │   ├── InventoryManagementSystem
│       │   ├── LibraryManagementSystem
│       │   ├── SortingCustomerOrders
│       │   └── TaskManagementSystem
│       └── DesignPatternandPrinciples/
│           ├── AdapterPatternExample
│           ├── BuilderPatternExample
│           ├── CommandPatternExample
│           ├── DecoratorPatternExample
│           ├── DependencyInjectionExample
│           └── FactoryMethodPatternExample
│
├── Week2_Assignment         (branch)
│   └── spring-core-maven/
│       ├── Ques1-8/LibraryManagement
│       └── Ques9/LibraryManagement
│
└── Week3_Assignment         (branch)
    └── spring-data-jpa-handson/orm-learn/
       
```

---

## 📅 Weekly Breakdown

### Week 1 — Engineering Concepts ✅

**Branch:** `Week1_Assignment`

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

**Branch:** `Week2_Assignment`

Hands-on practice with the **Spring Core framework** using Maven as the build tool.

- `Ques1-8/LibraryManagement` — Spring Core concepts covering questions 1 through 8
- `Ques9/LibraryManagement` — Extended Spring Core practice (Question 9)

Topics include Spring beans, dependency injection, application context, and Maven project structure.

---

### Week 3 — Spring Data JPA & ORM ✅

**Branch:** `Week3_Assignment`

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

## 🛠️ Technologies Used

- **Language:** Java 25
- **Frameworks:** Spring Core, Spring Data JPA, Spring Boot 4.1.0
- **Build Tool:** Maven (including Maven Wrapper `mvnw`)
- **ORM:** Hibernate 7.4.1 / JPA
- **Database:** MySQL 8.0
- **Libraries:** Lombok, HikariCP
- **Version Control:** Git & GitHub

---

## 🚀 Getting Started

### Prerequisites
- Java 17+
- Maven 3.6+
- MySQL 8.0+
- IDE (IntelliJ IDEA / Eclipse / VS Code)

### Running a Project

1. Clone the repository and switch to the relevant branch:
   ```bash
   git clone https://github.com/AyuSharma176/Digital-Nurture-5.0-DeepSkilling-JAVA-FSE-HandsOnPractice-Ayush-Sharma.git
   cd Digital-Nurture-5.0-DeepSkilling-JAVA-FSE-HandsOnPractice-Ayush-Sharma
   git checkout Week1_Assignment   # or Week2_Assignment / Week3_Assignment
   ```

2. Navigate to the project folder and build:
   ```bash
   cd "Engineering concepts/Algorithms_Data Structures/LibraryManagementSystem"
   mvn clean install
   ```

3. Run the application:
   ```bash
   mvn spring-boot:run
   # or for plain Java projects:
   java -cp target/classes com.example.Main
   ```

4. For Week 3 (Spring Data JPA), configure your database in `application.properties`:
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
| Branches | `Week1_Assignment`, `Week2_Assignment`, `Week3_Assignment` |
| Total Commits | 10+ |
| Status | Week 1 ✅ \| Week 2 ✅ \| Week 3 ✅ |
