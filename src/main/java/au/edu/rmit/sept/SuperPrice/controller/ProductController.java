package au.edu.rmit.sept.SuperPrice.controller;

import au.edu.rmit.sept.SuperPrice.model.*;
//import au.edu.rmit.sept.SuperPrice.model.ProductPrice;
//import au.edu.rmit.sept.SuperPrice.service.ProductService;
import au.edu.rmit.sept.SuperPrice.service.*;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Product> getAllProducts() {
        return this.productService.getAllProducts();
    }

    // Get Product id by Product name
    @GetMapping("/getProductIdByProductName/{product_name}")
    public int getProductIdByProductName(@PathVariable String product_name) {
        return this.productService.getProductIdByProductName(product_name);
    }

    // Get Product by id
    @GetMapping("/getProductById/{product_id}")
    public Optional<Product> getProductById(@PathVariable Long product_id) {
        return this.productService.getProductById(product_id);
    }

    // Get all Users
    @GetMapping("/All/Users")
    public List<User> getAllUsers() {
        return this.productService.getAllUsers();
    }

    // Get all Orders
    @GetMapping("/All/Orders")
    public List<Order> getAllOrders() {
        return this.productService.getAllOrders();
    }

    // TODO: Get all Product Prices
//    @GetMapping("/All/ProductPrices")
//    public List<ProductPrice> getAllProductPrices() {
//        return this.productService.getAllProductPrices();
//    }


    // TODO: Get User Rewards Points, given User name & email address
//    @GetMapping("/getUserRewards")
//    public int getUserRewards(@RequestParam String userName, @RequestParam String userEmail) {
//        return userService.getUserRewards(userName, userEmail);
//    }


    //


}