package au.edu.rmit.sept.SuperPrice.repository;

//import au.edu.rmit.sept.SuperPrice.model.Product;
import au.edu.rmit.sept.SuperPrice.model.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductPriceRepository extends PagingAndSortingRepository<ProductPrice, Long>, CrudRepository<ProductPrice, Long>, JpaRepository<ProductPrice, Long> {
    // Get all ProductPrices
    @Query(value = "SELECT p FROM ProductPrice p")
    List<ProductPrice> retrieveAllProductPrices();

    // Get ProductPrices by Product id
    @Query(value = "SELECT p FROM ProductPrice p WHERE p.product_id = :product_id")
    List<ProductPrice> retrieveProductPriceByProductId(@Param("product_id") int product_id);

    // Get ProductPrices by Supermarket id
    @Query(value = "SELECT p FROM ProductPrice p WHERE p.supermarket_id = :supermarket_id")
    List<ProductPrice> retrieveProductPriceBySupermarketId(@Param("supermarket_id") int supermarket_id);
}
