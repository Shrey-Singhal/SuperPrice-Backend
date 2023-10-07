package au.edu.rmit.sept.SuperPrice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.edu.rmit.sept.SuperPrice.model.ProductPrice;
import au.edu.rmit.sept.SuperPrice.repository.ProductPriceRepository;


/**
 * ProductPriceService class handles business logic related to the running of ProductPrice repository methods
 */
@Service
public class ProductPriceService {
    @Autowired
    private ProductPriceRepository productPriceRepository;

    // Get all ProductPrices
    public List<ProductPrice> getProductPrices() {
        return this.productPriceRepository.retrieveAllProductPrices();
    }

    // Get ProductPrices by product_id
    public List<ProductPrice> getProductPricesByProductId(int product_id) {
        return this.productPriceRepository.retrieveProductPricesByProductId(product_id);
    }

    // Get ProductPrices by supermarket_id
    public List<ProductPrice> getProductPricesBySupermarketId(int supermarket_id) {
        return this.productPriceRepository.retrieveProductPricesBySupermarketId(supermarket_id);
    }
}
