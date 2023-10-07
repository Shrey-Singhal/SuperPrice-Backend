package au.edu.rmit.sept.SuperPrice.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import au.edu.rmit.sept.SuperPrice.model.ProductPrice;
import au.edu.rmit.sept.SuperPrice.service.ProductPriceService;


@RestController
@RequestMapping(value = "/v1/ProductPrices")
@CrossOrigin(value = "http://localhost:5173")
public class ProductPricesController {
    // Declare service instance/s
    @Autowired
    private ProductPriceService productPriceService;

    // Get all ProductPrices
    @GetMapping
    public ResponseEntity<List<ProductPrice>> getAllProductPrices() {
        // Get a list of ProductPrices
        List<ProductPrice> prices = this.productPriceService.getProductPrices();

        // Convert to ResponseEntity
        if (!prices.isEmpty()) {
            // OK
            return ResponseEntity.ok(prices);
        } else {
            // No Content
            return ResponseEntity.noContent().build();
        }
    }


    // Get Product Prices by Product id
    @GetMapping("/{product_id}")
    public ResponseEntity<List<ProductPrice>> getProductPricesByProductId(@PathVariable int product_id) {
        // Get list of ProductPrices
        List<ProductPrice> prices = this.productPriceService.getProductPricesByProductId(product_id);

        // Convert to ResponseEntity
        if (!prices.isEmpty()) {
            // OK
            return ResponseEntity.ok(prices);
        } else {
            // No Content
            return ResponseEntity.noContent().build();
        }
    }


    // Get Product Prices by Supermarket id
    @GetMapping("/Supermarket/{supermarket_id}")
    public ResponseEntity<List<ProductPrice>> getProductPricesBySupermarketId(@PathVariable int supermarket_id) {
        // Get list of ProductPrices
        List<ProductPrice> prices = this.productPriceService.getProductPricesBySupermarketId(supermarket_id);

        // Convert to ResponseEntity
        if (!prices.isEmpty()) {
            // OK
            return ResponseEntity.ok(prices);
        } else {
            // No Content
            return ResponseEntity.noContent().build();
        }
    }
}
