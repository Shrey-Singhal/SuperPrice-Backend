package au.edu.rmit.sept.SuperPrice.service;

import au.edu.rmit.sept.SuperPrice.model.CustomDTOProductPrices;
import au.edu.rmit.sept.SuperPrice.repository.CustomProductPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Custom Service class handles business logic related to the running of custom ProductPrices repository methods
 */
@Service
public class CustomProductPriceService {
    @Autowired
    private CustomProductPriceRepository customProductPriceRepository;

    // CUSTOM SERVICE METHODS

    // Get Product, ProductPrices, ProductRewards & Supermarkets data by selected product_id
    public List<CustomDTOProductPrices> getProductPricesByProductId(int product_id) {
        return this.customProductPriceRepository.retrieveProductPricesByProductId(product_id);
    }

    // Get Products, ProductPrices, ProductRewards & Supermarkets data by selected supermarket_id
    public List<CustomDTOProductPrices> getProductPricesBySupermarketId(int supermarket_id) {
        return this.customProductPriceRepository.retrieveProductPricesBySupermarketId(supermarket_id);
    }

    // Get distinct Product categories by selected supermarket_id
    public List<CustomDTOProductPrices> getProductCategoriesBySupermarketId(int supermarket_id) {
        return this.customProductPriceRepository.retrieveProductCategoriesBySupermarketId(supermarket_id);
    }

    // Get Products, ProductPrices, ProductRewards & Supermarkets data by selected category & supermarket_id
    public List<CustomDTOProductPrices> getProductPricesBySupermarketIdAndProductCategory(Long supermarket_id, String product_category) {
        int supermarket_id_int = Math.toIntExact(supermarket_id);
        return this.customProductPriceRepository.retrieveProductPricesBySupermarketIdAndProductCategory(supermarket_id_int, product_category);
    }

    // TODO: Add any additional custom service methods here:

}
