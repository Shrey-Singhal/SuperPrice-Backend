package au.edu.rmit.sept.SuperPrice.service;

import au.edu.rmit.sept.SuperPrice.model.Product;
import au.edu.rmit.sept.SuperPrice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    // Declare repository instances
    @Autowired
    private ProductRepository productRepository;


    // Get all Products
    public List<Product> getAllProducts() {
        return this.productRepository.findAllProducts();
    }


    // Get all distinct Product categories
    public List<String> getAllProductCategories() {
        return this.productRepository.findProductCategories();
    }


    // Get all Products by category
    public List<Product> getAllProductsByCategory(String product_category) {
        return this.productRepository.findProductsByCategory(product_category);
    }


    // Get Product by id
    public Optional<Product> getProductById(Long productId) {
        return this.productRepository.findProductById(productId);
    }


    // Get Product by Name
    public Optional<Product> getProductByProductName(String product_name) {
        return this.productRepository.findProductByProductName(product_name);
    }


    // Add a new Product to the database TODO: Test this method
    public Optional<Product> createProduct(Product product) {
        // Add Product to the database
        return this.productRepository.saveProduct(product);
    }
}
