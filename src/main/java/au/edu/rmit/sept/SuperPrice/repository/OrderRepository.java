package au.edu.rmit.sept.SuperPrice.repository;

import au.edu.rmit.sept.SuperPrice.model.Order;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


/**
 * OrderRepository interface handles database operations related to the Order table
 */
@Repository
public interface OrderRepository {
    // Find all orders
    List<Order> findAllOrders();

    // Find Order by order_id
    Optional<Order> findOrderByOrderId(int order_id);

    // Save new Order
    Optional<Order> saveOrder(Order order);

    // Update Order
    Optional<Order> updateOrder(Order order);
}
