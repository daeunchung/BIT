use mydb;
select * from employees;
-- 한줄 주석문

/* 
	범위 주석문
*/

select @@autocommit;	-- autocommit 의 여부를 확인 (1:설정 0:해제)

set autocommit = true;	-- 설정
set autocommit = false;	-- 해제 (test 실행시에 autocommit 해제하고 사용을 권장, 이후에 commit 해야함)

commit;
rollback;

/*
자료형
	Java  			Oracle 					MySQL
	int				INTEGER, NUMBER(5) 		INT, DECIMAL(5), DECINAL(5,2)
	double			NUMBER					DOUBLE
    String			VARCHAR2				VARCHAR
    Date			DATE					DATE  
*/

-- table 생성
/*
ROW 행 가로 ==  record
COLUMN 열 세로

create table 테이블명(
	컬럼명 자료형, 
    컬럼명 자료형,
		:
	)
*/

-- Table 정보조회  (스키마가 mydb)
select *
from INFORMATION_SCHEMA.TABLES
WHERE TABLE_SCHEMA = 'mydb';

-- varchar
create table tb_varchar(
	col1 varchar(10),	-- 10byte
    col2 varchar(20),
    col3 varchar(30)
);

insert into tb_varchar(col1, col2, col3)
values('ABC', 'ABC', 'ABC');			-- 영문자: 1byte

insert into tb_varchar(col1, col2, col3)
values('가나다', '가나다', '가나다');		-- 한문자: 3byte

-- 숫자 (정수, 실수)
-- INTEGER

create table tb_integer(
	col1 int, 
    col2 integer
);

insert into tb_integer(col1, col2)
values(123, 456);		-- int 중간에 45a6 당연히 안되고

insert into tb_integer(col1, col2)
values('123', '456');	-- 자바에서는 x DB에서는 허용 o 

create table tb_decimal(
	col1 decimal,
    col2 decimal(5),
    col3 decimal(5,2)
);

insert into tb_demimal(col1, col2, col3)
values(1234.5678, 12345.12, 123.456);

select * from tb_decimal;

-- date
create table tb_date(
	col1 date,
    col2 date    
);
    
-- 현재날짜 구하기
insert into tb_date(col1, col2)
values(NOW(), NOW()-1);
    
select NOW();

select * from tb_date;

select date_format(col1, ' %y %m %d '), col2
from tb_date;

select date_format(col1, ' %y'), date_format(col1, '%m')
from tb_date;

-- timestamp
create table board(
	num INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(30),
    ymd TIMESTAMP default NOW(),
    PRIMARY KEY(num)
);

insert into board
values(1, '타이거즈', default);

insert into board
values(2, '라이온즈', now());

insert into board
values(3, '트윈즈', str_to_date('20221012143205', '%Y%m%d%H%i%s')); -- 외부 데이터

select * from board;

select num, title, date_format(ymd, '%y-%m-%d')
from board;

select num, title, date_format(ymd, '%y %m %d %h %i %s')
from board;
-- 소문자 22년도, 대문자 2022년도 로 출력

-- extract 함수

