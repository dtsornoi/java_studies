CREATE DATABASE humanResources;

USE humanResources;

CREATE TABLE IF NOT EXISTS employees(
	employeeId INTEGER PRIMARY KEY AUTO_INCREMENT,
    firstName VARCHAR (50),
    lastName VARCHAR (50),
    dateOfBirth DATE,
    postalAddress VARCHAR (100)
);

ALTER TABLE employees ADD phoneNumber VARCHAR(50);
ALTER TABLE employees ADD email VARCHAR (50);
ALTER TABLE employees ADD salary INT;

ALTER TABLE employees DROP COLUMN postalAddress;

CREATE TABLE IF NOT EXISTS employeeAddresses(
	country_id INT PRIMARY KEY AUTO_INCREMENT,
    country_name VARCHAR (50)
);

DROP DATABASE humanResources;

DROP TABLE employeeAddresses;

SELECT * FROM employees