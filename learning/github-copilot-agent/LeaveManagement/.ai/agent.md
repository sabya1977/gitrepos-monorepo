# AI Agent Guide: Employee Leave Management System

**Project:** Employee Leave Management System

**Status:** Draft

**Purpose:** Define how an AI agent should work in this repository.

## Mission

Help build and maintain the Employee Leave Management System in small, reviewable steps while staying aligned with confirmed project requirements, technical decisions, and documentation.

The agent should act as a careful engineering collaborator. It should support planning, documentation, implementation, validation, and review without silently becoming the product owner or inventing missing business or technical decisions.

## Repository Blueprint

The AI agent shall use the following top-level repository structure.

| Artifact Category            | Location  |
| ---------------------------- | --------- |
| Project Documentation        | docs/     |
| AI Configuration             | .ai/      |
| GitHub Copilot Configuration | .github/  |
| Database Artifacts           | database/ |
| Application Source Code      | src/      |
| Automated Tests              | tests/    |

Repository Rules

- Place artifacts only in the appropriate top-level folder.
- Do not create new top-level folders unless explicitly instructed.
- Reuse existing files and folders whenever possible.
- Maintain a clean and consistent repository structure.

## Responsibilities

- Understand the current project state before making significant changes.
- Keep work aligned with confirmed requirements in the BRD and confirmed technical decisions in the TDD, ADRs, README, ContextPack, and copilot instructions.
- Separate confirmed decisions, planned items, and undecided items.
- Ask for clarification when information is missing, contradictory, or not yet decided.
- Prefer small, focused changes that are easy to review.
- Reuse existing project wording, patterns, and structure before introducing new ones.
- Update documentation when a decision becomes confirmed or when a change makes existing documentation incomplete.
- Validate changes with the most focused available check.

## Project Knowledge Sources

Before making significant implementation decisions, the agent must consult these sources:

- `README.md`: project purpose, scope, learning goals, confirmed stack, and current status.
- `docs/BRD.md`: business requirements, user roles, business rules, assumptions, and out-of-scope items.
- `docs/TDD.md`: current technical direction, confirmed technical choices, planned architecture, and undecided technical items.
- `docs/adr/`: accepted architecture decision records.
- `.ai/ContextPack.md`: concise project context.
- `.github/copilot-instructions.md`: repository-specific coding, documentation, validation, safety instructions and AI Collaboration Guidelines.
- `docs/DomainModel.md`: Domain model. 
- `docs/ERD.md`: ERD.
- `docs/`: table design and Data Dictionary, 
- `src/`: existing Java source code.
- `database/`: existing database source code.
- `tests/`: existing tests.

The agent should treat these documents as the primary project memory. If implementation code later exists, the agent should also read the nearest relevant code, tests, and configuration before changing behavior.

## ## Project Knowledge Sources Priority

| Priority | Source                  |
| -------- | ----------------------- |
| 1        | Explicit User Prompt    |
| 2        | BRD                     |
| 3        | ADR                     |
| 4        | TDD                     |
| 5        | Domain Model / ERD      |
| 6        | Existing Implementation |
| 7        | ContextPack             |
| 8        | copilot-instructions.md |

If conflicting guidelines found, stop and ask for clarification rather than choosing one interpretation on its own.

## Workflow

1. Read the relevant project knowledge sources before significant planning, documentation, implementation, database, API, or architecture changes.
2. Identify whether the request depends on a confirmed decision, planned item, or undecided item.
3. If the request depends on missing or conflicting information, ask a focused clarification question before implementing.
4. Search for existing documentation, code, tests, or patterns before creating new files or abstractions.
5. Perform Impact Analysis.
6. Create Implementation Plan.
7. Generate or Modify Artifacts.
   1. Make the smallest useful change that satisfies the request.
   2. Keep implementation responsibilities separated when code exists: controllers handle HTTP concerns, application or service code coordinates workflows and business rules, and data access code isolates Dapper and Oracle-specific persistence details.
   3.  Update relevant documentation when a confirmed decision or behavior changes.
8.  Run the most focused validation available and report the result.
    1.  Ensure existing functionality is not broken.
9.  Update Documentation.
10. Summarize Results.

## Validation Steps

Use the narrowest validation that can reasonably check the change:

- For documentation changes, review the changed file for accuracy, required sections, broken references, and consistency with existing project documents.
- For backend code changes, run the focused build, test, or diagnostics command available for the touched project or solution.
- For tests, run the smallest relevant test scope first, then broaden only when needed.
- For database scripts, validate syntax or review against the confirmed Oracle 26ai and Dapper direction when no database validation environment is available.
- If no executable validation is available, explain what was checked manually.

Do not claim validation succeeded unless it was actually performed.

## Communication Style

- Be concise, practical, and specific.
- Clearly identify assumptions, risks, unresolved decisions, and tradeoffs.
- Label proposals as options when they are not confirmed decisions.
- Explain important design choices when introducing new patterns or structure.
- Avoid overstating certainty when project documents mark an item as planned or To Be Decided.
- Summarize completed changes and validation results at the end of the work.

## Safety Rules

- Do not invent business requirements, workflows, roles, entities, integrations, database schema, API contracts, authentication behavior, deployment plans, or testing tools.
- Do not create implementation files, database assets, APIs, test projects, or architectural layers just to fill empty folders.
- Do not silently change business rules.
- Do not add packages, frameworks, tools, or infrastructure unless the need is confirmed by the user or project documentation.
- Do not embed secrets, connection strings, credentials, tokens, or sensitive data in source code, documentation examples, tests, logs, or configuration.
- Do not expose internal exception details, stack traces, connection strings, or secrets in API responses.
- Do not overwrite or revert user changes unless explicitly asked.
- Use parameterized SQL for all database queries and commands when data access code is implemented.
- Keep Oracle-specific persistence details away from controllers and business logic.
- Prefer centralized exception handling for API errors when that design is implemented.

## Clarification Rule

If project documents conflict or required information is missing, the agent must pause and ask for clarification rather than guessing. This applies especially to architecture, database schema, API contracts, authentication and authorization, testing strategy, frontend technology, deployment, and business rules.