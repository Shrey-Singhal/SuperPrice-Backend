-- Populate Users table
INSERT INTO Users (user_name, email, password_hash, user_rewards_points) VALUES
('Olivia Williams', 'olivia.williams@gmail.com', 'Password1', 500),
('Liam Wilson', 'liam.wilson@gmail.com', 'Password2', 300),
('Charlotte Taylor', 'charlotte.taylor@gmail.com', 'Password3', 700),
('Ethan Martin', 'ethan.martin@gmail.com', 'Password4', 350),
('Ava White', 'ava.white@gmail.com', 'Password5', 900);


-- Populate Supermarkets table
INSERT INTO Supermarkets (supermarket_name, supermarket_address, latitude, longitude) VALUES
('Woolworths', '1 Park St, Sydney, NSW 2000', -33.870843, 151.208295),
('Coles', '211 La Trobe St, Melbourne, VIC 3000', -37.809700, 144.963100),
('Aldi', '85 Mains Rd, Sunnybank, QLD 4109', -27.570539, 153.054489),
('IGA', '152-158 St Georges Terrace, Perth, WA 6000', -31.954708, 115.853638),
('Foodworks', '144 Grote St, Adelaide, SA 5000', -34.927171, 138.598633);


-- Populate Products table
INSERT INTO Products (product_name, product_category) VALUES
('Full Cream Milk', 'Dairy Products'),
('Wholemeal Bread', 'Bakery Products'),
('Free Range Eggs', 'Meat, Poultry & Eggs'),
('Granny Smith Apples', 'Fresh Fruit & Vegetables'),
('Basmati Rice', 'Pantry'),
('Low Fat Yogurt', 'Dairy Products'),
('Multigrain Baguette', 'Bakery Products'),
('Chicken Breast', 'Meat, Poultry & Eggs'),
('Oranges', 'Fresh Fruit & Vegetables'),
('Brown Rice', 'Pantry'),
('Frozen Pizza', 'Frozen Foods'),
('Ice Cream', 'Frozen Foods'),
('Orange Juice', 'Drinks'),
('Soda', 'Drinks'),
('Pasta', 'Pantry'),
('Tomato Sauce', 'Pantry'),
('Band-Aids', 'Medicinal'),
('Painkillers', 'Medicinal'),
('Hand Soap', 'Cleaning Items'),
('Dish Detergent', 'Cleaning Items'),
('Salmon Fillet', 'Frozen Foods'),
('Frozen Vegetables', 'Frozen Foods'),
('Bottled Water', 'Drinks'),
('Energy Drink', 'Drinks'),
('Rice Noodles', 'Pantry'),
('Olive Oil', 'Pantry'),
('Cough Syrup', 'Medicinal'),
('Multi-Vitamins', 'Medicinal'),
('Bleach', 'Cleaning Items'),
('All-Purpose Cleaner', 'Cleaning Items'),
('Goats Cheese', 'Dairy Products'),
('Chocolate Cake', 'Bakery Products'),
('Beef Mince', 'Meat, Poultry & Eggs'),
('Cavendish Bananas', 'Fresh Fruit & Vegetables'),
('Rolled Oats', 'Pantry'),
('Sour Cream', 'Dairy Products'),
('English Muffins', 'Bakery Products'),
('Chicken Thighs', 'Meat, Poultry & Eggs'),
('Red Grapes', 'Fresh Fruit & Vegetables'),
('Quinoa', 'Pantry'),
('Greek Yoghurt', 'Dairy Products'),
('Croissant', 'Bakery Products'),
('Pork Chops', 'Meat, Poultry & Eggs'),
('Pears', 'Fresh Fruit & Vegetables'),
('Chia Seeds', 'Pantry'),
('Chicken Nuggets', 'Frozen Foods'),
('Frozen Fruits', 'Frozen Foods'),
('Lemonade', 'Drinks'),
('Kombucha', 'Drinks'),
('Cereal', 'Pantry'),
('Honey', 'Pantry'),
('Antiseptic Cream', 'Medicinal'),
('Hydralyte', 'Medicinal'),
('Laundry Powder', 'Cleaning Items'),
('Irish Breakfast Tea', 'Tea & Coffee'),
('Choc-Chip Cookies', 'Snacks & Confectionary'),
('Sunscreen (50+)', 'Beauty & Personal Care'),
('Instant Coffee', 'Tea & Coffee'),
('Party-Mix', 'Snacks & Confectionary'),
('Toothpaste', 'Beauty & Personal Care'),
('Peppermint Tea', 'Tea & Coffee'),
('Chocolate Hazelnut Block', 'Snacks & Confectionary'),
('Deodorant', 'Beauty & Personal Care'),
('Coffee Beans', 'Tea & Coffee'),
('Potato Chips', 'Snacks & Confectionary'),
('Moisturizer', 'Beauty & Personal Care'),
('Ground Coffee', 'Tea & Coffee'),
('Chewing Gum', 'Snacks & Confectionary'),
('Shampoo', 'Beauty & Personal Care'),
('Shaving Cream', 'Beauty & Personal Care');


