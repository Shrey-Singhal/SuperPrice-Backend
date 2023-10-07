package au.edu.rmit.sept.SuperPrice.service;

import au.edu.rmit.sept.SuperPrice.repository.ProductRewardRepositoryImpl;
import au.edu.rmit.sept.SuperPrice.model.ProductReward;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductRewardService {
    // ProductReward service methods for the running of ProductReward repository methods

    @Autowired
    private ProductRewardRepositoryImpl productRewardRepositoryImpl;

    // Get all ProductRewards
    public List<ProductReward> getAllProductRewards() {
        return this.productRewardRepositoryImpl.findAllProductRewards();
    }

    // Get ProductReward by product_reward_id
    public Optional<ProductReward> getProductRewardByProductRewardId(int product_reward_id) {
        return this.productRewardRepositoryImpl.findProductRewardByProductRewardId(product_reward_id);
    }

    // Get ProductReward by product_id
    public List<ProductReward> getProductRewardsByProductId(int product_id) {
        return this.productRewardRepositoryImpl.findProductRewardsByProductId(product_id);
    }

    // Get ProductReward by supermarket_id
    public List<ProductReward> getProductRewardsBySupermarketId(int supermarket_id) {
        return this.productRewardRepositoryImpl.findProductRewardsBySupermarketId(supermarket_id);
    }

    // Create new ProductReward TODO: Test this method
    public Optional<ProductReward> createProductReward(ProductReward newProductReward) {
        return this.productRewardRepositoryImpl.saveProductReward(newProductReward);
    }

    // Update ProductReward TODO: Test this method
    public Optional<ProductReward> updateProductReward(ProductReward productReward) {
        return this.productRewardRepositoryImpl.updateProductReward(productReward);
    }
}
