-- JOIN
-- 문제1) 사원들의 이름, 부서번호, 부서명을 출력하라
select e.first_name, d.department_id, d.department_name
from employees e, departments d
where e.department_id = d.department_id;

-- 문제2) 30번 부서의 사원들의 이름,직업,부서명을 출력하라
select e.first_name, j.job_title, d.department_name
from employees e, departments d, jobs j
where d.department_id = 30 AND e.department_id = d.department_id AND e.job_id = j.job_id;

-- 문제3) 커미션을 받는 사원의 이름, 직업, 부서번호,부서명을 출력하라
select distinct e.first_name, e.job_id, e.department_id, d.department_name
from employees e, departments d
where e.commission_pct is not null AND d.department_id = e.department_id;

-- 문제4) 지역번호 2500 에서 근무하는 사원의 이름, 직업,부서번호,부서명을 출력하라
select e.first_name, job_id, e.department_id, d.department_name
from employees e, departments d, locations l
where l.location_id = 2500 AND d.department_id = e.department_id;

-- 문제5) 이름에 A가 들어가는 사원들의 이름과 부서이름을 출력하라
select e.first_name, d.department_name
from employees e, departments d
where e.first_name like '%A%' AND e.department_id = d.department_id;

-- 문제6) 사원이름과 그 사원의 관리자 이름을 출력하라
select e.first_name as employee, mng.first_name as "employee's manager"
from employees e, employees mng
where e.manager_id = mng.employee_id;

-- 문제7) 사원이름과 부서명과 월급을 출력하는데 월급이 6000 이상인 사원을 출력하라
select e.first_name, d.department_name, e.salary
from employees e, departments d
where e.department_id = d.department_id AND e.salary >= 6000;

-- 문제8) first_name 이 TJ 이란 사원보다 늦게 입사한 사원의 이름과 입사일을 출력하라
select tj.first_name, tj.hire_date, e.hire_date, e.first_name
from employees e, employees tj
where tj.hire_date < e.hire_date AND tj.first_name = 'TJ';

select e.first_name, e.hire_date
from employees e
where
(select hire_date from employees where first_name = 'TJ') < e.hire_date;

-- 문제9) 급여가 3000에서 5000사이인 사원의 이름과 소속부서명 출력하라
select e.first_name, d.department_name, e.salary
from employees e, departments d
where e.salary between 3000 and 5000 
AND e.department_id = d.department_id;

-- 문제10) ACCOUNTING 부서 소속 사원의 이름과 입사일 출력하라
select e.first_name, e.hire_date , d.department_name
from departments d, employees e
where e.department_id = d.department_id 
AND d.department_name = 'ACCOUNTING';

-- 문제11) 급여가 3000이하인 사원의 이름과 급여, 근무지를 출력하라
select first_name, salary, l.city
from employees e, departments d, locations l
where d.location_id = l.location_id 
	AND e.department_id = d.department_id
	AND e.salary >= 3000;

select first_name, salary, l.city
from employees e, departments d, locations l
where e.department_id = d.department_id
	and d.location_id = l.location_id
	and salary >= 3000;

