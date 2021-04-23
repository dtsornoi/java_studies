CREATE DATABASE IF NOT EXISTS sda_school;
USE sda_school;

CREATE TABLE IF NOT EXISTS teacher(
	teacher_id INT PRIMARY KEY AUTO_INCREMENT,
    teacher_name VARCHAR(100)
);

-- DESCRIBE teacher;

CREATE TABLE IF NOT EXISTS course (
	course_id INT PRIMARY KEY AUTO_INCREMENT,
    course_name VARCHAR(100),
    teacher_id INT
);

CREATE TABLE IF NOT EXISTS student_course (
	student_course_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT,
    course_id INT
);

CREATE TABLE IF NOT EXISTS student(
	student_id INT PRIMARY KEY AUTO_INCREMENT,
    student_name VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS student_detail(
	student_id INT PRIMARY KEY AUTO_INCREMENT,
    address VARCHAR(100),
    phone VARCHAR(20),
    dob VARCHAR(11),
    join_date DATE
);