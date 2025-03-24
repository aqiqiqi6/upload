-- 创建数据库
CREATE DATABASE IF NOT EXISTS file_record DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- 使用数据库
USE file_record;

-- 创建表
CREATE TABLE file_record (
                             id BIGINT PRIMARY KEY AUTO_INCREMENT,
                             file_name VARCHAR(255) NOT NULL,
                             file_url VARCHAR(500) NOT NULL,
                             upload_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);