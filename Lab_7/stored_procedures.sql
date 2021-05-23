use faculty;

-- #1: параметризована вставка
drop procedure if exists insert_into_school;

DELIMITER //
create procedure insert_into_school (
    name varchar(45),
	phone_number varchar(45),
    school_director varchar(45),
    city varchar(45)
)
begin
	insert into school (
		name, phone_number, school_director, city
    )
    values (
		name, phone_number, school_director, city
    );
end //
DELIMITER ;

-- #2: реалізувати звязок М:М

insert into student (id, name, surname, father_name, rating, birth_date, admission_date, student_id_number, email, group_id, city_id, school_id) values (1, 'Sean', 'Dougher', 'Pat', 1, '2000-01-06 17:33:08', '2019-12-03 06:05:18', 1, 'pdougher0@behance.net', 1, 1, 1);
insert into student (id, name, surname, father_name, rating, birth_date, admission_date, student_id_number, email, group_id, city_id, school_id) values (2, 'Jerad', 'Gledstane', 'Mireille', 2, '2001-01-16 03:55:59', '2019-11-26 18:10:20', 2, 'mgledstane1@booking.com', 2, 2, 2);
insert into student (id, name, surname, father_name, rating, birth_date, admission_date, student_id_number, email, group_id, city_id, school_id) values (3, 'Lonna', 'Osmint', 'Piotr', 3, '2002-12-19 10:53:22', '2019-09-04 00:43:27', 3, 'posmint2@census.gov', 3, 3, 3);

insert into debt (id, subject) values (1, 'Structural and Misc Steel');
insert into debt (id, subject) values (2, 'Fire Sprinkler System');
insert into debt (id, subject) values (3, 'Glass & Glazing');

insert into student_has_debt (id, student_id, debt_id) values (1, 1, 1);
insert into student_has_debt (id, student_id, debt_id) values (2, 2, 2);
insert into student_has_debt (id, student_id, debt_id) values (3, 3, 3);