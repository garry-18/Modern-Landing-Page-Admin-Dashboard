-- ============================================================
-- DATABASE SETUP
-- Spring Boot Landing Page — Internship Task 2
-- ============================================================

-- Create and select the database
CREATE DATABASE IF NOT EXISTS internship_db
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE internship_db;

-- ============================================================
-- Table: contacts
-- Hibernate (spring.jpa.hibernate.ddl-auto=update) will
-- create this automatically, but this script lets you set
-- it up manually or inspect the expected schema.
-- ============================================================
CREATE TABLE IF NOT EXISTS contacts (
    id      BIGINT       NOT NULL AUTO_INCREMENT,
    name    VARCHAR(255),
    email   VARCHAR(255),
    message TEXT,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
