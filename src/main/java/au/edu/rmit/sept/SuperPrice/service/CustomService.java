package au.edu.rmit.sept.SuperPrice.service;


import au.edu.rmit.sept.SuperPrice.model.CustomDTOProductPrices;
import au.edu.rmit.sept.SuperPrice.repository.CustomProductPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomService {
    @Autowired
    private CustomProductPriceRepository customProductPriceRepository;

    // Custom service methods for the running of each custom repository method

    // Get Product, ProductPrices, ProductRewards & Supermarkets data for selected product_id
    public List<CustomDTOProductPrices> getCustomProductPriceData(int product_id) {
        return customProductPriceRepository.retrieveCustomProductPriceData(product_id);
    }

    // Get Products, ProductPrices, ProductRewards & Supermarket data for selected supermarket_id
    public List<CustomDTOProductPrices> getCustomProductPriceDataBySupermarket(int supermarket_id) {
        return customProductPriceRepository.retrieveCustomProductPriceDataBySupermarket(supermarket_id);
    }

    // Get distinct product categories for given supermarket_id
    public List<CustomDTOProductPrices> getCustomDistinctProductCategoryDataBySupermarket(int supermarket_id) {
        return customProductPriceRepository.retrieveCustomDistinctProductCategoryDataBySupermarketId(supermarket_id);
    }

    // Get products, product prices & product rewards for selected category & supermarket_id
    public List<CustomDTOProductPrices> getCustomProductCategoryProductPriceDataBySupermarket(int supermarket_id, String product_category) {
        return customProductPriceRepository.retrieveCustomProductCategoryProductPriceDataBySupermarketId(supermarket_id, product_category);
    }

    

}
