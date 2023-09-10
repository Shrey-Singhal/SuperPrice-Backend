package au.edu.rmit.sept.SuperPrice.controller;

import au.edu.rmit.sept.SuperPrice.model.Product;
import au.edu.rmit.sept.SuperPrice.service.ProductService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/products")
public class ProductController {

    ProductService service;

    @GetMapping("/listAll")
    public Iterable <Product> getThem(){
        return service.getAllProducts();
    }

    @GetMapping("/test")
    public String test(){
        return "Hello";
    }

}