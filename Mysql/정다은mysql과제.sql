-- 롯데e커머스 정다은 훈련생

-- 1. 운동부 TABLE을 작성하라.
-- TEAM : 팀 아이디, 지역, 팀 명, 개설 날짜, 전화번호, 홈페이지
-- PLAYER : 선수번호, 선수 명, 등록일, 포지션, 키, 팀 아이디
-- 3개의 TEAM을  등록합니다.
-- 3 개의 TEAM에 선수를 3 ~ 9명을 등록(추가)합니다.
-- 선수를 입력하면 그 선수의 팀 명과 전화번호, 홈페이지가 출력되도록 합니다. 
-- JOIN 해 보도록 합니다. 
-- 팀명으로 팀원들이 출력되도록 합니다. 

-- drop table team;drop table player;

create table TEAM(
	tid int,
    region varchar(30),
    tname varchar(30),
    regdate date,
    phone varchar(20),
    homepage varchar(30),
    primary key(tid)
);

create table PLAYER(
	pid int,
    pname varchar(20),
    regdate date,
    position varchar(30),
    height int,
    tid int,
    foreign key(tid) references TEAM(tid),
    primary key(pid)
);

insert into TEAM (tid, region, tname, regdate, phone, homepage)
values(1, 'Manchester', 'Manchester United F.C.', '2000-01-01', '057-569-4445', 'www.manchesterunitedfc.com' );
insert into TEAM (tid, region, tname, regdate, phone, homepage)
values(2, 'Liverpool', 'Liverpool F.C.', '2001-02-02', '132-234-5678', 'www.liverpoolfc.com' );
insert into TEAM (tid, region, tname, regdate, phone, homepage)
values(3, 'Chelsea', 'Chelsea F.C.', '2002-03-03', '769-345-1115', 'www.chelseafc.com' );

insert into PLAYER(pid, pname, regdate, position, height, tid)
values(1, 'arthur', '2010-03-08', 'goalkeeper', '189', 1);
insert into PLAYER(pid, pname, regdate, position, height, tid)
values(2, 'george', '2010-02-08', 'midfielder', '180', 1);
insert into PLAYER(pid, pname, regdate, position, height, tid)
values(3, 'richard', '2009-09-11', 'centerback', '183', 1);
insert into PLAYER(pid, pname, regdate, position, height, tid)
values(4, 'Donald', '2008-01-08', 'striker', '189', 2);
insert into PLAYER(pid, pname, regdate, position, height, tid)
values(5, 'Trump', '2008-12-02', 'midfielder', '180', 2);
insert into PLAYER(pid, pname, regdate, position, height, tid)
values(6, 'Nick', '2006-11-02', 'leftFullback', '183', 2);
insert into PLAYER(pid, pname, regdate, position, height, tid)
values(7, 'Benjamin', '2005-01-08', 'centerback', '175', 3);
insert into PLAYER(pid, pname, regdate, position, height, tid)
values(8, 'Jeramy', '2004-12-02', 'striker', '181', 3);
insert into PLAYER(pid, pname, regdate, position, height, tid)
values(9, 'Markus', '2004-11-02', 'goalkeeper', '192', 3);

-- 선수를 입력하면 그 선수의 팀 명과 전화번호, 홈페이지가 출력되도록 합니다. 
select p.pid, p.pname, t.tname, t.phone, t.homepage
from player p, team t
where p.tid = t.tid;

-- 팀명으로 팀원들이 출력되도록 합니다. 
select t.tname, p.pname
from player p, team t
where p.tid = t.tid;






-- 2. 온라인 마켓 TABLE을 작성하라.
-- PRODUCT(상품) : 상품번호, 상품명, 상품가격, 상품설명
-- CONSUMER(소비자) : 소비자 ID, 이름, 나이
-- CART(장바구니) : 장바구니 번호, 소비자 ID, 구입일, 상품번호, 수량
-- 상품 테이블에 상품을 등록합니다(개수는 5가지이상).
-- 소비자를 등록합니다. (10명이상)
-- 소비자가 쇼핑한 상품을 추가합니다.
-- 쇼핑한 상품을 출력합니다.
-- 소비자와 기간을 입력하면, 그 기간동안 구입한 물품이 출력됩니다.

-- drop  table PRODUCT;drop  table CONSUMER;drop  table CART;

create table PRODUCT(
	pid int,
    pname varchar(20),
    price int,
    details varchar(30),
    primary key(pid)
);

create table CONSUMER(
	consumerid int,
    cname varchar(20),
    details varchar(30),
    pid int, 
	foreign key(pid) references PRODUCT(pid),
    primary key(consumerid)
);

