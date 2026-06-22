-- Create CUSTOMER_INFO table based on Customer entity
CREATE TABLE IF NOT EXISTS CUSTOMER_INFO (
    CUSTOMER_ID INT NOT NULL PRIMARY KEY,
    FIRST_NAME VARCHAR(100) NOT NULL,
    LAST_NAME VARCHAR(100) NOT NULL,
    EMAIL VARCHAR(150),
    GENDER VARCHAR(20),
    CONTACT VARCHAR(15),
    COUNTRY VARCHAR(100),
    DOB VARCHAR(50),
    CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UPDATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Create index for email and contact
CREATE INDEX IF NOT EXISTS idx_email ON CUSTOMER_INFO(EMAIL);
CREATE INDEX IF NOT EXISTS idx_contact ON CUSTOMER_INFO(CONTACT);

-- Set character set for better Turkish character support
ALTER TABLE CUSTOMER_INFO CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

    drop table if exists customer_info;

    create table customer_info (
        customer_id integer not null,
        contact varchar(255),
        country varchar(255),
        dob varchar(255),
        email varchar(255),
        first_name varchar(255),
        gender varchar(255),
        last_name varchar(255),
        primary key (customer_id)
    ) engine=InnoDB;

    drop table if exists customer_info;

    create table customer_info (
        customer_id integer not null,
        contact varchar(255),
        country varchar(255),
        dob varchar(255),
        email varchar(255),
        first_name varchar(255),
        gender varchar(255),
        last_name varchar(255),
        primary key (customer_id)
    ) engine=InnoDB;

    drop table if exists customer_info;

    create table customer_info (
        customer_id integer not null,
        contact varchar(255),
        country varchar(255),
        dob varchar(255),
        email varchar(255),
        first_name varchar(255),
        gender varchar(255),
        last_name varchar(255),
        primary key (customer_id)
    ) engine=InnoDB;

    drop table if exists customer_info;

    create table customer_info (
        customer_id integer not null,
        contact varchar(255),
        country varchar(255),
        dob varchar(255),
        email varchar(255),
        first_name varchar(255),
        gender varchar(255),
        last_name varchar(255),
        primary key (customer_id)
    ) engine=InnoDB;

    drop table if exists customer_info;

    create table customer_info (
        customer_id integer not null,
        contact varchar(255),
        country varchar(255),
        dob varchar(255),
        email varchar(255),
        first_name varchar(255),
        gender varchar(255),
        last_name varchar(255),
        primary key (customer_id)
    ) engine=InnoDB;

    drop table if exists customer_info;

    create table customer_info (
        customer_id integer not null,
        contact varchar(255),
        country varchar(255),
        dob varchar(255),
        email varchar(255),
        first_name varchar(255),
        gender varchar(255),
        last_name varchar(255),
        primary key (customer_id)
    ) engine=InnoDB;

    drop table if exists customer_info;

    create table customer_info (
        customer_id integer not null,
        contact varchar(255),
        country varchar(255),
        dob varchar(255),
        email varchar(255),
        first_name varchar(255),
        gender varchar(255),
        last_name varchar(255),
        primary key (customer_id)
    ) engine=InnoDB;

    drop table if exists customer_info;

    create table customer_info (
        customer_id integer not null,
        contact varchar(255),
        country varchar(255),
        dob varchar(255),
        email varchar(255),
        first_name varchar(255),
        gender varchar(255),
        last_name varchar(255),
        primary key (customer_id)
    ) engine=InnoDB;
