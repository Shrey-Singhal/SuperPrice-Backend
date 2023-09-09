package au.edu.rmit.sept.shoppingApp.controller;

import au.edu.rmit.sept.shoppingApp.model.Product;
import au.edu.rmit.sept.shoppingApp.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "v1/products")
public class ProductController {

    ProductService service;

    @GetMapping("/listAll")
    public Iterable <Product> getThem(){
        return service.listAll();
    }

    @GetMapping("/test")
    public String test(){
        return "Hello";
    }




}