package au.edu.rmit.sept.SuperPrice.controller;

import au.edu.rmit.sept.SuperPrice.model.Supermarket;
import au.edu.rmit.sept.SuperPrice.service.SupermarketService;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/SuperPrice/")
@CrossOrigin(value = "http://localhost:5173")
public class SupermarketController {
    @Autowired
    private SupermarketService supermarketService;

    // SUPERMARKET CONTROLLER METHODS

    // Get all Supermarkets
    @GetMapping("v1/Supermarkets")
    public ResponseEntity<List<Supermarket>> getAllSupermarkets() {
        // Get a list of Supermarkets
        List<Supermarket> supermarkets = this.supermarketService.getAllSupermarkets();

        // Convert to ResponseEntity
        if (!supermarkets.isEmpty()) {
            // OK
            return ResponseEntity.ok(supermarkets);
        } else {
            // No Content
            return ResponseEntity.noContent().build();
        }
    }

    // Get Supermarket by supermarket_id
    @GetMapping("v1/Supermarkets/{supermarket_id}")
    public ResponseEntity<Supermarket> getSupermarketById(@PathVariable int supermarket_id) {
        // Get Supermarket by id
        Optional<Supermarket> supermarket = this.supermarketService.getSupermarketById(supermarket_id);

        // Convert to ResponseEntity
        if (supermarket.isPresent()) {
            // OK
            return ResponseEntity.ok(supermarket.get());
        } else {
            // No Content
            return ResponseEntity.noContent().build();
        }
    }


    // Get Supermarket by supermarket_name
    @GetMapping("v1/Supermarkets/name/{supermarket_name}")
    public ResponseEntity<Supermarket> getSupermarketByName(@PathVariable String supermarket_name) {
        // Get Supermarket by name
        Optional<Supermarket> supermarket = this.supermarketService.getSupermarketByName(supermarket_name);

        // Convert to ResponseEntity
        if (supermarket.isPresent()) {
            // OK
            return ResponseEntity.ok(supermarket.get());
        } else {
            // No Content
            return ResponseEntity.noContent().build();
        }
    }


    // Create new Supermarket TODO: Test this method
    @PostMapping("v1/createSupermarket")
    public ResponseEntity<Supermarket> createSupermarket(@RequestBody Supermarket supermarket) {
        Optional<Supermarket> supermarketOptional = this.supermarketService.createSupermarket(supermarket);
        return supermarketOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}