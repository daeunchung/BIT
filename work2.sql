use mydb;
-- 문제1) 사원들의 이름, 부서번호, 부서명을 출력하라
select first_name, e.department_id, department_name
from employees e, departments d
where e.department_id = d.department_id;

-- 문제2) 30번 부서의 사원들의 이름,직업,부서명을 출력하라
select first_name, job_id, department_name, e.department_id
from employees e, departments d
where e.department_id = d.department_id
	and e.department_id = 30;

-- 문제3) 커미션을 받는 사원의 이름, 직업, 부서번호,부서명을 출력하라
select first_name, job_id, e.department_id, department_name, commission_pct
from employees e, departments d
where e.department_id = d.department_id
	and commission_pct is not null;

-- 문제4) 지역번호 2500 에서 근무하는 사원의 이름, 직업, 부서번호,부서명을 출력하라
select first_name, job_id, d.department_id, department_name, location_id
from employees e, departments d
where e.department_id = d.department_id
	and d.location_id = 2500;

-- 문제5) 이름에 A가 들어가는 사원들의 이름과 부서이름을 출력하라
select first_name, department_name
from employees e, departments d
where e.department_id = d.department_id
	and first_name like '%A%';

-- 문제6) 사원이름과 그 사원의 관리자 이름을 출력하라
select e.first_name as "사원", m.first_name as "상사"
from employees e, employees m
where e.manager_id = m.employee_id;

-- 문제7) 사원이름과 부서명과 월급을 출력하는데 월급이 6000 이상인 사원을 출력하라
select first_name, department_name, salary
from employees e, departments d
where e.department_id = d.department_id
	and salary >= 6000;

-- 문제8) first_name 이 TJ 이란 사원보다 늦게 입사한 사원의 이름과 입사일을 출력하라
select tj.first_name, tj.hire_date, e.hire_date, e.first_name
from employees tj, employees e
where tj.first_name = 'TJ'
	and tj.hire_date < e.hire_date;

-- 문제9) 급여가 3000에서 5000사이인 사원의 이름과 소속부서명 출력하라
select first_name, department_name, salary
from employees e, departments d
where e.department_id = d.department_id
	and salary between 3000 and 5000;

-- 문제10) ACCOUNTING 부서 소속 사원의 이름과 입사일 출력하라
select first_name, hire_date, department_name
from employees e, departments d
where e.department_id = d.department_id
	and department_name = 'ACCOUNTING';

-- 문제11) 급여가 3000이하인 사원의 이름과 급여, 근무지를 출력하라
select first_name, salary, l.city
from employees e, departments d, locations l
where e.department_id = d.department_id
	and d.location_id = l.location_id
	and salary >= 3000;


-- 문제1) EMPLOYEES 테이블에서 (Kochhar(last_name)의 급여)보다 많은 사원의 
-- 사원번호,이름,담당업무,급여를 출력하라.
select employee_id, last_name, job_id, salary
from employees
where salary > (select salary 
				from employees
                where last_name = 'Kochhar');

-- 문제2) EMPLOYEES 테이블에서 (급여의 평균)보다 적은 사원의 
-- 사원번호,이름,담당업무,급여,부서번호를 출력하여라.  
select employee_id, first_name, job_id, salary, department_id
from employees
where salary < (select truncate(avg(salary), 0)	from employees);

-- 문제3) EMPLOYEES 테이블에서 (100번 부서의 최소 급여)보다 최소 급여가 많은 다른 모든 부서를 출력하라

select department_id, min(salary)
from employees
group by department_id
having min(salary) > (	select min(salary)
						from employees
						where department_id = 100);

-- 문제4) 업무별로 최소 급여를 받는 사원의 정보를 사원번호,이름,업무,부서번호를 출력하여라. 
-- 단 업무별로 정렬하여라.
select employee_id, first_name, job_id, department_id, salary
from employees
where (job_id, salary) in(	select job_id, min(salary)
							from employees
							group by job_id);

-- 문제5) EMPLOYEES 과 DEPARTMENTS 테이블에서 업무가 SA_MAN 사원의 정보를 이름,업무,부서명,근무지를 출력하라.
select first_name, job_id, department_name, city
from
	(select *
	from employees
	where job_id = 'SA_MAN') emp, departments dept, locations loc
where emp.department_id = dept.department_id
	and dept.location_id = loc.location_id;

-- 문제6) EMPLOYEES 테이블에서 가장 많은 사원을 갖는 MANAGER의 사원번호를 출력하라.
select manager_id, count(*), first_name
from employees
group by manager_id
having count(manager_id) = (select max(cnt)
							from
								(select count(*) as cnt
								from employees
								group by manager_id) a );                   
                            

-- 문제7) EMPLOYEES 테이블에서 가장 많은 사원이 속해 있는 부서 번호와 사원수를  출력하라.
select department_id, count(*)
from employees
group by department_id
having count(department_id) = (	select max(cnt)
								from 
									(select department_id, count(*) as cnt
									from employees
									group by department_id) a );

-- 문제8) EMPLOYEES 테이블에서 (사원번호가 123인 사원의 직업)과 같고 
-- (사원번호가 192인 사원의 급여(SAL))보다 많은 사원의 사원번호,이름,직업,급여를 출력하라.

-- Ctrl + Shift + enter = 부분 query 실행
select employee_id, first_name, job_id, salary
from employees
where 	job_id = (select job_id from employees where employee_id = 123)
	and
		salary > (select salary from employees where employee_id = 192);
      
-- 문제9)직업(JOB)별로 최소급여를 받는 사원의 정보를 사원번호,이름,업무,부서명을 출력하라.
-- 조건1 :직업별로 내림차순정렬
select employee_id, first_name, job_id, department_name
from employees e, departments d
where (job_id, salary) IN (	select job_id, min(salary)
							from employees
							group by job_id)
	and e.department_id = d.department_id
order by job_id desc;


-- 문제10) EMPLOYEES 테이블에서 (50번 부서의 최소 급여)를 받는 사원보다 많은 급여를 받는 
-- 사원의 사원번호,이름,업무,입사일자,급여,부서번호를 출력하라. 
-- 단 50번은 제외
select employee_id, first_name, job_id, hire_date, salary, department_id
from employees
where salary > (select min(salary) from employees where department_id = 50)
	and department_id != 50;

-- 문제11) EMPLOYEES 테이블에서 50번 부서의 최고 급여를 받는 사원보다 많은 급여를 받는 사원의 사원번호,이름,업무,입사일자,급여,부서번호를 출력하라. 
-- 단50번은 제외
select employee_id, first_name, job_id, hire_date, salary, department_id
from employees
where salary > (select max(salary) from employees where department_id = 50)
	and department_id != 50;

-- 문제12) 부서별로 커미션이 없는 사원들 중 월급이 가장 높은 사원의 이름, 급여를 출력하시오(부서순으로 정렬).

select department_id, first_name, salary
from employees
where (department_id, salary) in (	select department_id, max(salary)
									from employees
									where commission_pct is null
									group by department_id )
order by department_id asc;












