USE sda_course;

INSERT INTO employees (
	employee_first_name,
	employee_last_name, 
    employee_salary, 
    date_of_birth) 
VALUES
	('Michael', 'Harding', 20, '1937-07-25'),
	('Ariana', 'Fox', 30, '1992-09-30'),
	( 'Madelyn', 'Flynn',  35, '1953-03-05'),
	( 'Fynley', 'Dodd', 40, '1973-03-27'),
	( 'Aliza', 'Wyatt', 55, '1969-02-14'),
	('Michael', 'Doss', 67, '1964-12-11'),
	( 'Michael', 'Watshon', 37, '1983-12-11');
    
#DQL
#SELECT <all or any rows> —> FROM <name_table>
#JOIN <table>
#WHERE
#AND
#* —> all or any 
#BETWEEN
# = —> equal
# != <> -> diferent 
#IN - CONTAINS
#BETWEEN AND —> RANGE
# < <= > >= —> COMPARE
#IS NOT NULL - IS NULL
#LIKE --> when we want to compare, like letter
#IN --> Allows you to specify multiple values in a WHERE clause

SELECT * FROM employees
WHERE date_of_birth > '1969-02-14';
    
SELECT * FROM employees
WHERE employee_first_name = 'Michael' AND employee_salary > 30;

SELECT * FROM employees
WHERE employee_salary > 30;