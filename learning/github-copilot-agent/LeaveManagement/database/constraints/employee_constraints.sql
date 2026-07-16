-- Lesson 18 – Constraints (EMPLOYEE table)
alter table lms_employee add constraint lms_pk_employee primary key ( employee_id );

alter table lms_employee add constraint lms_uk_employee_employee_number unique ( employee_number );

alter table lms_employee add constraint lms_uk_employee_email_address unique ( email_address );

alter table lms_employee
   add constraint lms_fk_employee_employee foreign key ( manager_employee_id )
      references lms_employee ( employee_id );

alter table lms_employee
   add constraint lms_ck_employee_no_self_manager
      check ( manager_employee_id is null
          or manager_employee_id <> employee_id );

alter table lms_employee
   add constraint lms_ck_employee_status_code
      check ( employment_status_code in ( 'ACTIVE',
                                          'INACTIVE',
                                          'TERMINATED' ) );

alter table lms_employee
   add constraint lms_ck_employee_active_term_date
      check ( employment_status_code <> 'ACTIVE'
          or termination_date is null );

alter table lms_employee
   add constraint lms_ck_employee_term_after_hire
      check ( termination_date is null
          or termination_date >= hire_date );

alter table lms_employee add constraint lms_ck_employee_audit_dates check ( updated_date >= created_date );

alter table lms_employee
   add constraint lms_ck_employee_first_name_not_blank check ( trim(first_name) is not null );

alter table lms_employee
   add constraint lms_ck_employee_last_name_not_blank check ( trim(last_name) is not null );

alter table lms_employee
   add constraint lms_ck_employee_email_not_blank check ( trim(email_address) is not null );

alter table lms_employee
   add constraint lms_ck_employee_created_by_not_blank check ( trim(created_by) is not null );

alter table lms_employee
   add constraint lms_ck_employee_updated_by_not_blank check ( trim(updated_by) is not null );