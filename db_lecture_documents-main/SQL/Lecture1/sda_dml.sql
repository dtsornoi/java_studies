#DML
-- Ways to populate Tables
INSERT INTO employees (employee_id,
						employee_first_name, 
                        employee_last_name)
VALUES(
	1, 'John', 'Doe'
);

INSERT INTO employees (employee_id,
						employee_first_name, 
                        employee_last_name, 
                        date_of_birth,
                        employee_salary)
VALUES(
	2, 'Anna', 'Twilight', '1993-02-03', 4000
);

INSERT INTO employees (employee_first_name, 
                        employee_last_name)
VALUES(
	'Jessica', 'Jones'
);

-- Multiple insertions at a time
INSERT INTO employees (employee_first_name, 
                        employee_last_name)
VALUES
	('Klarck', 'Kent'),
    ('Rick', 'Roll'),
    ('Geralt', 'Rivia');

#ROW - TUPLA
#DQL
SELECT * FROM employees;

-- Delition of a specific row where row is selected by employee_id
DELETE FROM employees
WHERE employee_id = 10;

-- Disables safe updates in order to run DELETE FROM tablename without WHERE clause.
SET SQL_SAFE_UPDATES = 0;
-- Alternative is TRUNCATE tablename, TRUNCATE also resets the auto-increment

-- Update salary only where salary equals NULL. WHERE employee_salary = NULL - does not work/ use IS instead
UPDATE employees SET employee_salary = 1000
WHERE employee_salary IS NULL;

TRUNCATE employees;