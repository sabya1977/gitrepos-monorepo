# Domain Model: Employee Leave Management System

**Project:** Employee Leave Management System

**Version:** 1.0

**Status:** Draft

**Author:** GitHub Copilot

**Last Updated:** 2026-07-08

## 1. Purpose

This document identifies candidate business entities for the Employee Leave Management System based on the current `docs/BRD.md` and `docs/TDD.md`.

This is not a database schema. It does not define table names, columns, keys, constraints, indexes, stored procedures, seed data, or migration strategy. Those details remain undecided until database design is explicitly requested and confirmed.

## 2. Source Documents

- `docs/BRD.md`: business requirements, roles, workflows, rules, assumptions, out-of-scope items, and future enhancements.
- `docs/TDD.md`: planned technical direction, database overview, API capability areas, and unresolved technical decisions.
- `README.md`: project scope, intended users, current status, and confirmed technology stack.
- `.ai/ContextPack.md`: project context and guidance to avoid premature implementation decisions.

## 3. Classification Guidance

The candidate entities are classified as follows:

- **Master data**: relatively stable reference or organizational data used by workflows.
- **Transactional data**: records created or changed as part of leave request workflows.
- **Derived data**: calculated, summarized, or workflow-derived information that may be computed from other records, depending on final design.

### Master Data Entities

- Employee
- Leave Type
- Leave Request Status

### Transactional Data Entities

- Leave Request

### Candidate Derived Data Entities

- Leave Balance
- Leave Usage Summary
- Pending Approval Queue

## 4. Candidate Master Data Entities

| Entity               | Brief Description                             | Table in Version 1? |
| -------------------- | --------------------------------------------- | ------------------- |
| Employee             | Person who submits leave requests.            | **Yes**             |
| Leave Type           | Category such as vacation or sick leave, etc. | **Yes**             |
| Leave Request Status | Workflow state of a leave request.            | **Yes**             |

## 5. Candidate Transactional Data Entities

| Entity        | Brief Description           | Table in Version 1? |
| ------------- | --------------------------- | ------------------- |
| Leave Request | Employee request for leave. | **Yes**             |

## 6. Candidate Derived Data Entities

| Entity                 | Brief Description                 | Table in Version 1? |
| ---------------------- | --------------------------------- | ------------------- |
| Leave Balance          | Available leave by employee/type. | **Yes**             |
| Leave Usage Summary    | Aggregated leave usage.           | **No**              |
| Pending Approval Queue | Requests awaiting manager review. | **No**              |

## 7. Recommended Version 1 Persistence Scope

Based on the current BRD and TDD, the strongest candidates for Version 1 database persistence are:

- Employee.
- Leave Type.
- Leave Request Status.
- Leave Request.
- Leave Request Review.

The following should remain deferred items (shouldn't be part of ERD) until requirements are clarified:

- User Role and authorization-related storage.
- HR or administrative user as a separate entity.
- Leave balance and leave balance adjustment records.
- Leave cancellation records.
- Detailed status history and audit records.
- Reporting summaries and approval queues.

## 8. Open Decisions

The following decisions should be clarified before database schema design begins:

- Whether managers and HR or administrative users are employees with roles, separate user identities, or both.
- Whether Version 1 must enforce leave balance rules or only prepare for future balance tracking.
- How leave balances are calculated, accrued, restored, and adjusted.
- Whether status history is required in Version 1 or whether preserving final review outcomes is sufficient.
- Whether cancellation is part of Version 1 workflow.
- Which request statuses are valid in the initial workflow.
- How authentication, authorization, roles, and permissions will be stored or integrated.

## 9. Assumptions

- The project remains in planning and scaffolding status.
- This document identifies candidate entities only; it does not confirm database schema design.
- Version 1 should focus on the core leave request workflow unless the BRD or user confirms a broader scope.
- Undecided requirements are called out rather than converted into implementation decisions.
