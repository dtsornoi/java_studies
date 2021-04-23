SELECT 
	date_registered,
	COUNT(date_registred) AS Users_Registered
FROM users
GROUP BY date_registered;