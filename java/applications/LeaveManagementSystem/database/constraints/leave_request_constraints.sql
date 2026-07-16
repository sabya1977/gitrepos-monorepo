-- Lesson 18 – Constraints (LEAVE_REQUEST table)
alter table lms_leave_request add constraint lms_pk_leave_request primary key ( leave_request_id );

alter table lms_leave_request
   add constraint lms_fk_leave_request_employee foreign key ( employee_id )
      references lms_employee ( employee_id );

alter table lms_leave_request
   add constraint lms_fk_leave_request_leave_type foreign key ( leave_type_id )
      references lms_leave_type ( leave_type_id );

alter table lms_leave_request
   add constraint lms_fk_approver_id foreign key ( approver_id )
      references lms_employee ( employee_id );

alter table lms_leave_request add constraint lms_ck_leave_request_date_range check ( requested_end_date >= requested_start_date

);

alter table lms_leave_request add constraint lms_ck_leave_request_audit_dates check ( updated_date >= created_date );

alter table lms_leave_request add constraint lms_ck_leave_request_submitted_date check ( submitted_date >= created_date );

alter table lms_leave_request
   add constraint lms_ck_leave_request_reason_not_blank
      check ( request_reason is null
          or trim(request_reason) is not null );

alter table lms_leave_request
   add constraint lms_ck_leave_request_status_not_blank check ( trim(current_status_id) is not null );

alter table lms_leave_request
   add constraint lms_ck_valid_status_code
      check ( current_status_id in ( 'Pending',
                                     'Approved',
                                     'Rejected',
                                     'Cancelled' ) );

alter table lms_leave_request
   add constraint lms_ck_leave_request_created_by_not_blank check ( trim(created_by) is not null );

alter table lms_leave_request
   add constraint lms_ck_leave_request_updated_by_not_blank check ( trim(updated_by) is not null );