--PL/SQL Procedural Language/SQL
/* Functions: executable blocks of code with 0 or many input parameters, but 0 or 1 simple output parameters. 
    They cannot have DML statements nor call stored procedures, but can call other functions or views. */
-- public int add_num(int x, int y)
CREATE OR REPLACE FUNCTION 
ADD_NUM (X IN NUMBER, Y IN NUMBER) 
RETURN NUMBER AS Z NUMBER;
BEGIN
    Z:=X+Y;
    RETURN Z;
END;
/

--To run function
DECLARE
    FIRST_NUM NUMBER;
    SECOND_NUM NUMBER;
    TOTAL_SUM NUMBER;
BEGIN
    FIRST_NUM:=22;
    SECOND_NUM:=42;
    TOTAL_SUM:= ADD_NUM(FIRST_NUM, SECOND_NUM);
    DBMS_OUTPUT.PUT_LINE('SUM: ' || TOTAL_SUM);
END;
/


-- Stored Procedure is similar to a function, but can output 0 or more complex parameters 
-- and can use DML and call other functions and procedures
CREATE OR REPLACE PROCEDURE HELLO_WORLD_SP AS
BEGIN
    DBMS_OUTPUT.PUT_LINE('Hello World');
END;
/

-- Call it
Begin
    HELLO_WORLD_SP;
End;
/

-- Stored Procedure to add 1 year to a animal that had its birthday
-- Inputs: id, years to age
-- In the program we will increase age by the years=to=age
CREATE OR REPLACE PROCEDURE
BIRTHDAY_SP (AID IN NUMBER, YTA IN NUMBER) AS
BEGIN
    UPDATE ANIMALS SET age = age + YTA WHERE id = AID;
    COMMIT;
END;
/

-- Test BIRTHDAY_SP
BEGIN
    BIRTHDAY_SP(1, 4);
END;
/