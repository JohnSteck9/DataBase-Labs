use family_db;

-- =============================================================================
-- №1: для school забезпечити формат 
-- '8' + пробіл + 3 цифри + '-' + 2 цифри + '-' + 2 цифри
-- ^[8][[:blank:]][0-9]{3}[-][0-9]{2}[-][0-9]{2}$
drop trigger if exists phone_format;

DELIMITER //
create trigger phone_format
    before insert
    on student
    for each row
begin
    if (new.phone not rlike '^[8][[:blank:]][0-9]{3}[-][0-9]{2}[-][0-9]{2}$') then
		signal sqlstate '45000'
        set message_text = 'Wrong phone format!';
    end if;
end
//
DELIMITER ;

-- =============================================================================
-- №2: для student тільки такі імена 
-- 'Андрій' 'Гаврило' 'Юля' 'Іван' 'Віталій' 'Уляна'

drop trigger if exists name_checker;

DELIMITER //
create trigger name_checker
    before insert
    on student
    for each row
begin
    if (new.name not rlike '^[Андрій]')  
		or (new.name not rlike '^[Гаврило]')
		or (new.name not rlike '^[Юля]')
		or (new.name not rlike '^[Іван]')
		or (new.name not rlike '^[Віталій]')
		or (new.name not rlike '^[Уляна]')
    then
		signal sqlstate '45000'
        set message_text = 'Wrong name format!';
    end if;
end
//
DELIMITER ;

-- =============================================================================
-- №3: заборонити delete group

drop trigger if exists deny_group_delete;

DELIMITER //
create trigger deny_group_delete
    before delete
    on student_group
    for each row
begin
    if new.id then
        signal sqlstate '45000'
        set message_text = 'min_price value cannot be greater than max_price';
	end if;

end
//
DELIMITER ;

