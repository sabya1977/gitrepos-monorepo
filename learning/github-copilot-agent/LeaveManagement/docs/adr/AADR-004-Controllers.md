# ADR-004: Use ASP.NET Core Controllers for the API

# Lesson 9 - ADR

**Status:** Accepted

**Date:** 2026-07-07

## Decision

The Employee Leave Management System will use ASP.NET Core Controllers for backend API endpoints.

Controller actions should handle HTTP concerns, validate incoming requests as appropriate, call application or service logic, and return API responses. Business rules should remain outside controllers when an application or service layer exists.

## Context

The Employee Leave Management System is a planned backend-focused learning project for managing employee leave requests and related administrative workflows.

The current project documentation identifies ASP.NET Core Controllers as the confirmed API implementation style. The backend is expected to expose API capabilities for checking leave balance, submitting leave requests, retrieving leave request status, supporting manager review actions, maintaining leave types, and accessing employee or manager information needed for leave workflows.

The application has not been implemented yet. Endpoint routes, HTTP methods per operation, request and response schemas, API versioning, pagination, filtering, sorting, authentication and authorization enforcement, OpenAPI generation, and error response format remain **To Be Decided**.

## Alternatives Considered

No alternative API implementation styles are documented as having been discussed or considered in the current project documents.

This ADR does not invent or evaluate alternatives that are not recorded in the repository documentation or user-provided requirements.

## Rationale

ASP.NET Core Controllers are already listed as the confirmed API implementation style in the project documentation and instructions. Recording the decision in an ADR makes the API style easier to find and separates the confirmed controller choice from route, contract, and error-handling details that remain undecided.

Controllers also fit the current project standards by providing a clear place for HTTP concerns while allowing application logic, business rules, and data access to remain separated as the backend design evolves.

## Consequences

Positive consequences:

- Backend API endpoints should be implemented using ASP.NET Core Controllers.
- Controller actions should remain focused on HTTP request and response concerns.
- Controllers should delegate business workflows to application or service code when that structure exists.
- API code should use async action methods for operations that call services, repositories, or the database.

Tradeoffs and constraints:

- Route conventions and API contracts must still be designed before implementation.
- Controller behavior must stay aligned with confirmed BRD and TDD requirements.
- Centralized exception handling and error response contracts must be designed so controllers do not accumulate repeated error-handling code.
- Authorization rules must be defined before role-sensitive endpoints are implemented.

Still To Be Decided:

- Controller names and route conventions.
- Endpoint routes and HTTP methods.
- Request and response DTO structure.
- API versioning approach.
- Pagination, filtering, and sorting behavior.
- Error response format.
- Authentication and authorization enforcement.
- OpenAPI or Swagger configuration.

## Related Documents

- `README.md`
- `.ai/ContextPack.md`
- `docs/BRD.md`
- `docs/TDD.md`
- `docs/adr/ADR-001-Oracle26ai.md`
- `docs/adr/ADR-002-Dapper.md`
- `docs/adr/ADR-003-DotNet10.md`
- `.github/copilot-instructions.md`