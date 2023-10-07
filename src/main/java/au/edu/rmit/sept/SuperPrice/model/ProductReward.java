package au.edu.rmit.sept.SuperPrice.model;

import java.sql.Timestamp;

public class ProductReward {
    // ProductReward attributes
    private int product_reward_id;
    private int product_id;
    private int supermarket_id;
    private int rewards_points;
    private Timestamp last_updated;

    // Constructors
    public ProductReward() {}

    public ProductReward(int product_reward_id, int product_id, int supermarket_id, int rewards_points, Timestamp last_updated) {
        this.product_reward_id = product_reward_id;
        this.product_id = product_id;
        this.supermarket_id = supermarket_id;
        this.rewards_points = rewards_points;
        this.last_updated = last_updated;
    }


    // Getters
    public int getProductRewardId() {
        return this.product_reward_id;
    }

    public int getProductId() {
        return this.product_id;
    }

    public int getSupermarketId() {
        return this.supermarket_id;
    }

    public int getRewardsPoints() {
        return this.rewards_points;
    }

    public Timestamp getLastUpdated() {
        return this.last_updated;
    }


    // Setters
    public void setProductRewardId(int product_reward_id) {
        this.product_reward_id = product_reward_id;
    }

    public void setProductId(int product_id) {
        this.product_id = product_id;
    }

    public void setSupermarketId(int supermarket_id) {
        this.supermarket_id = supermarket_id;
    }

    public void setRewardsPoints(int rewards_points) {
        this.rewards_points = rewards_points;
    }

    public void setLastUpdated(Timestamp last_updated) {
        this.last_updated = last_updated;
    }
}
