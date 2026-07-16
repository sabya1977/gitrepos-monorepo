-- Lesson 17 – Table DDL (LEAVE_TYPE)
create table lms_leave_type (
   leave_type_id        number(19) not null,
   leave_type_code      varchar2(30 char) not null,
   leave_type_name      varchar2(90 char) not null,
   max_days_per_request number(10,2) not null,
   description          varchar2(500 char),
   is_active            char(1) not null,
   created_date         timestamp with time zone not null,
   created_by           varchar2(100 char) not null,
   updated_date         timestamp with time zone not null,
   updated_by           varchar2(100 char) not null
);