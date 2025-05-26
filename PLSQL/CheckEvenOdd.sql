-- pgm model 1

declare 
    num number:=&num;
    f number:=0;
begin 
    f:=num mod 2;
    if(f=0)
        then 
            dbms_output.put_line('The number is even');
    else
        dbms_output.put_line('The number is odd');
    end if;

end;
/
-- pgm model 2

SET SERVEROUTPUT ON;

DECLARE 
    num NUMBER := &num;
    f NUMBER := 0;
BEGIN 
    f := MOD(num, 2);
    
    IF f = 0 THEN
        DBMS_OUTPUT.PUT_LINE('The number is even');
    ELSE
        DBMS_OUTPUT.PUT_LINE('The number is odd');
    END IF;
END;
/


-- output 

-- The number is even


-- PL/SQL procedure successfully completed.


