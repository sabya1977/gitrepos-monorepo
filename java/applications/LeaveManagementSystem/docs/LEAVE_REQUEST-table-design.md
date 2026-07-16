# LEAVE_REQUEST Entity Design for Version 1

**Status:** Draft

**Date:** 2026-07-09

## Decision

The Employee Leave Management System will model `LEAVE_REQUEST` as the transactional entity that records an employee's request for leave for a specific leave type and requested period.

For Version 1, `LEAVE_REQUEST` should store the information needed to submit the request, show its current workflow status, relate it to the requesting employee and leave type, and preserve basic request auditability. Manager review outcome details should remain in the separate `LEAVE_REQUEST_REVIEW` entity identified by the ERD unless a later workflow decision requires multiple review events or status history.

This document is a logical entity design only. It does not generate Oracle DDL, table definitions, constraints, indexes, sequences, migrations, seed data, or stored procedures.

## Context

The BRD requires the system to allow employees to submit leave requests, identify the type of leave being requested, specify the requested leave period, view submitted requests, and see each request's current status. It also requires managers to approve or reject relevant requests and preserve review outcomes.

The Domain Model identifies `Leave Request` as a Version 1 transactional entity. The ERD identifies `Leave Request` as a Version 1 candidate entity related to `Employee`, `Leave Type`, `Leave Request Status`, and `Leave Request Review`.

Accepted ADRs confirm Oracle 26ai as the database platform, Dapper as the database access approach, .NET 10 as the backend platform, and ASP.NET Core Controllers as the API style. The physical schema, primary key generation strategy, API contracts, validation approach, authentication, authorization, approval routing, leave balance calculation, cancellation workflow, and detailed audit history remain to be decided.

## Business Purpose

`LEAVE_REQUEST` represents the employee's formal request to take leave. It is the central transactional record for the core workflow:

- An employee submits a request.
- The request identifies a leave type.
- The request captures the requested leave period.
- The request carries a current workflow status.
- The request may later receive a manager review outcome through `LEAVE_REQUEST_REVIEW`.

The entity supports workflow visibility and basic auditability without prematurely modeling advanced policy automation, detailed status history, cancellation records, notification state, or reporting summaries.

## Proposed Columns

| Attribute            | Oracle Type Candidate | Stored or Derived | Required?                                | Business Meaning                                                                    | Reasoning                                                                                                                                                                       |
| -------------------- | --------------------- | ----------------- | ---------------------------------------- | ----------------------------------------------------------------------------------- |
| `LeaveRequestId`     | `NUMBER(19)`          | Stored            | Yes                                      | Internal surrogate identifier for the leave request.                                | Provides a stable technical identity for relationships from review records and future workflow records. Final generation strategy remains to be decided.                        |
| `LeaveRequestNumber` | `VARCHAR2(30)`        | Stored            | Yes, if business identifier is confirmed | Business-facing request identifier shown to employees, managers, and support users. | Employees and managers need a readable way to discuss and track requests without exposing only an internal key. Format and generation rules remain to be decided.               |
| `EmployeeId`         | `NUMBER(19)`          | Stored            | Yes                                      | Employee who submitted the leave request.                                           | The BRD says every leave request must be associated with an employee. This supports request ownership and manager self-approval checks.                                         |
| `LeaveTypeId`        | `NUMBER(19)`          | Stored            | Yes                                      | Requested category of leave.                                                        | The BRD requires employees to identify the leave type being requested. This references maintained leave type master data instead of copying leave type names into each request. |
| `RequestedStartDate` | `DATE`                | Stored            | Yes                                      | First date in the requested leave period.                                           | The BRD requires the requested leave period. Start and end dates are the minimum confirmed period information.                                                                  |
| `RequestedEndDate`   | `DATE`                | Stored            | Yes                                      | Last date in the requested leave period.                                            | Required with start date to represent a date range while leaving partial-day and holiday handling undecided.                                                                    |