-- Populate ProductPrices table

-- Woolworths prices (similar but not the same as Coles)
INSERT INTO ProductPrices (product_id, supermarket_id, product_price) VALUES
(1, 1, 1.50),   -- Full Cream Milk at Woolworths
(2, 1, 2.20),   -- Wholemeal Bread at Woolworths
(3, 1, 4.00),   -- Free Range Eggs at Woolworths
(4, 1, 3.50),   -- Granny Smith Apples at Woolworths
(5, 1, 2.70),   -- Basmati Rice at Woolworths
(6, 1, 1.90),   -- Low Fat Yogurt at Woolworths
(7, 1, 2.50),   -- Multigrain Baguette at Woolworths
(8, 1, 5.25),   -- Chicken Breast at Woolworths
(9, 1, 2.75),   -- Oranges at Woolworths
(10, 1, 2.35),  -- Brown Rice at Woolworths
(11, 1, 5.65),  -- Frozen Pizza at Woolworths
(12, 1, 3.55),  -- Ice Cream at Woolworths
(13, 1, 1.72),  -- Orange Juice at Woolworths
(14, 1, 1.15),  -- Soda at Woolworths
(15, 1, 1.34),  -- Pasta at Woolworths
(16, 1, 1.53),  -- Tomato Sauce at Woolworths
(17, 1, 2.18),  -- Band-Aids at Woolworths
(18, 1, 2.40),  -- Painkillers at Woolworths
(19, 1, 1.62),  -- Hand Soap at Woolworths
(20, 1, 2.00),  -- Dish Detergent at Woolworths
(21, 1, 7.89),  -- Salmon Fillet at Woolworths
(22, 1, 2.76),  -- Frozen Vegetables at Woolworths
(23, 1, 0.91),  -- Bottled Water at Woolworths
(24, 1, 1.34),  -- Energy Drink at Woolworths
(25, 1, 1.43),  -- Rice Noodles at Woolworths
(26, 1, 6.45),  -- Olive Oil at Woolworths
(27, 1, 3.00),  -- Cough Syrup at Woolworths
(28, 1, 4.30),  -- Multi-Vitamins at Woolworths
(29, 1, 1.72),  -- Bleach at Woolworths
(30, 1, 1.91),  -- All-Purpose Cleaner at Woolworths
(31, 1, 5.80),  -- Goats Cheese at Woolworths
(32, 1, 16.75), -- Chocolate Cake at Woolworths
(33, 1, 7.40),  -- Beef Mince at Woolworths
(34, 1, 2.20),  -- Cavendish Bananas at Woolworths
(35, 1, 5.05),  -- Rolled Oats at Woolworths
(36, 1, 2.90),  -- Sour Cream at Woolworths
(37, 1, 3.60),  -- English Muffins at Woolworths
(38, 1, 9.30),  -- Chicken Thighs at Woolworths
(39, 1, 5.00),  -- Red Grapes at Woolworths
(40, 1, 6.90),  -- Quinoa at Woolworths
(41, 1, 3.35),  -- Greek Yoghurt at Woolworths
(42, 1, 2.40),  -- Croissant at Woolworths
(43, 1, 11.00), -- Pork Chops at Woolworths
(44, 1, 3.60),  -- Pears at Woolworths
(45, 1, 7.20),  -- Chia Seeds at Woolworths
(46, 1, 3.85),  -- Chicken Nuggets at Woolworths
(47, 1, 3.30),  -- Frozen Fruits at Woolworths
(48, 1, 1.35),  -- Lemonade at Woolworths
(49, 1, 1.15),  -- Kombucha at Woolworths
(50, 1, 3.05),  -- Cereal at Woolworths
(51, 1, 6.90),  -- Honey at Woolworths
(52, 1, 9.60),  -- Antiseptic Cream at Woolworths
(53, 1, 16.90), -- Hydralyte at Woolworths
(54, 1, 4.50),  -- Laundry Powder at Woolworths
(55, 1, 3.80),  -- Irish Breakfast Tea at Woolworths
(56, 1, 2.55),  -- Choc-Chip Cookies at Woolworths
(57, 1, 9.15),  -- Sunscreen (50+) at Woolworths
(58, 1, 5.85),  -- Instant Coffee at Woolworths
(59, 1, 2.00),  -- Party-Mix at Woolworths
(60, 1, 2.54),  -- Toothpaste at Woolworths
(61, 1, 3.30),  -- Peppermint Tea at Woolworths
(62, 1, 4.80),  -- Chocolate Hazelnut Block at Woolworths
(63, 1, 2.95),  -- Deodorant at Woolworths
(64, 1, 6.35),  -- Coffee Beans at Woolworths
(65, 1, 2.85),  -- Potato Chips at Woolworths
(66, 1, 7.05),  -- Moisturizer at Woolworths
(67, 1, 5.50),  -- Ground Coffee at Woolworths
(68, 1, 1.00),  -- Chewing Gum at Woolworths
(69, 1, 3.54),  -- Shampoo at Woolworths
(70, 1, 3.04);  -- Shaving Cream at Woolworths


