CREATE DATABASE IF NOT EXISTS real_estate_db;

USE real_estate_db;

CREATE TABLE IF NOT EXISTS Tenant(
	id INT AUTO_INCREMENT PRIMARY KEY,
    givenName VARCHAR(50),
    surname VARCHAR(50) NOT NULL,
    phone VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS Tenancy(
	tenant INT,
    property INT,
    dateStart DATE,
    dateEnd DATE,
    rate INT NOT NULL,
    PRIMARY KEY(tenant, property, dateStart),
    FOREIGN KEY (tenant) REFERENCES Tenant(id)
);

CREATE TABLE IF NOT EXISTS Property(
	id INT AUTO_INCREMENT PRIMARY KEY,
    propertyType INT NOT NULL,
    rent INT,
    unitnum INT,
    propertynum INT NOT NULL,
    street VARCHAR(100) NOT NULL,
    suburb VARCHAR(100) NOT NULL,
    postcode VARCHAR(50) NOT NULL
);

ALTER TABLE Tenancy ADD FOREIGN KEY (property) REFERENCES Property(id);

CREATE TABLE IF NOT EXISTS PropertyType(
	id INT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(250) NOT NULL
);

ALTER TABLE Property ADD FOREIGN KEY (propertyType) REFERENCES PropertyType(id);

CREATE TABLE IF NOT EXISTS House(
	id INT PRIMARY KEY NOT NULL,
    numBedrooms INT NOT NULL,
    FOREIGN KEY(id) REFERENCES Property(id)
);

CREATE TABLE IF NOT EXISTS Apartment(
	id INT PRIMARY KEY NOT NULL,
    numBedrooms INT NOT NULL,
    numCarSpaces INT,
    FOREIGN KEY(id) REFERENCES Property(id)
);

CREATE TABLE IF NOT EXISTS Shared (
    id INT PRIMARY KEY NOT NULL,
    contactName VARCHAR(50) NOT NULL,
    contactPhone VARCHAR(50) NOT NULL,
    FOREIGN KEY (id) REFERENCES Property (id)
);

#DROP DATABASE real_estate_db;