| `RequestedDayCount`         | `NUMBER(19)` | Derived for Version 1 | No                | Number of leave days represented by the requested period.  | This depends on unresolved rules for weekends, holidays, partial-day leave, and leave balance calculation. It should be calculated by business logic when needed until those rules are confirmed. If the business later requires preserving the exact evaluated day count at submission time, it may become stored.                      |
| `RequestReason`             | `VARCHAR2(60)` | Stored                | No                | Optional employee-provided reason or note for the request. | The BRD says the system should capture basic information needed to evaluate a request, but required reasons remain undecided. Keeping this optional supports review context without making it a business rule.                                                                                                                           |
| `CurrentStatusId`          | `VARCHAR2(20)` | Stored                | Yes               | Current workflow status of the request.                    | The BRD requires employees to view current request status and says status changes should be supported as a request moves through review. Detailed status history remains deferred.                                                                                                                                                       |
| `SubmittedDate`             | `DATE` | Stored                | Yes               | Date and time the request was submitted.                   | Supports ordering, visibility, and auditability of submitted requests. This is a workflow milestone rather than a derived value.                                                                                                                                                                                                         |
| `AssignedManagerEmployeeId` | `NUMBER(19)` | Stored conditionally  | No                | Candidate manager assigned to review the request.          | Manager routing is currently represented by `Employee.ManagerEmployeeId` in the ERD. Storing the assigned manager on the request would preserve the routing decision if managers change later, but approval routing rules are not confirmed. For Version 1, this should remain optional or deferred until routing behavior is confirmed. |
| `CreatedDate`               | `DATE` | Stored                | Yes               | Date and time the row was created.                         | Supports basic auditability without requiring a full audit history model.                                                                                                                                                                                                                                                                |
| `CreatedBy`                 | `DATE` | Stored                | Yes               | Actor or process that created the row.                     | Records who or what created the request record. This is not a foreign key yet because identity storage is undecided.                                                                                                                                                                                                                     |
| `UpdatedDate`       | `DATE` | Stored                | Yes               | Date and time the row was last updated.                    | Supports troubleshooting and visibility into workflow changes.                                                                                                                                                                                                                                                                           |
| `UpdatedBy`                 | `DATE` | Stored                | Yes               | Actor or process that last updated the row.                | Records who or what last changed the request record. This is not a foreign key yet because identity storage is undecided.                                                                                                                                                                                                                |

## Business Identifier

`LeaveRequestNumber` is the proposed business identifier for Version 1.

Reasoning:

- `LeaveRequestId` is useful for internal relationships but is not ideal as the user-facing reference.
- Employees and managers need a stable value to identify a request in screens, support conversations, logs, and future notifications.
- The identifier should remain stable even if request status, dates, reason, or reviewer details change.

The format is still to be decided. Candidate examples include a simple generated number or a prefixed value such as `LR-2026-000001`, but this document does not confirm a format or generation mechanism.

## Workflow-Related Fields

| Field                       | Treatment                           | Reasoning                                                                                                                                                                     |
| --------------------------- | ----------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `CurrentStatusId`           | Stored                              | Needed for efficient request status visibility, which is a core BRD requirement.                                                                                              |
| `SubmittedDate`             | Stored                              | Captures the submission milestone and supports sorting, reporting, and auditability.                                                                                          |
| `AssignedManagerEmployeeId` | Optional or deferred stored field   | Useful if the reviewer assignment must be preserved from submission time; otherwise it can be derived from `Employee.ManagerEmployeeId`. Routing rules are not finalized.     |
| Review outcome fields       | Derived from `LEAVE_REQUEST_REVIEW` | The ERD already models review outcome separately. Approval or rejection details should not be duplicated on `LEAVE_REQUEST` unless a future denormalization decision is made. |
| Status history fields       | Deferred                            | Detailed status history and audit records are explicitly deferred or undecided in current documentation.                                                                      |
| Cancellation fields         | Deferred                            | Cancellation is listed as a future or unresolved workflow item, so cancellation-specific attributes should not be added to Version 1 unless confirmed.                        |

## Relationships

