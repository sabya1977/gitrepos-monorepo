rem
rem Copyright (c) 2023 Sabyasachi Mitra
rem Freely available for Oracle Database 19c onwards
rem Function: create custom developer role and create a dba and dev user
rem should be run as sys
rem

   SET ECHO OFF
SET VERIFY OFF
SET HEADING OFF
SET FEEDBACK OFF
SET DEFINE ON
-- Exit setup script on any error
WHENEVER SQLERROR EXIT SQL.SQLCODE
rem =======================================================
rem Install descriptions
rem =======================================================
PROMPT
PROMPT The script will prompt you to enter a developer and dba user name/password
PROMPT If the values are blank it will raise application error and exit
PROMPT
rem =======================================================
rem Log installation process
rem =======================================================
SPOOL db_setup.log
rem =======================================================
rem Accept and verify developer/dba username/password
rem =======================================================
ACCEPT username PROMPT 'Enter developer user name: '
ACCEPT passwrd PROMPT 'Enter developer password: ' HIDE
begin
   if '&username' is null
   or '&passwrd' is null then
      raise_application_error(
         -20999,
         'Error: the username/password mandatory! Please specify a password!'
      );
   end if;
end;
/
define devusr = '&username'
define devpwd = '&passwrd'
--
ACCEPT username PROMPT 'Enter dba user name: '
ACCEPT passwrd PROMPT 'Enter dba password: ' HIDE

begin
   if '&username' is null
   or '&passwrd' is null then
      raise_application_error(
         -20999,
         'Error: the username/password mandatory! Please specify a password!'
      );
   end if;
end;
/
define dbausr = '&username'
define dbapwd = '&passwrd'
rem =======================================================
rem                   drop users and roles
rem =======================================================
drop user if exists &devusr cascade;
drop user if exists &dbausr cascade;
drop role if exists developer;
rem =======================================================
rem               Create developer role
rem =======================================================
PROMPT
PROMPT Creating developer role
PROMPT
create role developer not identified;
rem =======================================================
rem              Grant provileges to Developer role
rem =======================================================
PROMPT
PROMPT Granting provileges to Developer role
PROMPT
grant read any table to developer;
--
grant create session to developer;
--
grant select_catalog_role to developer;
--
grant resource to developer;
-- 
grant create job to developer;
grant grant any object privilege to developer;
grant drop any materialized view to developer;
grant create materialized view to developer;
grant drop any procedure to developer;
grant alter any table to developer;
grant on commit refresh to developer;
grant alter any type to developer;
grant alter any materialized view to developer;
grant execute any procedure to developer;
grant alter session to developer;
grant analyze any to developer;
grant alter any procedure to developer;
grant create any sequence to developer;
grant create view to developer;
grant query rewrite to developer;
grant alter any trigger to developer;
grant alter any sequence to developer;
grant drop any index to developer;
grant alter any index to developer;
grant read any table to developer;
grant drop any trigger to developer;
grant drop any sequence to developer;
grant delete any table to developer;
grant update any table to developer;
grant insert any table to developer;
grant drop any table to developer;
grant create any table to developer;
grant drop any type to developer;
grant create any procedure to developer;
grant select any sequence to developer;
grant create any type to developer;
grant create any trigger to developer;
grant create any index to developer;
grant select any table to developer;
grant create session to developer;
grant create any context to developer;
grant create any materialized view to developer;
grant drop any view to developer;
grant create any view to developer;
grant advisor to developer;
grant administer any sql tuning set to developer;
grant administer sql tuning set to developer;
grant administer sql management object to developer;
grant create materialized view to developer;
grant execute on dbms_advanced_rewrite to developer;
grant execute on sys.dbms_lock to developer;
grant select on sys.v_$parameter to developer;
grant manage scheduler to developer;
grant alter session to developer;
grant alter system to developer;
grant analyze any to developer;
grant analyze any dictionary to developer;
grant create any job to developer;
rem =======================================================
rem              Create developer
rem =======================================================
PROMPT
PROMPT Creating developer
PROMPT
create user &devusr identified by &devpwd
   default tablespace users
   temporary tablespace temp
   profile default
   account unlock;
--
alter user &devusr
   quota unlimited on users;
rem =======================================================
rem              Granting developer roles and privs
rem =======================================================
PROMPT
PROMPT Granting developer roles and privs
PROMPT
grant execute on dbms_stats to &devusr;
grant select on sys.v_$statname to &devusr;
grant select on sys.v_$mystat to &devusr;
grant select on sys.v_$latch to &devusr;
grant select on sys.v_$timer to &devusr;
grant select on v_$parameter to &devusr;
grant select on v_$session to &devusr;
grant select on v_$sql_plan_statistics_all to &devusr;
grant select on v_$sql to &devusr;
grant select on v_$sql_plan to &devusr;
grant select on v_$sql_shared_cursor to &devusr;
grant select on v_$sql to &devusr;
grant select on v_$process to &devusr;
grant select on v_$mystat to &devusr;
grant select on v_$sql to &devusr;
grant select on v_$sql_bind_capture to &devusr;
grant select on v_$sqlarea to &devusr;
grant select on v_$sqlarea_plan_hash to &devusr;
grant select on v_$sqlstats to &devusr;
grant select on v_$result_cache_objects to &devusr;
grant select on sys.col_usage$ to &devusr;
-- 
begin
   sys.dbms_resource_manager_privs.grant_system_privilege(
      grantee_name   => '&devusr',
      privilege_name => 'ADMINISTER_RESOURCE_MANAGER',
      admin_option   => false
   );
end;
/
--
grant developer to &devusr;
--
rem =======================================================
rem              Create DBA
rem =======================================================
PROMPT
PROMPT Creating DBA
PROMPT
create user &dbausr identified by &dbapwd
   default tablespace users
   temporary tablespace temp
   profile default
   account unlock;
--
alter user &dbausr
   quota unlimited on users;
--
rem =======================================================
rem              Granting dba roles and privs
rem =======================================================
PROMPT
PROMPT Granting dba roles and privs
PROMPT
grant dba to &dbausr;
-- 
grant exp_full_database to &dbausr;
-- 
grant imp_full_database to &dbausr;
spool off
PROMPT
PROMPT DB Setup is complete!
PROMPT
exit