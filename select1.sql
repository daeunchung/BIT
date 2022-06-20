/*
	CRUD
	
    INSERT
    DELETE
    SELECT -> 90%
    UPDATE
    
    object
    CREATE
    DROP
    ALTER
    
    SELECT (값, 컬럼명, 함수, SUB QUERY)
    FROM (테이블명, SUB QUERY)
*/

SELECT * FROM employees;

select employee_id, last_name, first_name
from employees;

-- desc
desc employees;

-- 임의 컬럼
select '이름: ', 20, first_name
from employees;

select '이름: ';

-- alias == 별명
select first_name AS "이름", last_name as "성" 
from employees;

select first_name "이름", last_name "성" 
from employees;

select first_name 이름, last_name 성 
from employees;

select first_name as "이 름", last_name as 성 
from employees;

select first_name, last_name, salary * 12 as 연봉
from employees;

-- '성'||'이름'
select concat('이름: ', last_name, first_name) as '전체이름'
from employees;

-- 조건절
/*
    WHERE 
	대소비교, 판정
    =, !=, >, <, >=, <=, <>
    
    IS NULL, IS NOT NULL 	!= NULL <- 사용못함
    
    && -> AND
    || -> OR
*/

select first_name, salary
from employees
where first_name = 'John';

select first_name, salary
from employees
where first_name != 'John';

select first_name, salary 
from employees
where salary >= 9000;

select first_name
from employees
where first_name >= 'John';

select hire_date, first_name
from employees
-- where hire_date < '1991-01-01';
where hire_date < date('1991-01-01');

select first_name, last_name 
from employees
where manager_id = '';

select first_name, last_name, salary
from employees
where manager_id is not null
	AND not salary >= 10000;

select first_name, last_name, salary
from employees
where (first_name = 'John' or first_name = 'Den')
	AND salary > 6000;
    
/*
	ALL, ANY, IN, EXISTS, BETWEEN
    and  or   or			>= <=
*/  

select first_name, last_name, salary
from employees
where salary = ALL(	select salary 
					from employees 
                    where salary = 8000);

select first_name, last_name, salary
from employees
where salary = 8000;

select first_name, last_name, salary
from employees
where salary IN (6000, 8000, 10000);


select first_name, last_name, salary
from employees
where salary = ANY(	select salary 
					from employees 
                    where job_id = 'IT_PROG');

-- exists
select first_name, salary, job_id 
from employees a
where exists (	select 1 from dual
				where a.job_id = 'IT_PROG');

-- BETWEEN		... >= AND ... <=
select first_name, salary 
from employees
where salary >= 3200 and salary <= 9000; 
 
select first_name, salary 
from employees
where salary between 3200 and 9000;

select first_name, salary 
from employees
where salary not between 3200 and 9000;
/*	salary < 3200 or salary > 9000 */		

-- like
select first_name, salary
from employees
where first_name like 'G_ra_d';	-- _ 한문자

select first_name
from employees
where first_name like 'K%y';

select first_name 
from employees
where first_name like '%a%';

/*
	order by == sorting 올림, 내림
*/

select first_name, salary
from employees
order by salary asc;

select first_name, salary
from employees
order by salary desc;

select employee_id, hire_date
from employees
order by hire_date;

select employee_id, first_name, manager_id 
from employees
-- order by manager_id is null asc; -- null은 나중에 출력
order by manager_id is null desc;

select employee_id, commission_pct 
from employees
order by commission_pct is null;

select first_name, commission_pct, salary
from employees
order by commission_pct is null desc, salary desc;

select first_name, salary * 12 as 연봉
from employees
order by 연봉 desc;

-- 그룹묶는 기능
-- 중복행을 제거 
select distinct department_id
from employees
order by department_id asc;

-- group by
select department_id
from employees
group by department_id
order by department_id asc;

/*
	그룹함수
	COUNT
    SUM
    AVG
    MAX
    MIN
*/

select COUNT(employee_id), count(*), sum(salary), avg(salary),
	max(salary), min(salary)
from employees
where job_id = 'IT_PROG';

/*
	ifnull(대상이 되는 컬럼, 출력하고 값)  == NVL  
    대상이 되는 컬럼이 null일 경우, 출력하고 값을 리턴한다 
*/
select first_name, ifnull(commission_pct, 0) 
from employees;

-- truncate
select department_id, sum(salary), max(salary), truncate(avg(salary), 0)
from employees
group by department_id;

select department_id, job_id
from employees
group by department_id, job_id;

-- group by -> 조건
-- having
select job_id, sum(salary)
from employees
group by job_id
having sum(salary) >= 100000;

-- 급여를 5000이상 받는 사원으로 합계를 내서 업무(job)로 그룹화하여 
-- 급여의 합계가 20000을 초과하는 업무명과 사원수, 합계, 평균
select job_id, count(*), sum(salary), avg(salary) 
from employees
where salary >= 5000 
group by job_id
having sum(salary) > 20000;

select department_id, count(*)
from employees
group by department_id
having count(*) > 30;



