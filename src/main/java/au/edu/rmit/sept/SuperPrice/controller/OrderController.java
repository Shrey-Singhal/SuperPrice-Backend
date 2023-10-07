package au.edu.rmit.sept.SuperPrice.controller;

import java.util.List;
import java.util.Optional;

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
@RequestMapping(value = "/SuperPrice/v1")
@CrossOrigin(value = "http://localhost:5173")
public class OrderController {
    // Order controller methods for the running of Order service methods

    @Autowired
    private OrderService orderService;

    // Get all Orders
    @GetMapping("/Orders")
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


    // Get Order by order_id
    @GetMapping("/Order/{order_id}")
    public ResponseEntity<Order> getOrderByOrderId(@PathVariable("order_id") int order_id) {
        Optional<Order> orderOptional = this.orderService.getOrderByOrderId(order_id);
        return orderOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    // Create new Order TODO: Test this method
    @GetMapping("/createOrder")
    public ResponseEntity<Order> createNewOrder(@RequestParam int user_id) {
        Order newOrder = new Order(user_id);
        Optional<Order> userOrder = this.orderService.createOrder(newOrder);
        return userOrder.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    // Update Order TODO: Test this method
    @PutMapping("/updateOrder")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order) {
        Optional<Order> orderOptional = this.orderService.updateOrder(order);
        return orderOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
