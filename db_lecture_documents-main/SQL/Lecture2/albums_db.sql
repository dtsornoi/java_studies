CREATE DATABASE albums_db;

USE albums_db;

CREATE TABLE Albums(
	AlbumId INT PRIMARY KEY,
    AlbumName VARCHAR (255),
    DateReleased DATETIME,
    ArtistId INT,
    GenreId INT,
    FOREIGN KEY (ArtistId) REFERENCES Artists(GenreId),
    FOREIGN KEY (GenreId) REFERENCES Genre(GenreId)
);

CREATE TABLE Genre(
	GenreId INT PRIMARY KEY,
    Genre VARCHAR (255)
);

CREATE TABLE Artists(
	ArtistId INT PRIMARY KEY,
    ArtistName VARCHAR (255)
);