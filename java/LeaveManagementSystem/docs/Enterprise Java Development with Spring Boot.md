## Enterprise Java Development with Spring Boot, Oracle 26ai and GitHub Copilot Agent.
- Every topic should be tied back to our Leave Management application.

### Part 1 — Java for Spring Boot

- Purpose

- Learn only the Java required for enterprise development.

- Not everything Java offers.

#### Lessons:
- Java Project Structure (Project structure of the Leave Management System)
- Classes and Objects
- Packages
- Practice (Demo and Exercise)
- Interfaces
- Practice (Demo and Exercise)
- Inheritance
- Practice (Demo and Exercise)
- Records
- Practice (Demo and Exercise)
- Enums
- Practice (Demo and Exercise)
- Exceptions
- Practice (Demo and Exercise)
- Generics
- Practice (Demo and Exercise)
- Collections
- Practice (Demo and Exercise)
- Streams
- Practice (Demo and Exercise)
- Optional
- Lambdas
- Practice (Demo and Exercise)
- Dependency Injection Concepts (Java side)
- Practice (Demo and Exercise)
- Generics
- Practice (Demo and Exercise)
- Java Modules (brief)
- Practice (Demo and Exercise)
- Modern Java Features used in Spring
- Practice (Demo and Exercise)

### Part 2 – Java Enterprise Foundations (NEW)

- Because Spring Boot is an evolution of these technologies.

- Without understanding them, Spring Boot often looks like magic.

#### Module 1 – HTTP Fundamentals
- Client-Server Architecture
- HTTP Request/Response
- HTTP Methods
- Headers
- Cookies
- Sessions
- Stateless vs Stateful
- REST Basics

#### Module 2 – Servlets

- This is probably the most important prerequisite.

##### Lessons:
- What is a Servlet?
- Servlet Life Cycle
- HttpServlet
- doGet()
- doPost()
- Request
- Response
- RequestDispatcher
- Session Management
- Filters
- Listeners
- Practice (Demo and Exercise)

- We'll even build one tiny servlet application.

- Only enough to appreciate why Spring MVC exists.

#### Module 3 – JSP (Brief)

- Not because we'll use it.

- Because you'll encounter it in legacy systems.

##### Topics:
- JSP
- Expression Language
- JSTL
- Why JSP became less popular
- Practice (Demo and Exercise)

#### Module 4 – JDBC

##### Very important for us.

- Topics:

- JDBC Architecture
- DriverManager
- Connection
- Statement
- PreparedStatement
- CallableStatement
- ResultSet
- Practice (Demo and Exercise)
- Then we'll connect to Oracle.

#### Module 5 – JPA

- Not implementation.

- Concepts.

##### Topics:

- What is persistence?
- ORM
- Entity
- EntityManager
- Repository Pattern
- Why ORMs exist
- Practice (Demo and Exercise) if applicable.

#### Module 6 – Hibernate

- Again, not because we'll use it.But because every Spring developer should understand it.

##### Topics:

- Hibernate Architecture
- Session
- Lazy Loading
- Eager Loading
- HQL
- Mapping
- Caching
- N+1 Query Problem
- Practice (Demo and Exercise)

### Part 3 – Spring Framework Fundamentals

#### Lessons
- Why Spring?
- IoC
- DI
- Beans
- Bean Lifecycle
- Component Scanning
- Configuration
- Spring Context
- Practice (Demo and Exercise) if applicable

### Part 4 — Spring Boot Fundamentals

- Purpose: Understand Spring.

#### Lessons

- What is Spring?
- Spring vs Spring Boot
- Maven Multi-module Projects
- Dependency Injection
- Spring Bean Lifecycle
- Component Scanning
- Configuration
- Profiles
- application.yml
- Logging
- Configuration Properties
- Practice (Demo and Exercise)

### Part 5 — REST API Development

#### Lessons

- Spring MVC
- REST Controllers
- Request Mapping
- Request DTOs
- Response DTOs
- Validation
- Exception Handling
- Global Exception Handler
- Swagger/OpenAPI
- Practice (Demo and Exercise)

### Part 6 — Oracle Integration

- This is where our Oracle design comes back.

#### Lessons

- Oracle JDBC
- Connection Pooling
- Spring JDBC
- SimpleJdbcCall
- Calling Oracle Packages
- REF CURSOR
- Transactions
- Exception Translation
- Package Client Pattern
- Practice (Demo and Exercise)

### Part 7 — Enterprise Architecture

#### Lessons

- Domain Layer
- Application Layer
- Infrastructure Layer
- Repository Pattern
- DTO Mapping
- Configuration
- Dependency Injection Review
- Practice (Demo and Exercise) if applicable

### Part 8 — Testing

#### Lessons

- JUnit
- Mockito
- Repository Tests
- Service Tests
- Controller Tests
- Integration Tests
- Practice (Demo and Exercise)

### Part 9 — AI Engineering

- This is unique.

#### Lessons

- AI Skills
- Prompt Library
- Agent Design
- Code Review Skills
- SQL Review Skills
- TDD Generation Skill
- API Generation Skill
- Unit Test Skill
- Refactoring Skill
- Documentation Skill

#### Part 10 — Enterprise SDLC Automation

- This is our end goal. The Agent should be able to do this:

Business Requirement

↓

Impact Analysis

↓

Update BRD

↓

Update TDD

↓

Update ERD

↓

Update Data Dictionary

↓

Generate Oracle DDL

↓

Generate Package

↓

Generate Java Domain

↓

Generate DTO

↓

Generate Service

↓

Generate Repository

↓

Generate Package Client

↓

Generate REST Controller

↓

Generate Unit Tests

↓

Generate Integration Tests

↓

Review

↓

Commit

- This is the AI-assisted SDLC we've been building toward.

- I'd introduce the following structure:
.ai/

├── agent.md
├── ContextPack.md
│
├── prompts/
│
│   create-tdd.md
│   create-ddl.md
│   create-controller.md
│   create-service.md
│   create-repository.md
│   create-package-client.md
│   create-unit-test.md
│   review-code.md
│
└── skills/

Proposed Skills
1. Business Analyst:
   skills/business-analyst.md
   
-  Responsibilities: 
    Analyze BRD
    Update BRD
    Impact Analysis

2. Solution Architect:
   skills/solution-architect.md

-  Responsibilities
    TDD
    ADR
    Architecture

3. Oracle Architect
   skills/oracle-architect.md

-  Responsibilities
    Tables
    Constraints
    Packages
    Indexes   

4. Java Architect
   skills/java-architect.md

-  Responsibilities
    Domain
    DTO
    Service
    Interfaces    

5. Spring Boot Developer
   skills/springboot-developer.md

-  Responsibilities
    Controllers
    Configuration
    DI
    REST
    Validation    

6. Oracle Integration Developer   
    skills/oracle-integration.md

-   Responsibilities:
     SimpleJdbcCall
     Package Clients
     REF CURSOR
     Transactions
    
7.  Test Engineer
    skills/test-engineer.md
-   Responsibilities
     JUnit
     Mockito
     Integration Tests
   
8. Code Reviewer
   skills/code-reviewer.md
-  Responsibilities   
    Review
    Refactoring
    Standards

9. Documentation Engineer    
    skills/documentation.md
-   Responsibilities
     README
     TDD
     ADR
     API documentation    

### Update agent.md

Receive Request

↓

Understand Requirements

↓

Review Knowledge Sources

↓

Perform Impact Analysis

↓

Identify Required Skills

↓

Create Execution Plan

↓

Invoke Required Skills

↓

Generate / Modify Artifacts

↓

Validate

↓

Update Documentation

↓

Summarize