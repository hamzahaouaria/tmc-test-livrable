-- Drop the database if it exists
DROP DATABASE IF EXISTS company_management_db;

-- Create the database
CREATE DATABASE company_management_db;

-- Use the database
USE company_management_db;

-- Start a transaction
START TRANSACTION;

-- Table for employees
CREATE TABLE employees (
    employee_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    date_of_birth DATE NOT NULL
);

-- Table for contracts
CREATE TABLE contracts (
    contract_id INT AUTO_INCREMENT PRIMARY KEY,
    employee_id INT,
    date_of_signature DATE NOT NULL,
    -- Duration in months
    duration INT NOT NULL,
    salary DECIMAL(10, 2) NOT NULL
);

-- Table for family members
CREATE TABLE family_members (
    family_member_id INT AUTO_INCREMENT PRIMARY KEY,
    employee_id INT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    date_of_birth DATE NOT NULL
);

-- Table for services
CREATE TABLE services (
    service_id INT AUTO_INCREMENT PRIMARY KEY,
    service_name VARCHAR(100) NOT NULL,
    director_employee_id INT,
    parent_service_id INT
);

-- Table for employee_services (to store the relationship between employees and services)
CREATE TABLE employee_services (
    employee_id INT,
    service_id INT,
    PRIMARY KEY (employee_id, service_id)
);

-- Add foreign key constraints
ALTER TABLE contracts
ADD FOREIGN KEY (employee_id) REFERENCES employees(employee_id);

ALTER TABLE family_members
ADD FOREIGN KEY (employee_id) REFERENCES employees(employee_id);

ALTER TABLE services
ADD FOREIGN KEY (director_employee_id) REFERENCES employees(employee_id);

ALTER TABLE services
ADD FOREIGN KEY (parent_service_id) REFERENCES services(service_id);

ALTER TABLE employee_services
ADD FOREIGN KEY (employee_id) REFERENCES employees(employee_id);

ALTER TABLE employee_services
ADD FOREIGN KEY (service_id) REFERENCES services(service_id);

-- Commit the transaction
COMMIT;
