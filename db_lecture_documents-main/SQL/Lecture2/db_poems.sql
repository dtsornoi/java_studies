CREATE DATABASE db_poems;

USE db_poems;

CREATE TABLE IF NOT EXISTS users(
	user_id INT PRIMARY KEY AUTO_INCREMENT,
	first_name VARCHAR (50),
    last_name VARCHAR (50),
    email VARCHAR (100),
    username VARCHAR (30),
    pass_phrase VARCHAR (500),
    is_admin TINYINT (4),
    date_registered DATETIME,
    profile_pic VARCHAR (30),
    registretion_confirmed TINYINT (4)
);

CREATE TABLE IF NOT EXISTS tokens(
	token_id INT PRIMARY KEY AUTO_INCREMENT,
    token CHAR (64),
    user_id INT (11),
    token_expires DATETIME,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE IF NOT EXISTS poems(
	poem_id INT (11) PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR (200),
    poem TEXT,
    date_submitted DATETIME,
    category_id INT (11),
    user_id INT (11),
    date_approved DATETIME,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (category_id) REFERENCES categories(category_id)
);

CREATE TABLE IF NOT EXISTS categories(
	category_id INT (11) PRIMARY KEY,
    category VARCHAR (100)
);

INSERT INTO users (
	-- user_id,
	date_registered)
VALUES (
	-- 1,
	CURRENT_TIMESTAMP);
    