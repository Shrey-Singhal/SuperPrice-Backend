package au.edu.rmit.sept.SuperPrice.controller;

import au.edu.rmit.sept.SuperPrice.model.Product;
import au.edu.rmit.sept.SuperPrice.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import java.util.Collection;
import java.util.List;
import java.util.Optional;


/** 
 * Base URL: http://localhost:8080/SuperPrice
 * CrossOrigin requests permitted from URL: http://localhost:5173
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
    public ResponseEntity<List<Product>> getProducts() {
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


    // Get all Product categories
    @GetMapping("v1/Products/Categories")
    public ResponseEntity<List<String>> getProductCategories() {
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


    // Get Product by product_id
    @GetMapping("v1/Product/{product_id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long product_id) {
        Optional<Product> productOptional = this.productService.getProductById(product_id);
        return productOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    


    // Get Product by product_name
    @GetMapping("v1/Product/Name/{product_name}")
    public ResponseEntity<Product> getProductByName(@PathVariable("product_name") String product_name) {
        Optional<Product> productOptional = this.productService.getProductByProductName(product_name);
        return productOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    // Get all Products by product_category
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
}