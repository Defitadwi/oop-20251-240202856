CREATE DATABASE agripos_db;

CREATE TABLE products (
    code VARCHAR(10) PRIMARY KEY,
    name VARCHAR(100),
    price DECIMAL(12,2),
    stock INTEGER
);