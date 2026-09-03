DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS members;

--
-- Table structure for table members
--

CREATE TABLE members (
    user_id VARCHAR(50) NOT NULL,
    pw CHAR(68) NOT NULL,
    active BOOLEAN NOT NULL,
    PRIMARY KEY (user_id)
);

--
-- Inserting data for table members
--
-- Password: fun123
--

INSERT INTO members (user_id, pw, active)
VALUES
    ('john', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', TRUE),
    ('mary', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', TRUE),
    ('susan', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', TRUE);

--
-- Table structure for table roles
--

CREATE TABLE roles (
    user_id VARCHAR(50) NOT NULL,
    role VARCHAR(50) NOT NULL,
    CONSTRAINT authorities5_idx_1 UNIQUE (user_id, role),
    CONSTRAINT authorities5_ibfk_1
        FOREIGN KEY (user_id)
        REFERENCES members (user_id)
);

--
-- Inserting data for table roles
--

INSERT INTO roles (user_id, role)
VALUES
    ('john', 'ROLE_EMPLOYEE'),
    ('mary', 'ROLE_EMPLOYEE'),
    ('mary', 'ROLE_MANAGER'),
    ('susan', 'ROLE_EMPLOYEE'),
    ('susan', 'ROLE_MANAGER'),
    ('susan', 'ROLE_ADMIN');
