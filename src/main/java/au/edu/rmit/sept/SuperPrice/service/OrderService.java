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
    private OrderRepository orderRepositoryImpl;


    // Get all Orders
    public List<Order> getAllOrders() {
        return this.orderRepositoryImpl.findAllOrders();
    }

    // Find Order by order_id
    public Optional<Order> getOrderByOrderId(int order_id) {
        return this.orderRepositoryImpl.findOrderByOrderId(order_id);
    }

    // Create new Order TODO: Test this method
    public Optional<Order> createOrder(Order newOrder) {
        return this.orderRepositoryImpl.saveOrder(newOrder);
    }

    // Update Order TODO: Test this method
    public Optional<Order> updateOrder(Order order) {
        return this.orderRepositoryImpl.updateOrder(order);
    }
}
