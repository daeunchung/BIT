/*
	view : 	가상 테이블
			실체가 없는 테이블 != dual
            다른 테이블에 접근하기 위한 테이블
            
	table <------ view <------- user
    속도가 빠르다
    한개의 view로 여러개의 테이블을 검색할 수 있다.
	제한설정이 가능하다. --> readonly
*/

create or replace view ub_test01
as 
select job_id, job_title, min_salary
from jobs;

/*
	int array[] = { 1, 2, 3 };
    int alias[] = array;
    
    alias[0] --> 1
    alias[0] = 11;
    array[0] --> 11
*/

insert into ub_test01(job_id, job_title, min_salary)
values('DEVELOPER', '개발자', 10000);

select * from jobs;

rollback;

delete from jobs
where job_id = 'DEVELOPER';

create table emp
as
select employee_id, first_name, salary
from employees;

-- view를 생성
create or replace view ub_view(empno, ename, sal)
as
select employee_id, first_name, salary
from emp;

insert into ub_view(empno, ename, sal)
values(300, '정수동', 11000);

select * from ub_view;
select * from emp;

create or replace view deft_emp_location_view
as
select employee_id, first_name, d.department_id,
	department_name, l.city
from employees e, departments d, locations l
where e.department_id = d.department_id
	and d.location_id = l.location_id;
    
select employee_id, department_name, city
from deft_emp_location_view
where employee_id = 103;















