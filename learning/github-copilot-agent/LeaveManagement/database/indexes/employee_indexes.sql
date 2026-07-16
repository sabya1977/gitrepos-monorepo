-- Lesson 19 – Indexes (EMPLOYEE table)
create index lms_idx_employee_manager_employee_id on
   lms_employee (
      manager_employee_id
   );