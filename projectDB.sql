create database pro_db;

create table Admin(
  User_name varchar(50),
  Pass_Word varchar(50),
  Department varchar(50)
);

create table Employee(
  id int primary key ,
  Username varchar(40),
  password varchar(40),
  age int,
  Department varchar(20),
  gender varchar(20),
);

create table Marketing(
  offer varchar(40),
  Date varchar(40),
  report varchar(20),
);

create table products(
  pro_id int primary key Identity  (1,1),
  pro_name varchar(40),
  
  pro_price float,
  pro_amount float,
);

insert into Admin values('ahmed','123','Cashier');

