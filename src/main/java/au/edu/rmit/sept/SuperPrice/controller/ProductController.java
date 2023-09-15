package au.edu.rmit.sept.SuperPrice.controller;

import au.edu.rmit.sept.SuperPrice.model.*;
//import au.edu.rmit.sept.SuperPrice.model.ProductPrice;
//import au.edu.rmit.sept.SuperPrice.service.ProductService;
import au.edu.rmit.sept.SuperPrice.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/Products") // TODO: Update final URLs
public class ProductController {
    // Declare service instances
    @Autowired
    private ProductService productService;

    // TODO: Test & remove
    @GetMapping("/Test")
    public String test(){
        return "Hello from SuperPrice!";
    }

    // Get all Products
    @GetMapping("/All")
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
//    public List<Product> getAllProducts() {
//        return this.productService.getAllProducts();
//    }



    // Get Product by id
    @GetMapping("/getProductById/{product_id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long product_id) {
        Optional<Product> productOptional = this.productService.getProductById(product_id);
        return productOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get Product by Product name
    @GetMapping("/getProductByProductName/{product_name}")
    public ResponseEntity<Product> getProductIdByProductName(@PathVariable String product_name) {
        // Get Product id by Product name
        Long product_id = this.productService.getProductIdByProductName(product_name);
        // Get Product by Product id
        Optional<Product> productOptional = this.productService.getProductById(product_id);
        return productOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
//    @GetMapping("/getProductIdByProductName/{product_name}")
//    public int getProductIdByProductName(@PathVariable String product_name) {
//        return this.productService.getProductIdByProductName(product_name);
//    }

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
//    public List<User> getAllUsers() {
//        return this.productService.getAllUsers();
//    }

    // TODO: Get all User emails / Can just use above & only use the email values?


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
//    public List<Order> getAllOrders() {
//        return this.productService.getAllOrders();
//    }

    // TODO: Save Order, incl. update User RewardsPoints


    // TODO: Get Product Prices by Product id
//    @GetMapping("/ProductPricesByProductId")
//    public List<ProductPrice> getProductPrices() {
//        return this.productService.getProductPrices();
//    }

    // Get User by email
    @GetMapping("/getUserByEmail/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email) {
        Optional<User> userOptional = this.productService.getUserByEmail(email);
        return userOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // TODO: Get User Rewards Points, given User email
//    @GetMapping("/getUserRewardsByEmail/{email}")
//    public Long getUserRewards(@PathVariable("email") String email) {
//        return productService.getUserRewards(email);
//    }


    //


}