create table CART(
	cartid int auto_increment primary key,
    consumerid int,
    purchasedate date,
    pid int,
    count int,
	foreign key(consumerid) references CONSUMER(consumerid),
	foreign key(pid) references PRODUCT(pid)
);

insert into PRODUCT (pid, pname, price, details)
values(1, 'glasses', 20000, '패션안경');
insert into PRODUCT (pid, pname, price, details)
values(2, 'shoes', 80000, '나이키운동화');
insert into PRODUCT (pid, pname, price, details)
values(3, 'handbag', 400000, '여성용핸드백');
insert into PRODUCT (pid, pname, price, details)
values(4, 'tumbler', 5000, '휴대용텀블러');
insert into PRODUCT (pid, pname, price, details)
values(5, 'computer', 2000000, '삼성테스크탑');

insert into CONSUMER(consumerid, cname, details, pid)
values(1, '정다은', '20대여성', null);
insert into CONSUMER(consumerid, cname, details, pid)
values(2, '홍길동', '40대남성', null);
insert into CONSUMER(consumerid, cname, details, pid)
values(3, '장길산', '30대남성', null);
insert into CONSUMER(consumerid, cname, details, pid)
values(4, '김철수', '20대남성', null);
insert into CONSUMER(consumerid, cname, details, pid)
values(5, '이유진', '20대여성', null);
insert into CONSUMER(consumerid, cname, details, pid)
values(6, '이영희', '40대여성', null);
insert into CONSUMER(consumerid, cname, details, pid)
values(7, '김은정', '20대여성', null);
insert into CONSUMER(consumerid, cname, details, pid)
values(8, '박민수', '30대남성', null);
insert into CONSUMER(consumerid, cname, details, pid)
values(9, '송주현', '10대남성', null);
insert into CONSUMER(consumerid, cname, details, pid)
values(10, '박문각', '50대남성', null);


    
-- 소비자가 쇼핑한 상품을 추가합니다.
insert into CART (consumerid, purchasedate, pid, count)
values(1, '2010-01-02', 5, 3);
insert into CART (consumerid, purchasedate, pid, count)
values(1, '2010-01-02', 4, 3);
insert into CART (consumerid, purchasedate, pid, count)
values(2, '2011-01-02', 3, 2);
insert into CART (consumerid, purchasedate, pid, count)
values(2, '2012-01-02', 2, 1);
insert into CART (consumerid, purchasedate, pid, count)
values(3, '2013-01-02', 1, 3);
insert into CART (consumerid, purchasedate, pid, count)
values(3, '2014-01-02', 5, 2);
insert into CART (consumerid, purchasedate, pid, count)
values(4, '2015-01-02', 4, 1);
insert into CART (consumerid, purchasedate, pid, count)
values(4, '2016-01-02', 3, 3);
insert into CART (consumerid, purchasedate, pid, count)
values(5, '2017-01-02', 2, 2);
insert into CART (consumerid, purchasedate, pid, count)
values(5, '2018-01-02', 1, 1);
insert into CART (consumerid, purchasedate, pid, count)
values(6, '2019-01-02', 5, 2);
insert into CART (consumerid, purchasedate, pid, count)
values(6, '2019-01-02', 4, 1);
insert into CART (consumerid, purchasedate, pid, count)
values(7, '2018-01-02', 2, 3);
insert into CART (consumerid, purchasedate, pid, count)
values(7, '2017-01-02', 1, 1);
insert into CART (consumerid, purchasedate, pid, count)
values(8, '2016-01-02', 2, 3);
insert into CART (consumerid, purchasedate, pid, count)
values(8, '2015-01-02', 1, 1);
insert into CART (consumerid, purchasedate, pid, count)
values(9, '2014-01-02', 2, 3);
insert into CART (consumerid, purchasedate, pid, count)
values(9, '2013-01-02', 1, 1);
insert into CART (consumerid, purchasedate, pid, count)
values(10, '2012-01-02', 2, 3);
insert into CART (consumerid, purchasedate, pid, count)
values(10, '2011-01-02', 1, 1);


-- 쇼핑한 상품을 출력합니다.
select c.pid, p.pname , sum(c.pid) as '카트에 담긴 총수량' from cart c, product p where c.pid = p.pid group by p.pid;


-- 소비자와 기간을 입력하면, 그 기간동안 구입한 물품이 출력됩니다. (예시 4번 소비자가 '2010-01-01' and '2020-01-01'
select product.pid as '소비자id', product.pname as '소비자이름', product.price as '구매물품 가격', cart.count as '구매수량'
from product, consumer, cart
where cart.consumerid = 4 
	AND cart.purchasedate between '2010-01-01' and '2020-01-01'
	AND product.pid = cart.pid
group by product.pid;

