# Populate Users table
INSERT INTO Users (user_name, email, password_hash, user_rewards_points) VALUES
('Olivia Williams', 'olivia.williams@gmail.com', 'Password1', 500),
('Liam Wilson', 'liam.wilson@gmail.com', 'Password2', 300),
('Charlotte Taylor', 'charlotte.taylor@gmail.com', 'Password3', 700),
('Ethan Martin', 'ethan.martin@gmail.com', 'Password4', 350),
('Ava White', 'ava.white@gmail.com', 'Password5', 900);


# Populate Supermarkets table
INSERT INTO Supermarkets (supermarket_name, supermarket_address, latitude, longitude) VALUES
('Woolworths', '1 Park St, Sydney, NSW 2000', -33.870843, 151.208295),
('Coles', '211 La Trobe St, Melbourne, VIC 3000', -37.809700, 144.963100),
('Aldi', '85 Mains Rd, Sunnybank, QLD 4109', -27.570539, 153.054489),
('IGA', '152-158 St Georges Terrace, Perth, WA 6000', -31.954708, 115.853638),
('Foodland', '144 Grote St, Adelaide, SA 5000', -34.927171, 138.598633);


# # Populate Product Categories table
# INSERT INTO ProductCategories (product_category_id, product_category_name, product_category_description) VALUES
# (1, 'Dairy Products', 'Milks, Cheeses, Yoghurts, and other non-frozen dairy products.'),
# (2, 'Bakery Products', 'Breads, Pastries, Pizza Bases, and other bakery products.'),
# (3, 'Meat, Poultry & Eggs', 'Red Meats (Beef, Lamb, Veal, Kangaroo, etc.), White Meats (Pork, Chicken), Seafoods, Eggs.'),
# (4, 'Fresh Fruit & Vegetables', 'Fresh Fruits, Fresh Vegetables, Fresh Herbs, Fresh Salad Mixes, Fresh Pre-chopped Vegetables.'),
# (5, 'Grains', 'Grains, Seeds, Rices, Pastas');

# # Populate Products table
# INSERT INTO Products (product_name, product_category_id) VALUES
# ('Full Cream Milk', 1),                  # Changed from 'Dairy'
# ('Wholemeal Bread', 2),
# ('Free Range Eggs', 3),            # Changed from 'Dairy'
# ('Granny Smith Apples', 4),    # Changed from 'Produce'
# ('Basmati Rice', 5);                             # Changed from 'Dry Goods'


# Populate Products table
INSERT INTO Products (product_name, product_category) VALUES
('Full Cream Milk', 'Dairy Products'),                  # Changed from 'Dairy'
('Wholemeal Bread', 'Bakery Products'),
('Free Range Eggs', 'Meat, Poultry & Eggs'),            # Changed from 'Dairy'
('Granny Smith Apples', 'Fresh Fruit & Vegetables'),    # Changed from 'Produce'
('Basmati Rice', 'Grains'),                             # Changed from 'Dry Goods'
('Goats Cheese', 'Dairy Products'),                     # Changed from 'Dairy'
('Chocolate Cake', 'Bakery Products'),
('Beef Mince', 'Meat, Poultry & Eggs'),                 # Changed from 'Dairy'
('Cavendish Bananas', 'Fresh Fruit & Vegetables'),      # Changed from 'Produce'
('Rolled Oats', 'Grains'),                              # Changed from 'Dry Goods'
('Sour Cream', 'Dairy Products'),                       # Changed from 'Dairy'
('English Muffins', 'Bakery Products'),
('Chicken Thighs', 'Meat, Poultry & Eggs'),             # Changed from 'Dairy'
('Red Grapes', 'Fresh Fruit & Vegetables'),             # Changed from 'Produce'
('Quinoa', 'Grains'),                                   # Changed from 'Dry Goods'
('Greek Yoghurt', 'Dairy Products'),                    # Changed from 'Dairy'
('Croissant', 'Bakery Products'),
('Pork Chops', 'Meat, Poultry & Eggs'),                 # Changed from 'Dairy'
('Pears', 'Fresh Fruit & Vegetables'),                  # Changed from 'Produce'
('Chia Seeds', 'Grains');                               # Changed from 'Dry Goods'


# Populate Product Prices table
INSERT INTO ProductPrices (product_id, supermarket_id, product_price) VALUES
# Product: Wholemeal Bread
(2, 3, 2.15),  # Wholemeal Bread at Aldi
(2, 2, 2.25),  # Wholemeal Bread at Coles
(2, 1, 2.20),  # Wholemeal Bread at Woolworths
# Add products for IGA & Foodland

