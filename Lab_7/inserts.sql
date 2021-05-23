use faculty;

insert into city (id, name, region_id) values (1, 'Gornyye Klyuchi', 1);
insert into city (id, name, region_id) values (2, 'Sao Gabriel', 2);
insert into city (id, name, region_id) values (3, 'Pankrushikha', 3);

insert into student_group (id, name, number, admission_date) values (1, 'Nerta', 'IP-1', '2020-03-14 03:08:42');
insert into student_group (id, name, number, admission_date) values (2, 'Rahal', 'IP-11', '2019-08-23 15:18:15');
insert into student_group (id, name, number, admission_date) values (3, 'Brewster', 'IP-12', '2019-05-18 21:49:23');


insert into school (id, name, phone_number, school_director, city) values (1, 'Borer-Williamson', '581-864-7773', 'Pail Le Count', 1);
insert into school (id, name, phone_number, school_director, city) values (2, 'Cartwright, Maggio and Hilll', '422-631-7999', 'Belicia enzley', 2);
insert into school (id, name, phone_number, school_director, city) values (3, 'Greenfelder Inc', '476-924-8840', 'Dory Brilon', 3);

insert into region (id, name, code) values (2, 'Alabama', 'U1');
insert into region (id, name, code) values (3, 'England', 'G3');
insert into region (id, name, code) values (4, 'Bourgogne', 'F3');