package au.edu.rmit.sept.SuperPrice.service;

import au.edu.rmit.sept.SuperPrice.model.Product;
import au.edu.rmit.sept.SuperPrice.repository.ProductRepository;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ProductService {
    // Declare repository instance
    ProductRepository repository;

    // Initialise repository instance
    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    // Get a list of all the products in the database TODO: Implement & test
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    // Create a product TODO: Implement & test -> If necessary
    public Product createProduct(Product product) {
        return repository.save(product);
    }
}
