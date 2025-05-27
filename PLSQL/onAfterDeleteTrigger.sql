CREATE OR REPLACE TRIGGER trg_delete
AFTER DELETE
ON department
FOR EACH ROW
BEGIN
    INSERT INTO backup (
        name,
        course,
        marks,
        deleted
    ) VALUES (
        :OLD.name,
        :OLD.course,
        :OLD.marks,
        SYSDATE -- or use a flag like 'Y' to indicate deletion
    );
END;
/
