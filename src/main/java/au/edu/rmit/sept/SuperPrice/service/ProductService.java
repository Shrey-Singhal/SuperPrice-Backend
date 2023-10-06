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
        return this.productRepository.findAllByCategory(product_category);
    }

    // Get Product by id
    public Optional<Product> getProductById(Long productId) {
        return this.productRepository.findById(productId);
    }

    // Get Product id by Name
    public Long getProductIdByProductName(String product_name) {
        return this.productRepository.retrieveProductIdByProductName(product_name);
    }

    // TODO: Add a new Product to the database
    public Product addProduct(Product product) {
        // Add Product to the database
        return this.productRepository.save(product);
    }




    // TODO: Process Order -> Add Order to Order History & Update Users Rewards Points

}
