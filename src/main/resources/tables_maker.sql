CREATE TABLE customers
(
    `registration_code` INT PRIMARY KEY AUTO_INCREMENT,
    `full_name`         VARCHAR(255),
    `email`            VARCHAR(255),
    `telephone`        VARCHAR(20)
);

CREATE TABLE orders
(
    `order_id`        INT PRIMARY KEY AUTO_INCREMENT,
    `customer_id`     INT,
    `submission_date` DATE,
    FOREIGN KEY (`customer_id`) REFERENCES `customers` (`registration_code`)
);



CREATE TABLE products
(
    `product_id`   INT PRIMARY KEY AUTO_INCREMENT,
    `product_name` VARCHAR(255),
    `sku_code` varchar(255),
    `unit_price` INT
);

CREATE TABLE orderLines
(
    `orderLine_id` INT PRIMARY KEY AUTO_INCREMENT,
    `order_id`     INT,
    `product_id`   INT,
    `quantity`     INT,
    FOREIGN KEY (`order_id`) REFERENCES orders (`order_id`),
    FOREIGN KEY (`product_id`) REFERENCES products (`product_id`)
);

