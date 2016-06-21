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

create table user
(
   /* 用户编号,自动增长 */
   id                  int not null auto_increment,
   /* 用户登录名 */
   login               varchar(20),
   /* 用户真实姓名 */
   name                varchar(20),
   /* 用户登录密码 */
   pass                varchar(20),
   /* 用户性别 */
   sex                 varchar(20),
   /* 用户电话 */
   phone               varchar(20),
   /* 用户Email */
   email               varchar(20),
   /* 设置用户编号为主键 */
   primary key (id)
);

/*=============================*/
/* Table: 订单状态表结构 		   */
/*=============================*/
create table status
(
   /* 状态编号,自动增长 */
   id                  int not null auto_increment,
   /* 订单状态 */
   status               varchar(10),
   /* 设置订单编号为主键 */
   primary key (id)
);
/*=============================*/
/* Table: 订单表结构	 		   */
/*=============================*/
create table forder
(
   /* 订单编号,自动增长 */
   id                  int not null auto_increment,
   /* 收件人名字 */
   name                varchar(20),
   /* 收件人电话 */
   phone               varchar(20),
   /* 配送信息 */
   remark              varchar(20),
   /* 下单日期 */
   date                timestamp default CURRENT_TIMESTAMP,
   /* 订单总金额 */
   total               decimal(8,2),
   /* 收件人邮编 */
   post                varchar(20),
    /* 收件人邮编 */
   address             varchar(200),
   /* 订单状态 */
   sid                 int default 1,
   /* 会员编号 */
   uid                 int,
   /* 设置订单编号为主键 */
   primary key (id)
);
/* 修改自动增长的初始值 */
ALTER TABLE forder AUTO_INCREMENT = 2013021801;

/*=============================*/
/* Table: 购物项表结构 		   */
/*=============================*/

create table sorder
(
   /* 购物项编号,自动增长 */
   id                  int not null auto_increment,
   /* 被购买商品的名称 */
   name                varchar(20),
   /* 购买时商品的价格 */
   price               decimal(8,2),
   /* 购买的数量 */
   number              int not null,
   /* 所属商品编号 */
   pid                  int,
   /* 此订单项,所属的订单编号 */
   fid                  int,
   /* 设置购物项编号为主键 */
   primary key (id)
);


insert into product(name,price,pic,remark,xremark,commend,available,cid) values('iphone6',200,'test.jpg','test','test and test',true,true,12);
select * from product ;
select  * from category order by id asc;