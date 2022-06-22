use mydb;

/*
	PL = Procedural Language
    sql -> function
    
    SQL을 확장한 순차적 언어 -> Procudure(처리자), 		Function,   Trigger
						   insert, delete, update	select		callback(자동호출)
                           
	변수, 제어문(if, while, loop)
*/

-- autocommit 확인
select @@autocommit;

-- autocommit off
set autocommit = false;

select 1 from dual;
select 1;		-- mysql만 가능

-- 변수
-- var counter int;
set @counter = 1;
select @counter;

set @message = '하이';
select @message;

set @height = 178.3 + 11;
select @height;

-- procedure
/*
	delimiter $$

	create procedure 프로시저명( IN 매개변수명 자료형, OUT 매개변수명 자료형 )
	begin
		
        쿼리문 + 제어처리
        
	end$$
    
	delimiter ;    
*/

-- 프로시저 삭제
drop procedure if exists sp_hello_world;

DELIMITER $$

create procedure sp_hello_world( )
begin
	declare message varchar(20);
    set message := 'hello PL';
    
    select concat('message = ', message);
    
end$$

DELIMITER ;


DELIMITER //

create procedure myproc(in inum int, out onum int)
begin 
	select inum;    
    
    set onum = 333;    
end;
//

DELIMITER ;


-- 프로시저 호출
call sp_hello_world();

call myproc(123, @outNum);

select @outNum;


insert into departments(department_id, department_name, location_id)
values(300, '관리부', 1400);



drop procedure if exists add_dept;

delimiter //

create procedure add_dept(	in deptno int, 
							in deptname varchar(30),
                            in deptloc int )
begin
	declare exit handler for 1062
    begin
		select 'insert fail';
    end;
	
    insert into departments(department_id, department_name, location_id)
	values(deptno, deptname, deptloc);
    
end;
//

delimiter ;
                            
call add_dept(300, '관리부', 1400);


-- 사원번호를 할당하면, 급여를 30%를 인상시키는 프로시저 
delimiter //
create procedure updateSalary(in v_empno int)
begin
	declare exit handler for 1365
    begin
		select '수정에 실패했습니다';
    end;

	update employees
    set salary = salary * 1.3
    where employee_id = v_empno;    
end;
//
delimiter ;

call updateSalary(150);

select * 
from employees
where employee_id = 150;

rollback;

-- 사원번호를 입력하면 이름, 입사일, 급여가 출력이 되는 프로시저
delimiter //
create procedure emp_info(in v_empno int)
begin
	declare emp_name varchar(20);
    declare emp_hiredate date;
    declare emp_sal decimal(8, 2);
    
    select first_name, hire_date, salary
		into emp_name, emp_hiredate, emp_sal
    from employees
    where employee_id = v_empno;  
    
    select emp_name as 이름, emp_hiredate as 입사일, emp_sal as 월급;

end;
//
delimiter ;

call emp_info(100);

-- 사원번호를 입력받고 그 사원의 급여에 1000을 더한 값으로 갱신(UPDATE)하라.
-- 사원번호와 갱신된 급여를 출력하라.

delimiter //
create procedure salaryPlus1000(in v_empno int)
begin
	declare v_updateSal decimal(8, 2);
    
    select salary into v_updateSal
    from employees
    where employee_id = v_empno;

	select concat(v_empno, '번 사원의 급여:', v_updateSal);
    
    -- update
    update employees
    set salary = salary + 1000
    where employee_id = v_empno;
    
    -- commit;
    
    -- 확인용
	select salary into v_updateSal
    from employees
    where employee_id = v_empno;

	select concat('갱신된 ', v_empno, '번 사원의 급여:', v_updateSal);
end;
//
delimiter ;

call salaryPlus1000(150);


-- 제어문
-- if
select if(2 > 1, 'TRUE', 'FALSE') as result;

select commission_pct, if(commission_pct is null, '없음', '있음') 
from employees;

-- 급여 상위레벨, 평균레벨, 하위레벨
delimiter //
create procedure hiclass(in v_empno int)
begin
	declare emp_name varchar(20);
    declare emp_sal decimal(8, 2);
    
    select first_name, salary into emp_name, emp_sal
    from employees
    where employee_id = v_empno;
    
    if emp_sal >= 10000 then
		select "상위레벨:", emp_sal;	
    elseif emp_sal < 10000 and emp_sal > 600 then
		select "평균레벨:", emp_sal;
    else 
		select "하위벨:", emp_sal;
	end if;
    
end;
//
delimiter ;

call hiclass(100);
call hiclass(180);
call hiclass(200);


-- while, loop, repeat
drop table if exists testTable;

create table testTable(num int);

delimiter //
create procedure whileTest()
begin
	declare i int default 1;		-- int i = 1
    
    while(i <= 10) do
		insert into testTable(num) 
        values(i);
        
        set i = i + 1;        
    end while;
    
end;
//
delimiter ; 

call whileTest();

select * from testTable;


-- loop
delimiter $$
create procedure loopTest()
begin
	declare x int;
    set x = 1;
    
    loop_label:LOOP
		if x > 10 then
			leave loop_label;
		end if;
        
        insert into testTable(num)
        values(x);
        
        set x = x + 1;    
    end LOOP;

end$$
delimiter ;

call loopTest();

select * from testTable;

drop procedure if exists test_cursor;

-- cursor
-- 지정이름의 사원을 커서를 이용해서 카운터한다.
delimiter //

create procedure test_cursor(in emp_name varchar(20))
begin
	declare cnt int default 0;
    
    declare v_sal decimal(8, 2);
    declare v_first_name varchar(20);
    
    declare endOfRow boolean default false;
    
    declare userCursor cursor for		-- cursor 선언
		select first_name, salary from employees where first_name = emp_name;

	declare continue handler for not found set endOfRow = true;
    
    open userCursor;
    cloop: WHILE TRUE DO
		fetch userCursor into v_first_name, v_sal;
    
		if endOfRow then
			leave cloop;
		end if;
        
        set cnt = cnt + 1;
        select concat(cnt, '번 ', v_first_name);
    
    END WHILE;
    close userCursor;
    
    update employees
    set salary = salary * 1.1
    where first_name = v_first_name;
    
end;
//
delimiter ;

-- 1175 -> delete, update

call test_cursor('David');

rollback;


drop procedure if exists expCursor_test;

-- 평균 월급을 커서로 구하기
delimiter //

create procedure expCursor_test(in v_deptno int)
begin
	declare v_dname varchar(30);
    declare emp_cnt double;
    declare sal_avg double;
    
    declare dept_avg cursor for
		select department_name, count(employee_id) cnt, round( avg(salary), 3 ) sal
        from employees e, departments d
        where e.department_id = d.department_id
			and e.department_id = v_deptno
		group by department_name;
        
	open dept_avg;
    
		-- cursor fetch
        fetch dept_avg into v_dname, emp_cnt, sal_avg;
        
        select concat('부서명:', v_dname); 
        select concat('사원수:', emp_cnt);
        select concat('평균월급:', sal_avg);
    
    close dept_avg;
end;
//
delimiter ;

call expCursor_test(60);





















