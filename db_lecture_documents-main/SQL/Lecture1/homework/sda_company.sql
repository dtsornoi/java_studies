CREATE DATABASE companyDB;

USE companyDB;

CREATE TABLE company(
	company_id VARCHAR (28) UNIQUE,
    trade VARCHAR (40) NOT NULL,
    number_of_employees INT NOT NULL DEFAULT 0
);

CREATE TABLE job_offer(
	offer_id VARCHAR (36) UNIQUE,
    offer_title VARCHAR (40) DEFAULT '',
    offer_min_salary decimal(6,0) DEFAULT 5000,
    offer_max_salary decimal(6,0) DEFAULT NULL,
    company_id VARCHAR (28),
	FOREIGN KEY (company_id) REFERENCES company(company_id)
);

CREATE TABLE candidate(
	candidate_id VARCHAR (36),
    first_name VARCHAR (40) DEFAULT '',
    last_name VARCHAR (40) DEFAULT '',
    email VARCHAR (30),
    phone_number VARCHAR (12),
    job_offer_id VARCHAR (36),
    company_id VARCHAR (28),
    FOREIGN KEY (job_offer_id, company_id) REFERENCES comapny(offer_id, company_id)
);