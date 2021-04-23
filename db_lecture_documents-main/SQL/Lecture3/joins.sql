SELECT 
	t.teacher_id,
    c.course_id,
    c.course_name,
    t.teacher_name
FROM course c #on left side
JOIN teacher	t #on right side  INNER , LEFT, RIGHT, OUTTER
ON t.teacher_id = c.teacher_id;

SELECT 
	c.course_id as id, c.course_name,
	t.teacher_id,
    t.teacher_name,
    st.student_name
FROM teacher t
INNER JOIN  course c  ON t.teacher_id = c.teacher_id
INNER JOIN student_course stc ON stc.course_id = c.course_id
INNER JOIN student st ON st.student_id = stc.student_id;

SELECT 
	c.course_id as id,
	c.course_name,
	t.teacher_id, t.teacher_name
FROM teacher t
INNER JOIN  course c  
ON t.teacher_id = c.teacher_id;