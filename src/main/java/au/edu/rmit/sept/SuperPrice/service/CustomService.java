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

    // TODO: Add any additional custom repositories


    // Custom service methods for the running of each custom repository method

    // Get contents of joined Product, ProductPrices & Supermarkets tables for given product_id
    public List<CustomDTOProductPrices> getCustomProductPriceData(int product_id) {
        return customProductPriceRepository.retrieveCustomProductPriceData(product_id);
    }

    // Get contents of joined Product, ProductPrices & Supermarkets tables for given supermarket_id
    public List<CustomDTOProductPrices> getCustomProductPriceDataBySupermarket(int supermarket_id) {
        return customProductPriceRepository.retrieveCustomProductPriceDataBySupermarket(supermarket_id);
    }
}
