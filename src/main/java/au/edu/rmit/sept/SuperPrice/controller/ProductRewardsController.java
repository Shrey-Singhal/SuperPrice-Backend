package au.edu.rmit.sept.SuperPrice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import au.edu.rmit.sept.SuperPrice.service.ProductRewardService;
import au.edu.rmit.sept.SuperPrice.model.ProductReward;

/**
 * UserController class handles requests for User data
 * Base URL: http://localhost:8080/SuperPrice
 * CrossOrigin: http://localhost:5173
 */
@RestController
@RequestMapping(value = "/SuperPrice/")
@CrossOrigin(value = "http://localhost:5173")
public class ProductRewardsController {
    // ProductReward controller methods for the running of ProductReward service methods

    @Autowired
    private ProductRewardService productRewardService;

    // Get all ProductRewards
    @GetMapping("v1/ProductRewards")
    public ResponseEntity<List<ProductReward>> getAllProductRewards() {
        // Get a list of ProductRewards
        List<ProductReward> productRewards = this.productRewardService.getAllProductRewards();

        // Convert to ResponseEntity
        if (!productRewards.isEmpty()) {
            // OK
            return ResponseEntity.ok(productRewards);
        } else {
            // No Content
            return ResponseEntity.noContent().build();
        }
    }

    // Get ProductReward by product_reward_id
    @GetMapping("v1/ProductReward/{product_reward_id}")
    public ResponseEntity<ProductReward> getProductRewardByProductRewardId(@PathVariable("product_reward_id") int product_reward_id) {
        Optional<ProductReward> productRewardOptional = this.productRewardService.getProductRewardByProductRewardId(product_reward_id);
        return productRewardOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get ProductRewards by product_id
    @GetMapping("v1/ProductRewards/Product/{product_id}")
    public ResponseEntity<List<ProductReward>> getProductRewardsByProductId(@PathVariable("product_id") int product_id) {
        List<ProductReward> productRewards = this.productRewardService.getProductRewardsByProductId(product_id);
        return ResponseEntity.ok(productRewards);
    }

    // Get ProductRewards by supermarket_id
    @GetMapping("v1/ProductRewards/Supermarket/{supermarket_id}")
    public ResponseEntity<List<ProductReward>> getProductRewardsBySupermarketId(@PathVariable("supermarket_id") int supermarket_id) {
        List<ProductReward> productRewards = this.productRewardService.getProductRewardsBySupermarketId(supermarket_id);
        return ResponseEntity.ok(productRewards);
    }

    // Create new ProductReward TODO: Test this method
    @PostMapping("v1/createProductReward")
    public ResponseEntity<ProductReward> createProductReward(@RequestBody ProductReward productReward) {
        Optional<ProductReward> productRewardOptional = this.productRewardService.createProductReward(productReward);
        return productRewardOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update ProductReward TODO: Test this method
    @PutMapping("v1/updateProductReward")
    public ResponseEntity<ProductReward> updateProductReward(@RequestBody ProductReward productReward) {
        Optional<ProductReward> productRewardOptional = this.productRewardService.updateProductReward(productReward);
        return productRewardOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
