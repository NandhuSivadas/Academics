declare 
 a number:=10;
 b number:=20;
 max number:=0;
begin 
  if(a > b)
    then
        max:=a;
   else
       max:=b;
  end if;
  dbms_output.put_line('largest number is:' || max);
end;


-- output

-- largest number is:20


-- PL/SQL procedure successfully completed.


