-- Lesson 18 – Constraints (LEAVE_TYPE table)

alter table lms_leave_type add constraint lms_pk_leave_type primary key ( leave_type_id );

alter table lms_leave_type add constraint lms_uk_leave_type_leave_type_code unique ( leave_type_code );

alter table lms_leave_type add constraint lms_uk_leave_type_leave_type_name unique ( leave_type_name );

alter table lms_leave_type
   add constraint lms_ck_leave_type_code_not_blank check ( trim(leave_type_code) is not null );

alter table lms_leave_type
   add constraint lms_ck_valid_leave_type_code
      check ( leave_type_code in ( 'VL',
                                   'SL',
                                   'COL',
                                   'UPL',
                                   'CL',
                                   'ML',
                                   'PL',
                                   'MENL',
                                   'STDL',
                                   'SBL' ) );
alter table lms_leave_type
   add constraint lms_ck_leave_type_code_uppercase check ( leave_type_code = upper(leave_type_code) );

alter table lms_leave_type
   add constraint lms_ck_leave_type_name_not_blank check ( trim(leave_type_name) is not null );

alter table lms_leave_type add constraint lms_ck_leave_type_max_days_positive check ( max_days_per_request > 0 );

alter table lms_leave_type
   add constraint lms_ck_leave_type_is_active check ( is_active in ( 'Y',
                                                                     'N' ) );

alter table lms_leave_type add constraint lms_ck_leave_type_audit_dates check ( updated_date >= created_date );

alter table lms_leave_type
   add constraint lms_ck_leave_type_created_by_not_blank check ( trim(created_by) is not null );

alter table lms_leave_type
   add constraint lms_ck_leave_type_updated_by_not_blank check ( trim(updated_by) is not null );