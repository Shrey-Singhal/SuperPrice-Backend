package au.edu.rmit.sept.SuperPrice.controller;

// Local class imports
import au.edu.rmit.sept.SuperPrice.model.*;
import au.edu.rmit.sept.SuperPrice.service.*;
import au.edu.rmit.sept.SuperPrice.controller.ControllerFilters;

// Spring Boot package class imports
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Java package class imports
//import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/SuperPrice") // TODO: Update final URLs
public class ProductController {
    // Declare service instance/s
    @Autowired
    private ProductService productService;


    // Controller methods

    // TODO: Test & remove
    @GetMapping("/Test")
    public String test(){
        return "Hello from SuperPrice!";
    }

    // Get all Products
    @GetMapping("/All/Products") // TODO: Update final URLs
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

    // Get all Products by category (from path variable) // NOTE: for testing purposes only
    @GetMapping("/getProductsByCategory/{product_category}") // TODO: Update final URLs
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

    // Get all Products by category (from request body)
    @PostMapping("/getProductsByProductCategory") // TODO: Update final URLs
    public ResponseEntity<List<Product>> getProductsByProductCategory(@RequestBody String product_category) {
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

    // Get Product by id (from url path variable) // NOTE: For testing purposes only
    @GetMapping("/getProductById/{product_id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long product_id) {
        Optional<Product> productOptional = this.productService.getProductById(product_id);
        return productOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get Product by id (from request body)
    @PostMapping("/getProductByProductId") // TODO: Update final URLs
    public ResponseEntity<Product> getProductByProductId(@RequestBody Long product_id) {
        Optional<Product> productOptional = this.productService.getProductById(product_id);
        return productOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get Product by Product name (from url path variable) // NOTE: For testing purposes only
    @GetMapping("/getProductByName/{product_name}")
    public ResponseEntity<Product> getProductByName(@PathVariable String product_name) {
        // Get Product id by Product name
        Long product_id = this.productService.getProductIdByProductName(product_name);

        // Get Product by Product id
        Optional<Product> productOptional = this.productService.getProductById(product_id);
        return productOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get Product by Product name (from request body)
    @PostMapping("/getProductByProductName") // TODO: Update final URLs
    public ResponseEntity<Product> getProductByProductName(@RequestBody String product_name) {
        // Get Product id by Product name
        Long product_id = this.productService.getProductIdByProductName(product_name);

        // Get Product by Product id
        Optional<Product> productOptional = this.productService.getProductById(product_id);
        return productOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all Users
    @GetMapping("/All/Users") // TODO: Update final URLs
    public ResponseEntity<List<User>> getAllUsers() {
        // Get a list of Users
        List<User> users = this.productService.getAllUsers();

        // Convert to ResponseEntity
        if (!users.isEmpty()) {
            // OK
            return ResponseEntity.ok(users);
        } else {
            // No Content
            return ResponseEntity.noContent().build();
        }
    }

    // Get User by email (from url path variable) // NOTE: For testing purposes only
    @GetMapping("/getUserByEmail/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email) {
        Optional<User> userOptional = this.productService.getUserByEmail(email);
        return userOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get User by email (from request body)
    @PostMapping("/getUserByUserEmail") // TODO: Update final URLs
    public ResponseEntity<User> getUserByUserEmail(@RequestBody String email) {
        Optional<User> userOptional = this.productService.getUserByEmail(email);
        return userOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all Orders
    @GetMapping("/All/Orders") // TODO: Update final URLs
    public ResponseEntity<List<Order>> getAllOrders() {
        // Get a list of Orders
        List<Order> orders = this.productService.getAllOrders();

        // Convert to ResponseEntity
        if (!orders.isEmpty()) {
            // OK
            return ResponseEntity.ok(orders);
        } else {
            // No Content
            return ResponseEntity.noContent().build();
        }
    }

    // TODO: Save Order, incl. update User RewardsPoints


    // Get Product Prices by Product id (from url path variable) // NOTE: For testing purposes only
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

    // Get Product Prices by Product id (from request body)
    @PostMapping("/getPricesByProductId") // TODO: Update final URLs
    public ResponseEntity<List<ProductPrice>> getPricesByProductId(@RequestBody int product_id) {
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

    // Get all Product Prices // TODO: Remove if not needed
    @GetMapping("/getAllProductPrices") // TODO: Update final URLs
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


    // TODO: Get User Rewards Points, given User email
//    @GetMapping("/getUserRewardsByEmail/{email}")
//    public Long getUserRewards(@PathVariable("email") String email) {
//        return productService.getUserRewards(email);
//    }


    // TODO: Add any additional methods required for the Rewards Points Feature implementation


}