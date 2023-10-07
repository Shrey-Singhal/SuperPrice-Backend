package au.edu.rmit.sept.SuperPrice.repository;

import  au.edu.rmit.sept.SuperPrice.model.ProductReward;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


/**
 * ProductRewardsRepository interface handles database operations related to the ProductRewards table
 */
@Repository
public interface ProductRewardRepository {
    // ProductRewards Repository methods

    // Find all ProductRewards
    List<ProductReward> findAllProductRewards();

    // Find ProductReward by product_reward_id
    Optional<ProductReward> findProductRewardByProductRewardId(int product_reward_id);

    // Find ProductReward by product_id
    List<ProductReward> findProductRewardsByProductId(int product_id);

    // Find ProductReward by supermarket_id
    List<ProductReward> findProductRewardsBySupermarketId(int supermarket_id);

    // Save new ProductReward
    Optional<ProductReward> saveProductReward(ProductReward productReward);

    // Update ProductReward
    Optional<ProductReward> updateProductReward(ProductReward productReward);
}
