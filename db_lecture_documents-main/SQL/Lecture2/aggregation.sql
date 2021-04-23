#DQL
#Aggregation function
#MAX, MIN, AVG, SUM

#AS -> alias
SELECT MAX(employee_salary) AS highest_salary 
FROM employees;

#SUBQUERY
SELECT employee_first_name FROM employees
WHERE employee_salary = (SELECT MIN(employee_salary) FROM employees);

#ASC -> Ascending
#DESC -> descending
#OEDER BY -> order by parameter

SELECT employee_first_name FROM employees
ORDER BY employee_first_name, employee_last_name ASC;