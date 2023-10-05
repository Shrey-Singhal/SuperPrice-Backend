package au.edu.rmit.sept.SuperPrice.repository;

import au.edu.rmit.sept.SuperPrice.model.CustomDTOProductPrices;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomProductPriceRepository {
    // CUSTOM REPOSITORY METHODS

    // Get contents of joined Product, ProductPrices & Supermarkets tables for given product_id
    List<CustomDTOProductPrices> retrieveCustomProductPriceData(int product_id);

    // Get contents of joined Product, ProductPrices & Supermarkets tables for given supermarket_id
    List<CustomDTOProductPrices> retrieveCustomProductPriceDataBySupermarket(int supermarket_id);

    // Get distinct product categories for given supermarket_id
    List<CustomDTOProductPrices> retrieveCustomDistinctProductCategoryDataBySupermarketId(int supermarket_id);

    // Get products, product prices & product rewards for selected category & supermarket_id
    List<CustomDTOProductPrices> retrieveCustomProductCategoryProductPriceDataBySupermarketId(int supermarket_id, String product_category);

}
