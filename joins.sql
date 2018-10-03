-- Inner join: TableA inner join TableB on FK = PK
-- Combining columns from two tables
SELECT ANIMALS.name, EMPLOYEES.name 
FROM ANIMALS INNER JOIN EMPLOYEES
ON EMPLOYEES.animal = ANIMALS.id;

-- Union: SELECT TableA (WHERE blah) UNION SELECT TableA (Where blah)
-- Columns have to match
SELECT * FROM ANIMALS INNER JOIN EMPLOYEES ON animal = ANIMALS.id 
WHERE ANIMALS.age > 5
UNION
SELECT * FROM ANIMALS INNER JOIN EMPLOYEES ON animal = ANIMALS.id 
WHERE legs < 6;