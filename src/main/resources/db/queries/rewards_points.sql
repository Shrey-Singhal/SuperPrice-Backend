SELECT
    P.product_id,
    P.product_name,
    P.product_category,
    PP.product_price,
    S.supermarket_name,
    S.supermarket_address,
    PR.rewards_points
FROM Products AS P
         INNER JOIN ProductPrices AS PP
                    ON P.product_id = PP.product_id
         INNER JOIN Supermarkets AS S
                    ON PP.supermarket_id = S.supermarket_id
         INNER JOIN ProductRewards AS PR
                    ON P.product_id = PR.product_id
                        AND S.supermarket_id = PR.supermarket_id;

