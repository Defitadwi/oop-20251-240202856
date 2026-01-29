CREATE DATABASE IF NOT EXISTS agripos_db;
USE agripos_db;

CREATE TABLE IF NOT EXISTS products (
    id VARCHAR(50) PRIMARY KEY,
    name VARCHAR(100),
    category VARCHAR(50),
    price DOUBLE,
    stock INT
);