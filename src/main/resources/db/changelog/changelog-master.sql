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
    title VARCHAR(255) not null,
    modules INT
);
--changeset aishy:1
ALTER TABLE student ALTER COLUMN name SET NOT NULL;
ALTER TABLE student ALTER COLUMN age SET NOT NULL;

--changeset aishy:2
ALTER TABLE course ALTER COLUMN fee SET NOT NULL;
ALTER TABLE course ALTER COLUMN modules SET NOT NULL;

-- Rollback instructions are optional but recommended for each changeset
--rollback ALTER TABLE student ALTER COLUMN name DROP NOT NULL;
--rollback ALTER TABLE student ALTER COLUMN age DROP NOT NULL;
--rollback ALTER TABLE course ALTER COLUMN abbreviation DROP NOT NULL;
--rollback ALTER TABLE course ALTER COLUMN fee DROP NOT NULL;
--rollback ALTER TABLE course ALTER COLUMN modules DROP NOT NULL;
