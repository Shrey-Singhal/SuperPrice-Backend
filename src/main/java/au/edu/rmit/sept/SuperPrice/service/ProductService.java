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

    // Get Product id by Name
    public int getProductIdByProductName(String product_name) {
        int product_id = productRepository.retrieveProductIdByProductName(product_name);
        System.out.printf("Product ID: %d", product_id);
        return product_id;
    }

    // Get Product by id
    public Optional<Product> getProductById(Long productId) {
        return productRepository.findById(productId);
    }

    // Get all Users
    public List<User> getAllUsers() {
        return this.userRepository.findAllBy();
    }

    // TODO: Create (add) User


    // Get all Orders
    public List<Order> getAllOrders() {
        return this.orderRepository.findAllBy();
    }

    // TODO: Create (add) Order based on shopping cart


    // TODO: Get all ProductPrice/s
//    public List<ProductPrice> getAllProductPrices() {
//        return productPriceRepository.findAllBy();
//    }


    // TODO: Process Order -> Add Order to Order History & Update Users Rewards Points


    // TODO: Get Users Rewards Points given User email


}
