-- How can you retrieve all the information from the cd.facilities table?
SELECT * FROM cd.facilities;

-- How would you retrieve a list of only facility names and member costs?
SELECT name, membercost
FROM cd.facilities;

-- How can you produce a list of facilities that charge a free to members?
SELECT name, membercost
FROM cd.facilities
WHERE membercost > 0;

-- How can you produce a list of facilities that charge a free to members,
-- and that fee is less than 1/50th of the monthly maintenances cost?
SELECT name, membercost, monthlymaintenance
FROM cd.facilities
WHERE membercost > 0
AND membercost < (monthlymaintenance / 50.00);

-- How can you produce a list of all facilities with the word 'Tennis' in their name
SELECT *
FROM cd.facilities
WHERE name ILIKE '%tennis%';

-- How can you produce a list of members who joined after the start of september 2012?
SELECT memid, surname, firstname, joindate
FROM cd.members
WHERE joindate >= '2012-09-01';

-- How can you produce and ordered list of the first 10 surnames in the members table?
SELECT DISTINCT(surname)
FROM cd.members
ORDER BY surname
LIMIT 10;

-- How can you get the signup date of your last member?
SELECT MAX(joindate)
FROM cd.members;

-- Produce a count of the number of facilities that have a cost to guests of 10 or more.
SELECT count(facid)
FROM cd.facilities
WHERE guestcost >= 10;

-- Produce a list of the total number of slots booked per facility in the month of Sept 2012.
SELECT facid, SUM(slots) AS total_slots
FROM cd.bookings
WHERE EXTRACT(MONTH FROM starttime) = 9
GROUP BY facid
ORDER by SUM(slots);

-- Produce a list of facilities with more than 1000 slots booked.
SELECT facid, SUM(slots) AS total_slots
FROM cd.bookings
GROUP BY facid
HAVING SUM(slots) > 1000;
