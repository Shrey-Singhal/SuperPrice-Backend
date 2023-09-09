# Temporarily disable foreign key checks to prevent integrity constraints when dropping tables
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS Users;
DROP TABLE IF EXISTS Supermarkets;
DROP TABLE IF EXISTS Products;
DROP TABLE IF EXISTS ProductPrices;
DROP TABLE IF EXISTS ProductRewards;
DROP TABLE IF EXISTS UserAddresses;
DROP TABLE IF EXISTS Orders;
DROP TABLE IF EXISTS OrderProducts;
DROP TABLE IF EXISTS UserOrderHistory;
DROP TABLE IF EXISTS UserRewardsPoints;
DROP TABLE IF EXISTS RewardsLevels;

CREATE TABLE Users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password_hash VARCHAR(100) NOT NULL,
    user_rewards_points INT NOT NULL DEFAULT 0 # DO WE NEED TO INCLUDE HERE OR JUST USE TABLE LINKED TO USER_ID?
    # ADD ANY ADDITIONAL FIELDS NEEDED
);

INSERT INTO Users (user_name, email, password_hash, user_rewards_points) VALUES
('Olivia Williams', 'olivia.williams@gmail.com', 'Password1', 500),
('Liam Wilson', 'liam.wilson@gmail.com', 'Password2', 300),
('Charlotte Taylor', 'charlotte.taylor@gmail.com', 'Password3', 700),
('Ethan Martin', 'ethan.martin@gmail.com', 'Password4', 350),
('Ava White', 'ava.white@gmail.com', 'Password5', 900);

CREATE TABLE Supermarkets (
    supermarket_id INT AUTO_INCREMENT PRIMARY KEY,
    supermarket_name VARCHAR(100) NOT NULL,
    supermarket_address VARCHAR(200) NOT NULL,
    latitude DECIMAL(10, 6) NOT NULL,
    longitude DECIMAL(10, 6) NOT NULL
    # ADD ANY ADDITIONAL FIELDS NEEDED
);

INSERT INTO Supermarkets (supermarket_name, supermarket_address, latitude, longitude) VALUES
('Woolworths', '1 Park St, Sydney, NSW 2000', -33.870843, 151.208295),
('Coles', '211 La Trobe St, Melbourne, VIC 3000', -37.809700, 144.963100),
('Aldi', '85 Mains Rd, Sunnybank, QLD 4109', -27.570539, 153.054489),
('IGA', '152-158 St Georges Terrace, Perth, WA 6000', -31.954708, 115.853638),
('Foodland', '144 Grote St, Adelaide, SA 5000', -34.927171, 138.598633);

CREATE TABLE Products (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    product_category VARCHAR(50) NOT NULL
    # ADD ANY ADDITIONAL FIELDS NEEDED
);

INSERT INTO Products (product_name, product_category) VALUES
('Full Cream Milk', 'Dairy'),
('Wholemeal Bread', 'Bakery'),
('Free Range Eggs', 'Dairy'),
('Granny Smith Apples', 'Produce'),
('Basmati Rice', 'Dry Goods');


CREATE TABLE ProductPrices (
    product_price_id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT NOT NULL,
    supermarket_id INT NOT NULL,
    product_price DECIMAL(8, 2) NOT NULL,
    last_updated TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (product_id) REFERENCES Products(product_id),
    FOREIGN KEY (supermarket_id) REFERENCES Supermarkets(supermarket_id),
    INDEX(product_id, supermarket_id) # OPTIMISATION FOR PRODUCT PRICE LOOKUPS
    # ADD ANY ADDITIONAL FIELDS NEEDED
);

INSERT INTO ProductPrices (product_id, supermarket_id, product_price) VALUES
(2, 3, 2.15),  # Wholemeal Bread at Aldi
(1, 2, 1.55),  # Full Cream Milk at Coles
(4, 1, 3.50),  # Granny Smith Apples at Woolworths
(3, 3, 3.90),  # Free Range Eggs at Aldi
(5, 1, 2.70),  # Basmati Rice at Woolworths

(3, 1, 4.00),  # Free Range Eggs at Woolworths
(2, 1, 2.20),  # Wholemeal Bread at Woolworths
(5, 3, 2.65),  # Basmati Rice at Aldi
(1, 1, 1.50),  # Full Cream Milk at Woolworths
(4, 3, 3.40),  # Granny Smith Apples at Aldi

(4, 2, 3.55),  # Granny Smith Apples at Coles
(2, 2, 2.25),  # Wholemeal Bread at Coles
(5, 2, 2.75),  # Basmati Rice at Coles
(1, 3, 1.45),  # Full Cream Milk at Aldi
(3, 2, 4.10);  # Free Range Eggs at Coles

CREATE TABLE ProductRewards (
    product_reward_id INT PRIMARY KEY,
    product_id INT NOT NULL,
    supermarket_id INT NOT NULL,
    rewards_points INT NOT NULL,
    FOREIGN KEY (product_id) REFERENCES Products(product_id),
    FOREIGN KEY (supermarket_id) REFERENCES Supermarkets(supermarket_id)
    # ADD ANY ADDITIONAL FIELDS NEEDED
);

