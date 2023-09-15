package au.edu.rmit.sept.SuperPrice.service;

import au.edu.rmit.sept.SuperPrice.model.*;
import au.edu.rmit.sept.SuperPrice.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    // Declare repository instances
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductPriceRepository productPriceRepository;


    // Get all Products
    public List<Product> getAllProducts() {
        return this.productRepository.findAllBy();
    }

    // Get Product by id
    public Optional<Product> getProductById(Long productId) {
        return productRepository.findById(productId);
    }

    // Get Product id by Name
    public Long getProductIdByProductName(String product_name) {
        return productRepository.retrieveProductIdByProductName(product_name);
    }

    // Get all Users
    public List<User> getAllUsers() {
        return this.userRepository.findAllBy();
    }

    // Get User by Email
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    // TODO: Get User address id by User id

    // TODO: Create (add) User


    // Get all Orders
    public List<Order> getAllOrders() {
        return this.orderRepository.findAllBy();
    }

    // TODO: Create (add) Order based on shopping cart
    // Get User by email
    // Get User address by User id

    // TODO: Get all ProductPrice/s (Moshe)

    // TODO: Process Order -> Add Order to Order History & Update Users Rewards Points


}
