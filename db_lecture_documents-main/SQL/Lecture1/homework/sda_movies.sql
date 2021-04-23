CREATE DATABASE moviesDB;

USE moviesDB;

CREATE TABLE movies(
	movie_id VARCHAR (36),
    movie_name VARCHAR (40),
    movie_type VARCHAR (30),
    movie_rating TINYINT
);

CREATE TABLE IF NOT EXISTS movies(
	movie_id VARCHAR (36) UNIQUE,
    movie_name VARCHAR (40),
    movie_type VARCHAR (30),
    movie_rating TINYINT
);

CREATE TABLE IF NOT EXISTS movies(
	movie_id INT PRIMARY KEY AUTO_INCREMENT,
    movie_name VARCHAR (40) NOT NULL,
    movie_type VARCHAR (30) NOT NULL,
    movie_rating TINYINT NOT NULL
);

CREATE TABLE IF NOT EXISTS movies(
	movie_id INT PRIMARY KEY AUTO_INCREMENT UNIQUE,
    movie_name VARCHAR (40) UNIQUE,
    movie_type VARCHAR (30),
    movie_rating TINYINT
);

CREATE TABLE movies_V2 LIKE movies;