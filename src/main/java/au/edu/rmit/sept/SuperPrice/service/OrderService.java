package au.edu.rmit.sept.SuperPrice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.edu.rmit.sept.SuperPrice.model.Order;
import au.edu.rmit.sept.SuperPrice.repository.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;


    // Get all Orders
    public List<Order> getAllOrders() {
        return this.orderRepository.findAllOrders();
    }

    // Find Order by order_id
    public Optional<Order> getOrderByOrderId(int order_id) {
        return this.orderRepository.findOrderByOrderId(order_id);
    }

    // Create new Order
    public Optional<Order> createOrder(Order newOrder) {
        return this.orderRepository.saveOrder(newOrder);
    }

    // Update Order
    public Optional<Order> updateOrder(Order order) {
        return this.orderRepository.updateOrder(order);
    }
}
