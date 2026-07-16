# ADR-003: Use .NET 10 as the Backend Platform

# Lesson 9 - ADR

**Status:** Accepted

**Date:** 2026-07-07

## Decision

The Employee Leave Management System will use Java 25 (LTS) and Spring Boot as the backend platform.

Backend APIs will be built with Spring Boot. Backend code should follow the current project standards for asynchronous programming, `SLF4J + Logback` logging, centralized exception handling, XML documentation for public APIs, and maintainable implementation.

## Context

The Employee Leave Management System is a planned backend-focused learning project for managing employee leave requests and related administrative workflows.

The current project documentation identifies Java 25 (LTS) and Spring Boot as the confirmed backend platform. The backend is expected to expose API capabilities for leave request submission, leave request status retrieval, manager review actions, leave type maintenance, and employee or manager information needed for leave workflows.

The application has not been implemented yet. The detailed backend project layout, formal application architecture pattern, API route design, authentication and authorization approach, validation approach, and deployment model remain **To Be Decided**.

## Alternatives Considered

No alternative backend platforms are documented as having been discussed or considered in the current project documents.

This ADR does not invent or evaluate alternatives that are not recorded in the repository documentation or user-provided requirements.

## Rationale

Java 25 (LTS) and Spring Boot is already listed as the confirmed backend platform in the project documentation and instructions. Recording the decision in an ADR makes the platform choice easier to find and separates the confirmed backend platform from implementation details that remain undecided.

This decision also supports the project learning goals, which include building a Java 25 (LTS) and Spring Boot backend application, connecting it to Oracle 26ai, and developing the system incrementally with clear documentation.

## Consequences

Positive consequences:

- Backend implementation decisions should target Java 25 (LTS).
- API Style is REST API.
- API implementation using Spring MVC.
- Dependency Injection using Spring IoC.
- Application logging should use `SLF4J + Logback` through dependency injection.
- Public API contracts should include XML documentation where appropriate.

Still To Be Decided:

- Backend solution and project layout.
- Formal application architecture pattern.
- API routes and contracts.
- Authentication and authorization approach.
- Validation approach.
- Deployment target and CI/CD process.

## Related Documents

- `README.md`
- `.ai/ContextPack.md`
- `docs/BRD.md`
- `docs/TDD.md`
- `docs/adr/ADR-001-Oracle26ai.md`
- `docs/adr/ADR-002-Database Access Strategy.md`
- `.github/copilot-instructions.md`