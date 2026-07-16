-- Lesson 19 – Indexes (LEAVE_REQUEST table)
create index lms_idx_leave_request_employee_submitted on
   lms_leave_request (
      employee_id,
      submitted_date
   );

create index lms_idx_leave_request_approver_status_submitted on
   lms_leave_request (
      approver_id,
      current_status_id,
      submitted_date
   );