
create table pds(
	seq int auto_increment primary key,
	id varchar(50) not null,
	title varchar(200) not null,
	content varchar(4000),
	filename varchar(50) not null,
	newfilename varchar(50) not null,
	readcount decimal(8) not null,
	downcount decimal(8) not null,
	regdate timestamp not null
);

alter table pds
add
foreign key(id) references member(id); 

select * from pds;




