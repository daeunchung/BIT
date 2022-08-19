use mydb;

create table poll(
	pollid int auto_increment primary key,
    id varchar(50) not null,
    question varchar(1000) not null,
    sdate date not null,
    edate date not null,
    itemcount int null,
    polltotal decimal(8) not null,
    regdate date not null
);

-- 외래키는 원래는 null 을 허용 
create table pollsub(
		pollsubid int auto_increment primary key,
        pollid int not null,
        answer varchar(1000) not null,
        acount decimal(8) not null
);

alter table pollsub
add
constraint pollsub_fk foreign key(pollid)
references poll(pollid);

create table voter(
		voterid  int auto_increment primary key,
        pollid int not null,
		pollsubid int not null,
        id varchar(50) not null,
        regdate date not null
);

alter table voter
add constraint voter_fk foreign key(pollid)
references poll(pollid);

alter table voter
add constraint voter_fk2 foreign key(pollsubid)
references pollsub(pollsubid);


-- select * from poll;
-- select * from 
