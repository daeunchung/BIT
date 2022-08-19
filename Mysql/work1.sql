use mydb;

-- 문제1) EMPLOYEES 테이블에서 급여가 6000이상인 사원의 사원번호, 이름, 담당업무, 급여를 출력하라.
select employee_id, first_name, job_id, salary 
from employees
where salary >= 6000;

-- 문제2) EMPLOYEES 테이블에서 담당 업무가 ST_MAN인 사원의 사원번호, 성명, 담당업무, 급여, 부서번호를 출력하라.
select employee_id, first_name, job_id, salary, department_id
from employees
where job_id = 'ST_MAN';

-- 문제3) EMPLOYEES 테이블에서 입사일자가 1999년 1월 1일 이후에 입사한 사원의 사원번호, 성명, 담당업무, 급여, 입사일자, 부서번호를 출력하라.
select employee_id, first_name, job_id, salary, hire_date, department_id
from employees
where hire_date > '1999-01-01';

select employee_id, first_name, job_id, salary, hire_date, department_id
from employees
where hire_date > DATE('1999-01-01');

select employee_id, first_name, job_id, salary, hire_date, department_id
from employees
where hire_date like '1999%';

-- 문제4) EMPLOYEES 테이블에서 급여가 3000에서 5000사이의 사원의 성명, 담당업무, 급여, 부서번호를 출력하라. 
select first_name, job_id, salary, department_id
from employees
where salary >= 3000 and salary <= 5000;

select first_name, job_id, salary, department_id
from employees
where salary between 3000 and 5000;

-- 문제5) EMPLOYEES 테이블에서 사원번호가 145,152,203인 사원의 사원번호, 성명, 담당업무, 급여, 입사일자를 출력하라
select employee_id, first_name, job_id, salary, hire_date
from employees
where employee_id = 145 or employee_id = 152 or employee_id = 203;

select employee_id, first_name, job_id, salary, hire_date
from employees
where employee_id in(145, 152, 203);

-- 문제6) EMPLOYEES 테이블에서 입사일자가 2000년도에 입사한 사원의 사원번호, 성명, 담당업무, 급여, 입사일자, 부서번호를 출력하라.
select employee_id, first_name, job_id, salary, hire_date, department_id
from employees
where hire_date LIKE '2000%';

-- 문제7) EMPLOYEES 테이블에서 보너스가 NULL인 사원의 사원번호, 성명, 담당업무, 급여, 입사일자, 보너스, 부서번호를 출력하라.
select employee_id, first_name, job_id, salary, hire_date, commission_pct, department_id
from employees
where commission_pct is null;

-- 문제8) EMPLOYEES 테이블에서 급여가 7000이상이고 JOB이 ST_MAN인 사원의 사원번호, 성명, 담당업무, 급여, 입사일자, 부서번호를 출력하라 
select employee_id, first_name, job_id, salary, hire_date, department_id
from employees
where salary >= 7000 and job_id = 'ST_MAN';

-- 문제9) EMPLOYEES 테이블에서 급여가 10000이상이거나 JOB이 ST_MAN인 사원의 사원번호, 성명, 담당업무, 급여, 입사일자, 부서번호를 출력하라 
select employee_id, first_name, job_id, salary, hire_date, department_id
from employees
where salary >= 10000 or job_id = 'ST_MAN';

-- 문제10) EMPLOYEES 테이블에서 JOB_ID가 ST_MAN, ST_MAN, SA_REP가 아닌 사원의 사원번호, 성명, 담당업무, 급여, 부서번호를 출력하라
select employee_id, first_name, job_id, salary, department_id
from employees
where job_id not in('ST_MAN', 'ST_MAN', 'SA_REP');

-- 문제11) 업무가 AD_PRES이고 급여가 12000이상이거나 업무가 SA_MAN인 사원의 사원번호, 이름, 업무, 급여를 출력하라.
select employee_id, first_name, job_id, salary
from employees
where job_id = 'AD_PRES' and salary > 12000 or job_id = 'SA_MAN';

-- 문제12) 업무가 AD_PRES 또는 SALESMAN이고 급여가 12000이상의 사원의 사원번호, 이름, 업무, 급여를 출력하라.
select employee_id, first_name, job_id, salary
from employees
where job_id = 'AD_PRES' or job_id = 'SA_MAN' and salary >= 12000 ;




