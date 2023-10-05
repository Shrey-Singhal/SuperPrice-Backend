package au.edu.rmit.sept.SuperPrice.repository;

import au.edu.rmit.sept.SuperPrice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

// import java.util.Collection;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Find all Products
    List<Product> findAllBy();

    // Find all distinct product categories
    @Query(value = "SELECT DISTINCT product_category FROM Product")
    List<String> retrieveDistinctProductCategories();

    // Find all Products by product_category
    @Query(value = "SELECT p FROM Product p WHERE LOWER(p.product_category) = LOWER(:product_category)")
    List<Product> findAllByCategory(@Param("product_category") String product_category);

    // Find Products by product_name
    @Query(value = "SELECT p.product_id FROM Product p WHERE LOWER(p.product_name) = LOWER(:product_name)")
    Long retrieveProductIdByProductName(@Param("product_name") String product_name);
}