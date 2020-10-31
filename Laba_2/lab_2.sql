# 1) ----------------------------------------------------
USE labor_sql;
SELECT trip_no, town_from, town_to from labor_sql.trip
where town_from != 'Rostov' and town_to != 'Rostov';

# 2) ----------------------------------------------------
SELECT *
FROM battles
WHERE name not rlike '.+c$' and name rlike '^\\w+ \\w+$';

# 3) ----------------------------------------------------
USE labor_sql;
SELECT product.maker, pc.model, pc.price from pc, product
where product.type = 'PC';

# 4) ----------------------------------------------------
SELECT DISTINCT maker 
FROM product
#where type = 'PC' and maker = any (SELECT maker from product where type = 'Laptop');
WHERE maker = SOME (SELECT maker FROM product WHERE type = 'PC') 
AND maker = SOME (SELECT maker FROM product WHERE type = 'Laptop');
# 5) ----------------------------------------------------
SELECT maker, type, speed
FROM product JOIN laptop 
ON product.model = laptop.model AND laptop.speed >= 750
UNION
SELECT maker, type, speed
FROM product JOIN pc 
ON product.model = pc.model AND pc.speed >= 750;
# 6) ----------------------------------------------------
SELECT
CONCAT("name: ", name) name,
CONCAT("class: ", class) class,
CONCAT("launched: ", launched) launched
FROM Ships;

# 7) ----------------------------------------------------
SELECT date, count(*) Num
FROM trip JOIN pass_in_trip
ON trip.trip_no = pass_in_trip.trip_no AND town_from = 'London'
GROUP BY date
ORDER BY date;

# -----CHECK------------------------------------------
SELECT town_from, date
FROM trip JOIN pass_in_trip
ON trip.trip_no = pass_in_trip.trip_no AND town_from = 'London';

# 8) ----------------------------------------------------
SELECT DISTINCT ships.name, classes.displacement, classes.numGuns
FROM ships
JOIN outcomes ON ships.name = outcomes.ship
JOIN battles ON battles.name = outcomes.battle AND battles.name = 'Guadalcanal'
JOIN classes ON ships.class = classes.class;

# 9) ----------------------------------------------------
SELECT maker,
CASE 
 WHEN COUNT(CASE type WHEN 'PC' THEN 1 END) > 0
  THEN CONCAT('yes(', COUNT(CASE type WHEN 'PC' THEN 1 END), ')')
 ELSE 'no'
END as printer
FROM Product
GROUP BY maker
ORDER BY maker;

# 10) ----------------------------------------------------
SELECT class, count(c.name) as count
FROM 
	(SELECT name, class FROM ships 
	UNION
	SELECT classes.class, outcomes.ship
	FROM classes, outcomes
	WHERE classes.class=outcomes.ship) c
GROUP BY class