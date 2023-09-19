SELECT product_price_id, product_id, product_price FROM ProductPrices WHERE product_id = 1;

SELECT * FROM ProductPrices WHERE supermarket_id = 1;

SELECT * FROM ProductPrices;

# Joins Products and ProductPrices tables
SELECT Products.product_id, Products.product_name, Products.product_category,
       ProductPrices.product_price, ProductPrices.last_updated
FROM Products
         INNER JOIN ProductPrices
                    ON Products.product_id = ProductPrices.product_id;


# Joins Products, ProductPrices, and Supermarkets tables to give filterable table of data
SELECT
    P.product_id,
    P.product_name,
    P.product_category,
    PP.product_price,
    S.supermarket_name,
    S.supermarket_address
FROM Products AS P
         INNER JOIN ProductPrices AS PP
                    ON P.product_id = PP.product_id
         INNER JOIN Supermarkets AS S
                    ON PP.supermarket_id = S.supermarket_id;
