#DDL
CREATE DATABASE IF NOT EXISTS sda_course;
-- CREATE SCHEMA sda_course; -- the same as CREATE DATABASE dbname;

-- DROP DATABASE sda_course; -- to delete a DB

-- Selects requested DB
USE sda_course;

-- Creates a table employees with given columns and attributes
CREATE TABLE IF NOT EXISTS employees (
	employee_id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    employee_first_name VARCHAR (50) NOT NULL,
    employee_last_name VARCHAR (50) NOT NULL,
    date_of_birth VARCHAR (10),
    employee_salary FLOAT
);

DESCRIBE employees;