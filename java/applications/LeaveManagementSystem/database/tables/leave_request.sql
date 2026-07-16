-- Lesson 17 – Table DDL (LEAVE_REQUEST)
create table lms_leave_request (
   leave_request_id     number(19) not null,
   employee_id          number(19) not null,
   approver_id          number(19) not null,
   leave_type_id        number(19) not null,
   requested_start_date date not null,
   requested_end_date   date not null,
   request_reason       varchar2(60 char),
   current_status_id    varchar2(20 char) not null,
   submitted_date       date not null,
   created_date         date not null,
   created_by           varchar2(100 char) not null,
   updated_date         date not null,
   updated_by           varchar2(100 char) not null
);