## Step 1: Create a Named Docker Volume
docker volume create orcl_vol

## Step 2: Pull and Start the Oracle Database Container
docker run -d --name oracle26ai \
  -p 1521:1521 \
  -v orcl_vol:/opt/oracle/oradata \
  -e ORACLE_PWD=oracle \
  container-registry.oracle.com/database/free:latest

## Step 3: Monitor Database Initialization
docker logs -f oracle26ai

## Step 4: Detaching the Volume (Simulating a Purge)
docker stop oracle26ai
docker rm oracle26ai

## Remove the image (Optional):
docker rmi container-registry.oracle.com/database/free:latest

## Step 5: Attaching the Volume to a New Container/Image
docker run -d --name oracle26ai \
  -p 1521:1521 \
  -v orcl_vol:/opt/oracle/oradata \
  -e ORACLE_PWD=oracle \
  container-registry.oracle.com/database/free:latest

## ⚠️ Important: When re-attaching a volume, always make sure the environment variable      password (ORACLE_PWD) matches the password originally used when the database files were generated, otherwise internal wallet and admin credentials may mismatch.

## Step 6: Connect to your Database

Hostname: localhost

Port: 1521

Username: SYSTEM or SYS (as SYSDBA)

Password: YourSecurePassword123!

Container Database (CDB) SID: FREE

Pluggable Database (PDB) Service Name: freepdb1
