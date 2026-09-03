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
- Interfaces
- Inheritance
- Records
- Enums
- Exceptions
- Generics
- Collections
- Streams
- Optional
- Lambdas
- Dependency Injection Concepts (Java side)
- Java Modules (brief)
- Modern Java Features used in Spring

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