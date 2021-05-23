use faculty;

-- =====================================================================
-- №1: вивести перші літери з name, surname, fether_name з табл student

drop function if exists get_NFS;
DELIMITER //

create function get_NFS(name varchar(45), surname varchar(45), father_name varchar(45)) 
returns varchar(45)

begin

return concat(name, surname, father_name);
end //
DELIMITER ;

SELECT LEFT(name , 1) into @name FROM student LIMIT 1;
SELECT LEFT(surname , 1) into @surname FROM student LIMIT 1;
SELECT LEFT(father_name , 1) into @father_name FROM student LIMIT 1;

select get_NFS(@name, @surname, @father_name);

-- =====================================================================

-- №2: функція, яка стягує за ключем між CITY та STUDENT значення поля STUDENT.
drop function if exists get_student_name;

DELIMITER //
create function get_student_name(student_id int)
returns varchar(30)
begin
return (
	select c1.name
	from student s
	left join city c1 on s.city_id = c1.id
    where s.id = student_id
);
end //
DELIMITER ;

select *, get_student_name(s.id) as name from student s;
