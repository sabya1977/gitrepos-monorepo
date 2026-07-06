# Context Pack: Employee Leave Management System

# Lesson 4 – ContextPack.md (Teaching the AI About Your Project)
# ContextPack.md is a pattern that experienced AI-assisted development teams use to provide concise, high-value project context.
# If README.md is Project Brochure then ContextPack.md is Project Handbook. 
# Scope 

**Project:** Employee Leave Management System

**Version:** 1.1

**Status:** Draft

**Author:** GitHub Copilot (Reviewed by Raktim)

**Last Updated:** 2026-07-05

## Audience

This file is primarily for GitHub Copilot Agent and other AI coding assistants working in this repository.

Use this file to understand the current project context before creating code, documentation, tests, database assets, or project structure. Do not treat planned items as implemented decisions.

## Project Overview

The Employee Leave Management System is a learning project for building a backend-focused business application with .NET 10, Oracle 26ai, Visual Studio Code, Git, and GitHub Copilot Agent.

The application is intended to model employee leave request workflows and related administrative tasks. The project is also intended to help practice AI-assisted development, requirements clarification, source control, database design, and incremental backend development.

The application has not been implemented yet.

## Confirmed Intended Users

- Employees who need to request leave and view request status.
- Managers who need to review leave requests from team members.
- HR or administrative users who need to maintain leave-related information.
- Developers learning to build and evolve a professional application using AI-assisted development tools.

## Technology Stack

### Confirmed

- Backend: .NET 10.
- Database: Oracle 26ai.
- Development environment: Visual Studio Code.
- Version control: Git.
- AI-assisted development: GitHub Copilot Agent.
- ORM: Dapper

### Planned or Undecided

- Frontend technology: undecided.
  Possible options:
-  React
-  Angular
-  Blazor
-  Testing: xUnit (planned)
- Authentication and authorization approach: undecided.
- Database migration strategy: undecided.
- Testing tools and test project structure: undecided.
- Application architecture pattern: undecided.
- Package choices, libraries, and frameworks beyond the confirmed stack: undecided.

## Planned Architecture

The architecture has not been finalized.

Planned direction:

- Keep source code organized in a way that separates application code, database assets, documentation, and tests.
- Keep implementation choices aligned with confirmed requirements.
- Make technical decisions incrementally and document them when they become confirmed.

Undecided architecture items:

- API style.
- Backend project layout.
- Layering or architectural pattern.
- Frontend presence and structure.
- Authentication and authorization design.
- Error handling and validation approach.
- Integration strategy between application code and Oracle 26ai.

AI agents should not invent an architecture. If an implementation task requires an architectural decision, ask a focused question or propose a small number of options labeled as options.

## Database

Confirmed database platform:

- Oracle 26ai.

Planned database purpose:

- Store leave-related data for the application.
- Support the planned employee leave request workflow.

Planned repository location:

- `database/` is the planned location for database scripts, schema, and seed data.

Undecided database items:

- Data model.
- Table names and relationships.
- Primary key strategy.
- Migration tool or process.
- Seed data format.
- Oracle-specific features to use.

AI agents should not create schema details unless the user asks for schema design or confirms the domain model.

## Testing Strategy

Testing is planned, but the test tools and structure have not been finalized.

Planned testing direction:

- Add automated tests when application behavior is implemented.
- Keep tests aligned with confirmed requirements.
- Use the `tests/` folder as the planned location for automated tests.

Undecided testing items:

- .NET test framework.
- Frontend test framework, if a frontend is added.
- Integration testing approach.
- Database testing approach.
- CI test execution strategy.

AI agents should not assume xUnit, NUnit, MSTest, Playwright, Cypress, Vitest, Jest, Testcontainers, or any other test tooling until a decision is made.

## Coding Principles

- Do not assume requirements that are not explicitly provided.
- Do not treat planned items as implemented facts.
- Prefer small, reviewable changes.
- Keep code and documentation aligned with confirmed decisions.
- Mark assumptions clearly when proposing options.
- Avoid premature implementation details.
- Update documentation when major confirmed project decisions are made.
- Preserve the repository's current simplicity until there is a clear reason to add structure.

## Folder Structure

Current repository structure:

```text
LeaveManagement/
├── .ai/
├── .github/
├── database/
├── docs/
├── src/
├── tests/
├── ContextPack.md
└── README.md
```

Current folder intent:

- `.ai/`: available for AI-related project assets if needed later.
- `.github/`: available for GitHub configuration and workflows if needed later.
- `database/`: planned location for database scripts, schema, and seed data.
- `docs/`: planned location for project notes and design documentation.
- `src/`: planned location for application source code.
- `tests/`: planned location for automated tests.

The detailed internal folder structure has not been decided.

## Current Project Status

Current status: planning and scaffolding.

Currently present:

- `README.md`.
- `ContextPack.md`.
- Empty top-level folders for AI assets, GitHub assets, database assets, documentation, source code, and tests.

Not yet present:

- Application source code.
- .NET solution or project files.
- Database schema or scripts.
- Automated tests.
- CI/CD workflows.
- Detailed design documents.

## Assumptions

Only the following assumptions are safe at this time:

- This is a learning project.
- .NET 10 is intended for backend API development.
- Oracle 26ai is intended for data storage.
- Visual Studio Code, Git, and GitHub Copilot Agent are part of the learning workflow.
- Requirements and technical decisions will evolve over time.

Do not assume any unconfirmed frontend framework, backend architecture, package, database schema, testing library, authentication provider, deployment platform, or CI/CD design.

## AI Guidance

When working in this repository:

- Read `README.md` and `ContextPack.md` before making changes.
- Ground recommendations in the current files and explicit user instructions.
- Clearly separate confirmed facts, planned work, and undecided items.
- Ask a focused clarification question when a requested change depends on an undecided major choice.
- If proposing options, label them as options rather than decisions.
- Avoid adding unnecessary features or tool choices.
- Do not create implementation files simply to fill the scaffold.
- Keep documentation concise and useful for future development.
- Validate changes when a relevant validation method exists.
