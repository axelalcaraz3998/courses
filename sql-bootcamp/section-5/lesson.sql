-- ========== AS statement ==========
SELECT customer_id, SUM(amount) AS total_spent
FROM payment
GROUP BY customer_id
HAVING SUM(amount) > 100;

-- ========== Inner join ==========
SELECT payment.customer_id, first_name, last_name, payment_id, amount
FROM payment
INNER JOIN customer
ON payment.customer_id = customer.customer_id;

-- ========== Full join ==========
SELECT *
FROM customer
FULL JOIN payment
ON customer.customer_id = payment.customer_id
WHERE customer.customer_id IS NULL
OR payment.payment_id IS NULL;

-- ========== Left join ==========
SELECT film.film_id, title, inventory_id, store_id
FROM film
LEFT JOIN inventory
ON film.film_id = inventory.film_id
WHERE inventory.film_id IS NULL;
