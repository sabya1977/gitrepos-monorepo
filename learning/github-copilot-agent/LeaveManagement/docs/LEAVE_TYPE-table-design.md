# LEAVE_TYPE Table Design

**Project:** Employee Leave Management System

**Table:** `LEAVE_TYPE`

**Status:** Draft logical table design

**Last Updated:** 2026-07-09

## 1. Business Purpose

The `LEAVE_TYPE` table stores the leave categories that employees can select when submitting leave requests. It supports the BRD requirement to maintain basic leave types, including vacation, sick leave, compensatory, unpaid leave, casual leave, maternity leave, paternity leave, menstrual leave, study leave, and sabbatical leave.

This table is master data used by the leave request workflow. It allows HR or administrative users to maintain leave categories without embedding leave type names directly in leave request records.

This document does not generate `CREATE TABLE` SQL or Oracle DDL.

## 2. Proposed Columns

| Column                 | Oracle Type Candidate      | Required? | Business Meaning                                                |
| ---------------------- | -------------------------- | --------- | --------------------------------------------------------------- |
| `LEAVE_TYPE_ID`        | `NUMBER(19)`               | Yes       | Internal surrogate identifier for a leave type.                 |
| `LEAVE_TYPE_CODE`      | `VARCHAR2(30)`             | Yes       | Stable business code for the leave type.                        |
| `LEAVE_TYPE_NAME`      | `VARCHAR2(90)`             | Yes       | Human-readable leave type name shown to users.                  |
| `MAX_DAYS_PER_REQUEST` | `NUMBER(10,2)`             | Yes       | Maximum days allowed for the leave type                         |
| `DESCRIPTION`          | `VARCHAR2(500)`            | No        | Optional business description for HR/admin maintenance.         |
| `IS_ACTIVE`            | `CHAR(1)`                  | Yes       | Indicates whether the leave type is available for new requests. |
| `CREATED_DATE`         | `TIMESTAMP WITH TIME ZONE` | Yes       | Date and time the row was created.                              |
| `CREATED_BY`           | `VARCHAR2(100)`            | Yes       | Actor or process that created the row.                          |
| `UPDATED_DATE`         | `TIMESTAMP WITH TIME ZONE` | Yes       | Date and time the row was last updated.                         |
| `UPDATED_BY`           | `VARCHAR2(100)`            | Yes       | Actor or process that last updated the row.                     |

## 3. Primary Key

| Key         | Column          | Reasoning                                                                                               |
| ----------- | --------------- | ------------------------------------------------------------------------------------------------------- |
| Primary key | `LEAVE_TYPE_ID` | Stable internal identifier for relationships from leave requests and conditional leave balance records. |

`LEAVE_TYPE_ID` is proposed as a surrogate key so display names and business codes can be maintained without changing related leave request records. The final Oracle identity, sequence, or other key-generation mechanism remains to be decided before DDL is created.

## 4. Candidate Keys

| Candidate Key       | Columns           | Reasoning                                                                                          |
| ------------------- | ----------------- | -------------------------------------------------------------------------------------------------- |
| Leave type code key | `LEAVE_TYPE_CODE` | Provides a stable business identifier for application logic, reporting, and HR/admin maintenance.  |
| Leave type name key | `LEAVE_TYPE_NAME` | Prevents duplicate user-facing leave category names if the business confirms names must be unique. |

Candidate key status should be confirmed before physical schema design. If the business allows localized names, renamed leave types, or multiple policy variants with similar names, the uniqueness rule for `LEAVE_TYPE_NAME` may need refinement.

## 5. Foreign Keys

The `LEAVE_TYPE` table has no proposed foreign keys in the current logical design.

Other tables are expected to reference `LEAVE_TYPE`:

| Referencing Table | Candidate Column | Reasoning                                                        |
| ----------------- | ---------------- | ---------------------------------------------------------------- |
| `LEAVE_REQUEST`   | `LEAVE_TYPE_ID`  | Each leave request must identify the requested leave category.   |
| `LEAVE_BALANCE`   | `LEAVE_TYPE_ID`  | Conditional relationship if leave balance tracking is confirmed. |

## 6. Audit Columns

