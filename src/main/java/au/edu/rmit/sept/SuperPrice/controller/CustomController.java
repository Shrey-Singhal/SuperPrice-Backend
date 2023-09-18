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

    // TODO: Add any additional custom controller methods


}
