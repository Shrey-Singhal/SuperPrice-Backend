SELECT DISTINCT p.product_category FROM Products p 
INNER JOIN ProductPrices pp ON p.product_id = pp.product_id 
INNER JOIN Supermarkets s ON pp.supermarket_id = s.supermarket_id 
INNER JOIN ProductRewards pr ON p.product_id = pr.product_id AND pp.supermarket_id = pr.supermarket_id 
WHERE s.supermarket_id = 1;

SELECT p.product_id, p.product_name, p.product_category, pp.product_price_id, pp.product_price, pr.rewards_points, s.supermarket_id, s.supermarket_name, s.supermarket_address FROM Products p 
INNER JOIN ProductPrices pp ON p.product_id = pp.product_id 
INNER JOIN Supermarkets s ON pp.supermarket_id = s.supermarket_id 
INNER JOIN ProductRewards pr ON p.product_id = pr.product_id AND pp.supermarket_id = pr.supermarket_id 
WHERE p.product_category = 'Bakery Products' AND s.supermarket_id = 1;