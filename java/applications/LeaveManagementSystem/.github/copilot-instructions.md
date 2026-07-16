# Project Guidelines

# Lesson 7: The Company Handbook
# Compnay wide Engineering Standards

**Version:** 1.0

**Status:** Draft

**Author:** GitHub Copilot (Reviewed by Raktim)

**Last Updated:** 2026-07-06

These instructions apply to all GitHub Copilot-generated code and documentation for the Employee Leave Management System.

## Project Standards

- Read and follow the existing project documentation before making changes: `README.md`, `docs/BRD.md`, `docs/TDD.md`, and `.ai/ContextPack.md`.
- Treat confirmed decisions, planned items, and undecided items differently.
- Do not invent business requirements, workflows, entities, roles, integrations, database schema, or deployment decisions.
- Ask for clarification when a requested change depends on an undecided requirement or technical decision.
- Reuse existing code, project patterns, documentation, and naming before introducing new abstractions.
- Prefer simple, maintainable code over clever or speculative designs.

## AI Collaboration Guidelines

- Work as a careful engineering collaborator, not as an autonomous product owner.
- Follow the BRD, Mapping, TDD, README, and ContextPack as the primary sources of truth.
- Review the existing implementation.
- If a requirement is ambiguous, ask a clarifying question instead of guessing.
- Prefer modifying existing files over creating duplicates.
- Reuse existing code before creating new components.
- Prefer modifying existing code over creating new code.
- Explain important design decisions when introducing new patterns.
- Do not duplicate functionality.
- Prefer small, incremental changes that are easy for the user to review.
- When proposing options, label them clearly as options and do not present them as confirmed decisions.
- Keep responses and documentation aligned with the current project status: planning and scaffolding until implementation begins.
- Surface risks, missing decisions, and tradeoffs concisely instead of silently choosing a direction.
- Do not create implementation files, database assets, APIs, or test projects merely to fill empty folders.
- Preserve repository organization.


## Current Technical Guidelines

- Use Java 25 (LTS) as Backend language.
- Use Spring Boot for backend development.
- Build REST APIs with Spring MVC.
- Use Spring JDBC (SimpleJdbcCall) for database access.
- Use JSON over HTTPS as communication format.
- Use Spring IoC for Dependency Injection.
- Use Apache Maven as Build tool.
- Use Oracle 26ai as the database platform.
- Use asynchronous programming for I/O-bound work, including controller actions, service methods, and database calls.
- Use `SLF4J + Logback` for application logging.
- Use JUnit 5 + Mockito for automated tests.
- Use Oracle Database package, store procedure and functions for all database queries and commands.
- Add XML documentation comments for public APIs, public classes, and public members that are part of the application contract.
- Use centralized exception handling for API errors instead of scattering repeated `try`/`catch` blocks across controllers.

## Architecture Guidelines

- Application Architecture is Pragmatic Clean Architecture.
- Keep new structure small and justified by the current task.

## API Guidelines

- Use ASP.NET Core Controllers for HTTP endpoints.
- Keep controller actions focused on request validation, calling application logic, and returning responses.
- Use async action methods for operations that call services, repositories, or the database.
- Do not define API routes, DTOs, status codes, or versioning schemes beyond what the task or documentation requires.
- Keep API behavior aligned with the BRD and TDD.

## Data Access Guidelines

- Use Spring JDBC (SimpleJdbcCall) for database operations.
- Use Oracle Database package, stored procedure and function for SQL commands.
- Keep SQL readable and close to the data access code unless the project later adopts a different query organization standard.
- Do not invent database tables, columns, stored procedures, indexes, seed data, or migration tooling unless explicitly requested or documented.
- Keep Oracle 26ai-specific details isolated from controllers and business logic.

## Database Guidelines