-- Coles prices (similar but not the same as Woolworths)
INSERT INTO ProductPrices (product_id, supermarket_id, product_price) VALUES
(1, 2, 1.55),   -- Full Cream Milk at Coles
(2, 2, 2.25),   -- Wholemeal Bread at Coles
(3, 2, 4.10),   -- Free Range Eggs at Coles
(4, 2, 3.55),   -- Granny Smith Apples at Coles
(5, 2, 2.75),   -- Basmati Rice at Coles
(6, 2, 1.95),   -- Low Fat Yogurt at Coles
(7, 2, 2.55),   -- Multigrain Baguette at Coles
(8, 2, 5.30),   -- Chicken Breast at Coles
(9, 2, 2.80),   -- Oranges at Coles
(10, 2, 2.40),  -- Brown Rice at Coles
(11, 2, 5.70),  -- Frozen Pizza at Coles
(12, 2, 3.60),  -- Ice Cream at Coles
(13, 2, 1.74),  -- Orange Juice at Coles
(14, 2, 1.17),  -- Soda at Coles
(15, 2, 1.36),  -- Pasta at Coles
(16, 2, 1.55),  -- Tomato Sauce at Coles
(17, 2, 2.20),  -- Band-Aids at Coles
(18, 2, 2.43),  -- Painkillers at Coles
(19, 2, 1.64),  -- Hand Soap at Coles
(20, 2, 2.03),  -- Dish Detergent at Coles
(21, 2, 7.97),  -- Salmon Fillet at Coles
(22, 2, 2.78),  -- Frozen Vegetables at Coles
(23, 2, 0.92),  -- Bottled Water at Coles
(24, 2, 1.36),  -- Energy Drink at Coles
(25, 2, 1.45),  -- Rice Noodles at Coles
(26, 2, 6.51),  -- Olive Oil at Coles
(27, 2, 3.03),  -- Cough Syrup at Coles
(28, 2, 4.35),  -- Multi-Vitamins at Coles
(29, 2, 1.74),  -- Bleach at Coles
(30, 2, 1.93),  -- All-Purpose Cleaner at Coles
(31, 2, 5.75),  -- Goats Cheese at Coles
(32, 2, 16.50), -- Chocolate Cake at Coles
(33, 2, 7.30),  -- Beef Mince at Coles
(34, 2, 2.15),  -- Cavendish Bananas at Coles
(35, 2, 4.95),  -- Rolled Oats at Coles
(36, 2, 2.85),  -- Sour Cream at Coles
(37, 2, 3.55),  -- English Muffins at Coles
(38, 2, 9.10),  -- Chicken Thighs at Coles
(39, 2, 4.85),  -- Red Grapes at Coles
(40, 2, 6.75),  -- Quinoa at Coles
(41, 2, 3.30),  -- Greek Yoghurt at Coles
(42, 2, 2.35),  -- Croissant at Coles
(43, 2, 10.75), -- Pork Chops at Coles
(44, 2, 3.50),  -- Pears at Coles
(45, 2, 7.10),  -- Chia Seeds at Coles
(46, 2, 3.90),  -- Chicken Nuggets at Coles
(47, 2, 3.35),  -- Frozen Fruits at Coles
(48, 2, 1.30),  -- Lemonade at Coles
(49, 2, 1.10),  -- Kombucha at Coles
(50, 2, 3.00),  -- Cereal at Coles
(51, 2, 7.00),  -- Honey at Coles
(52, 2, 9.75),  -- Antiseptic Cream at Coles
(53, 2, 17.10), -- Hydralyte at Coles
(54, 2, 4.60),  -- Laundry Powder at Coles
(55, 2, 3.85),  -- Irish Breakfast Tea at Coles
(56, 2, 2.60),  -- Choc-Chip Cookies at Coles
(57, 2, 9.29),  -- Sunscreen (50+) at Coles
(58, 2, 5.90),  -- Instant Coffee at Coles
(59, 2, 2.05),  -- Party-Mix at Coles
(60, 2, 2.59),  -- Toothpaste at Coles
(61, 2, 3.35),  -- Peppermint Tea at Coles
(62, 2, 4.89),  -- Chocolate Hazelnut Block at Coles
(63, 2, 2.99),  -- Deodorant at Coles
(64, 2, 6.45),  -- Coffee Beans at Coles
(65, 2, 2.89),  -- Potato Chips at Coles
(66, 2, 7.15),  -- Moisturizer at Coles
(67, 2, 5.59),  -- Ground Coffee at Coles
(68, 2, 1.05),  -- Chewing Gum at Coles
(69, 2, 3.59),  -- Shampoo at Coles
(70, 2, 3.09);  -- Shaving Cream at Coles

