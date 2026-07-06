# Technical Design Document: Employee Leave Management System

**Project:** Employee Leave Management System

**Version:** 1.0

**Status:** Draft

**Author:** GitHub Copilot

**Last Updated:** 2026-07-06

## 1. Purpose

This Technical Design Document describes the current technical direction for the Employee Leave Management System based on the existing Business Requirements Document and project context.

The application is still in the planning and scaffolding stage. This document separates confirmed technical choices from planned or undecided items. Details that have not yet been decided are marked as **To Be Decided** or **Planned**.

## 2. Source Documents

- `docs/BRD.md`: Business requirements and initial business rules.
- `.ai/ContextPack.md`: Current project context and AI guidance.
- `README.md`: Project purpose, confirmed stack, and repository structure.

## 3. Solution Overview

The Employee Leave Management System is a backend-focused business application for managing employee leave requests and related administrative workflows.

The planned solution will provide an ASP.NET Core API that supports the core leave workflow:

- Employee checks leave balance.
- Employees submit leave requests if sufficient balance is available in the category they want to submit for.
- Employees view submitted leave requests and current statuses.
- Managers review leave requests from relevant employees.
- Managers approve or reject leave requests.
- HR or administrative users maintain leave-related information.
- The system stores leave-related data in Oracle 26ai.

The first implementation focus is the core leave request workflow. Features outside the confirmed or planned requirements remain out of scope until clarified.

## 4. Confirmed Technical Decisions

The following technical decisions are confirmed for this document:

- Backend platform: .NET 10.
- API implementation style: ASP.NET Core Controllers.
- Database platform: Oracle 26ai.
- Database access: Dapper.
- Development environment: Visual Studio Code.
- Version control: Git.
- Source location: `src/` is planned for application source code.
- Database asset location: `database/` is planned for database scripts, schema, and seed data.
- Test location: `tests/` is planned for automated tests.

## 5. High-Level Architecture

The high-level architecture is planned as a backend API connected to an Oracle 26ai database.

```text
Client or API Consumer
        |
        v
ASP.NET Core Web API
        |
        v
Application / Business Logic
        |
        v
Data Access with Dapper
        |
        v
Oracle 26ai Database
```

### 5.1 Architecture Status

- Overall backend API direction: **Planned**.
- ASP.NET Core Controllers for API endpoints: **Confirmed**.
- Dapper for database access: **Confirmed**.
- Oracle 26ai for persistence: **Confirmed**.
- Detailed backend project layout: **To Be Decided**.
- Formal application architecture pattern: **To Be Decided**.
- Frontend presence and technology: **To Be Decided**.
- Authentication and authorization architecture: **To Be Decided**.

## 6. Technology Stack

| Area                             | Decision                 | Status        |
| -------------------------------- | ------------------------ | ------------- |
| Backend runtime                  | .NET 10                  | Confirmed     |
| API framework                    | ASP.NET Core Controllers | Confirmed     |
| Database                         | Oracle 26ai              | Confirmed     |
| Data access                      | Dapper                   | Confirmed     |
| Development environment          | Visual Studio Code       | Confirmed     |
| Version control                  | Git                      | Confirmed     |
| Frontend                         | To Be Decided            | To Be Decided |
| Authentication and authorization | To Be Decided            | To Be Decided |
| Database migrations              | To Be Decided            | To Be Decided |
| Testing framework                | To Be Decided            | To Be Decided |
| CI/CD platform                   | To Be Decided            | To Be Decided |
| Deployment platform              | To Be Decided            | To Be Decided |

## 7. Application Layers

The exact project structure and architectural pattern have not been finalized. The following layer responsibilities are planned as a conceptual separation to keep implementation organized.

### 7.1 API Layer

**Status:** Planned

Responsibilities:

- Expose HTTP endpoints using ASP.NET Core Controllers.
- Accept request payloads for leave-related workflows.
- Return API responses with appropriate status information.
- Delegate business operations to application or service code.

