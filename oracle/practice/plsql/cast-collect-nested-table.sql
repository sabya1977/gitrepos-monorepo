drop type if exists practice.emp_tab;
drop type if exists practice.emp_obj;
-- Create object type for employee
create or replace type practice.emp_obj as object (
      employee_id number,
      first_name  varchar2(50),
      last_name   varchar2(50)
);
--
create or replace type practice.emp_tab as
   table of emp_obj;
--
grant execute on practice.emp_obj to oradev23;
--
grant execute on practice.emp_tab to oradev23;
--
select d.department_name,
       cast(collect(practice.emp_obj(
          e.employee_id,
          e.first_name,
          e.last_name
       )) as practice.emp_tab) as emp_collection
  from hr.employees e
 inner join hr.departments d
using ( department_id )
 where department_id = 80
 group by d.department_name;
--