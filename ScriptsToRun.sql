CREATE DATABASE IF NOT EXISTS cz3002;
USE cz3002;
DROP TABLE IF EXISTS users;
CREATE TABLE users
(
    username VARCHAR(50)  NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);
INSERT INTO users (username, password)
VALUES ('test', 'password'),
       ('peter', '12345password');