-- hr 정렬
-- 문제1) EMPLOYEES 테이블에서 입사일자 순으로 정렬한 사원번호, 이름, 업무, 급여, 입사일자,부서번호를 출력하라.
select employee_id, first_name, job_id, salary, hire_date, department_id
from employees
order by hire_date asc;

-- 문제2) EMPLOYEES 테이블에서 가장 최근에 입사한 순으로 정렬한 사원번호, 이름, 업무, 급여, 입사일자,부서번호를 출력하라.
select employee_id, first_name, job_id, salary, hire_date, department_id
from employees
order by hire_date desc;

-- 문제3) EMPLOYEES 테이블에서 부서번호로 정렬한 후 부서번호가 같을 경우 급여가 많은 순으로 정렬한 사원번호, 성명, 업무, 부서번호, 급여를 출력하여라.
select employee_id, first_name, job_id, department_id, salary
from employees
order by department_id asc, salary desc;

-- 문제4) EMPLOYEES 테이블에서 첫번째 정렬은 부서번호로 두번째 정렬은 업무로 세번째 정렬은 급여가 많은 순으로 정렬한 사원번호, 성명, 입사일자, 부서번호, 업무, 급여를 출력하여라.
select employee_id, first_name, department_id, job_id, salary
from employees
order by department_id asc, job_id asc, salary desc;


-- hr 그룹핑
-- 문제1) EMPLOYEES 테이블에서 모든 SALESMAN(SA_)에 대하여 급여의 평균, 최고액, 최저액, 합계를 구하여 출력하여라.
select avg(salary), max(salary), min(salary), sum(salary)
from employees
where job_id LIKE 'SA_%';

-- 문제2) EMPLOYEES 테이블에 등록되어 있는 인원수, 보너스가 NULL이 아닌 인원수, 보너스의 평균, 등록되어 있는 부서의 수를 구하여 출력하라.
select count(*), count(commission_pct), avg(commission_pct * salary), count(distinct department_id)
from employees;

-- 문제3) EMPLOYEES 테이블에서 부서별로 인원수, 평균 급여, 최저급여, 최고 급여, 급여의 합을 구하여 출력하라.
select department_id, count(*), avg(salary), min(salary), max(salary), sum(salary)
from employees
group by department_id;

-- 문제4) EMPLOYEES 테이블에서 각 부서별로 인원수,급여의 평균, 최저 급여, 최고 급여, 급여의 합을 구하여 급여의 합이 많은 순으로 출력하여라.
select department_id, count(*), avg(salary), min(salary), max(salary), sum(salary) as 급여합계
from employees
group by department_id
order by 급여합계 desc;	-- alias 를 사용할 경우, ""는 제외해야 정상 산출된다

-- 문제5) EMPLOYEES 테이블에서 부서별, 업무별 그룹하여 결과를 부서번호, 업무, 인원수, 급여의 평균, 급여의 합을 구하여 출력하여라.
select department_id, job_id, count(*), avg(salary), sum(salary)
from employees
group by department_id, job_id
order by department_id;

-- 문제6) EMPLOYEES 테이블에서 부서 인원이 4명보다 많은 부서의 부서번호, 인원수, 급여의 합을 구하여 출력하여라
select department_id, count(*), sum(salary)
from employees
group by department_id
having count(*) > 4;

-- 문제7) EMPLOYEES 테이블에서 급여가 최대 10000이상인 부서에 대해서 부서번호, 평균 급여, 급여의 합을 구하여 출력하여라.
select department_id, avg(salary), sum(salary), max(salary)
from employees
group by department_id
having max(salary) >= 10000;

-- 문제8) EMPLOYEES 테이블에서 업무별 급여의 평균이 10000 이상인 업무에 대해서 업무명,평균 급여, 급여의 합을 구하여 출력하라.
select job_id, avg(salary), sum(salary)
from employees
group by job_id
having avg(salary) >= 10000;

-- 문제9) EMPLOYEES 테이블에서 전체 월급이 10000을 초과하는 각 업무에 대해서 업무와 월급여 합계를 출력하라. 
-- 단 판매원(SA_)은 제외하고 급여 합계로 정렬(내림차순)하라.
select job_id, sum(salary)
from employees
where job_id not like 'SA%'
group by job_id
having sum(salary) > 10000
order by sum(salary) desc;

select job_id, salary from employees where job_id not like 'SA%';

select job_id, sum(salary)
from (select job_id, salary from employees where job_id not like 'SA%') a
group by job_id
having sum(salary) > 10000
order by sum(salary) desc;





