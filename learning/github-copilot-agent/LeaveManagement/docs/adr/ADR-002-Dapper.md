# ADR-002: Use Dapper for Database Access

**Status:** Accepted

**Date:** 2026-07-07

## Decision

The Employee Leave Management System will use Dapper for database access from application code.

Database queries and commands will use parameterized SQL. Oracle 26ai-specific persistence details should remain isolated from API controllers and business logic.

## Context

The Employee Leave Management System is a planned backend-focused learning project for managing employee leave requests and related administrative workflows.

The current project documentation identifies Dapper as the confirmed data access approach and Oracle 26ai as the confirmed database platform. The application is expected to store and retrieve leave-related data for employees, managers, HR or administrative users, leave types, leave requests, request statuses, and review outcomes.

The application has not been implemented yet. The database schema, repository pattern usage, query organization, Oracle connection configuration, transaction handling strategy, and stored procedure usage remain **To Be Decided**.

## Alternatives Considered

No alternative ORM or data access technologies are documented as having been discussed or considered in the current project documents.

This ADR does not invent or evaluate alternatives that are not recorded in the repository documentation or user-provided requirements.

## Rationale

Dapper is already listed as the confirmed data access technology in the project documentation and instructions. Recording the decision in an ADR makes the choice easier to find and separates the confirmed data access approach from implementation details that remain undecided.

Dapper fits the current project direction because the system is expected to use Oracle 26ai directly while keeping SQL visible, explicit, and close to the data access code. The project standards also require parameterized SQL and separation of persistence details from controllers and business logic.

## Consequences

Positive consequences:

- Application data access code will use Dapper consistently.
- SQL statements should be explicit and parameterized.
- Data access code should isolate Oracle 26ai persistence details from controllers and business logic.
- Future repository or data access abstractions should be designed around Dapper when those structures are confirmed.

Tradeoffs and constraints:

- Developers are responsible for writing and maintaining SQL queries and commands.
- Query organization, transaction handling, and mapping conventions must be decided before or during implementation.
- Database schema changes must remain coordinated with Dapper queries.
- Automated tests for data access will need a confirmed database testing approach.

Still To Be Decided:

- Repository pattern usage.
- Query organization.
- Oracle connection configuration.
- Transaction handling strategy.
- Stored procedure usage, if any.
- Database integration testing approach.
- Mapping conventions between query results and application models or DTOs.

## Related Documents

- `README.md`
- `.ai/ContextPack.md`
- `docs/BRD.md`
- `docs/TDD.md`
- `docs/adr/ADR-001-Oracle26ai.md`
- `.github/copilot-instructions.md`