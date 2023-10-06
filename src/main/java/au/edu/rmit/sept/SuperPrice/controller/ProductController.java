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
 * TODO: Move test controller methods into test directory & adapt as needed
 */

@RestController
@RequestMapping(value = "/SuperPrice") // TODO: Update final URLs
@CrossOrigin(value = "http://localhost:5173")
public class ProductController {
    // Declare service instance/s
    @Autowired
    private ProductService productService;


    // CONTROLLER METHODS

    // TODO: Test & remove
    @GetMapping("/Test")
    public String test(){
        return "Hello from SuperPrice!";
    }


    // PRODUCT CONTROLLER METHODS

    // Get all Products
    @GetMapping("/All/Products")
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
    @GetMapping("/All/Categories")
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

    // Test Method: Get all Products by category (from path variable)
    @GetMapping("/getProductsByCategory/{product_category}")
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

    // // Get all Products by category (from request body)
    // @PostMapping("/getProductsByProductCategory")
    // public ResponseEntity<List<Product>> getProductsByProductCategory(@RequestBody String product_category) {
    //     // Get a list of Products by category
    //     List<Product> products = this.productService.getAllProductsByCategory(product_category);

    //     // Convert to ResponseEntity
    //     if (!products.isEmpty()) {
    //         // OK
    //         return ResponseEntity.ok(products);
    //     } else {
    //         // No Content
    //         return ResponseEntity.noContent().build();
    //     }
    // }

    // Test Method: Get Product by id (from url path variable)
    @GetMapping("/getProductById/{product_id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long product_id) {
        Optional<Product> productOptional = this.productService.getProductById(product_id);
        return productOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // // Get Product by id (from request body)
    // @PostMapping("/getProductByProductId")
    // public ResponseEntity<Product> getProductByProductId(@RequestBody Long product_id) {
    //     Optional<Product> productOptional = this.productService.getProductById(product_id);
    //     return productOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    // }

    // Test Method: Get Product by Product name (from url path variable)
    @GetMapping("/getProductByName/{product_name}")
    public ResponseEntity<Product> getProductByName(@PathVariable String product_name) {
        // Get Product id by Product name
        Long product_id = this.productService.getProductIdByProductName(product_name);

        // Get Product by Product id
        Optional<Product> productOptional = this.productService.getProductById(product_id);
        return productOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // // Get Product by Product name (from request body)
    // @PostMapping("/getProductByProductName")
    // public ResponseEntity<Product> getProductByProductName(@RequestBody String product_name) {
    //     // Get Product id by Product name
    //     Long product_id = this.productService.getProductIdByProductName(product_name);

    //     // Get Product by Product id
    //     Optional<Product> productOptional = this.productService.getProductById(product_id);
    //     return productOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    // }


    // USER CONTROLLER METHODS

    // Get all Users
    @GetMapping("/All/Users")
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

    // Test Methods: Get User by email (from url path variable)
    @GetMapping("/getUserByEmail/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email) {
        Optional<User> userOptional = this.productService.getUserByEmail(email);
        return userOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // // Get User by email (from request body)
    // @PostMapping("/getUserByUserEmail")
    // public ResponseEntity<User> getUserByUserEmail(@RequestBody String email) {
    //     Optional<User> userOptional = this.productService.getUserByEmail(email);
    //     return userOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    // }


    // Create new User
    @PostMapping("/v1/Users")
    public ResponseEntity<User> createNewUser(@RequestParam String user_name, @RequestParam String email, @RequestParam String password_hash) {
        // User newUser = new User();
        // newUser.setUserName(user_name);
        // newUser.setUserEmail(email);
        // newUser.setUserPassword(password_hash);

        User newUser = this.productService.createUser(user_name, email, password_hash);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }


    // ORDER CONTROLLER METHODS

    // Get all Orders
    @GetMapping("/All/Orders")
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
    @GetMapping("/NewOrder")
    public ResponseEntity<Order> createNewOrder(@RequestParam int user_id) {
        Order newOrder = new Order(user_id);
//        newOrder.setUserId(user_id);
        Order userOrder = this.productService.createOrder(newOrder);
        return new ResponseEntity<>(userOrder, HttpStatus.CREATED);
    }


    // PRODUCT PRICES CONTROLLER METHODS

    // Test Method: Get Product Prices by Product id (from url path variable)
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

    // // Get Product Prices by Product id (from request body)
    // @PostMapping("/getPricesByProductId")
    // public ResponseEntity<List<ProductPrice>> getPricesByProductId(@RequestBody int product_id) {
    //     // Get list of ProductPrices
    //     List<ProductPrice> prices = this.productService.getProductPricesByProductId(product_id);

    //     // Convert to ResponseEntity
    //     if (!prices.isEmpty()) {
    //         // OK
    //         return ResponseEntity.ok(prices);
    //     } else {
    //         // No Content
    //         return ResponseEntity.noContent().build();
    //     }
    // }

    // Test Method: Get Product Prices by Supermarket id (from url path variable)
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