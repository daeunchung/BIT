-- 1. 사원번호를 입력 받으면 다음과 같이 출력되는 PROCEDURE를 작성하라.
-- Purchasing 부서의 Alexander사원입니다
drop procedure if exists emp_info;

DELIMITER $$
create procedure emp_info(in v_empno int)
begin
	declare emp_id int;
    declare emp_name varchar(30);
    declare emp_dept varchar(30);
    
    set emp_id = v_empno;
    select e.first_name, d.department_name
		into emp_name, emp_dept
	from employees e, departments d
    where e.department_id = d.department_id AND e.employee_id = emp_id;
        
    select concat( emp_dept, ' 부서의 ', emp_name, ' 사원입니다. ');
end$$
DELIMITER ;

call emp_info(115);


-- 2. 사원번호를 입력받고, 소속부서의 최고, 최저연봉 차액을 파라미터로 출력하는 PROCEDURE를 작성하라.
drop procedure if exists salary_diff;

DELIMITER $$
create procedure salary_diff(in v_empno int)
begin
	declare emp_id int;
    declare sal_diff int;
    
    set emp_id = v_empno;
    select max(salary) - min(salary) into sal_diff
	from employees e, departments d
    where d.department_id = e.department_id AND e.employee_id = emp_id
    group by d.department_id;
    
    select concat( v_empno, ' 번 사원이 속한 부서의 최고, 최저연봉 차액은 ', sal_diff, ' 입니다. ');
end$$
DELIMITER ;

call salary_diff(115);
-- 3. 부서번호를 입력하면 해당 부서에서 근무하는 사원 수를 반환하는 함수를 정의하시오.
drop function if exists count_emp;

DELIMITER $$
create function count_emp(v_empno int) returns int
begin
	declare dept_id int;
    declare emp_cnt int;
    set dept_id = v_deptno;

	select count(e.employee_id) 
		into emp_cnt
	from employees e, departments d
	where e.department_id = d.department_id;

	return emp_cnt;
end$$
delimiter ;

set @cnt = count_emp(60);    -- procedure 와 달리 call 이 아니다

-- 4. employees 테이블의 사원번호를 입력하면 해당 사원의 관리자 이름을 구하는 함수를 정의하시오.
drop function if exists manager_name;

DELIMITER $$
create function manager_name(v_empno int) returns varchar(30)
begin
	declare emp_id int;
    declare mng_name varchar(30);
    set emp_id = v_empno;

	select m.first_name
		into mng_name
	from employees e, employees m
	where e.manager_id = m.employee_id;

	set mng_name = m.first_name;
	return mng_name;
end$$
delimiter ;

select manager_name(115);
-- 5. employees 테이블을 이용해서 사원번호를 입력하면 급여 등급을 구하는 함수를 정의하시오.

-- 18000 ~ 24000 A, 
-- 12000 ~ 18000 미만 B, 
-- 8000 ~ 12000 미만 C, 
-- 3000 ~ 8000 미만 D, 
-- 그 외에는 F,

drop function if exists grade_func;


-- loop
delimiter //
create procedure grade_func(v_empno int) returns varchar(5)
begin
	declare score int;
	declare grade varchar(5);
    
    select salary into score
    from employees
    where employee_id = v_empno;
    
    if emp_sal >= 10000 then 
		select "상위레벨: ", emp_sal;
	elseif emp_sal <10000 and emp_sal > 6000 then
		select "평균레벨: ", emp_sal;
	else
		select "하위레벨: ", emp_sal;
	end if;
    
end;
//
delimiter ;

call grade_func();
select * from testTable;


create function grade_func(v_empno int) returns varchar(30)
begin





