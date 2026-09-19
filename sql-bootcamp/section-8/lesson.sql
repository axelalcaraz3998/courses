-- ========== CREATE statement ==========
CREATE TABLE account(
	user_id SERIAL PRIMARY KEY,
	username VARCHAR(50) UNIQUE NOT NULL,
	password VARCHAR(50) NOT NULL,
	email VARCHAR(250) UNIQUE NOT NULL,
	created_on TIMESTAMP NOT NULL,
	last_login TIMESTAMP
);

CREATE TABLE job(
	job_id SERIAL PRIMARY KEY,
	job_name VARCHAR(200) UNIQUE NOT NULL
);

CREATE TABLE account_job(
	user_id INTEGER REFERENCES account(user_id),
	job_id INTEGER REFERENCES job(job_id),
	hire_date TIMESTAMP NOT NULL
);

-- ========== INSERT statement ==========
INSERT INTO account(username, password, email, created_on)
VALUES(
	'jose',
	'password123',
	'jose@example.com',
	CURRENT_TIMESTAMP
);

SELECT * FROM account;

INSERT INTO job(job_name)
VALUES('Astronaut');

SELECT * FROM job;

INSERT INTO account_job(user_id, job_id, hire_date)
VALUES(1, 1, CURRENT_TIMESTAMP);

SELECT * FROM account_job;

-- ========== UPDATE statement ==========
UPDATE account
SET last_login = CURRENT_TIMESTAMP
WHERE user_id = 1;

SELECT * FROM account;

UPDATE account_job
SET hire_date = account.created_on
FROM account
WHERE account_job.user_id = account.user_id;

SELECT * FROM account_job;

-- ========== DELETE statement ==========
INSERT INTO job(job_name)
VALUES('President');

SELECT * FROM job;

DELETE FROM job
WHERE job_name = 'President';

SELECT * FROM job;

-- ========== ALTER statement ==========
CREATE TABLE information(
	info_id SERIAL PRIMARY KEY,
	title VARCHAR(500) NOT NULL,
	person VARCHAR(50) UNIQUE NOT NULL
);

ALTER TABLE information
RENAME TO new_info;

ALTER TABLE new_info
RENAME COLUMN person TO people;

ALTER TABLE new_info
ALTER COLUMN people DROP NOT NULL;

SELECT * FROM new_info;

-- ========== DROP statement ==========
ALTER TABLE new_info
DROP COLUMN IF EXISTS people;

SELECT * FROM new_info;
