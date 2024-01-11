CONNECT SYSDBA/password_li_nsit@localhost:1521/ORCL
create database School;
-- _____________________create_tables.sql______________________________________

-- Create teachers table
CREATE TABLE teachers (
    teacher_id INT PRIMARY KEY,
    t_1st_name VARCHAR(255) NOT NULL,
    t_last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    grade VARCHAR(255) NOT NULL
);

-- Create students table
CREATE TABLE students (
    std_id INT PRIMARY KEY,
    std_1st_name VARCHAR(255) NOT NULL,
    std_last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    major_id INT,
    FOREIGN KEY (major_id) REFERENCES majors (major_id)
);

-- Create departments table
CREATE TABLE departments (
    dept_id INT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    dpt_head_id INT,
    FOREIGN KEY (dpt_head_id) REFERENCES teachers (teacher_id)
);

-- Create majors table
CREATE TABLE majors (
    major_id INT PRIMARY KEY,
    major_title VARCHAR(255) NOT NULL
);

-- Create modules table
CREATE TABLE modules (
    module_id INT PRIMARY KEY,
    module_title VARCHAR(255) NOT NULL,
    dept_id INT,
    FOREIGN KEY (dept_id) REFERENCES departments (dept_id)
);
SELECT* FROM departments;
-- ________________insert into tables is next _______________

INSERT INTO departments (dept_id,title,dpt_head_id) 
VALUES (1,'GEGM','100'),
        (2,'MIP','101'),
        (3,'BCG','102');