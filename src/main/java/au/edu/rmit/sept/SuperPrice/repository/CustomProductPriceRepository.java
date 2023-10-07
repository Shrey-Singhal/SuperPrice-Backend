package au.edu.rmit.sept.SuperPrice.repository;

import au.edu.rmit.sept.SuperPrice.model.CustomDTOProductPrices;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Custom repository class handles custom queries returning aggregated data for ProductPrices & related tables
 */
@Repository
public interface CustomProductPriceRepository {
    // CUSTOM PRODUCTPRICES REPOSITORY METHODS

    // Get custom ProductPricesData by selected product_id (related Products, ProductPrices, ProductRewards & Supermarkets data)
    List<CustomDTOProductPrices> retrieveProductPricesByProductId(int product_id);

    // Get custom ProductPrices data by selected supermarket_id  (related Products, ProductPrices, ProductRewards & Supermarkets data)
    List<CustomDTOProductPrices> retrieveProductPricesBySupermarketId(int supermarket_id);

    // Get distinct Product categories by selected supermarket_id
    List<CustomDTOProductPrices> retrieveProductCategoriesBySupermarketId(int supermarket_id);

    // Get custom ProductPrices data by selected category & supermarket_id (related Products, ProductPrices, ProductRewards & Supermarkets data)
    List<CustomDTOProductPrices> retrieveProductPricesBySupermarketIdAndProductCategory(int supermarket_id, String product_category);

}
