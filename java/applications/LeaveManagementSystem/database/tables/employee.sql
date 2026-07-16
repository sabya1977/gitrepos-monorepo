-- Lesson 17 – Table DDL (Employee)
create table lms_employee (
   employee_id            number(19) not null,
   employee_number        varchar2(30 char) not null,
   first_name             varchar2(100 char) not null,
   last_name              varchar2(100 char) not null,
   email_address          varchar2(320 char) not null,
   manager_employee_id    number(19),
   employment_status_code varchar2(20 char) not null,
   hire_date              date not null,
   termination_date       date,
   created_date           timestamp with time zone not null,
   created_by             varchar2(100 char) not null,
   updated_date           timestamp with time zone not null,
   updated_by             varchar2(100 char) not null
);