INSERT INTO ProductRewards (product_reward_id, product_id, supermarket_id, rewards_points) VALUES
(1, 2, 3, 20),  # Wholemeal Bread at Aldi
(2, 1, 2, 15),  # Full Cream Milk at Coles
(3, 4, 1, 30),  # Granny Smith Apples at Woolworths
(4, 3, 3, 10),  # Free Range Eggs at Aldi
(5, 5, 1, 25),  # Basmati Rice at Woolworths

(6, 3, 1, 35),  # Free Range Eggs at Woolworths
(7, 2, 1, 40),  # Wholemeal Bread at Woolworths
(8, 5, 3, 45),  # Basmati Rice at Aldi
(9, 1, 1, 50),  # Full Cream Milk at Woolworths
(10, 4, 3, 5),  # Granny Smith Apples at Aldi

(11, 4, 2, 15),  # Granny Smith Apples at Coles
(12, 2, 2, 20),  # Wholemeal Bread at Coles
(13, 5, 2, 25),  # Basmati Rice at Coles
(14, 1, 3, 30),  # Full Cream Milk at Aldi
(15, 3, 2, 35); # Free Range Eggs at Coles

CREATE TABLE UserAddresses (
    user_address_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    address VARCHAR(200) NOT NULL,
    latitude DECIMAL(10, 6) NOT NULL,
    longitude DECIMAL(10, 6) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
    # ADD ANY ADDITIONAL FIELDS NEEDED
);



CREATE TABLE Orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    delivery_address_id INT NOT NULL,
    order_status VARCHAR(50) NOT NULL,
    order_total DECIMAL(10, 2) NOT NULL,
    order_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (delivery_address_id) REFERENCES UserAddresses(user_address_id)
    # ADD ANY ADDITIONAL FIELDS NEEDED
);

INSERT INTO Orders (user_id, delivery_address_id, order_status, order_total, order_date) VALUES
(1, 1, 'Delivered', 50.25, '2023-09-04 10:30:00'),
(2, 2, 'Pending', 30.40, '2023-09-04 11:15:00'),
(3, 3, 'Delivered', 45.60, '2023-09-04 12:00:00'),
(4, 4, 'Pending', 25.00, '2023-09-04 14:20:00'),
(5, 5, 'Shipped', 55.70, '2023-09-04 16:45:00');

CREATE TABLE OrderProducts (
    order_product_id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    product_price DECIMAL(8, 2) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES Orders(order_id),
    FOREIGN KEY (product_id) REFERENCES Products(product_id)
    # ADD ANY ADDITIONAL FIELDS NEEDED
);

INSERT INTO OrderProducts (order_id, product_id, quantity, product_price) VALUES
(1, 1, 3, 1.55),
(2, 2, 2, 2.15),
(3, 3, 5, 3.90),
(4, 4, 4, 3.50),
(5, 5, 3, 2.70);


CREATE TABLE UserOrderHistory (
    order_history_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    order_id INT NOT NULL,
    order_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    order_total DECIMAL(10, 2) NOT NULL,
    delivery_address_id INT NOT NULL,
    order_status VARCHAR(50) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (order_id) REFERENCES Orders(order_id),
    FOREIGN KEY (delivery_address_id) REFERENCES UserAddresses(user_address_id)
    # ADD ANY ADDITIONAL FIELDS NEEDED
);

INSERT INTO UserOrderHistory (user_id, order_id, order_total, delivery_address_id, order_status, order_date) VALUES
(1, 1, 50.25, 1, 'Delivered', '2023-09-04 10:30:00'),
(2, 2, 30.40, 2, 'Pending', '2023-09-04 11:15:00'),
(3, 3, 45.60, 3, 'Delivered', '2023-09-04 12:00:00'),
(4, 4, 25.00, 4, 'Pending', '2023-09-04 14:20:00'),
(5, 5, 55.70, 5, 'Shipped', '2023-09-04 16:45:00');

CREATE TABLE UserRewardsPoints (
    user_rewards_id INT PRIMARY KEY,
    user_id INT NOT NULL,
    rewards_points INT NOT NULL DEFAULT 0,
    rewards_level_id INT NOT NULL DEFAULT 0,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (rewards_level_id) REFERENCES RewardsLevels(rewards_level_id)
    # ADD ANY ADDITIONAL FIELDS NEEDED
);

INSERT INTO UserRewardsPoints (user_rewards_id, user_id, rewards_points, rewards_level_id) VALUES
(1, 1, 0, 2),
(2, 2, 100, 2),
(3, 3, 200, 2),
(4, 4, 300, 2),
(5, 5, 1000, 3);

CREATE TABLE RewardsLevels (
    rewards_level_id INT PRIMARY KEY,
    rewards_level_name VARCHAR(50) NOT NULL,
    required_points_amount DECIMAL(10, 2) NOT NULL
    # ADD ANY ADDITIONAL FIELDS NEEDED
);

INSERT INTO RewardsLevels (rewards_level_name, required_points_amount) VALUES
('Bronze', 0),
('Silver', 500),
('Gold', 1000),
('Platinum', 2000);
