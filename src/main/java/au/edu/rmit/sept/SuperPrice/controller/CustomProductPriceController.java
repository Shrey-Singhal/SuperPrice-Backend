package au.edu.rmit.sept.SuperPrice.controller;

import au.edu.rmit.sept.SuperPrice.model.CustomDTOProductPrices;
import au.edu.rmit.sept.SuperPrice.service.CustomProductPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * CustomController class handles requests for custom queries
 * Base URL: http://localhost:8080/SuperPrice
 * CrossOrigin: http://localhost:5173
 * 
 * TODO: Update final URLs
 * TODO: Move test controller methods to tests & adapt as needed
 */
@RestController
@RequestMapping(value = "/v2/ProductPrices")
@CrossOrigin(value = "http://localhost:5173")
public class CustomProductPriceController {
    // Declare custom service instance
    @Autowired
    private CustomProductPriceService customService;

    // Get custom ProductPrices data by given product_id (related Products, ProductPrices, ProductRewards & Supermarkets data)
    @GetMapping("/{product_id}")
    public ResponseEntity<List<CustomDTOProductPrices>> getProductPricesByProductId(@PathVariable("product_id") int product_id) {
        List<CustomDTOProductPrices> customProductPriceData = this.customService.getProductPricesByProductId(product_id);

        // Convert to ResponseEntity
        if (!customProductPriceData.isEmpty()) {
            // OK
            return ResponseEntity.ok(customProductPriceData);
        } else {
            // No Content
            return ResponseEntity.noContent().build();
        }
    }

    // Get custom ProductPrice data by given supermarket_id (related Products, ProductPrices, ProductRewards & Supermarkets data)
    @GetMapping("/Supermarket/{supermarket_id}")
    public ResponseEntity<List<CustomDTOProductPrices>> getProductPricesBySupermarketId(@PathVariable("supermarket_id") int supermarket_id) {
        List<CustomDTOProductPrices> customProductPriceData = this.customService.getProductPricesBySupermarketId(supermarket_id);

        // Convert to ResponseEntity
        if (!customProductPriceData.isEmpty()) {
            // OK
            return ResponseEntity.ok(customProductPriceData);
        } else {
            // No Content
            return ResponseEntity.noContent().build();
        }
    }


    // Get distinct Product categories by given supermarket_id
    @GetMapping("/Categories/{supermarket_id}")
    public ResponseEntity<List<CustomDTOProductPrices>> getProductCategoriesBySupermarketId(@PathVariable("supermarket_id") int supermarket_id) {
        List<CustomDTOProductPrices> customProductPriceData = this.customService.getProductCategoriesBySupermarketId(supermarket_id);

        // Convert to ResponseEntity
        if (!customProductPriceData.isEmpty()) {
            // OK
            return ResponseEntity.ok(customProductPriceData);
        } else {
            // No Content
            return ResponseEntity.noContent().build();
        }
    }


    // Get custom ProductPrices data by selected supermarket_id & product_category (related Products, ProductPrices, ProductRewards & Supermarkets data)
    // Test with http://localhost:8080/v2/ProductPrices/Supermarket/1/Dairy Products
    @GetMapping("/Supermarket/Category/{supermarket_id}/{product_category}")
    public ResponseEntity<List<CustomDTOProductPrices>> getProductPricesBySupermarketIdAndProductCategory(@PathVariable("supermarket_id") Long supermarket_id, @PathVariable("product_category") String product_category) {
        List<CustomDTOProductPrices> customProductPriceData = this.customService.getProductPricesBySupermarketIdAndProductCategory(supermarket_id, product_category);

        // Convert to ResponseEntity
        if (!customProductPriceData.isEmpty()) {
            // OK
            return ResponseEntity.ok(customProductPriceData);
        } else {
            // No Content
            return ResponseEntity.noContent().build();
        }
    }


    // TODO: Test this method & related service & repository methods
    // Get custom ProductPrices data by selected inputs or display all if none selected (related Products, ProductPrices, ProductRewards & Supermarkets data)
    @GetMapping
    public ResponseEntity<List<CustomDTOProductPrices>> getProductsBySupermarketIdAndProductCategory(@RequestParam(required = false) Long supermarket_id, @RequestParam(required = false) String product_category) {
        if (supermarket_id == null && product_category == null) {
            // Get all ProductPrices for default supermarket (supermarket_id = 1)
            int supermarketId = 1;
            List<CustomDTOProductPrices> customProductPriceData = this.customService.getProductPricesBySupermarketId(supermarketId);

            // Convert to ResponseEntity
            if (!customProductPriceData.isEmpty()) {
                // OK
                return ResponseEntity.ok(customProductPriceData);
            } else {
                // No Content
                return ResponseEntity.noContent().build();
            }
        } else {
            // Get all ProductPrices in selected category & supermarket
            List<CustomDTOProductPrices> customProductPriceData = this.customService.getProductPricesBySupermarketIdAndProductCategory(supermarket_id, product_category);

            // Convert to ResponseEntity
            if (!customProductPriceData.isEmpty()) {
                // OK
                return ResponseEntity.ok(customProductPriceData);
            } else {
                // No Content
                return ResponseEntity.noContent().build();
            }
        }
    }


    // TODO: Add any additional custom controller methods here:


}
