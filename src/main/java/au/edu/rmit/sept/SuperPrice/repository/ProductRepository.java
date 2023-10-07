package au.edu.rmit.sept.SuperPrice.repository;

import au.edu.rmit.sept.SuperPrice.model.Product;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * ProductRepository class handles the retrieval of Product data from the database
 */
@Repository
public interface ProductRepository {
    // Find all Products
    List<Product> findAllProducts();

    // Find all distinct product categories
    List<String> findProductCategories();

    // Find all Products by product_category
    List<Product> findProductsByCategory(String product_category);

    // Find Product by product_id
    Optional<Product> findProductById(int product_id);

    // Find Product by product_name
    Optional<Product> findProductByProductName(String product_name);

    // Save new Product
    Optional<Product> saveProduct(Product product);
}