# EMPLOYEE Table Design

**Project:** Employee Leave Management System

**Table:** `EMPLOYEE`

**Status:** Draft logical table design

**Last Updated:** 2026-07-09

## 1. Business Purpose

The `EMPLOYEE` table stores the employee information needed to support the core leave workflow. It identifies people who can submit leave requests, view their request status, and act as managers for other employees when assigned that responsibility.

This table supports the BRD requirement to maintain employee and manager information and the ERD relationship where an employee may be managed by another employee. It does not model authentication, authorization, HR administrator identity, payroll, attendance, or external HR system integration because those decisions remain outside the current confirmed scope.

This document does not generate `CREATE TABLE` SQL or Oracle DDL.

## 2. Proposed Columns

| Column                   | Oracle Type Candidate      | Required? | Business Meaning                                                   |
| ------------------------ | -------------------------- | --------- | ------------------------------------------------------------------ |
| `EMPLOYEE_ID`            | `NUMBER(19)`               | Yes       | Internal employee surrogate identifier.                            |
| `EMPLOYEE_NUMBER`        | `VARCHAR2(30)`             | Yes       | Business-facing employee code or staff number.                     |
| `FIRST_NAME`             | `VARCHAR2(100)`            | Yes       | Employee given name.                                               |
| `LAST_NAME`              | `VARCHAR2(100)`            | Yes       | Employee family name.                                              |
| `EMAIL_ADDRESS`          | `VARCHAR2(320)`            | Yes       | Work email used for contact and lookup.                            |
| `MANAGER_EMPLOYEE_ID`    | `NUMBER(19)`               | No        | Employee responsible for reviewing this employee's leave requests. |
| `EMPLOYMENT_STATUS_CODE` | `VARCHAR2(20)`             | Yes       | Employee lifecycle status, such as active or inactive.             |
| `HIRE_DATE`              | `DATE`                     | Yes       | Date the employee joined the organization.                         |
| `TERMINATION_DATE`       | `DATE`                     | No        | Date the employee left the organization, if applicable.            |
| `CREATED_DATE`           | `TIMESTAMP WITH TIME ZONE` | Yes       | Date and time the row was created.                                 |
| `CREATED_BY`             | `VARCHAR2(100)`            | Yes       | Actor or process that created the row.                             |
| `UPDATED_DATE`           | `TIMESTAMP WITH TIME ZONE` | Yes       | Date and time the row was last updated.                            |
| `UPDATED_BY`             | `VARCHAR2(100)`            | Yes       | Actor or process that last updated the row.                        |

## 3. Primary Key

| Key         | Column        | Reasoning                                                                                                     |
| ----------- | ------------- | ------------------------------------------------------------------------------------------------------------- |
| Primary key | `EMPLOYEE_ID` | Stable internal identifier for relationships from leave requests, manager self-reference, and review records. |

`EMPLOYEE_ID` is proposed as a surrogate key because employee numbers and email addresses can change in real business operations. The final Oracle identity, sequence, or other key-generation mechanism remains to be decided before DDL is created.

## 4. Candidate Keys

| Candidate Key       | Columns           | Reasoning                                                                                                                                     |
| ------------------- | ----------------- | --------------------------------------------------------------------------------------------------------------------------------------------- |
| Employee number key | `EMPLOYEE_NUMBER` | Business-facing employee identifier should uniquely identify an employee if the organization confirms employee numbers are stable and unique. |
| Email key           | `EMAIL_ADDRESS`   | Work email should be unique for active employee records if the organization uses one account per employee.                                    |

Candidate key status should be confirmed before physical schema design. If historical rehire records, email reuse, or multiple employment records per person are required later, uniqueness rules may need refinement.

## 5. Foreign Keys

| Foreign Key                     | Column                | References             | Required? | Reasoning                                                                                                     |
| ------------------------------- | --------------------- | ---------------------- | --------- | ------------------------------------------------------------------------------------------------------------- |
| Employee manager self-reference | `MANAGER_EMPLOYEE_ID` | `EMPLOYEE.EMPLOYEE_ID` | No        | Supports manager routing while treating managers as employees until the role and identity model is confirmed. |

The manager relationship is nullable because manager routing rules are still undecided and some employees may exist before a manager is assigned. If future requirements confirm multiple managers, dated assignments, or approval chains, this self-reference should be replaced or supplemented by an Employee Manager Assignment table.

## 6. Audit Columns

