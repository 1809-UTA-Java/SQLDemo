/* Create tables */
CREATE TABLE ANIMALS (
	id integer primary key,
	name varchar2(50),
	age integer check (age > 0),
	legs integer not null
);

/* each column is defined with [name] [type] [constraint] [constraint] */

CREATE TABLE EMPLOYEES (
	id integer primary key,
	name varchar2(50),
	age integer not null,
	job varchar2(50),
	animal integer
);

/* Create foreign keys with alter command */
ALTER TABLE EMPLOYEES ADD CONSTRAINT FKAnimals
FOREIGN KEY (animal)
REFERENCES ANIMALS (id)
ON DELETE CASCADE;
