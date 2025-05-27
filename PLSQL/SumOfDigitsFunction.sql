set serveroutput on;
create or replace function SumOfDigits(num in number)
return number
is 
  temp number := num;
  sum number := 0;
  k number;
begin
  while temp > 0 loop
    k := mod(temp, 10);
    sum := sum + k;
    temp := trunc(temp / 10);  
  end loop;
  return sum;
end;
/


declare
  num1 number := 121;
begin
  dbms_output.put_line(SumOfDigits(num1));
end;
/
