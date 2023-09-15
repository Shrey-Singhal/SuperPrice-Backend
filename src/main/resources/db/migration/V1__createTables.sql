# Temporarily disable foreign key checks to prevent integrity constraints when dropping tables
SET FOREIGN_KEY_CHECKS = 0;

# Drop Tables if they exist
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


# Create Users table
CREATE TABLE Users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password_hash VARCHAR(100) NOT NULL,
    user_rewards_points INT NOT NULL DEFAULT 0 # DO WE NEED TO INCLUDE HERE OR JUST USE TABLE LINKED TO USER_ID?
    # ADD ANY ADDITIONAL FIELDS NEEDED
);


# Create Supermarkets table
CREATE TABLE Supermarkets (
    supermarket_id INT AUTO_INCREMENT PRIMARY KEY,
    supermarket_name VARCHAR(100) NOT NULL,
    supermarket_address VARCHAR(200) NOT NULL,
    latitude DECIMAL(10, 6) NOT NULL,
    longitude DECIMAL(10, 6) NOT NULL
    # ADD ANY ADDITIONAL FIELDS NEEDED
);


# Create Products table
CREATE TABLE Products (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    product_category VARCHAR(50) NOT NULL
    # ADD ANY ADDITIONAL FIELDS NEEDED
);


# Create Product Prices table
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


# Create Product Rewards table
CREATE TABLE ProductRewards (
    product_reward_id INT PRIMARY KEY,
    product_id INT NOT NULL,
    supermarket_id INT NOT NULL,
    rewards_points INT NOT NULL,
    FOREIGN KEY (product_id) REFERENCES Products(product_id),
    FOREIGN KEY (supermarket_id) REFERENCES Supermarkets(supermarket_id)
    # ADD ANY ADDITIONAL FIELDS NEEDED
);


# Create User Addresses table
CREATE TABLE UserAddresses (
    user_address_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    address VARCHAR(200) NOT NULL,
#     latitude DECIMAL(10, 6) NOT NULL,
#     longitude DECIMAL(10, 6) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
    # ADD ANY ADDITIONAL FIELDS NEEDED
);


# Create Orders table
CREATE TABLE Orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    delivery_address_id INT NOT NULL,
    order_status VARCHAR(50),
    order_total_price DECIMAL(10, 2),
    order_total_rewards INT,
    order_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (delivery_address_id) REFERENCES UserAddresses(user_address_id)
    # ADD ANY ADDITIONAL FIELDS NEEDED
);


# Create Order Products table
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


# Create Order History table
CREATE TABLE UserOrderHistory (
    order_history_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    order_id INT NOT NULL,
    order_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    order_total_price DECIMAL(10, 2) NOT NULL,
    order_total_rewards INT NOT NULL,
    delivery_address_id INT NOT NULL,
    order_status VARCHAR(50) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (order_id) REFERENCES Orders(order_id),
    FOREIGN KEY (delivery_address_id) REFERENCES UserAddresses(user_address_id)
    # ADD ANY ADDITIONAL FIELDS NEEDED
);


# Create User Rewards Points table
CREATE TABLE UserRewardsPoints (
    user_rewards_id INT PRIMARY KEY,
    user_id INT NOT NULL,
    rewards_points INT NOT NULL DEFAULT 0,
    rewards_level_id INT NOT NULL DEFAULT 0,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (rewards_level_id) REFERENCES RewardsLevels(rewards_level_id)
    # ADD ANY ADDITIONAL FIELDS NEEDED
);


# Create Rewards Levels table
CREATE TABLE RewardsLevels (
    rewards_level_id INT AUTO_INCREMENT PRIMARY KEY,
    rewards_level_name VARCHAR(50) NOT NULL,
    required_points_amount DECIMAL(10, 2) NOT NULL
    # ADD ANY ADDITIONAL FIELDS NEEDED
);
