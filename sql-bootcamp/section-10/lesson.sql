-- ========== CASE statement ==========
SELECT customer_id,
CASE
	WHEN customer_id <= 100 THEN 'Premium'
	WHEN customer_id BETWEEN 100 AND 200 THEN 'Plus'
	ELSE 'Normal'
END AS priority
FROM customer;

SELECT SUM(
CASE
	WHEN rating = 'R' THEN 1
	ELSE 0
END) AS r,
SUM(
CASE
	WHEN rating = 'PG' THEN 1
	ELSE 0
END) AS pg,
SUM(
CASE
	WHEN rating = 'PG-13' THEN 1
	ELSE 0
END) AS pg13
FROM film;
