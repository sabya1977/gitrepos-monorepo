drop user if exists f1data cascade
/

create user f1data identified by "oracle"
/
alter user f1data
   enable editions
/
grant connect,resource to f1data
/
grant create any view to f1data
/
grant create any table to f1data
/
grant create any view to f1data
/
grant drop any view to f1data
/
grant drop any table to f1data
/
grant drop any view to f1data
/
grant execute on dbms_crypto to f1data
/
grant unlimited tablespace to f1data
/
grant alter any procedure to f1data
/
grant create any procedure to f1data
/
grant drop any procedure to f1data
/
grant execute any procedure to f1data
/
grant select any table to f1data
/
grant create any synonym to f1data
/
grant create public synonym to f1data
/

grant create analytic view to f1data
/
grant create attribute dimension to f1data
/
grant alter session to f1data
/
grant create hierarchy to f1data
/
grant create job to f1data
/
grant create materialized view to f1data
/
grant create mining model to f1data
/
grant create procedure to f1data
/
grant create sequence to f1data
/
grant create session to f1data
/
grant create synonym to f1data
/
grant create table to f1data
/
grant create trigger to f1data
/
grant create type to f1data
/
grant create view to f1data
/
create or replace directory test_dir as '/tmp';
grant read,write on directory test_dir to f1data;
grant exp_full_database to f1data;
grant imp_full_database to f1data;