package au.edu.rmit.sept.SuperPrice.controller;

// Local class imports
import au.edu.rmit.sept.SuperPrice.model.*;
import au.edu.rmit.sept.SuperPrice.service.*;

// Spring Boot package class imports
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Java package class imports
//import java.util.Collection;
import java.util.List;
import java.util.Optional;


/** 
 * Base URL: http://localhost:8080/SuperPrice
 * CrossOrigin requests permitted from URL: http://localhost:5173
 * 
 * TODO: Update final URLs
 */

@RestController
@RequestMapping(value = "/")
@CrossOrigin(value = "http://localhost:5173")
public class ProductController {
    // Declare service instance/s
    @Autowired
    private ProductService productService;

    // PRODUCT CONTROLLER METHODS

    // Get all Products
    @GetMapping("v1/Products")
    public ResponseEntity<List<Product>> getAllProducts() {
        // Get a list of Products
        List<Product> products = this.productService.getAllProducts();

        // Convert to ResponseEntity
        if (!products.isEmpty()) {
            // OK
            return ResponseEntity.ok(products);
        } else {
            // No Content
            return ResponseEntity.noContent().build();
        }
    }

    // Get all product categories
    @GetMapping("v1/Products/Categories")
    public ResponseEntity<List<String>> getAllCategories() {
        // Get a list of all product categories
        List<String> categories = this.productService.getAllProductCategories();

        // Convert to Response Entity
        if (!categories.isEmpty()) {
            // OK
            return ResponseEntity.ok(categories);
        } else {
            // No Content
            return ResponseEntity.noContent().build();
        }
    }

    // Get all Products by category
    @GetMapping("v1/Products/Category/{product_category}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable("product_category") String product_category) {
        // Get a list of Products by category
        List<Product> products = this.productService.getAllProductsByCategory(product_category);

        // Convert to ResponseEntity
        if (!products.isEmpty()) {
            // OK
            return ResponseEntity.ok(products);
        } else {
            // No Content
            return ResponseEntity.noContent().build();
        }
    }


    // Get Product by id
    @GetMapping("v1/Product/{product_id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long product_id) {
        Optional<Product> productOptional = this.productService.getProductById(product_id);
        return productOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }





    // PRODUCT PRICES CONTROLLER METHODS

    // Get Product Prices by Product id
    @GetMapping("/getProductPricesByProductId/{product_id}")
    public ResponseEntity<List<ProductPrice>> getProductPricesByProductId(@PathVariable int product_id) {
        // Get list of ProductPrices
        List<ProductPrice> prices = this.productService.getProductPricesByProductId(product_id);

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
    @GetMapping("/getProductPricesBySupermarketId/{supermarket_id}")
    public ResponseEntity<List<ProductPrice>> getProductPricesBySupermarketId(@PathVariable int supermarket_id) {
        // Get list of ProductPrices
        List<ProductPrice> prices = this.productService.getProductPricesBySupermarketId(supermarket_id);

        // Convert to ResponseEntity
        if (!prices.isEmpty()) {
            // OK
            return ResponseEntity.ok(prices);
        } else {
            // No Content
            return ResponseEntity.noContent().build();
        }
    }

    // // Get Product Prices by Supermarket id (from request body)
    // @GetMapping("/getPricesBySupermarketId")
    // public ResponseEntity<List<ProductPrice>> getPricesBySupermarketId(@RequestBody int supermarket_id) {
    //     // Get list of ProductPrices
    //     List<ProductPrice> prices = this.productService.getProductPricesBySupermarketId(supermarket_id);

    //     // Convert to ResponseEntity
    //     if (!prices.isEmpty()) {
    //         // OK
    //         return ResponseEntity.ok(prices);
    //     } else {
    //         // No Content
    //         return ResponseEntity.noContent().build();
    //     }
    // }

    // Get all Product Prices // TODO: Remove if not needed (not necessary for the Price Comparison Feature)
    @GetMapping("/getAllProductPrices")
    public ResponseEntity<List<ProductPrice>> getAllProductPrices() {
        // Get list of ProductPrices
        List<ProductPrice> prices = this.productService.getAllProductPrices();

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