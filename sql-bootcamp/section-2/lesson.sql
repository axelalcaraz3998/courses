-- ========== SELECT statement ==========
SELECT first_name, last_name, email FROM customer;

-- ========== DISTINCT statement ==========
SELECT DISTINCT rating FROM film;

-- ========== COUNT function ==========
SELECT COUNT(DISTINCT amount) FROM payment;

-- ========== WHERE clause ==========
SELECT email
FROM customer
WHERE first_name = 'Nancy'
AND last_name = 'Thomas';

SELECT description
FROM film
WHERE title = 'Outlaw Hanky';

SELECT phone
FROM address
WHERE address = '259 Ipoh Drive';

-- ========== ORDER BY and LIMIT clause ==========
SELECT customer_id
FROM payment
ORDER BY payment_date ASC
LIMIT 10;

SELECT title, length
FROM film
ORDER BY length ASC
LIMIT 5;

-- ========== BETWEEN operator ==========
SELECT COUNT(payment_id)
FROM payment
WHERE amount BETWEEN 8 AND 9;

SELECT *
FROM payment
WHERE payment_date BETWEEN '2007-02-01' AND '2007-02-15';

-- ========== IN operator ==========
SELECT *
FROM customer
WHERE first_name IN ('John', 'Jake', 'Julie');

-- ========== LIKE and ILIKE operator ==========
SELECT *
FROM customer
WHERE first_name ILIKE 'J%'
AND last_name ILIKE 'S%';
