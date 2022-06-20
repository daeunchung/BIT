/*
	Join
    두개 이상의 테이블을 연결해서 데이터를 검색하는 방법 
    보통 두개 이상의 행(row)들의 공통된 기본키, 외래키를 사용해서 join 한다.
    
    목적 : 현재 테이블에서 상대테이블의 정보(column)을 산출하기 위한 처리
    
    기본키 : 테이블에서 중복되지 않는 column
    외래키 : 다른 테이블에서 기본키로 설정되어 있다.
    
    join 종류
    inner Join		*****
    full outer join *
    cross join
    outer join
		left		***
		right		***
	self join		*****

*/
use mydb;

-- inner join
-- ansi SQL

select employee_id, first_name,
	e.department_id, d.department_id,
    d.department_name
from employees e INNER JOIN departments d
on e.department_id = d.department_id;

-- my sql
select employee_id, first_name,
	e.department_id, d.department_id,
    d.department_name
from employees e, departments d
where e.department_id = d.department_id;

select e.employee_id, e.first_name,
	e.job_id, j.job_id, j.job_title
from employees e, jobs j
where e.job_id = j.job_id
	and e.job_id = 'IT_PROG';

-- 3개 테이블을 조인 ( 현재 내 테이블에 없는 정보를 조인은 통해 다른 테이블에서 정보를 가져오는 것 )
select employee_id, first_name, e.department_id, department_name, job_title
from employees e, departments d, jobs j
where e.department_id = d.department_id
	and e.job_id = j.job_id;

-- cross join
-- ansi
select e.employee_id, e.first_name,
	e.department_id, d.department_id,
    d.department_name
from employees e CROSS JOIN departments d;

-- mysql
select e.employee_id, e.first_name,
	e.department_id, d.department_id,
    d.department_name
from employees e, departments d;


-- left outer
select e.employee_id, e.first_name,
	e.department_id, d.department_id,
    d.department_name
from employees e LEFT OUTER JOIN departments d
	on e.department_id = d.department_id;


select e.employee_id, e.first_name,
	e.department_id, d.department_id,
    d.department_name
from employees e RIGHT OUTER JOIN departments d
	on e.department_id = d.department_id;


-- full outer join
select e.employee_id, e.first_name,
	e.department_id, d.department_id,
    d.department_name
from employees e LEFT OUTER JOIN departments d
	on e.department_id = d.department_id
UNION
select e.employee_id, e.first_name,
	e.department_id, d.department_id,
    d.department_name
from employees e RIGHT OUTER JOIN departments d
	on e.department_id = d.department_id;


-- 차집합
select e.employee_id, e.first_name,
	e.department_id, d.department_id,
    d.department_name
from employees e LEFT OUTER JOIN departments d
	on e.department_id = d.department_id
where e.department_id is null;


select e.employee_id, e.first_name,
	e.department_id, d.department_id,
    d.department_name
from employees e RIGHT OUTER JOIN departments d
	on e.department_id = d.department_id
where e.department_id is null;

-- 조인이 안된 것을 걸러낸다. 좌 우 차집합의 합집합
select e.employee_id, e.first_name,
	e.department_id, d.department_id,
    d.department_name
from employees e LEFT OUTER JOIN departments d
	on e.department_id = d.department_id
where e.department_id is null
UNION
select e.employee_id, e.first_name,
	e.department_id, d.department_id,
    d.department_name
from employees e RIGHT OUTER JOIN departments d
	on e.department_id = d.department_id
where e.department_id is null;


-- self join : 동일한 테이블 join
select emp.employee_id, emp.first_name,
	emp.manager_id, mgr.employee_id,
    mgr.first_name
from employees emp, employees mgr
where emp.manager_id = mgr.employee_id;

