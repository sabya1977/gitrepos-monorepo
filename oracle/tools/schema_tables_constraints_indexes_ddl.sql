-- Print table, column, constraint, and index DDL/details for one or more schemas.
-- Defaults to the FACETS and FACETS_XC schemas when no argument is provided.
-- Usage examples:
--   @schema_tables_constraints_indexes_ddl.sql
--   @schema_tables_constraints_indexes_ddl.sql FACETS
--   @schema_tables_constraints_indexes_ddl.sql FACETS,FACETS_XC

   set define on
set verify off
set feedback on
set heading on
set trimspool on
set pagesize 50000
set linesize 32767
set long 10000000
set longchunksize 32767
set serveroutput on size unlimited

column p_schemas new_value p_schemas noprint
select upper(replace(
   nvl(
      nullif(
         '&&1',
         ''
      ),
      'FACETS,FACETS_XC'
   ),
   ' ',
   ''
)) p_schemas
  from dual;

pro   
pro    ============================================================
pro    Schemas: &&p_schemas
pro    ============================================================
pro   

begin
   dbms_metadata.set_transform_param(
      dbms_metadata.session_transform,
      'PRETTY',
      true
   );
   dbms_metadata.set_transform_param(
      dbms_metadata.session_transform,
      'SQLTERMINATOR',
      true
   );
   dbms_metadata.set_transform_param(
      dbms_metadata.session_transform,
      'SEGMENT_ATTRIBUTES',
      true
   );
   dbms_metadata.set_transform_param(
      dbms_metadata.session_transform,
      'STORAGE',
      true
   );
   dbms_metadata.set_transform_param(
      dbms_metadata.session_transform,
      'TABLESPACE',
      true
   );
   dbms_metadata.set_transform_param(
      dbms_metadata.session_transform,
      'CONSTRAINTS',
      true
   );
   dbms_metadata.set_transform_param(
      dbms_metadata.session_transform,
      'REF_CONSTRAINTS',
      true
   );
end;
/

pro   
pro    ===================== TABLE COLUMNS ========================
pro   

column owner format a30
column table_name format a40
column column_name format a40
column data_type format a35
column nullable format a8
column data_default format a80 word_wrapped

with target_schemas as (
   select distinct regexp_substr(
      '&&p_schemas',
      '[^,]+',
      1,
      level
   ) owner
     from dual
   connect by
      regexp_substr(
         '&&p_schemas',
         '[^,]+',
         1,
         level
      ) is not null
)
select c.owner,
       c.table_name,
       c.column_id,
       c.column_name,
       case
          when c.data_type in ( 'CHAR',
                                'NCHAR',
                                'VARCHAR2',
                                'NVARCHAR2' ) then
             c.data_type
             || '('
             || c.char_col_decl_length
             || ')'
          when c.data_type = 'NUMBER'
             and c.data_precision is not null then
             c.data_type
             || '('
             || c.data_precision
             ||
             case
                when c.data_scale is not null then
                      ',' || c.data_scale
                else
                   ''
             end
             || ')'
          when c.data_type like 'TIMESTAMP%'
             and c.data_scale is not null then
             c.data_type
             || '('
             || c.data_scale
             || ')'
          else
             c.data_type
       end as data_type,
       c.nullable,
       c.data_default
  from all_tab_columns c
  join all_tables t
on t.owner = c.owner
   and t.table_name = c.table_name
  join target_schemas s
on s.owner = c.owner
 order by c.owner,
          c.table_name,
          c.column_id;

pro   
pro    ===================== CONSTRAINTS ==========================
pro   

column constraint_type_desc format a12
column constraint_name format a40
column columns format a100 word_wrapped
column referenced_table format a60
column search_condition format a120 word_wrapped

with target_schemas as (
   select distinct regexp_substr(
      '&&p_schemas',
      '[^,]+',
      1,
      level
   ) owner
     from dual
   connect by
      regexp_substr(
         '&&p_schemas',
         '[^,]+',
         1,
         level
      ) is not null
),constraint_cols as (
   select cc.owner,
          cc.constraint_name,
          listagg(cc.column_name,
                  ', ') within group(
           order by cc.position) as columns
     from all_cons_columns cc
    group by cc.owner,
             cc.constraint_name
)
select c.owner,
       c.table_name,
       c.constraint_name,
       case c.constraint_type
          when 'P' then
             'PRIMARY KEY'
          when 'U' then
             'UNIQUE'
          when 'R' then
             'FOREIGN KEY'
          when 'C' then
             'CHECK'
          else
             c.constraint_type
       end as constraint_type_desc,
       nvl(
          cc.columns,
          '-'
       ) as columns,
       case
          when c.constraint_type = 'R' then
             rc.owner
             || '.'
             || rc.table_name
          else
             '-'
       end as referenced_table,
       case
          when c.constraint_type = 'C' then
             c.search_condition
          else
             null
       end as search_condition,
       c.status
  from all_constraints c
  left join constraint_cols cc
on cc.owner = c.owner
   and cc.constraint_name = c.constraint_name
  left join all_constraints rc
on rc.owner = c.r_owner
   and rc.constraint_name = c.r_constraint_name
  join target_schemas s
on s.owner = c.owner
 where c.constraint_type in ( 'P',
                              'U',
                              'R',
                              'C' )
   and exists (
   select 1
     from all_tables t
    where t.owner = c.owner
      and t.table_name = c.table_name
)
 order by c.owner,
          c.table_name,
          c.constraint_type,
          c.constraint_name;

pro   
pro    ===================== TABLE DDL ============================
pro   

with target_schemas as (
   select distinct regexp_substr(
      '&&p_schemas',
      '[^,]+',
      1,
      level
   ) owner
     from dual
   connect by
      regexp_substr(
         '&&p_schemas',
         '[^,]+',
         1,
         level
      ) is not null
)
select dbms_metadata.get_ddl(
   'TABLE',
   t.table_name,
   t.owner
) as ddl_text
  from all_tables t
  join target_schemas s
on s.owner = t.owner
 order by t.owner,
          t.table_name;

pro   
pro    ===================== INDEX DDL ============================
pro   

with target_schemas as (
   select distinct regexp_substr(
      '&&p_schemas',
      '[^,]+',
      1,
      level
   ) owner
     from dual
   connect by
      regexp_substr(
         '&&p_schemas',
         '[^,]+',
         1,
         level
      ) is not null
)
select dbms_metadata.get_ddl(
   'INDEX',
   i.index_name,
   i.owner
) as ddl_text
  from all_indexes i
  join target_schemas s
on s.owner = i.table_owner
 where i.temporary = 'N'
 order by i.owner,
          i.index_name;

undefine 1
undefine p_schemas