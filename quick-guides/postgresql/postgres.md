-- using psql
sudo -u postgres psql

\q to quit

psql -d postgres -U postgres -h localhost

-- using pg_ctl 

sudo -u postgres pg_ctl status -D $PGDATA

-- create superuser or dba in postgresql
CREATE USER koba WITH ENCRYPTED PASSWORD 'postgres';
ALTER USER koba WITH SUPERUSER;