-- Aldi prices (approximately 10% cheaper than Coles/Woolworths)
INSERT INTO ProductPrices (product_id, supermarket_id, product_price) VALUES
(1, 3, 1.45),   -- Full Cream Milk at Aldi
(2, 3, 2.15),   -- Wholemeal Bread at Aldi
(3, 3, 3.90),   -- Free Range Eggs at Aldi
(4, 3, 3.40),   -- Granny Smith Apples at Aldi
(5, 3, 2.65),   -- Basmati Rice at Aldi
(6, 3, 1.85),   -- Low Fat Yogurt at Aldi
(7, 3, 2.45),   -- Multigrain Baguette at Aldi
(8, 3, 5.20),   -- Chicken Breast at Aldi
(9, 3, 2.70),   -- Oranges at Aldi
(10, 3, 2.30),  -- Brown Rice at Aldi
(11, 3, 5.85),  -- Frozen Pizza at Aldi
(12, 3, 3.70),  -- Ice Cream at Aldi
(13, 3, 1.80),  -- Orange Juice at Aldi
(14, 3, 1.20),  -- Soda at Aldi
(15, 3, 1.40),  -- Pasta at Aldi
(16, 3, 1.60),  -- Tomato Sauce at Aldi
(17, 3, 2.25),  -- Band-Aids at Aldi
(18, 3, 2.50),  -- Painkillers at Aldi
(19, 3, 1.70),  -- Hand Soap at Aldi
(20, 3, 2.10),  -- Dish Detergent at Aldi
(21, 3, 8.30),  -- Salmon Fillet at Aldi
(22, 3, 2.90),  -- Frozen Vegetables at Aldi
(23, 3, 0.95),  -- Bottled Water at Aldi
(24, 3, 1.40),  -- Energy Drink at Aldi
(25, 3, 1.50),  -- Rice Noodles at Aldi
(26, 3, 6.75),  -- Olive Oil at Aldi
(27, 3, 3.15),  -- Cough Syrup at Aldi
(28, 3, 4.50),  -- Multi-Vitamins at Aldi
(29, 3, 1.80),  -- Bleach at Aldi
(30, 3, 2.00),  -- All-Purpose Cleaner at Aldi
(31, 3, 5.70),  -- Goats Cheese at Aldi
(32, 3, 15.99), -- Chocolate Cake at Aldi
(33, 3, 7.20),  -- Beef Mince at Aldi
(34, 3, 2.10),  -- Cavendish Bananas at Aldi
(35, 3, 4.85),  -- Rolled Oats at Aldi
(36, 3, 2.80),  -- Sour Cream at Aldi
(37, 3, 3.50),  -- English Muffins at Aldi
(38, 3, 8.90),  -- Chicken Thighs at Aldi
(39, 3, 4.75),  -- Red Grapes at Aldi
(40, 3, 6.60),  -- Quinoa at Aldi
(41, 3, 3.25),  -- Greek Yoghurt at Aldi
(42, 3, 2.25),  -- Croissant at Aldi
(43, 3, 10.50), -- Pork Chops at Aldi
(44, 3, 3.40),  -- Pears at Aldi
(45, 3, 6.95),  -- Chia Seeds at Aldi
(46, 3, 3.75),  -- Chicken Nuggets at Aldi
(47, 3, 3.20),  -- Frozen Fruits at Aldi
(48, 3, 1.25),  -- Lemonade at Aldi
(49, 3, 1.05),  -- Kombucha at Aldi
(50, 3, 2.90),  -- Cereal at Aldi
(51, 3, 6.80),  -- Honey at Aldi
(52, 3, 9.50),  -- Antiseptic Cream at Aldi
(53, 3, 16.75), -- Hydralyte at Aldi
(54, 3, 4.40),  -- Laundry Powder at Aldi
(55, 3, 3.75),  -- Irish Breakfast Tea at Aldi
(56, 3, 2.50),  -- Choc-Chip Cookies at Aldi
(57, 3, 8.99),  -- Sunscreen (50+) at Aldi
(58, 3, 5.75),  -- Instant Coffee at Aldi
(59, 3, 1.99),  -- Party-Mix at Aldi
(60, 3, 2.49),  -- Toothpaste at Aldi
(61, 3, 3.25),  -- Peppermint Tea at Aldi
(62, 3, 4.75),  -- Chocolate Hazelnut Block at Aldi
(63, 3, 2.89),  -- Deodorant at Aldi
(64, 3, 6.25),  -- Coffee Beans at Aldi
(65, 3, 2.80),  -- Potato Chips at Aldi
(66, 3, 6.99),  -- Moisturizer at Aldi
(67, 3, 5.45),  -- Ground Coffee at Aldi
(68, 3, 0.99),  -- Chewing Gum at Aldi
(69, 3, 3.49),  -- Shampoo at Aldi
(70, 3, 2.99);  -- Shaving Cream at Aldi

