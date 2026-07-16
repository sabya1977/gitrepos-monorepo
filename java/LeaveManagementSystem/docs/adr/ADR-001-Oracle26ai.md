# ADR-001: Use Oracle 26ai as the Database Platform

# Lesson 9 - ADR

**Status:** Accepted

**Date:** 2026-07-07

## Decision

The Employee Leave Management System will use Oracle 26ai as its database platform.

Application code will access the database using Spring JDBC (SimpleJdbcCall). Database scripts, schema files, and seed data will be stored under `database/` when those assets are created.

## Context

The Employee Leave Management System is a planned backend-focused learning project for managing employee leave requests and related administrative workflows.

The current project documentation identifies Oracle 26ai as the confirmed database platform. The system is expected to store leave-related data needed for employees, managers, HR or administrative users, leave types, leave requests, request statuses, and review outcomes.

The database schema has not been designed yet. Table names, relationships, primary key strategy, migration approach, seed data format, and Oracle-specific feature usage remain **To Be Decided**.

## Alternatives Considered

No alternative database platforms are documented as having been discussed or considered in the current project documents.

This ADR does not invent or evaluate alternatives that are not recorded in the repository documentation or user-provided requirements.

## Rationale

Oracle 26ai is already listed as the confirmed database platform in the project documentation and instructions. Recording the decision in an ADR makes the decision easier to find and separates the confirmed platform choice from database design details that remain undecided.

This decision also supports the project learning goals, which include connecting Java 25 (LTS) and Spring Boot backend application code to Oracle 26ai and organizing database assets in a version-controlled repository.

## Consequences

Positive consequences:

- Database design and persistence decisions will be made with Oracle 26ai as the target platform.
- Application data access code should use Spring JDBC (SimpleJdbcCall) with parameterized SQL.
- Oracle-specific persistence details should remain isolated from controllers and business logic.
- Future database scripts should be organized under `database/`.

Tradeoffs and constraints:

- The team must make future schema, migration, connection configuration, and database testing decisions in a way that works with Oracle 26ai.
- Developers need access to a suitable Oracle 26ai development or test environment when database-backed implementation begins.
- Oracle-specific behavior should be documented when it affects application design or database scripts.

Still To Be Decided:

- Database schema.
- Table names and relationships.
- Primary key strategy.
- Migration tooling and process.
- Seed data format.
- Database integration testing approach.
- Oracle-specific features to use, if any.

## Related Documents

- `README.md`
- `.ai/ContextPack.md`
- `docs/BRD.md`
- `docs/TDD.md`
- `.github/copilot-instructions.md`