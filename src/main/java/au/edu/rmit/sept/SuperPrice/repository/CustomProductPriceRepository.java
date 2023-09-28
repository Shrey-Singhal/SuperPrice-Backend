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

    // TODO: Add any further custom methods

}