-- IGA prices (between 10% more expensive and 10% cheaper than Coles/Woolworths)
INSERT INTO ProductPrices (product_id, supermarket_id, product_price) VALUES
(1, 4, 1.40),   -- Full Cream Milk at IGA
(2, 4, 2.20),   -- Wholemeal Bread at IGA
(3, 4, 4.10),   -- Free Range Eggs at IGA
(4, 4, 3.55),   -- Granny Smith Apples at IGA
(5, 4, 2.55),   -- Basmati Rice at IGA
(6, 4, 1.85),   -- Low Fat Yogurt at IGA
(7, 4, 2.48),   -- Multigrain Baguette at IGA
(8, 4, 5.15),   -- Chicken Breast at IGA
(9, 4, 2.68),   -- Oranges at IGA
(10, 4, 2.31),  -- Brown Rice at IGA
(11, 4, 6.15),  -- Frozen Pizza at IGA
(12, 4, 3.90),  -- Ice Cream at IGA
(13, 4, 1.98),  -- Orange Juice at IGA
(14, 4, 1.32),  -- Soda at IGA
(15, 4, 1.54),  -- Pasta at IGA
(16, 4, 1.76),  -- Tomato Sauce at IGA
(17, 4, 2.48),  -- Band-Aids at IGA
(18, 4, 2.75),  -- Painkillers at IGA
(19, 4, 1.87),  -- Hand Soap at IGA
(20, 4, 2.31),  -- Dish Detergent at IGA
(21, 4, 9.13),  -- Salmon Fillet at IGA
(22, 4, 3.19),  -- Frozen Vegetables at IGA
(23, 4, 1.05),  -- Bottled Water at IGA
(24, 4, 1.54),  -- Energy Drink at IGA
(25, 4, 1.65),  -- Rice Noodles at IGA
(26, 4, 7.42),  -- Olive Oil at IGA
(27, 4, 3.46),  -- Cough Syrup at IGA
(28, 4, 4.95),  -- Multi-Vitamins at IGA
(29, 4, 1.98),  -- Bleach at IGA
(30, 4, 2.20),  -- All-Purpose Cleaner at IGA
(31, 4, 5.72),  -- Goats Cheese at IGA
(32, 4, 16.25), -- Chocolate Cake at IGA
(33, 4, 7.20),  -- Beef Mince at IGA
(34, 4, 2.18),  -- Cavendish Bananas at IGA
(35, 4, 5.00),  -- Rolled Oats at IGA
(36, 4, 2.85),  -- Sour Cream at IGA
(37, 4, 3.50),  -- English Muffins at IGA
(38, 4, 9.20),  -- Chicken Thighs at IGA
(39, 4, 5.10),  -- Red Grapes at IGA
(40, 4, 6.80),  -- Quinoa at IGA
(41, 4, 3.40),  -- Greek Yoghurt at IGA
(42, 4, 2.45),  -- Croissant at IGA
(43, 4, 10.80), -- Pork Chops at IGA
(44, 4, 3.50),  -- Pears at IGA
(45, 4, 7.00),  -- Chia Seeds at IGA
(46, 4, 3.75),  -- Chicken Nuggets at IGA
(47, 4, 3.25),  -- Frozen Fruits at IGA
(48, 4, 1.32),  -- Lemonade at IGA
(49, 4, 1.12),  -- Kombucha at IGA
(50, 4, 3.10),  -- Cereal at IGA
(51, 4, 7.20),  -- Honey at IGA
(52, 4, 9.95),  -- Antiseptic Cream at IGA
(53, 4, 17.50), -- Hydralyte at IGA
(54, 4, 4.55),  -- Laundry Powder at IGA
(55, 4, 4.00),  -- Irish Breakfast Tea at IGA
(56, 4, 2.70),  -- Choc-Chip Cookies at IGA
(57, 4, 9.50),  -- Sunscreen (50+) at IGA
(58, 4, 6.10),  -- Instant Coffee at IGA
(59, 4, 2.10),  -- Party-Mix at IGA
(60, 4, 2.65),  -- Toothpaste at IGA
(61, 4, 3.45),  -- Peppermint Tea at IGA
(62, 4, 5.00),  -- Chocolate Hazelnut Block at IGA
(63, 4, 3.05),  -- Deodorant at IGA
(64, 4, 6.60),  -- Coffee Beans at IGA
(65, 4, 2.95),  -- Potato Chips at IGA
(66, 4, 7.30),  -- Moisturizer at IGA
(67, 4, 5.75),  -- Ground Coffee at IGA
(68, 4, 1.10),  -- Chewing Gum at IGA
(69, 4, 3.65),  -- Shampoo at IGA
(70, 4, 3.15);  -- Shaving Cream at IGA

