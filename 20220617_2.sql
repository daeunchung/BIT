/*
	SUB QUERY
    Query 안의 Query
    
    SELECT 단일 row, 단일 column 
    FROM   다중 row, 다중 column
    WHERE  다중 row, 다중 column

*/

-- select
select employee_id, first_name,
	(select last_name
    from employees
    where department_id = 100)
from employees;

-- 단일행 단일컬럼을 반환하는 select 문만 subquery 로 가능

-- 단일행 다중컬럼이라서 subquery 로 사용불가
select last_name, first_name
    from employees
    where employee_id = 100;

-- 다중행 단일컬럼
select last_name
    from employees
    where department_id = 100;

select first_name, sum(salary)
from employees;

select first_name,
	(select sum(salary) from employees),
    (select avg(salary) from employees)
from employees;

select first_name, salary,
    (select avg(salary) from employees)
from employees
where department_id = 30;


-- from ( 무조건 무조건 alias 주어야함 )
select employee_id, first_name, salary
from(	select department_id, employee_id, first_name, salary
		from employees
		where department_id = 100) a
where salary > 8000;

-- 부서번호 50, 급여가 6000 이상인 사원
select empno, ename, sal
from ( 	select employee_id as empno, first_name as ename, salary as sal
		from employees
		where department_id = 50 ) a
where sal >= 6000;

-- 업무별로 급여의 합계, 인원수, 사원명, 월급
select job_id, count(*), first_name, salary
from employees
group by job_id;

select e.employee_id, e.first_name, a.급여합계, a.인원수
from employees e, (	select job_id, sum(salary) as 급여합계, count(*) as 인원수
					from employees
					group by job_id) a;

-- where
-- 평균급여보다 많이 받는 사원
select employee_id, first_name, salary
from employees
where salary > (select avg(salary) from employees);

-- 부서번호가 90 인 사원의 업무명
select job_id, first_name, department_id
from employees
where job_id in ( 	select job_id
					from employees
					where department_id = 90 );
                    
-- 부서별로 가장 급여를 적게 받는 사원의 급여와 같은 급여를 받는 사원
select employee_id, first_name, salary
from employees
where salary =	( select min(salary)
					from employees
					group by department_id );


-- 각 부서별로 가장 급여를 적게 받는 사원
select department_id, employee_id, first_name, salary
from employees
where (department_id, salary ) IN ( select department_id, min(salary)
					from employees
					group by department_id )
order by department_id;

-- 각 부서별로 가장 높은 급여를 받는 사원
select department_id, employee_id, first_name, salary
from employees
where (department_id, salary ) IN ( select department_id, max(salary)
					from employees
					group by department_id )
order by department_id;

-- 특수 쿼리
-- substr('hello world', 1) : 처음부터 다 가지고 와라
-- substr('hello world', 1, 5) : 5글자 가지고 와라
-- case 
select employee_id, first_name, phone_number,
	case substr(phone_number, 1, 3)
    when '515' then '서울'
    when '590' then '부산'
    when '650' then '광주'
    else '기타'
    end as 지역
from employees;

-- over() 함수 알고있자 ~~
-- group by 를 보강하기 위해서 나온 함수
-- select 절에서만 사용

select department_id, count(*)over(), first_name
from employees
group by department_id;

-- PARTITION BY == SELECT절 안에 GROUP BY
-- department_id 로 묶은 부분의 갯수
select first_name, salary, department_id,
	count(*) over(partition by department_id)
from employees;


-- 순위함수 분석함수 
/*
	RANK()			1	2	3	3	5	6
    DENSE_RANK()	1	2	3	3	4	5
    ROW_NUMBER()	1 2 3 4 5 6
    ROWNUM -> @rownum:=@rownum+1
    
	ranking 은 select 절에서만 사용할 수 있다
*/

select employee_id, first_name, salary,
	rank()over(order by salary desc) as "RANK",
    dense_rank()over(order by salary desc) as "DENSE_RANK",
	row_number()over(order by salary desc) as "ROW_NUMBER"
from employees;

select @rownum:=@rownum+1, employee_id, first_name
from employees
where (@rownum:=0)=0
	and @rownum < 10;
    
-- 1 ~ 10
select @rownum:=@rownum+1, employee_id, first_name
from employees, (SELECT @rownum:=0) rnum
where @rownum < 10;

select @rownum:=@rownum+1, employee_id, first_name
from employees, (SELECT @rownum:=0) rnum
where @rownum > 10 and @rownum <= 20;


-- 게시판 페이지 잘라서 받아와야 할 때 사용 (중요합니다)
select rnum, employee_id, first_name, salary
from 
	(select @rownum:=@rownum+1 AS rnum, employee_id, first_name, salary
	from employees, (SELECT @rownum:=0) r
	order by salary desc) ef
-- where rnum > 10 and rnum <= 20;
where rnum between 11 and 20;















