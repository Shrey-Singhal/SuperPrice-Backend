package au.edu.rmit.sept.SuperPrice.repository;

import au.edu.rmit.sept.SuperPrice.model.ProductPrice;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * ProductPriceRepository class handles the retrieval of ProductPrice data from the database
 */
@Repository
public interface ProductPriceRepository {
    // Get all ProductPrices
    List<ProductPrice> retrieveAllProductPrices();

    // Get ProductPrices by product_id
    List<ProductPrice> retrieveProductPricesByProductId(int product_id);

    // Get ProductPrices by supermarket_id
    List<ProductPrice> retrieveProductPricesBySupermarketId(int supermarket_id);
}
