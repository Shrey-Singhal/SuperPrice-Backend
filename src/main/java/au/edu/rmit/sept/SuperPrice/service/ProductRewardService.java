package au.edu.rmit.sept.SuperPrice.service;

import au.edu.rmit.sept.SuperPrice.repository.ProductRewardRepository;
import au.edu.rmit.sept.SuperPrice.model.ProductReward;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductRewardService {
    // ProductReward service methods for the running of ProductReward repository methods

    @Autowired
    private ProductRewardRepository productRewardRepository;

    // Get all ProductRewards
    public List<ProductReward> getAllProductRewards() {
        return this.productRewardRepository.findAllProductRewards();
    }

    // Get ProductReward by product_reward_id
    public Optional<ProductReward> getProductRewardByProductRewardId(int product_reward_id) {
        return this.productRewardRepository.findProductRewardByProductRewardId(product_reward_id);
    }

    // Get ProductReward by product_id
    public List<ProductReward> getProductRewardsByProductId(int product_id) {
        return this.productRewardRepository.findProductRewardsByProductId(product_id);
    }

    // Get ProductReward by supermarket_id
    public List<ProductReward> getProductRewardsBySupermarketId(int supermarket_id) {
        return this.productRewardRepository.findProductRewardsBySupermarketId(supermarket_id);
    }

    // Create new ProductReward TODO: Test this method
    public Optional<ProductReward> createProductReward(ProductReward newProductReward) {
        return this.productRewardRepository.saveProductReward(newProductReward);
    }

    // Update ProductReward TODO: Test this method
    public Optional<ProductReward> updateProductReward(ProductReward productReward) {
        return this.productRewardRepository.updateProductReward(productReward);
    }
}