| Column         | Rule                                      | Reasoning                                                            |
| -------------- | ----------------------------------------- | -------------------------------------------------------------------- |
| `CREATED_DATE` | Required at insert and not changed later. | Supports basic auditability for maintained reference data.           |
| `CREATED_BY`   | Required at insert.                       | Records the actor or process that created the leave type.            |
| `UPDATED_DATE` | Required at insert and each update.       | Supports tracking changes made by HR/admin users or setup processes. |
| `UPDATED_BY`   | Required at insert and each update.       | Records the actor or process that last changed the leave type.       |

`CREATED_BY` and `UPDATED_BY` are not proposed as foreign keys yet because authentication, authorization, user identity, and HR administrator modeling remain to be decided.

## 7. Validation Rules

| Rule                | Applies To                                               | Description                                                                                                                  |
| ------------------- | -------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------- |
| Required identifier | `LEAVE_TYPE_ID`                                          | Must be present for persisted rows. Generation strategy remains to be decided.                                               |
| Required code       | `LEAVE_TYPE_CODE`                                        | Must not be blank.                                                                                                           |
| Unique code         | `LEAVE_TYPE_CODE`                                        | Must uniquely identify a leave type.                                                                                         |
| Code format         | `LEAVE_TYPE_CODE`                                        | Should use a stable uppercase code such as `VACATION`, `SICK`, or `UNPAID`.                                                  |
| Required name       | `LEAVE_TYPE_NAME`                                        | Must not be blank.                                                                                                           |
| Unique name         | `LEAVE_TYPE_NAME`                                        | Should be unique if the business confirms user-facing names cannot repeat.                                                   |
| Active flag values  | `IS_ACTIVE`                                              | Must use confirmed values only. Candidate values: `Y` and `N`.                                                               |
| Inactive type usage | `IS_ACTIVE`                                              | Inactive leave types should not be available for new leave requests. Existing requests may still reference them for history. |
| Description length  | `DESCRIPTION`                                            | Must stay within the confirmed length and should not contain policy rules that belong in future policy tables.               |
| Audit timestamps    | `CREATED_DATE`, `UPDATED_DATE`                           | Updated timestamp must be greater than or equal to created timestamp.                                                        |
| Audit actors        | `CREATED_BY`, `UPDATED_BY`                               | Must not be blank and must not contain secrets or sensitive credential values.                                               |
| Required identifier | `MAX_DAYS_PER_REQUEST`         Must be greater than zero |

## 8. Initial Planned Leave Types

The BRD lists the following planned leave types as initial business values:

| Leave Type Name    | Candidate Code |
| ------------------ | -------------- |
| Vacation           | `VL`           |
| Sick Leave         | `SL`           |
| Compensatory Leave | `COL`          |
| Unpaid Leave       | `UPL`          |
| Casual Leave       | `CL`           |
| Maternity Leave    | `ML`           |
| Paternity Leave    | `PL`           |
| Menstrual Leave    | `MENL`         |
| Study Leave        | `STDL`         |
| Sabbatical Leave   | `SBL`          |

These are candidate reference values only. This document does not create seed data or insert statements.

## 9. Relationship Summary

| Relationship                | Cardinality                                    | Optionality                                          | Implementation Candidate                                         |
| --------------------------- | ---------------------------------------------- | ---------------------------------------------------- | ---------------------------------------------------------------- |
| Leave Type to Leave Request | One leave type to zero or many leave requests. | Mandatory from Leave Request to Leave Type.          | Future `LEAVE_REQUEST.LEAVE_TYPE_ID` foreign key.                |
| Leave Type to Leave Balance | One leave type to zero or many leave balances. | Conditional until leave balance design is confirmed. | Future `LEAVE_BALANCE.LEAVE_TYPE_ID` foreign key if implemented. |

## 10. Open Decisions

The following decisions should be resolved before creating Oracle DDL:

- Final primary key generation strategy for `LEAVE_TYPE_ID`.
- Final data lengths for leave type code, name, description, and audit actor fields.
- Whether `LEAVE_TYPE_NAME` must be unique or only `LEAVE_TYPE_CODE` must be unique.
- Confirmed code naming convention for leave types.
- Confirmed active flag values and lifecycle behavior for retired leave types.
- Whether half-day should remain a leave type or become a future request duration/partial-day attribute.
- Whether policy-specific fields belong in this table or in future leave policy tables.
- Whether audit actor columns should reference a future user table.
