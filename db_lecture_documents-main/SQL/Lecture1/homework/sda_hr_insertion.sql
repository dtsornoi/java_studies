USE humanResources;

INSERT INTO employees(
			employeeId,
            firstName,
            lastName,
            dateOfBirth,
            phoneNumber,
            email,
            salary)
VALUES (1, 'John', 'Johnson', '1975-01-01', '0-800-800-314', 'john@johnson.com', 1000),
		(2, 'James', 'Jameson', '1985-02-02','0-800-800-999', 'james@jameson.com', 2000);

UPDATE employees SET dateOfBirth = '1980-01-01'
WHERE employeeId = 1;

TRUNCATE employees;
 
SELECT * FROM employees;
