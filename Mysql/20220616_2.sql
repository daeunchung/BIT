/*
CRUD
	INSERT
    DELETE
    SELECT --> 90%
    UPDATE
    
Object
	CREATE
    DROP
    ALTER

	SELECT(값, 컬럼명, 함수, SUB QUERY)
    FROM (테이블명, SUB QUERY)
    
    
*/
select * from employees;

select employee_id, last_name, first_name
from employees;

-- desc (describe)
desc employees;

-- 임의의 컬럼 (원하는대로 그냥 출력시키는 거)
select '이름: ', 20, first_name
from employees;

select '이름: ';

-- alias == 별명
select first_name AS "이름", last_name AS "성"
from employees;

select first_name "이름", last_name "성"  -- AS 생략가능
from employees;

select first_name 이름, last_name 성  -- "" 생략가능
from employees;

select first_name "이 름", last_name 성  -- 띄어쓰기 있으면 "" 생략 불가능
from employees;

select first_name, last_name, salary * 12 AS 연봉
from employees;

-- '성'||'이름'
select concat('이름: ', last_name, first_name) as '전체이름'
from employees;

-- 조건절    WHERE 절
/*
	대소비교, 판정
    =, !=, >, <, >=, <= <>  
    
    IS NULL, IS NOT NULL  				
    NULL, != NULL 과 같이 사용할 수 없다 무조건 IS 써야함
    
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
where first_name <> 'John';

select first_name, salary
from employees
where salary >= 9000;

select first_name
from employees
where first_name >= 'John';			-- 철자는 ASCII 취급

select hire_date, first_name
from employees
-- where hire_date < '1991-01-01';		-- hire_date 는 DATE형, ''는 string 이지만 비교가 가능
where hire_date < date('1991-01-01');	-- 외부 데이터를 불러와서 사용

select first_name, last_name
from employees
where manager_id IS NULL;		-- manager_id = NULL; 또는 manager_id = ''; 안됨

select first_name, last_name, salary
from employees
where manager_id IS NOT NULL
AND not salary >= 10000;

select first_name, last_name, salary
from employees
where (first_name = 'John' or first_name = 'Den')
AND salary > 6000;

/*
	SELECT 절
    
    ALL, ANY, IN, EXISTS, BETWEEN
    and  or   or           >= <= 
*/

select first_name, last_name, salary
from employees
where salary = ALL(	select salary 
					from employees 
                    where salary = 8000);

-- 위 쿼리와 동일
select first_name, last_name, salary
from employees
where salary = 8000;

-- OR 6000 또는 8000 또는 10000
select first_name, last_name, salary
from employees
where salary IN (6000, 8000, 10000);	

-- ALL 은 AND 라서 9000이면서 6000일수 없음
select first_name, last_name, salary
from employees
where salary = ALL (select salary 			
					from employees 
                    where job_id = 'IT_PROG');

-- ANY 은 OR 라서 IT_PROG와 연봉 같은 사람들 출력
select first_name, last_name, salary
from employees
where salary = ANY (select salary 			
					from employees 
                    where job_id = 'IT_PROG');

-- exists	-- dual 이란 가상 테이블
select first_name, last_name, salary
from employees a
where exists (  select 1 from dual 
				where a.job_id = 'IT_PROG');


--  BETWEEN    --->= AND ... <=
select first_name, salary
from employees
where salary >= 3200 and salary <= 9000;

select first_name, salary
from employees
where salary between 3200 and 9000;

select first_name, salary
from employees
where salary not between 3200 and 9000;

/*
	salary < 3200 or salary > 9000
*/

-- like
select first_name, salary
from employees
where first_name like 'G_ra_d'; -- _ 한문자
    
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

select employee_id
from employees
order by hire_date;

select employee_id, first_name, manager_id
from employees
-- order by manager_id is null asc;  -- null 은 나중에 출력
order by manager_id is null desc;

select * 
from employees
order by commission_pct;

select employee_id, commission_pct
from employees
order by commission_pct is null;

select first_name, commission_pct, salary
from employees
order by commission_pct is null desc, salary desc;

select first_name, salary * 12 as 연봉
from employees
order by 연봉 desc;

-- 그룹 묶는 기능
-- 중복행을 제거
select distinct department_id
from employees
order by department_id asc;

-- group by
select *
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
	ifnull(대상이 되는 컬럼, 출력하고 싶은 값)  == NVL
    대상이 되는 컬럼이 null일 경우, 출력하고 값을 리턴한다.
*/

select first_name, ifnull(commision_pct, 0)
from employees;

-- truncate
select department_id, sum(salary), max(salary), truncate(avg(salary), 0)
from employees
group by department_id;

select department_id, job_id
from employees
group by department_id, job_id;

-- group by  ->  조건
-- having
select job_id, sum(salary)
from employees
group by job_id
having sum(salary) >= 100000;

-- 급여가 5000이상 받는 사원으로 합계를 내서 업무(job)로 그룹화하여
-- 급여의 합계가 20000을 초과하는 업무명과 사원수, 함계, 평균

select job_id, count(*), sum(salary), avg(salary)
from employees
where salary >= 5000
group by job_id
having sum(salary) > 20000;

select department_id, first_name
from employees
group by department_id
having count(*) > 30;









