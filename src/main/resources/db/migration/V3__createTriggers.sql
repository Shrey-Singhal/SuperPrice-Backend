-- Set trigger to update total price and total rewards values for orders
-- when products are added to order products prices and rewards values
DELIMITER //

CREATE TRIGGER update_order_totals
    AFTER INSERT ON OrderProducts
    FOR EACH ROW
BEGIN
    -- Calculate and update order_total_price
    UPDATE Orders
    SET order_total_price = (
        SELECT SUM(product_price * quantity)
        FROM OrderProducts
        WHERE order_id = NEW.order_id
    )
    WHERE order_id = NEW.order_id;

    -- Calculate and update order_total_rewards
    UPDATE Orders
    SET order_total_rewards = (
        SELECT SUM(product_rewards * quantity)
        FROM OrderProducts
        WHERE order_id = NEW.order_id
    )
    WHERE order_id = NEW.order_id;
END;
//

DELIMITER ;


