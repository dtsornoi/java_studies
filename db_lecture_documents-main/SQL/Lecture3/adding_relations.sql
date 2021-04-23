ALTER TABLE student_detail ADD FOREIGN KEY(student_id)
REFERENCES student(student_id);

ALTER TABLE course ADD FOREIGN KEY(teacher_id)
REFERENCES teacher(teacher_id);

ALTER TABLE student_course ADD FOREIGN KEY(student_id)
REFERENCES student(student_id);

ALTER TABLE student_course ADD FOREIGN KEY(course_id)
REFERENCES course(course_id);