To Be Decided:

- Controller names and route conventions.
- API versioning approach.
- Request and response DTO structure.
- OpenAPI or Swagger configuration.

### 7.2 Application / Business Logic Layer

**Status:** Planned

Responsibilities:

- Coordinate leave request workflows.
- Apply confirmed business rules.
- Prevent managers from approving their own leave requests.
- Prevent employees from applying for leave beyond available balance when leave balance tracking is implemented.
- Restore balance when cancelled leave is implemented.
- Preserve review outcomes.

To Be Decided:

- Service naming and organization.
- Validation approach.
- Transaction boundaries.
- How pending business rules are represented before they are finalized.

### 7.3 Data Access Layer

**Status:** Planned

Responsibilities:

- Use Dapper to execute database queries and commands.
- Isolate Oracle 26ai persistence details from API controllers.
- Map query results to application data models or DTOs.

To Be Decided:

- Repository pattern usage.
- Query organization.
- Oracle connection configuration.
- Transaction handling strategy.
- Stored procedure usage, if any.

### 7.4 Database Layer

**Status:** Planned

Responsibilities:

- Store employees, managers, leave types, leave requests, request statuses, and review outcomes when the schema is designed.
- Preserve leave request and approval information needed for workflow visibility and auditability.

To Be Decided:

- Database schema.
- Table names and relationships.
- Primary key strategy.
- Indexing strategy.
- Audit fields.
- Migration tooling and process.
- Seed data format.

## 8. Database Overview

Oracle 26ai is the confirmed database platform. Dapper is the confirmed database access approach.

The database is planned to support:

- Employee information needed for leave workflows.
- Manager information and employee-manager relationships.
- Basic leave types such as vacation, sick leave, and unpaid leave.
- Leave requests and requested leave periods.
- Leave request statuses.
- Manager review outcomes.
- Leave-related information maintained by HR or administrative users.

The database schema has not been designed yet. No table structure, column list, constraints, key strategy, stored procedures, or Oracle-specific features are confirmed in the current source documents.

## 9. API Overview

The API will be implemented using ASP.NET Core Controllers.

Planned API capability areas:

- Check Leave balance for a Leave category.
- Leave request submission.
- Leave request status retrieval.
- Leave request review by managers.
- Leave type maintenance.
- Employee and manager information access needed for leave workflows.

To Be Decided:

- Endpoint routes.
- HTTP methods per operation.
- Request and response schemas.
- API versioning.
- Pagination, filtering, and sorting behavior.
- Error response format.
- Authentication and authorization enforcement.
- Whether an OpenAPI specification will be generated.

## 10. Security and Access Control

Security and access control are planned but not yet fully defined.

Confirmed or planned role concepts from the business requirements:

- Employee.
- Manager.
- HR or administrative user.
- Developer or learner.

Planned access rules:

- Users should only perform actions appropriate to their role.
- Employees should not review their own requests as managers unless explicitly allowed by the business.
- Administrators should not approve leave unless they are also managers.

To Be Decided:

- Authentication provider.
- Authorization model.
- Role and permission storage.
- Token, session, or identity integration approach.
- Local development authentication approach.

## 11. Logging

Logging is planned but the detailed logging approach has not been finalized.

Planned logging needs:

- Application startup and shutdown events.
- API request handling at an appropriate level.
- Leave request submission, approval, rejection, and cancellation events when implemented.
- Validation failures or rejected business operations where useful for support.
- Unhandled exceptions.
- Database access failures.

To Be Decided:

- Logging framework or providers beyond ASP.NET Core defaults.
- Log format and correlation ID strategy.
- Sensitive data redaction rules.
- Log storage and retention.
- Monitoring or alerting integration.

## 12. Exception Handling

Exception handling is planned but the detailed implementation approach has not been finalized.

Planned exception handling goals:

- Return consistent API error responses.
- Avoid exposing sensitive internal details to API consumers.
- Distinguish validation errors, authorization failures, not-found cases, business rule violations, database errors, and unexpected failures.
- Log unexpected failures with enough context for troubleshooting.

