drop database if exists shop;

create database shop default character set utf8;

use shop;

drop table if exists category;
drop table if exists account;


create table account(
	id int not null auto_increment,
	login varchar(20),
	name varchar(20),
	pass varchar(20),
	primary key (id)
);



create table category(
	 id  int not null auto_increment,

   type varchar(20),

   hot  bool default false,
   aid int,

   primary key (id)
);

/*create table product*/
create table product(
	id int not null auto_increment,
	name varchar(20),
	price decimal(8,2),
	pic varchar(200),
	remark longtext,
	xremark longtext,
	date timestamp default CURRENT_TIMESTAMP,
	commend bool,
	available bool,/*open in video*/
	cid int,
	primary key(id)
);

insert into product(name,price,pic,remark,xremark,commend,available,cid) values('iphone6',200,'test.jpg','test','test and test',true,true,12);
select * from product ;
select  * from category order by id asc;