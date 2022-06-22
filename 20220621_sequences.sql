/*
	sequence : 중복되지 않는 증가숫자
				1000 , 2000 + 1


*/

-- sequence table create
/*
create table sequences(
	name varchar(32),
    currval bigint unsigned 
) engine = InnoDB;
*/
-- 시퀀스를 생성하는 프로시저를 생성      -- 같은 이름이 있으면 무조건 지우고 시작
delimiter $$
create procedure create_sequence(in the_name text)
modifies sql data
deterministic
begin
	delete from sequences where name=the_name;
	insert into sequences values(the_name, 0);
end
delimiter ;

delimiter $$
create function nextval(the_name varchar(32)) returns bigint unsigned
modifies sql data
deterministic
begin
	declare ret bigint unsigned;
    
    update sequences set currval = currval + 1 where name=the_name;
    
    select currval into ret from sequences where name=the_name limit 1; -- 맨끝에 한개만 가져오라
	return ret;

end$$
delimiter ;

-- 위에까지 시퀀스가 생성된 것임
insert into sequences
values('myseq', 0);

SET SQL_SAFE_UPDATES = 0;

-- nextval 값을 가져오기
select nextval('myseq')
from dual;

-- auto increment 는 우리가 원하는 수에서 ㅅ시작시키기 어렵다 시퀀스를 사용하면 좋다
