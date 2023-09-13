package au.edu.rmit.sept.SuperPrice.controller;

import au.edu.rmit.sept.SuperPrice.model.Product;
import au.edu.rmit.sept.SuperPrice.service.ProductService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/products") // TODO: Update final URLs
public class ProductController {
    // Declare service instance
    ProductService service;

    // TODO: Test & remove
    @GetMapping("/test")
    public String test(){
        return "Hello from SuperPrice!";
    }


    @GetMapping("/All")
    public List<Product> getProducts(){
        return service.getAllProducts();
    }


}