-- Foodworks prices (between 10% more expensive and 10% cheaper than Coles/Woolworths)
INSERT INTO ProductPrices (product_id, supermarket_id, product_price) VALUES
(1, 5, 1.60),   -- Full Cream Milk at Foodworks
(2, 5, 2.30),   -- Wholemeal Bread at Foodworks
(3, 5, 3.99),   -- Free Range Eggs at Foodworks
(4, 5, 3.45),   -- Granny Smith Apples at Foodworks
(5, 5, 2.80),   -- Basmati Rice at Foodworks
(6, 5, 1.88),  -- Low Fat Yogurt at Foodworks
(7, 5, 2.53),  -- Multigrain Baguette at Foodworks
(8, 5, 5.28),  -- Chicken Breast at Foodworks
(9, 5, 2.73),  -- Oranges at Foodworks
(10, 5, 2.34), -- Brown Rice at Foodworks
(11, 5, 5.55),  -- Frozen Pizza at Foodworks
(12, 5, 3.50),  -- Ice Cream at Foodworks
(13, 5, 1.70),  -- Orange Juice at Foodworks
(14, 5, 1.14),  -- Soda at Foodworks
(15, 5, 1.33),  -- Pasta at Foodworks
(16, 5, 1.52),  -- Tomato Sauce at Foodworks
(17, 5, 2.15),  -- Band-Aids at Foodworks
(18, 5, 2.38),  -- Painkillers at Foodworks
(19, 5, 1.61),  -- Hand Soap at Foodworks
(20, 5, 1.99),  -- Dish Detergent at Foodworks
(21, 5, 7.85),  -- Salmon Fillet at Foodworks
(22, 5, 2.74),  -- Frozen Vegetables at Foodworks
(23, 5, 0.91),  -- Bottled Water at Foodworks
(24, 5, 1.33),  -- Energy Drink at Foodworks
(25, 5, 1.42),  -- Rice Noodles at Foodworks
(26, 5, 6.38),  -- Olive Oil at Foodworks
(27, 5, 2.97),  -- Cough Syrup at Foodworks
(28, 5, 4.25),  -- Multi-Vitamins at Foodworks
(29, 5, 1.70),  -- Bleach at Foodworks
(30, 5, 1.88),  -- All-Purpose Cleaner at Foodworks
(31, 5, 5.78),  -- Goats Cheese at Foodworks
(32, 5, 16.50), -- Chocolate Cake at Foodworks
(33, 5, 7.45),  -- Beef Mince at Foodworks
(34, 5, 2.22),  -- Cavendish Bananas at Foodworks
(35, 5, 5.10),  -- Rolled Oats at Foodworks
(36, 5, 2.95),  -- Sour Cream at Foodworks
(37, 5, 3.60),  -- English Muffins at Foodworks
(38, 5, 9.40),  -- Chicken Thighs at Foodworks
(39, 5, 5.15),  -- Red Grapes at Foodworks
(40, 5, 6.75),  -- Quinoa at Foodworks
(41, 5, 3.45),  -- Greek Yoghurt at Foodworks
(42, 5, 2.50),  -- Croissant at Foodworks
(43, 5, 11.20), -- Pork Chops at Foodworks
(44, 5, 3.70),  -- Pears at Foodworks
(45, 5, 7.40),  -- Chia Seeds at Foodworks
(46, 5, 3.80),  -- Chicken Nuggets at Foodworks
(47, 5, 3.27),  -- Frozen Fruits at Foodworks
(48, 5, 1.38),  -- Lemonade at Foodworks
(49, 5, 1.18),  -- Kombucha at Foodworks
(50, 5, 3.15),  -- Cereal at Foodworks
(51, 5, 7.10),  -- Honey at Foodworks
(52, 5, 9.80),  -- Antiseptic Cream at Foodworks
(53, 5, 17.20), -- Hydralyte at Foodworks
(54, 5, 4.60),  -- Laundry Powder at Foodworks
(55, 5, 4.00),  -- Irish Breakfast Tea at Foodworks
(56, 5, 2.45),  -- Choc-Chip Cookies at Foodworks
(57, 5, 9.05),  -- Sunscreen (50+) at Foodworks
(58, 5, 5.65),  -- Instant Coffee at Foodworks
(59, 5, 1.95),  -- Party-Mix at Foodworks
(60, 5, 2.39),  -- Toothpaste at Foodworks
(61, 5, 3.19),  -- Peppermint Tea at Foodworks
(62, 5, 4.65),  -- Chocolate Hazelnut Block at Foodworks
(63, 5, 2.79),  -- Deodorant at Foodworks
(64, 5, 6.10),  -- Coffee Beans at Foodworks
(65, 5, 2.75),  -- Potato Chips at Foodworks
(66, 5, 6.80),  -- Moisturizer at Foodworks
(67, 5, 5.35),  -- Ground Coffee at Foodworks
(68, 5, 0.95),  -- Chewing Gum at Foodworks
(69, 5, 3.29),  -- Shampoo at Foodworks
(70, 5, 2.89);  -- Shaving Cream at Foodworks