- Use Oracle 26ai for database design and persistence decisions.
- Use Dapper for database access from application code.
- Use parameterized SQL for every query and command.
- Keep database scripts, schema files, and seed data under `database/` when those assets are created.
- Do not create or assume tables, columns, relationships, constraints, indexes, stored procedures, seed data, or migration scripts unless the user requests them or project documentation confirms them.
- Keep database design aligned with confirmed business rules in `docs/BRD.md` and technical direction in `docs/TDD.md`.
- Treat data model, primary key strategy, migration process, seed data format, and Oracle-specific feature usage as `To Be Decided` until confirmed.
- Avoid embedding database connection strings, credentials, or secrets in source code, documentation examples, tests, or logs.
- Use meaningful table and column names.
- Prefer primary and foreign key constraints.
- Keep schema changes in version-controlled SQL scripts.
- Separate DDL, indexes, and sample data into appropriate files.

# Oracle Database Naming Standards

- Naming Conventions

- Table names: LMS_UPPERCASE with underscores
- Column names: LMS_UPPERCASE with underscores
- Primary Key: LMS_PK_<TABLE_NAME>
- Foreign Key: LMS_FK_<CHILD_TABLE>_<PARENT_TABLE>
- Unique Constraint: LMS_UK_<TABLE>_<COLUMN>
- Index: LMS_IDX_<TABLE>_<COLUMN>
- View: LMS_VW_<NAME>
- Package: LMS_PKG_<NAME>
- Procedure: LMS_SP_<NAME>
- Function: LMS_FN_<NAME>
- Trigger: LMS_TRG_<NAME>
- Sequence: LMS_SEQ_<TABLE_NAME> (if sequences are used)

# Oracle Data Type Standards

- Identifiers NUMBER(19)

- Names VARCHAR2(100 CHAR)

- Codes VARCHAR2(30 CHAR)

- Description VARCHAR2(500 CHAR)

- Remarks VARCHAR2(1000 CHAR)

- Flags VARCHAR2(1)

- Dates DATE

- Timestamps TIMESTAMP


## Logging and Exceptions Handling Guidelines

- Use `SLF4J + Logback` through dependency injection for logging.
- Log meaningful workflow and diagnostic events without logging sensitive data.
- Prefer centralized exception handling for consistent API error responses.
- Do not expose internal exception details, connection strings, stack traces, or secrets in API responses.
- Distinguish validation errors, authorization failures, not-found cases, business rule violations, database failures, and unexpected failures when the error handling design is implemented.

## Testing Guidelines

- Use JUnit 5 + Mockito for automated tests.
- Add or update tests when implementing behavior.
- Keep tests focused on confirmed requirements and the behavior changed by the task.
- Prefer unit tests for business rules and workflow decisions.
- Add integration or data access tests only when the project has a confirmed database testing approach.
- Do not introduce additional testing tools, mocking libraries, containers, or coverage tooling unless requested or documented.
- Don't reduce test coverage

## Documentation Standards

- Update documentation when a technical decision becomes confirmed.
- Mark unresolved items as `To Be Decided` or `Planned`.
- Keep documentation concise and aligned with the current project state.
- Add XML documentation for public APIs and public members that future callers will consume.
- Explain assumptions.

## Code Quality

- Favor clear names, small methods, and explicit control flow.
- Avoid premature abstractions and broad refactors.
- Preserve the repository's current simplicity until there is a clear reason to add structure.
- Keep changes small, reviewable, and directly connected to the user's request.
- Do not fix unrelated issues unless the user asks for that work.

## AI Behavior

- Think before generating code.
- Read nearby files and relevant documentation before making code or documentation changes.
- Make the smallest useful change that satisfies the user's request.
- Validate changes with the most focused available check, such as tests, build, linting, or editor diagnostics.
- If validation is unavailable, explain what was checked manually.
- Do not overwrite or revert user changes unless the user explicitly asks.
- Do not introduce new packages, frameworks, tools, or architectural layers without a confirmed need.
- If a task conflicts with existing documentation, pause and ask for clarification or update the documentation only when the user confirms the new decision.
- Search for existing implementations before creating new ones.
- Keep generated content concise, practical, and maintainable.
- Update tests when functionality changes.
- Update documentation when architecture changes.
- Never silently change business rules.
- Clearly identify assumptions.