To Be Decided:

- Global exception handling mechanism.
- Error response contract.
- Business exception types.
- Validation error format.
- Mapping between application errors and HTTP status codes.

## 13. Validation and Business Rules

The following business rules are planned from the BRD and may be refined during implementation:

- A leave request must be associated with an employee.
- A leave request must have a leave type.
- A leave request must have a requested leave period.
- A leave request should have a status that reflects where it is in the workflow.
- A manager may approve or reject a leave request assigned for review.
- Basic leave types are planned to include vacation, sick leave, and unpaid leave.
- Manager cannot approve own leave.
- Cancelled leave restores balance.
- Employee cannot apply leave beyond balance.
- Administrator cannot approve leave unless also a manager.

To Be Decided:

- Leave balance calculation rules.
- Leave accrual rules.
- Holiday and weekend handling.
- Partial-day or half-day leave handling.
- Approval routing rules.
- Required reasons or comments for approvals or rejections.
- Detailed role-specific access rules.

## 14. Testing Strategy

Automated testing is planned, but the tools and structure have not been finalized.

Planned testing areas:

- Unit tests for business rules and workflow decisions.
- API tests for controller behavior once endpoints are defined.
- Data access tests for Dapper queries once the database schema exists.
- Integration tests for core leave workflows once the application and database design are implemented.
- Regression tests for confirmed business rules.

To Be Decided:

- .NET test framework.
- Test project structure.
- Mocking or test double approach.
- Database integration testing approach.
- Test data management.
- CI test execution strategy.
- Code coverage expectations.

## 15. Deployment Considerations

Deployment has not yet been designed.

Planned considerations:

- Configuration management for database connection settings.
- Environment-specific settings for development, test, and production-like environments.
- Secure handling of credentials and secrets.
- Database migration or deployment process.
- Health checks for API and database connectivity.
- Logging and diagnostics in deployed environments.

To Be Decided:

- Deployment target.
- Hosting model.
- CI/CD workflow.
- Release process.
- Infrastructure provisioning approach.
- Environment naming and promotion strategy.

## 16. Repository Organization

Current planned repository structure:

```text
LeaveManagement/
|-- README.md
|-- .ai/
|-- .github/
|-- database/
|-- docs/
|-- src/
`-- tests/
```

Planned folder usage:

- `src/`: application source code.
- `database/`: database scripts, schema, and seed data.
- `docs/`: requirements, design documents, and project notes.
- `tests/`: automated tests.
- `.ai/`: AI-related project context and guidance.
- `.github/`: GitHub configuration and workflows if added later.

To Be Decided:

- Internal source project layout.
- Test project layout.
- Database script organization.
- CI/CD workflow files.

## 17. Future Enhancements

The following future enhancements are identified in the BRD and should remain outside the initial implementation unless later confirmed:

- Leave balance tracking.
- Leave accrual rules.
- Holiday and weekend handling.
- Request cancellation or modification workflows.
- Notifications for request submission and review outcomes.
- Comments or reason tracking for approvals and rejections.
- Basic reporting for leave requests and statuses.
- Additional leave types.
- More detailed role and permission rules.
- Integration with external business systems.

## 18. Open Decisions

The following items are still **To Be Decided**:

- Frontend technology and whether a frontend will be included initially.
- Authentication and authorization approach.
- Detailed application architecture pattern.
- Backend project layout.
- Database schema and migration strategy.
- API route and contract design.
- Validation approach.
- Error response format.
- Logging providers and monitoring approach.
- Testing framework and test structure.
- Deployment target and CI/CD process.

## 19. Design Principles

- Keep implementation aligned with confirmed business requirements.
- Make technical decisions incrementally.
- Mark planned or undecided items clearly.
- Avoid adding features outside the current scope.
- Keep documentation updated when decisions become confirmed.
- Prefer small, reviewable implementation increments.