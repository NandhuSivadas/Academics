set serveroutput on;
create or replace procedure SumOfDigits(num in number,TotalSum out number)
is 
temp number:=num;
sum number:=0;
k number;
begin
  while temp>0 loop
      k:=mod(temp,10);
      sum:=sum+k;
      temp:=trunc(temp/10);
  end loop;
  TotalSum:=sum;
end;
/

declare
  num number := 123;
  result number;
begin
  SumOfDigits(num, result);
  dbms_output.put_line(result);
end;
/