| Relationship                                     | Cardinality                                                        | Optionality                                      | Reasoning                                                                                                                                                          |
| ------------------------------------------------ | ------------------------------------------------------------------ | ------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| `Employee` to `LeaveRequest`                     | One employee to zero or many leave requests.                       | Mandatory from `LeaveRequest` to `Employee`.     | The BRD says a leave request must be associated with an employee.                                                                                                  |
| `LeaveType` to `LeaveRequest`                    | One leave type to zero or many leave requests.                     | Mandatory from `LeaveRequest` to `LeaveType`.    | The BRD requires the requested leave type and HR/admin-maintained leave type information.                                                                          |
| `LeaveRequestStatus` to `LeaveRequest`           | One status to zero or many leave requests.                         | Mandatory from `LeaveRequest` to current status. | Current status is required for request tracking and workflow visibility.                                                                                           |
| `Employee` as assigned manager to `LeaveRequest` | One manager employee to zero or many assigned requests, if stored. | Optional or deferred.                            | Useful only if the business confirms that manager assignment must be frozen on the request. Simple routing can derive this from the submitting employee's manager. |
| `LeaveBalance` to `LeaveRequest`                 | No direct confirmed relationship.                                  | Conditional.                                     | Balance checks are planned, but balance calculation, accrual, restoration, and cancellation behavior are undecided.                                                |

## Candidate Keys

| Candidate Key                  | Attributes                                                                                        | Status                               | Reasoning                                                                                                                                                                                                                            |
| ------------------------------ | ------------------------------------------------------------------------------------------------- | ------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| Internal primary identity      | `LeaveRequestId`                                                                                  | Proposed                             | Stable internal identifier for relationships and application persistence. Final key generation remains to be decided.                                                                                                                |
| Business request number        | `LeaveRequestNumber`                                                                              | Proposed, pending confirmation       | Provides a unique human-facing request reference. Format and generation rules remain open.                                                                                                                                           |
| Duplicate active request guard | `EmployeeId`, `LeaveTypeId`, `RequestedStartDate`, `RequestedEndDate`, active workflow status set | Validation rule, not a confirmed key | May help prevent duplicate open requests for the same employee, leave type, and period, but overlap and amendment rules are not yet confirmed. This should not be treated as a physical unique key until business rules are clearer. |

## Audit Fields

| Field         | Rule                                      | Reasoning                                                                                                                                                               |
| ------------- | ----------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `CreatedDate` | Required at insert and not changed later. | Supports basic auditability for submitted requests.                                                                                                                     |
| `CreatedBy`   | Required at insert.                       | Records the actor or process that created the request. Usually this should align with the submitting employee or system process, but identity design remains undecided. |
| `UpdatedDate` | Required at insert and each update.       | Supports visibility into status and workflow changes.                                                                                                                   |
| `UpdatedBy`   | Required at insert and each update.       | Records the actor or process that last changed the request.                                                                                                             |

`CreatedBy` and `UpdatedBy` should not be foreign keys in this logical design because authentication, authorization, and user identity storage remain undecided.

## Validation Rules

| Rule                                                      | Applies To                                    | Description                                                                                                                            | Source or Reasoning                                                                                                         |
| --------------------------------------------------------- | --------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------- |
| Request must have an employee                             | `EmployeeId`                                  | Must reference an existing employee.                                                                                                   | BRD business rule: a leave request must be associated with an employee.                                                     |
| Request must have a leave type                            | `LeaveTypeId`                                 | Must reference an existing active leave type for new submissions.                                                                      | BRD business rule: a leave request must have a leave type. Existing historical requests may reference inactive leave types. |
| Request must have a requested period                      | `RequestedStartDate`, `RequestedEndDate`      | Both dates are required.                                                                                                               | BRD business rule: a leave request must have a requested leave period.                                                      |
| Date range must be valid                                  | `RequestedStartDate`, `RequestedEndDate`      | End date must be on or after start date.                                                                                               | Prevents impossible leave periods.                                                                                          |
| Current status is required                                | `CurrentStatusId`                             | Must reference a valid leave request status.                                                                                           | BRD requires status visibility and workflow status changes.                                                                 |
| Initial status must represent submission                  | `CurrentStatusId`, `SubmittedDate`            | A newly submitted request should begin in the confirmed initial status, such as submitted or pending review.                           | The exact status values remain to be decided.                                                                               |
| Status transitions must be controlled                     | `CurrentStatusId`                             | Status should change only through confirmed workflow actions.                                                                          | Prevents arbitrary status changes that bypass business rules.                                                               |
| Manager cannot approve own leave                          | `EmployeeId`, related review reviewer         | A review action must not allow the requesting employee to approve their own request.                                                   | BRD security/business rule. Enforcement belongs in review workflow logic using `LEAVE_REQUEST` and `LEAVE_REQUEST_REVIEW`.  |
| Administrator approval requires manager role              | Related review actor                          | An administrator should not approve leave unless also authorized as a manager.                                                         | BRD business rule; role model remains undecided.                                                                            |
| Balance check is conditional                              | `EmployeeId`, `LeaveTypeId`, requested period | Employee cannot apply beyond balance when leave balance tracking and calculation rules are implemented.                                | BRD and TDD mention this rule, but leave balance design is unresolved.                                                      |
| Duplicate or overlapping requests require policy decision | `EmployeeId`, requested period, status        | The system should define whether overlapping active requests are allowed before enforcing a strict rule.                               | Overlap, amendment, cancellation, and partial-day rules remain undecided.                                                   |
| Optional reason must be bounded                           | `RequestReason`                               | If provided, it should be non-empty after trimming and within a confirmed maximum length.                                              | Prevents storing unusable or oversized free text. Final length remains to be decided.                                       |
| Audit timestamps must be ordered                          | `CreatedDate`, `UpdatedDate`, `SubmittedDate` | Updated date should be greater than or equal to created date; submitted date should align with creation or submission workflow timing. | Supports consistent audit interpretation.                                                                                   |
| Audit actors must be meaningful                           | `CreatedBy`, `UpdatedBy`                      | Must not be blank and must not contain secrets or credentials.                                                                         | Supports auditability while avoiding sensitive data exposure.                                                               |

