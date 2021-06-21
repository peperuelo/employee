DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS person;
DROP TABLE IF EXISTS position;

CREATE TABLE Position
(
    position_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(255) NOT NULL
);

CREATE TABLE Person
(
    person_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name      VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    address   VARCHAR(255) NOT NULL,
    cellphone VARCHAR(255) NOT NULL,
    city_name VARCHAR(255) NOT NULL
);

CREATE TABLE Employee
(
    id       BIGINT AUTO_INCREMENT PRIMARY KEY,
    person   BIGINT  NOT NULL,
    position BIGINT  NOT NULL,
    salary   INTEGER NOT NULL,
    FOREIGN KEY (person) REFERENCES Person (person_id),
    FOREIGN KEY (position) REFERENCES Position (position_id)
);
