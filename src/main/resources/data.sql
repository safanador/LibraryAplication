CREATE TABLE IF NOT EXISTS magazine (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    publication_date DATE,
    category VARCHAR(255),
    issue_number INT,
    publisher VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS book (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    publication_date DATE,
    author VARCHAR(255),
    isbn VARCHAR(20),
    page_count INT
);

CREATE TABLE IF NOT EXISTS dvd (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    publication_date DATE,
    director VARCHAR(255),
    genre VARCHAR(100),
    duration INT
);