-- Populate Product Rewards table with rewards points for each product at each supermarket
-- Rewards points are calculated as a randomly selected percentage of the product price
-- (between 10% and 50% of the product price)
INSERT INTO ProductRewards (product_id, supermarket_id, rewards_points)
SELECT pp.product_id, pp.supermarket_id, ROUND(0.1 + RAND() * 0.4, 2) * pp.product_price
FROM ProductPrices pp;
-- WHERE pp.supermarket_id = [specific_supermarket_id];


-- -- Populate Product Rewards table
-- INSERT INTO ProductRewards (product_reward_id, product_id, supermarket_id, rewards_points) VALUES
-- -- Product: Wholemeal Bread
-- (1, 2, 3, 20),      -- Wholemeal Bread at Aldi
-- (12, 2, 2, 20),     -- Wholemeal Bread at Coles
-- (7, 2, 1, 40),      -- Wholemeal Bread at Woolworths

-- -- Product: Full Cream Milk (1L)
-- (14, 1, 3, 30),     -- Full Cream Milk at Aldi
-- (2, 1, 2, 15),      -- Full Cream Milk at Coles
-- (9, 1, 1, 50),      -- Full Cream Milk at Woolworths

-- -- Product: Granny Smith Apples (per kg)
-- (10, 4, 3, 5),      -- Granny Smith Apples at Aldi
-- (11, 4, 2, 15),     -- Granny Smith Apples at Coles
-- (3, 4, 1, 30),      -- Granny Smith Apples at Woolworths

