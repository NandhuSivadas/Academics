declare
 n number:=&n;
 c number:=1;
begin 
  for i in 1..n loop
  c:=i*c;
  end loop;
 dbms_output.put_line('factorial is' || c);
end;
/

-- output
-- factorial is:120


-- PL/SQL procedure successfully completed.


