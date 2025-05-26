SET SERVEROUTPUT ON;

DECLARE
    str VARCHAR2(100) := '&str';  -- User input
    rev VARCHAR2(100) := '';
    i   NUMBER;
BEGIN
    i := LENGTH(str);
    
    WHILE i > 0 LOOP
        rev := rev || SUBSTR(str, i, 1);
        i := i - 1;
    END LOOP;

    DBMS_OUTPUT.PUT_LINE('Original String: ' || str);
    DBMS_OUTPUT.PUT_LINE('Reversed String: ' || rev);
END;
/


    
-- output
-- Original String: hello
-- Reversed String: olleh


-- PL/SQL procedure successfully completed.

-- Elapsed: 00:00:00.008
