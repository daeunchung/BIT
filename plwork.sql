-- use mydb;
-- 1. 사원번호를 입력 받으면 다음과 같이 출력되는 PROCEDURE를 작성하라.
-- Purchasing 부서의 Alexander 사원입니다
/*
DELIMITER $$
CREATE PROCEDURE getDeptName(IN empno INT, OUT dname VARCHAR(30), OUT ename varchar(20))
BEGIN  	
    SELECT d.department_name, e.first_name INTO dname, ename
    FROM employees e, departments d
    WHERE e.department_id = d.department_id
        AND e.employee_id = empno;
END$$
DELIMITER ;

call getDeptName(103, @dname, @ename);
select concat(@dname, '부서의 ', @ename, '사원입니다');
*/

-- 2. 사원번호를 입력받고, 소속부서의 최고, 최저연봉 차액을 파라미터로 출력하는 PROCEDURE를 작성하라.
delimiter //
create procedure emp_deptDiffMoney(in empno int, out diff double)
begin
	declare deptno int;
    
    -- 입력된 사원의 부서 조사
    select department_id into deptno
    from employees
    where employee_id = empno;
    
    -- 최고, 최소의 차액
    select (MAX(salary) - MIN(salary)) into diff
    from employees
    where department_id = deptno;

end;
//
delimiter ;

call emp_deptDiffMoney(103, @diff);

select @diff;

-- 3. 부서번호를 입력하면 해당 부서에서 근무하는 사원 수를 반환하는 함수를 정의하시오.
delimiter $$
create function get_emp_count(deptno int) returns int
begin
	declare v_count int;
    
    select count(*) into v_count 
    from employees
    where department_id = deptno
    group by department_id;
    
    return v_count;    
end$$
delimiter ;

set @cnt = get_emp_count(60);

select @cnt as '총인원';


-- 4. employees 테이블의 사원번호를 입력하면 해당 사원의 관리자 이름을 구하는 함수를 정의하시오.
-- self join
delimiter $$
create function get_mgr_name(empno int) returns varchar(20)
begin
	declare mgrname varchar(20);
    
    select mgr.first_name into mgrname
    from employees emp, employees mgr
    where emp.manager_id = mgr.employee_id
		and emp.employee_id = empno;
    
    return mgrname;    
end$$
delimiter ;

set @mname = get_mgr_name(103);
select @mname;

-- 5. employees 테이블을 이용해서 사원번호를 입력하면 급여 등급을 구하는 함수를 정의하시오.
/*
18000 ~ 24000 A, 		
12000 ~ 18000 미만 B, 
8000 ~ 12000 미만 C, 
3000 ~ 8000 미만 D, 
그 외에는 F,
*/
delimiter $$
create function get_sal_grade(empno int) returns varchar(1)
begin
	declare sgrade varchar(1);
    
    select 
		case when salary >= 18000 and salary <= 24000 then 'A'
			when salary >= 12000 and salary < 18000 then 'B'
            when salary >= 8000 and salary < 12000 then 'C'
            when salary >= 3000 and salary < 8000 then 'D'
            else 'F'
		end into sgrade
    from employees
    where employee_id = empno;    

	return sgrade;
end$$

delimiter ;

set @sgrade = get_sal_grade(103);

select @sgrade;


