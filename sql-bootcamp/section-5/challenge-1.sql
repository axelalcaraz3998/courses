-- What are the emails of the customers who live in California?
SELECT first_name, last_name, email, district
FROM customer
INNER JOIN address
ON customer.address_id = address.address_id
WHERE district = 'California';

-- Get a list of all the movies Nick Wahlberg has been in.
SELECT film.title, film.release_year
FROM film_actor
INNER JOIN actor
ON film_actor.actor_id = actor.actor_id
INNER JOIN film
ON film_actor.film_id = film.film_id
WHERE actor.first_name = 'Nick'
AND actor.last_name = 'Wahlberg';
