/*
Create 2 tables: students and teachers.

The students table should have columns:
	1. student_id
	2. first_name
	3. last_name
	4. homeroom_number
	5. phone
	6. email
	7. graduation_year

The teachers table should have columns:
	1. teacher_id
	2. first_name
	3. last_name
	4. homeroom_number
	5. department
	6. email
	7. phone

The constraints are as follows:
	1. We must have a phone number to contact students in case of an emergency.
	2. We must have ids as the primary key of the tables
	3. Phone numbers and emails must be unique to the individual.
*/

CREATE TABLE students(
	student_id SERIAL PRIMARY KEY,
	first_name VARCHAR(255) NOT NULL,
	last_name VARCHAR(255) NOT NULL,
	homeroom_number SMALLINT NOT NULL,
	phone VARCHAR(255) UNIQUE NOT NULL,
	email VARCHAR(255) UNIQUE NOT NULL,
	graduation_year SMALLINT
);

CREATE TABLE teachers(
	teacher_id SERIAL PRIMARY KEY,
	first_name VARCHAR(255) NOT NULL,
	last_name VARCHAR(255) NOT NULL,
	homeroom_number SMALLINT NOT NULL,
	department VARCHAR(255) NOT NULL,
	phone VARCHAR(255) UNIQUE NOT NULL,
	email VARCHAR(255) UNIQUE NOT NULL
);
