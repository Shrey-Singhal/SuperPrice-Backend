package au.edu.rmit.sept.shoppingApp.service;

import au.edu.rmit.sept.shoppingApp.model.Product;
import java.util.Collection;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public interface ProductService {
    // repository instance
    private final ProductRepository productRepository;

    // Initialise repository instance
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Get a list of all the products in the database TODO: Implement & test
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Create a product TODO: Implement & test -> If necessary
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // Get a product by product name & supermarket name / id TODO: Implement & test
    public Book getProduct(String nameProduct, String nameSupermarket) {
        // Find product by
        return productRepository.findByName(nameProduct).orElse(null);
    }
}
