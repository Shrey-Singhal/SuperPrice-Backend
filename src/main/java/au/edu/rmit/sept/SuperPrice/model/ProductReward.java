package au.edu.rmit.sept.SuperPrice.model;

import jakarta.persistence.*;
// import java.sql.Timestamp;

@Entity
@Table(name = "ProductRewards") // Specify table name?
public class ProductReward {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_reward_id", updatable = false)
    private int product_reward_id;
    @Column(name = "product_id", updatable = false)
    private int product_id;
    @Column(name = "supermarket_id", updatable = false)
    private int supermarket_id;
    @Column(name = "rewards_points")
    private int rewards_points;

    // Constructors
    public ProductReward() {}

    public ProductReward(int product_reward_id, int product_id, int supermarket_id, int rewards_points) {
        this.product_reward_id = product_reward_id;
        this.product_id = product_id;
        this.supermarket_id = supermarket_id;
        this.rewards_points = rewards_points;
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
}
