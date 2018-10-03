/* Drop database and user if it exists */
DROP USER zoo CASCADE;

/* Create database and user */
CREATE USER zoo
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

/* Grant permissions to user */
GRANT connect to zoo;
GRANT resource to zoo;
GRANT create session to zoo;
GRANT create table to zoo;
GRANT create view to zoo;

