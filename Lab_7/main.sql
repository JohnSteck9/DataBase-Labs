create database if not exists faculty;
use faculty;

SET FOREIGN_KEY_CHECKS = 0;
drop table if exists student;
drop table if exists city;
drop table if exists region;
drop table if exists school;
drop table if exists debt;
drop table if exists student_group;
drop table if exists student_has_debt;
SET FOREIGN_KEY_CHECKS = 1;

create table student (
  id int auto_increment primary key,
  name varchar(45) not null,
  surname varchar(45) not null,
  father_name varchar(45) not null,
  rating int not null
    check(rating >= 0 and rating <= 100),
  birth_date date not null,
  admission_date date not null,
  student_id_number varchar(11) not null,
  email varchar(45) not null,
  group_id int not null,
  city_id int not null,
  school_id int not null
) ENGINE = INNODB;

create table student_group (
  id int auto_increment primary key,
  name varchar(45) not null,
  number varchar(8) not null,
  admission_date date not null
) ENGINE = INNODB;

create table student_has_debt (
  id int auto_increment primary key,
  student_id int not null,
  debt_id int not null
) ENGINE = INNODB;

create table city (
  id int auto_increment primary key,
  name varchar(45) not null,
  region_id int not null
) ENGINE = INNODB;

create table debt (
  id int auto_increment primary key,
  subject varchar(45) not null
) ENGINE = INNODB;

create table region (
  id int auto_increment primary key,
  name varchar(45) not null,
  code varchar(5) not null
) ENGINE = INNODB;

create table school (
  id int auto_increment primary key,
  name varchar(45) not null,
  phone_number varchar(45) not null,
  school_director varchar(135) not null,
  city int not null
) ENGINE = INNODB;












