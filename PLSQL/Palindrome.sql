-- example 1
declare 
    num number:=&num;
    f number:=0;
    temp number:=0;
    p number:=0;
begin 
   temp:=num;
   while(num!=0) loop
        f:=num mod 10;
        p:=(p*10)+f;
        num:=num / 10;
    end loop;
 if(temp=p)
    then 
        dbms_output.put_line('palindrome');
else
        dbms_output.put_line('not palindrome');
 end if;
end;
/


-- example 2

SET SERVEROUTPUT ON;

DECLARE 
    num NUMBER := &num;
    f NUMBER := 0;
    temp NUMBER;
    p NUMBER := 0;
BEGIN 
    temp := num;

    WHILE num != 0 LOOP
        f := MOD(num, 10);    
        p := (p * 10) + f;      
        num := TRUNC(num / 10); 
    END LOOP;

    IF temp = p THEN 
        DBMS_OUTPUT.PUT_LINE('Palindrome');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Not Palindrome');
    END IF;
END;
/

-- output

-- not palindrome


-- PL/SQL procedure successfully completed.