# Product: Full Cream Milk (1L)
(1, 3, 1.45),  # Full Cream Milk at Aldi
(1, 2, 1.55),  # Full Cream Milk at Coles
(1, 1, 1.50),  # Full Cream Milk at Woolworths

# Product: Granny Smith Apples (per kg)
(4, 3, 3.40),  # Granny Smith Apples at Aldi
(4, 2, 3.55),  # Granny Smith Apples at Coles
(4, 1, 3.50),  # Granny Smith Apples at Woolworths

# Product: Free Range Eggs (1 dozen)
(3, 3, 3.90),  # Free Range Eggs at Aldi
(3, 2, 4.10),  # Free Range Eggs at Coles
(3, 1, 4.00),  # Free Range Eggs at Woolworths

# Product: Basmati Rice (1kg)
(5, 3, 2.65),  # Basmati Rice at Aldi
(5, 2, 2.75),  # Basmati Rice at Coles
(5, 1, 2.70);  # Basmati Rice at Woolworths


# Populate Product Rewards table
INSERT INTO ProductRewards (product_reward_id, product_id, supermarket_id, rewards_points) VALUES
# Product: Wholemeal Bread
(1, 2, 3, 20),      # Wholemeal Bread at Aldi
(12, 2, 2, 20),     # Wholemeal Bread at Coles
(7, 2, 1, 40),      # Wholemeal Bread at Woolworths

# Product: Full Cream Milk (1L)
(14, 1, 3, 30),     # Full Cream Milk at Aldi
(2, 1, 2, 15),      # Full Cream Milk at Coles
(9, 1, 1, 50),      # Full Cream Milk at Woolworths

# Product: Granny Smith Apples (per kg)
(10, 4, 3, 5),      # Granny Smith Apples at Aldi
(11, 4, 2, 15),     # Granny Smith Apples at Coles
(3, 4, 1, 30),      # Granny Smith Apples at Woolworths

# Product: Free Range Eggs (1 dozen)
(4, 3, 3, 10),      # Free Range Eggs at Aldi
(15, 3, 2, 35),     # Free Range Eggs at Coles
(6, 3, 1, 35),      # Free Range Eggs at Woolworths

# Product: Basmati Rice (1kg)
(8, 5, 3, 45),      # Basmati Rice at Aldi
(13, 5, 2, 25),     # Basmati Rice at Coles
(5, 5, 1, 25);      # Basmati Rice at Woolworths


# Populate Orders table
INSERT INTO Orders (user_id, delivery_address_id, order_status, order_total_price, order_total_rewards, order_date) VALUES
(1, 1, 'Delivered', 50.25, 50, '2023-09-04 10:30:00'),
(2, 2, 'Pending', 30.40, 30, '2023-09-04 11:15:00'),
(3, 3, 'Delivered', 45.60, 46, '2023-09-04 12:00:00'),
(4, 4, 'Pending', 25.00, 25, '2023-09-04 14:20:00'),
(5, 5, 'Shipped', 55.70, 56, '2023-09-04 16:45:00');


# Populate Order Products table
INSERT INTO OrderProducts (order_id, product_id, quantity, product_price, product_rewards) VALUES
(1, 1, 3, 1.55, 15),
(2, 2, 2, 2.15, 21),
(3, 3, 5, 3.90, 40),
(4, 4, 4, 3.50, 35),
(5, 5, 3, 2.70, 27);


# Populate Order History table
INSERT INTO UserOrderHistory (user_id, order_id, order_total_price, order_total_rewards, delivery_address_id, order_status, order_date) VALUES
(1, 1, 50.25, 1, 50, 'Delivered', '2023-09-04 10:30:00'),
(2, 2, 30.40, 2, 30, 'Pending', '2023-09-04 11:15:00'),
(3, 3, 45.60, 3, 46, 'Delivered', '2023-09-04 12:00:00'),
(4, 4, 25.00, 4, 25, 'Pending', '2023-09-04 14:20:00'),
(5, 5, 55.70, 5, 56, 'Shipped', '2023-09-04 16:45:00');


# Populate User Rewards Points table
INSERT INTO UserRewardsPoints (user_rewards_id, user_id, rewards_points, rewards_level_id) VALUES
(1, 1, 0, 2),
(2, 2, 1000, 2),
(3, 3, 5000, 2),
(4, 4, 10000, 2),
(5, 5, 25000, 3);

# Populate Rewards Levels table
INSERT INTO RewardsLevels (rewards_level_id, rewards_level_name, required_points_amount) VALUES
(1, 'Bronze', 0),
(2, 'Silver', 500),
(3, 'Gold', 1000),
(4, 'Platinum', 2000);
