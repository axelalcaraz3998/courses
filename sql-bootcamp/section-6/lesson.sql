-- ========== Timestamps and Extract ==========
SHOW TIMEZONE;

SELECT NOW();

SELECT TIMEOFDAY();

SELECT CURRENT_TIME;

SELECT CURRENT_DATE;

SELECT EXTRACT(YEAR FROM payment_date) AS year
FROM payment;

SELECT TO_CHAR(payment_date, 'YYYY-Mon-dd')
FROM payment;

SELECT COUNT(payment_id)
FROM payment
WHERE EXTRACT(dow FROM payment_date) = 1;

-- ========== Mathematical Functions and Operators ==========
SELECT ROUND(rental_rate / replacement_cost, 2) * 100 AS percentage
FROM film;

SELECT ROUND(0.1 * replacement_cost, 2) AS deposit
FROM film;

-- ========== String Functions and Operators ==========
SELECT LENGTH(first_name) AS length
FROM customer;

SELECT first_name || ' ' || last_name AS full_name
FROM customer;

SELECT LOWER(LEFT(first_name, 1)) || LOWER(last_name) || '@example.com' AS email
FROM customer;

-- ========== Subquery ==========
SELECT title, rental_rate
FROM film
WHERE rental_rate > (
	SELECT AVG(rental_rate)
	FROM film
);

SELECT film_id, title
FROM film
WHERE film_id IN (
	SELECT inventory.film_id
	FROM rental
	INNER JOIN inventory
	ON rental.inventory_id = inventory.inventory_id
	WHERE rental.return_date BETWEEN '2005-05-29'
	AND '2005-05-30'
);

SELECT first_name, last_name
FROM customer
WHERE EXISTS (
	SELECT payment_id
	FROM payment
	WHERE payment.customer_id = customer.customer_id
	AND payment.amount > 11
);

-- ========== Self Join ==========
SELECT t1.title, t2.title, t1.length
FROM film t1
INNER JOIN film t2
ON t1.film_id != t2.film_id
AND t1.length = t2.length;
