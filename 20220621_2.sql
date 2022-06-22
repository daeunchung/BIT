/*
	function
    매개변수, return 값
    select 구문
    delimiter $$
    
    begin
    
    create function 함수명(매개변수 자료형) returns 리턴 자료형
    
		select 쿼리처리
        
        return 값;
    
    end$$
    delimiter ;

*/

delimiter $$

create function func(p_val double) returns double
begin
	declare v_val double;
    
    set v_val = p_val;
    set v_val = v_val * 2;
    
    return v_val;
    
end$$
delimiter ;

-- 1418 error
set global log_bin_trust_function_creators = 1;

select func(100);

set @num = func(22);
select @num;

-- 월급과 커미션을 합친 금액의 세금을 계산 15%
delimiter $$
create function tax(v_sal decimal(8, 2), v_bonus decimal(2, 2)) returns double
begin
	return (v_sal + ( ifnull(v_bonus, 0) * v_sal ) * 0.15);
end$$
delimiter ;

-- delimiter //
-- create function tax(v_sal decimal(8, 2), v_bonus decimal(2, 2)) returns double
-- begin
-- 	return (v_sal + ( ifnull(v_bonus, 0) * v_sal ) * 0.15);
-- end;
-- //
-- delimiter ;

select first_name, salary + salary * ifnull(commission_pct, 0) as 실급여,
	salary * ifnull(commission_pct, 0) as 보너스,
    tax(salary, commission_pct) as 세금
from employees;


-- 사원번호를 입력하면, 업무명을 취득할 수 있는 함수
delimiter $$

create function getJobName(v_empno int) returns varchar(35)
begin
	declare v_jobname varchar(35);
    select *
    from employees e, jobs j
    where e.job_id = j.job_id
		and employedd_id = v.empno;
    
    return v_jobname;
end$$
delimiter ;

set @jobname = getJobName(103);
select @jobname;

select employee_id, first_name, salary, getJobName(103)
from employees;




