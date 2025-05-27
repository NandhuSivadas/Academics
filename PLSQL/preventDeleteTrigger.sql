CREATE OR REPLACE TRIGGER trg_delete
BEFORE DELETE
ON department
FOR EACH ROW
DECLARE
    emp_count INT;
BEGIN
    SELECT COUNT(*) INTO emp_count 
    FROM employees 
    WHERE department_id = :OLD.department_id;

    IF emp_count > 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Error: Cannot delete department with assigned employees.');
    END IF;
END;
/
