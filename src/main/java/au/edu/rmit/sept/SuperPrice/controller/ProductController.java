package au.edu.rmit.sept.SuperPrice.controller;

import au.edu.rmit.sept.SuperPrice.model.*;
//import au.edu.rmit.sept.SuperPrice.model.ProductPrice;
//import au.edu.rmit.sept.SuperPrice.service.ProductService;
import au.edu.rmit.sept.SuperPrice.service.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/Products") // TODO: Update final URLs
public class ProductController {
    // Declare service instances
    ProductService productService;

    // TODO: Test & remove
    @GetMapping("/Test")
    public String test(){
        return "Hello from SuperPrice!";
    }

    // TODO: Test & remove if not needed
    @GetMapping("/All")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    // TODO: Get ProductPrices for Product, given Product name
//    @GetMapping("/getProductPrices")
//    public List<ProductPrice> getProductPrices(@RequestParam String productName) {
////    public String getProductPrices(@RequestParam String productName, Model model) {
////        List<ProductPrice> prices = service.getProductPrices(productName);
////        model.addAttribute("prices", prices);
////        return "product_prices";
//        return productService.getProductPrices(productName);
//    }


    // TODO: Get User Rewards Points, given User name & email address
//    @GetMapping("/getUserRewards")
//    public int getUserRewards(@RequestParam String userName, @RequestParam String userEmail) {
//        return userService.getUserRewards(userName, userEmail);
//    }


    //


}