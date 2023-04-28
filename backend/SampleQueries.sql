/* Retrieving information from customers */
SELECT FirstName, LastName, UserName FROM CUSTOMER;

/* Retreiving information from employees */
SELECT FirstName, LastName, LocationID FROM EMPLOYEE;

/* Retrieve the type name, description, and price of all plant types */
SELECT TypeName, Description, Price FROM PLANT_TYPE;

/* Retrieve the quantity of all plant types in each location */
SELECT TypeName, LocationSector, Quantity FROM NUMBER_OF 
JOIN LOCATION ON NUMBER_OF.LocationID = LOCATION.LocationID;

/* Retrieve the first name, last name, and location sector of all employees 
working in a location with a temperature of 70 or higher */
SELECT EMPLOYEE.FirstName, EMPLOYEE.LastName, LOCATION.LocationSector FROM EMPLOYEE 
JOIN LOCATION ON EMPLOYEE.LocationID = LOCATION.LocationID
WHERE LOCATION.Temperature >= 70;

/* Retrieve the plant ID, plant type, and customer username of all plants owned by a 
customer with the username "JJam65" */
SELECT PLANT.PlantID, PLANT.PlantType, CUSTOMER.UserName FROM PLANT
JOIN CUSTOMER ON PLANT.CustomerID = CUSTOMER.CustomerID
WHERE CUSTOMER.UserName = 'JJam65';

/* Find all orders that contain more than two items and have a total cost of over $50 */
SELECT o.order_id, o.order_date, o.customer_id, SUM(i.item_price * oi.quantity) AS total_cost
FROM orders o
JOIN order_items oi ON o.order_id = oi.order_id
JOIN items i ON oi.item_id = i.item_id
GROUP BY o.order_id
HAVING COUNT(*) > 2 AND total_cost > 50;

/* Find the top 5 customers who have made the most orders */
SELECT c.customer_id, c.first_name, c.last_name, COUNT(*) AS total_orders
FROM customers c
JOIN orders o ON c.customer_id = o.customer_id
GROUP BY c.customer_id
ORDER BY total_orders DESC
LIMIT 5;

/* Find the customers who have made an order in every month of 2022 */
SELECT c.customer_id, c.first_name, c.last_name
FROM customers c
WHERE NOT EXISTS (
  SELECT *
  FROM months m
  WHERE NOT EXISTS (
    SELECT *
    FROM orders o
    WHERE o.customer_id = c.customer_id AND MONTH(o.order_date) = m.month_number AND YEAR(o.order_date) = 2022
  )
);

