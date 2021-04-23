CREATE TABLE school_students(
	id INT AUTO_INCREMENT PRIMARY KEY,
    total_students INT NOT NULL,
    up_to_date DATE
);

DESCRIBE school_students;

CREATE TRIGGER after_insert_students
	AFTER INSERT ON student
    FOR EACH ROW
INSERT INTO school_students(total_students, up_to_date)
VALUES ((SELECT COUNT(*) FROM student), NOW());

SELECT * FROM school_students;
SELECT * FROM student;
INSERT INTO student(student_name) VALUES ('Camillo');
INSERT INTO student (student_name) VALUES ('INDREK');