## Initial Leave Status Codes

| Leave Status Code |
| ----------------- |
| `Pending`         |
| `Approved`        |
| `Rejected`        |
| `Cancelled`       |
| ----------------- |


## Stored Versus Derived Summary

Stored for Version 1:

- `LeaveRequestId`.
- `LeaveRequestNumber`, if the business identifier is confirmed.
- `EmployeeId`.
- `LeaveTypeId`.
- `RequestedStartDate`.
- `RequestedEndDate`.
- `RequestReason`, optional.
- `CurrentStatusId`.
- `SubmittedDate`.
- `CreatedDate`.
- `CreatedBy`.
- `UpdatedDate`.
- `UpdatedBy`.

Derived for Version 1:

- `RequestedDayCount`, until calendar, holiday, weekend, partial-day, and balance rules are confirmed.
- Pending approval queue membership, from current status and routing rules.
- Current reviewer, unless assigned reviewer must be frozen on the request.

Conditionally stored or deferred:

- `AssignedManagerEmployeeId`, if routing must be preserved at submission time.
- Status history fields, if detailed workflow audit becomes a Version 1 requirement.
- Cancellation fields, if cancellation becomes part of Version 1.
- Evaluated leave duration, if the business requires preserving the exact calculated duration used for balance decisions.

## Consequences

Positive consequences:

- The design supports the confirmed core workflow without creating physical schema prematurely.
- Current request status is easy to retrieve for employees and managers.
- Review outcomes remain separated from request submission data, matching the ERD.
- Derived values are identified so future implementation can avoid unnecessary duplication.

Tradeoffs and constraints:

- Without status history, the system preserves the current status but not every transition event.
- Without stored assigned manager, manager reassignment could affect derived pending-review views unless the business freezes assignment at submission time.
- Without stored requested day count, duration must be recalculated until leave calendar and balance rules are confirmed.
- Business identifier generation must be designed before implementation or DDL.

Still To Be Decided:

- Final table and column names.
- Final primary key generation strategy.
- `LeaveRequestNumber` format and generation rules.
- Initial leave request status values and transition rules.
- Whether assigned manager is stored on the request or derived from employee-manager routing.
- Whether request reason is required, optional, or omitted.
- Whether status history is required in Version 1.
- Whether cancellation is part of Version 1.
- Leave balance calculation, accrual, restoration, and enforcement rules.
- Weekend, holiday, partial-day, and half-day leave handling.
- Authentication, authorization, and audit actor identity model.

## Related Documents

- `README.md`
- `.ai/ContextPack.md`
- `docs/BRD.md`
- `docs/TDD.md`
- `docs/DomanModel.md`
- `docs/ERD.md`
- `docs/adr/ADR-001-Oracle26ai.md`
- `docs/adr/ADR-002-Dapper.md`
- `docs/adr/ADR-003-DotNet10.md`
- `docs/adr/AADR-004-Controllers.md`
- `docs/adr/ADR-005-LeaveRequest-Entity-Design.md`