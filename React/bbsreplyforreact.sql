use mydb;

CREATE TABLE if not exists reply (
    rid int auto_increment primary key,
    seq int not null,
    id varchar(30) not null,
    content varchar(1000),
    FOREIGN KEY (seq) REFERENCES bbs(seq),
    FOREIGN KEY (id) REFERENCES member(id)
);

-- drop table reply;

select * from reply;
select * from bbs;

	update bbs
	set title = "ㅇㅇ", content = "ㅇㅇㅇㅇ", wdate = NOW() 
	where seq = 1;