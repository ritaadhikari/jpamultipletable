--liquibase formatted sql

CREATE TABLE student (
    id BIGSERIAL,
    name VARCHAR(255),
    depart VARCHAR(10),
    age INT
);
CREATE TABLE course (
    id BIGSERIAL not null,
    abbreviation VARCHAR(50),
    fee INT,
    title VARCHAR(255),
    modules INT
);