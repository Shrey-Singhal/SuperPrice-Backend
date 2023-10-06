package au.edu.rmit.sept.SuperPrice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.edu.rmit.sept.SuperPrice.model.ProductPrice;
import au.edu.rmit.sept.SuperPrice.repository.ProductPriceRepositoryImpl;

@Service
public class ProductPriceService {
    @Autowired
    private ProductPriceRepositoryImpl productPriceRepositoryImpl;


    // Get all ProductPrice/s
    public List<ProductPrice> getAllProductPrices() {
        return this.productPriceRepositoryImpl.retrieveAllProductPrices();
    }

    // Get Product Prices by Product id
    public List<ProductPrice> getProductPricesByProductId(int product_id) {
        return this.productPriceRepositoryImpl.retrieveProductPriceByProductId(product_id);
    }

    // Get Product Prices by Supermarket id
    public List<ProductPrice> getProductPricesBySupermarketId(int supermarket_id) {
        return this.productPriceRepositoryImpl.retrieveProductPriceBySupermarketId(supermarket_id);
    }
}