| Column         | Rule                                      | Reasoning                                                                |
| -------------- | ----------------------------------------- | ------------------------------------------------------------------------ |
| `CREATED_DATE` | Required at insert and not changed later. | Supports basic auditability without defining a full audit history model. |
| `CREATED_BY`   | Required at insert.                       | Records the actor or process that created the employee row.              |
| `UPDATED_DATE` | Required at insert and each update.       | Supports troubleshooting and administrative visibility.                  |
| `UPDATED_BY`   | Required at insert and each update.       | Records the actor or process that last changed the employee row.         |

`CREATED_BY` and `UPDATED_BY` are not proposed as foreign keys yet because authentication, authorization, user identity, and HR administrator modeling remain to be decided.

## 7. Validation Rules

| Rule                      | Applies To                                   | Description                                                                                                       |
| ------------------------- | -------------------------------------------- | ----------------------------------------------------------------------------------------------------------------- |
| Required identifier       | `EMPLOYEE_ID`                                | Must be present for persisted rows. Generation strategy remains to be decided.                                    |
| Unique employee number    | `EMPLOYEE_NUMBER`                            | Must be unique if the business confirms employee numbers are stable unique identifiers.                           |
| Unique email address      | `EMAIL_ADDRESS`                              | Should be unique for active employee records unless future identity rules allow shared or reused email addresses. |
| Required names            | `FIRST_NAME`, `LAST_NAME`                    | Must not be blank.                                                                                                |
| Required email            | `EMAIL_ADDRESS`                              | Must not be blank and should follow a valid email format.                                                         |
| Manager must exist        | `MANAGER_EMPLOYEE_ID`                        | When provided, must reference an existing employee.                                                               |
| No self-manager           | `MANAGER_EMPLOYEE_ID`                        | Must not equal `EMPLOYEE_ID`; supports the rule that managers cannot approve their own leave.                     |
| Status allowed values     | `EMPLOYMENT_STATUS_CODE`                     | Should be limited to confirmed employee lifecycle statuses. Candidate values: `ACTIVE`, `INACTIVE`, `TERMINATED`. |
| Active employee date rule | `EMPLOYMENT_STATUS_CODE`, `TERMINATION_DATE` | Active employees should not have a termination date.                                                              |
| Termination date rule     | `HIRE_DATE`, `TERMINATION_DATE`              | If both dates are present, termination date must be on or after hire date.                                        |
| Audit timestamps          | `CREATED_DATE`, `UPDATED_DATE`               | Updated timestamp must be greater than or equal to created timestamp.                                             |
| Audit actors              | `CREATED_BY`, `UPDATED_BY`                   | Must not be blank and must not contain secrets or sensitive credential values.                                    |

## 8. Relationship Summary

| Relationship                              | Cardinality                                             | Optionality                                          | Implementation Candidate                                        |
| ----------------------------------------- | ------------------------------------------------------- | ---------------------------------------------------- | --------------------------------------------------------------- |
| Manager Employee to Employee              | One manager employee to zero or many managed employees. | Optional on both sides until routing is confirmed.   | `MANAGER_EMPLOYEE_ID` self-reference.                           |
| Employee to Leave Request                 | One employee to zero or many leave requests.            | Mandatory from Leave Request to Employee.            | Future `LEAVE_REQUEST.EMPLOYEE_ID` foreign key.                 |
| Reviewer Employee to Leave Request Review | One reviewer employee to zero or many reviews.          | Mandatory from Leave Request Review to Employee.     | Future `LEAVE_REQUEST_REVIEW.REVIEWER_EMPLOYEE_ID` foreign key. |
| Employee to Leave Balance                 | One employee to zero or many leave balances.            | Conditional until leave balance design is confirmed. | Future `LEAVE_BALANCE.EMPLOYEE_ID` foreign key if implemented.  |

## 9. Open Decisions

The following decisions should be resolved before creating Oracle DDL:

- Final primary key generation strategy for `EMPLOYEE_ID`.
- Final data lengths for names, employee number, email, and audit actor fields.
- Whether employee numbers and email addresses must be globally unique or only unique for active employees.
- Confirmed employee lifecycle status values.
- Whether manager routing remains a self-reference or moves to an assignment table.
- Whether HR/admin users are employees, application users, separate identities, or roles.
- Whether audit actor columns should reference a future user table.
- Whether optimistic concurrency should use `VERSION_NUMBER`, Oracle-specific features, or another approach.