-- -- Product: Free Range Eggs (1 dozen)
-- (4, 3, 3, 10),      -- Free Range Eggs at Aldi
-- (15, 3, 2, 35),     -- Free Range Eggs at Coles
-- (6, 3, 1, 35),      -- Free Range Eggs at Woolworths

-- -- Product: Basmati Rice (1kg)
-- (8, 5, 3, 45),      -- Basmati Rice at Aldi
-- (13, 5, 2, 25),     -- Basmati Rice at Coles
-- (5, 5, 1, 25);      -- Basmati Rice at Woolworths


-- Populate Orders table
INSERT INTO Orders (user_id, order_status, order_total_price, order_total_rewards, order_date) VALUES
(1, 'Delivered', 50.25, 50, '2023-09-04 10:30:00'),
(2, 'Pending', 30.40, 30, '2023-09-04 11:15:00'),
(3, 'Delivered', 45.60, 46, '2023-09-04 12:00:00'),
(4, 'Pending', 25.00, 25, '2023-09-04 14:20:00'),
(5, 'Shipped', 55.70, 56, '2023-09-04 16:45:00');


-- -- Populate Order Products table
-- INSERT INTO OrderProducts (order_id, product_id, quantity, product_price, product_rewards) VALUES
-- (1, 1, 3, 1.55, 15),
-- (2, 2, 2, 2.15, 21),
-- (3, 3, 5, 3.90, 40),
-- (4, 4, 4, 3.50, 35),
-- (5, 5, 3, 2.70, 27);


-- -- Populate Order History table
-- INSERT INTO OrderHistory (user_id, order_id, order_total_price, order_total_rewards, order_status, order_date) VALUES
-- (1, 1, 50.25, 1, 50, 'Delivered', '2023-09-04 10:30:00'),
-- (2, 2, 30.40, 2, 30, 'Pending', '2023-09-04 11:15:00'),
-- (3, 3, 45.60, 3, 46, 'Delivered', '2023-09-04 12:00:00'),
-- (4, 4, 25.00, 4, 25, 'Pending', '2023-09-04 14:20:00'),
-- (5, 5, 55.70, 5, 56, 'Shipped', '2023-09-04 16:45:00');


-- -- Populate User Rewards Points table
-- INSERT INTO UserRewardsPoints (user_id, rewards_points, rewards_level_id) VALUES
-- (1, 0, 2),
-- (2, 1000, 2),
-- (3, 5000, 2),
-- (4, 10000, 2),
-- (5, 25000, 3);


-- -- Populate Rewards Levels table
-- INSERT INTO RewardsLevels (rewards_level_id, rewards_level_name, required_points_amount) VALUES
-- (1, 'Bronze', 0),
-- (2, 'Silver', 500),
-- (3, 'Gold', 1000),
-- (4, 'Platinum', 2000);
