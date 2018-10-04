/* Populate tables */
--@ddl-drop.sql
--@ddl.sql

SAVEPOINT beforeInserts;

INSERT INTO ANIMALS
VALUES (1, 'Hippo', 15, 1);

INSERT INTO ANIMALS
VALUES (2, '', 1, 0);

INSERT INTO EMPLOYEES
VALUES (1, 'Bob', 23, 'vet', 2);

INSERT INTO EMPLOYEES
VALUES (2, 'Bobbert', 23, null, 1);

INSERT INTO EMPLOYEES (id, name, age, animal)
VALUES (3, 'Bobby', 23, 2);

UPDATE ANIMALS SET name = 'cobra' WHERE id = 2;

--Delete a row
DELETE FROM ANIMALS WHERE id = 2;

ROLLBACK TO beforeInserts;

--Create sequence
CREATE SEQUENCE SQAnimalPK START WITH 3 INCREMENT BY 1;

--Create trigger (before insert, call sequence)
CREATE OR REPLACE TRIGGER TRINSERTANIMAL
BEFORE INSERT ON ANIMALS
FOR EACH ROW
BEGIN
	SELECT SQAnimalPK.NEXTVAL INTO :NEW.id FROM DUAL;
END;
/
/*
public void trinsertanimal() {
	for(Row r: rows) {
		r.id = sqanimalpk.next();
	}
}
*/

INSERT INTO ANIMALS (name, age, legs)
VALUES ('Bobb', 23, 6);


COMMIT;
