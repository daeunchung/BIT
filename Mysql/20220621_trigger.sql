/*
	trigger : 촉발하다. == callback
    before, after
    delimiter $$
		create trigger 트리거명                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
        
	delimiter ;
*/

-- 저장(검사) 테이블
create table deptUpdate(
	oldname varchar(30),
    newname varchar(30)
);

delimiter $$
create trigger trigger_test
	before update
    on departments
    for each row
begin
	insert into deptUpdate(oldname, newname)
    values(old.department_name, new.department_name);
    
end$$
delimiter ;

update departments
set department_name = '총괄본부'
where department_id = 300;

select * from deptUpdate;