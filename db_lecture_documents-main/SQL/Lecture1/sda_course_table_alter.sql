ALTER TABLE employees
#DDL
ADD date_hired VARCHAR(10);

-- Gives disctiption of the table
DESCRIBE employees;

-- Delete a column
ALTER TABLE  employees
DROP COLUMN date_hired;

-- Can change the name and type
ALTER TABLE employees
CHANGE COLUMN date_of_birth dateOfBirth DATE;

-- Can change the typy only
ALTER TABLE employees
MODIFY dateOfBirth VARCHAR(10);