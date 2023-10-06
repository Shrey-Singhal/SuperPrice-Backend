package au.edu.rmit.sept.SuperPrice.repository;

//import au.edu.rmit.sept.SuperPrice.model.Product;
import au.edu.rmit.sept.SuperPrice.model.ProductPrice;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.repository.CrudRepository;
// import org.springframework.data.repository.PagingAndSortingRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductPriceRepository {
    // Get all ProductPrices
    List<ProductPrice> retrieveAllProductPrices();

    // Get ProductPrices by Product id
    List<ProductPrice> retrieveProductPriceByProductId(int product_id);

    // Get ProductPrices by Supermarket id
    List<ProductPrice> retrieveProductPriceBySupermarketId(int supermarket_id);
}
