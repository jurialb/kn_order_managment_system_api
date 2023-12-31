CREATE TABLE IF NOT EXISTS customers
(
    `registration_code` INT PRIMARY KEY AUTO_INCREMENT,
    `full_name`         VARCHAR(255),
    `email`            VARCHAR(255),
    `telephone`        VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS orders
(
    `order_id`        INT PRIMARY KEY AUTO_INCREMENT,
    `customer_id`     INT,
    `submission_date` DATE,
    FOREIGN KEY (`customer_id`) REFERENCES `customers` (`registration_code`)
);


CREATE TABLE IF NOT EXISTS products
(
    `product_id`   INT PRIMARY KEY AUTO_INCREMENT,
    `product_name` VARCHAR(255),
    `sku_code` varchar(255),
    `unit_price` INT
);


CREATE TABLE IF NOT EXISTS order_lines
(
            `orderline_id` INT PRIMARY KEY AUTO_INCREMENT,
    `order_id`     INT,
    `product_id`   INT,
    `quantity`     INT,
    FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`),
    FOREIGN KEY (`product_id`) REFERENCES products   (`product_id`)
);
DELETE FROM order_lines;
ALTER TABLE order_lines AUTO_INCREMENT = 1;
DELETE FROM products;
ALTER TABLE products AUTO_INCREMENT = 1;
DELETE FROM orders;
ALTER TABLE orders AUTO_INCREMENT = 1;
DELETE FROM customers;
ALTER TABLE customers AUTO_INCREMENT = 1;



INSERT INTO customers (full_name, email, telephone) VALUES
                                                        ('John Doe', 'johndoe@example.com', '098-725-4321'),
                                                        ('Jane Smith', 'janesmith@example.com', '238-765-4321'),
                                                        ('Peter Jones', 'peterjones@example.com', '098-765-4321');

INSERT INTO orders (customer_id, submission_date) VALUES
                                                      (1 , '2023-10-04'),
                                                      (2, '2023-10-05'),
                                                      (3, '2023-10-06');


INSERT INTO products (product_name, sku_code, unit_price) VALUES
                                                              ('Laptop', 'ABC123', 1000),
                                                              ('Smartphone', 'DEF456', 500),
                                                              ('Tablet', 'GHI789', 300);


INSERT INTO order_lines (order_id, product_id, quantity) VALUES
                                                             (1, 1, 1),
                                                             (1, 2, 2),
                                                             (2, 3, 3),
                                                             (3, 1, 1),
                                                             (3, 2, 2);