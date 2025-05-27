set serveroutput on;
create or replace function Prime(num in number)
return number
is 
i number;
temp number;
flag number:=0;
begin
temp:=trunc(num/2);
for i in 2..temp loop
    if mod(num,i)=0 then
        flag:=1;
    end if;
    
end loop;
return flag;
end;
/


declare
  num1 number:=5;
begin
  if Prime(num1) = 0 then
    dbms_output.put_line(num1 || ' is a Prime number');
  else
    dbms_output.put_line(num1 || ' is NOT a Prime number');
  end if;
end;