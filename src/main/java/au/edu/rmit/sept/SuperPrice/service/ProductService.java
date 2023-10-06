package au.edu.rmit.sept.SuperPrice.service;

import au.edu.rmit.sept.SuperPrice.model.*;
import au.edu.rmit.sept.SuperPrice.repository.*;

// Spring Boot package class imports
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

// Java package class imports
//import java.util.Collection;
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

    // Get all distinct product categories
    public List<String> getAllProductCategories() {
        return this.productRepository.retrieveDistinctProductCategories();
    }

    // Get all Products by category
    public List<Product> getAllProductsByCategory(String product_category) {
        return productRepository.findAllByCategory(product_category);
    }

    // Get Product by id
    public Optional<Product> getProductById(Long productId) {
        return productRepository.findById(productId);
    }

    // Get Product id by Name
    public Long getProductIdByProductName(String product_name) {
        return productRepository.retrieveProductIdByProductName(product_name);
    }

    // TODO: Add a new Product to the database
    public Product addProduct(Product product) {
        // Add Product to the database
        return productRepository.save(product);
    }

    // Get all Users
    public List<User> getAllUsers() {
        return this.userRepository.findAllBy();
    }

    // Get User by Email
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    // Create new User
    public User createUser(String user_name, String email, String password_hash) {
        User newUser = new User();
        newUser.setUserName(user_name);
        newUser.setUserEmail(email);
        newUser.setUserPassword(password_hash);

        return this.userRepository.save(newUser);
    }

    // Get all Orders
    public List<Order> getAllOrders() {
        return this.orderRepository.findAllBy();
    }


    // TODO: Create (add) Order based on shopping cart
        // TODO: Get User by email -> Need User id to create new order
        // TODO: Get User address by User id
    public Order createOrder(Order newOrder) {
        return this.orderRepository.save(newOrder);
    }


    // TODO: Process Order -> Add Order to Order History & Update Users Rewards Points


    // Get all ProductPrice/s
    public List<ProductPrice> getAllProductPrices() {
        return this.productPriceRepository.retrieveAllProductPrices();
    }

    // Get Product Prices by Product id
    public List<ProductPrice> getProductPricesByProductId(int product_id) {
        return this.productPriceRepository.retrieveProductPriceByProductId(product_id);
    }

    // Get Product Prices by Supermarket id
    public List<ProductPrice> getProductPricesBySupermarketId(int supermarket_id) {
        return this.productPriceRepository.retrieveProductPriceBySupermarketId(supermarket_id);
    }





}
