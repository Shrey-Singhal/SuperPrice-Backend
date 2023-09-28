package au.edu.rmit.sept.SuperPrice.controller;


import au.edu.rmit.sept.SuperPrice.model.CustomDTOProductPrices;
import au.edu.rmit.sept.SuperPrice.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/SuperPrice") // TODO: Update final URLs
@CrossOrigin(value = "http://localhost:5173")
public class CustomController {
    // Declare custom service instance
    @Autowired
    private CustomService customService;

    // CUSTOM CONTROLLER METHODS

    // TODO: Remove test controller method
    @GetMapping("/ComparePricesTest/{product_id}")
    public ResponseEntity<List<CustomDTOProductPrices>> getCustomProductPriceDataTest(@PathVariable("product_id") int product_id) {
        List<CustomDTOProductPrices> customProductPriceData = this.customService.getCustomProductPriceData(product_id);

        // Convert to ResponseEntity
        if (!customProductPriceData.isEmpty()) {
            // OK
            return ResponseEntity.ok(customProductPriceData);
        } else {
            // No Content
            return ResponseEntity.noContent().build();
        }
    }

    // Get related ProductPrice & Supermarket data for Product with given product_id
    @PostMapping("/ComparePrices")
    public ResponseEntity<List<CustomDTOProductPrices>> getCustomProductPriceData(@RequestBody int product_id) {
        List<CustomDTOProductPrices> customProductPriceData = this.customService.getCustomProductPriceData(product_id);

        // Convert to ResponseEntity
        if (!customProductPriceData.isEmpty()) {
            // OK
            return ResponseEntity.ok(customProductPriceData);
        } else {
            // No Content
            return ResponseEntity.noContent().build();
        }
    }

    // Get ProductPrice data for Products from supermarket with given supermarket_id
    @PostMapping("/ViewCategoryProductsBySupermarket")
    public ResponseEntity<List<CustomDTOProductPrices>> getCustomProductPriceDataBySupermarket(@RequestBody int supermarket_id) {
        List<CustomDTOProductPrices> customProductPriceData = this.customService.getCustomProductPriceDataBySupermarket(supermarket_id);

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
