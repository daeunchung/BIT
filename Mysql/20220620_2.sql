/*
	view : 가상 테이블
			실체가 없는 테이블 != dual 
            다른 테이블에 접근하기 위한 테이블
            
	table <---------- view <------------ user
    속도가 빠르다
    한개의 view로 여러개의 테이블을 검색할 수 있다.
    제한설정이 가능하다 --> readonly
*/

create or replace view ub_test01
as
select job_id, job_title, min_salary
from jobs;

insert into ub_test01(job_id, job_title, min_salary)
values('DEVELOPER', '개발자', 10000);

select * from jobs;

rollback;

delete from jobs where job_id = 'DEVELOPER';

create table emp
as
select employee_id, first_name, salary
from employees;

-- view 를 생성
create or replace view ub_view(empno, ename, sal) 
as
select employee_id, first_name, salary
from emp;

insert into ub_view(empno, ename, sal)
values(300, '정수동', 11000);

select * from ub_view;	-- view를 통해 본 것 (중간에 거쳐갈 뷰를 생성)
select * from emp;		-- 실제를 본 것 (view에 insert 한거 반영 O )

-- 3개의 테이블을 뷰 1개로 묶었다. 실무에서 이런 뷰를 많이 만들어서 사용
create or replace view deft_emp_location_view
as
select employee_id, first_name, d.department_id,
	department_name, l.city
from employees e, departments d, locations l
where e.department_id = d.department_id 
	AND d.location_id = l.location_id;

-- 이미 생성해 놓은 view 를 사용하면 단번에 원하는 것을 출력 가능
select employee_id, department_name, city
from deft_emp_location_view
where employee_id = 103;







