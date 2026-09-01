-- Drop user first if they exist
DROP ROLE IF EXISTS springstudent;

-- Create user
CREATE ROLE springstudent WITH LOGIN PASSWORD 'springstudent';

-- Grant privileges on the database
GRANT ALL PRIVILEGES ON DATABASE student_tracker TO springstudent;
