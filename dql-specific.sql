/*
SELECT [columns]
FROM [tables]
WHERE [conditions]
GROUP BY [columns]
ORDER BY [columns]
*/
SELECT name, age FROM ANIMALS
WHERE age > 5;

SELECT ANIMALS.name, COUNT(ANIMALS.id) FROM ANIMALS, EMPLOYEES
GROUP BY ANIMALS.name;

/* Count is an example of an aggregate function: a function that operates on all rows and returns a value */

/* Scalar functions operate on one row only */

/* Views are saved Select operations */
CREATE VIEW VWANIMALS (animal, total) AS
SELECT ANIMALS.name, COUNT(ANIMALS.id) FROM ANIMALS, EMPLOYEES
GROUP BY ANIMALS.name;