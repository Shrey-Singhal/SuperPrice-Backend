package au.edu.rmit.sept.SuperPrice.repository;

import au.edu.rmit.sept.SuperPrice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // TODO: Find all Products
    List<Product> findAllByIdNotNull();

    // TODO: Find Products by Product Name -> Implement & test
    List<Product> findProductsByName(String productName);
}