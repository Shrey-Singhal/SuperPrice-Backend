package au.edu.rmit.sept.SuperPrice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import au.edu.rmit.sept.SuperPrice.model.Order;
import au.edu.rmit.sept.SuperPrice.service.OrderService;

/**
 * OrderController class handles requests for Order data
 * Base URL: http://localhost:8080/SuperPrice
 * CrossOrigin: http://localhost:5173
 */
@RestController
@RequestMapping(value = "/")
@CrossOrigin(value = "http://localhost:5173")
public class OrderController {
    @Autowired
    private OrderService orderService;

    // ORDER CONTROLLER METHODS

    // Get all Orders
    @GetMapping("v1/Orders")
    public ResponseEntity<List<Order>> getAllOrders() {
        // Get a list of Orders
        List<Order> orders = this.orderService.getAllOrders();

        // Convert to ResponseEntity
        if (!orders.isEmpty()) {
            // OK
            return ResponseEntity.ok(orders);
        } else {
            // No Content
            return ResponseEntity.noContent().build();
        }
    }

    // TODO: Create new Order
    @GetMapping("v1/createOrder")
    public ResponseEntity<Order> createNewOrder(@RequestParam int user_id) {
        Order newOrder = new Order(user_id);
//        newOrder.setUserId(user_id);
        Order userOrder = this.orderService.createOrder(newOrder);
        return new ResponseEntity<>(userOrder, HttpStatus.CREATED);
    }
}
