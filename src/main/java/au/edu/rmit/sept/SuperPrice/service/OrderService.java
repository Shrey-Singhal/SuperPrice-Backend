package au.edu.rmit.sept.SuperPrice.service;

import java.util.List;

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
        return this.orderRepositoryImpl.findAllBy();
    }


    // TODO: Create new Order
    public Order createOrder(Order newOrder) {
        return this.orderRepositoryImpl.save(newOrder);
    }
}
