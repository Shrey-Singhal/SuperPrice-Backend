package au.edu.rmit.sept.SuperPrice.repository;


import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Repository;
import au.edu.rmit.sept.SuperPrice.model.ProductReward;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.sql.DataSource;


/**
 * ProductRewardsRepositoryImpl class handles database operations related to the ProductRewards table
 */
@Repository
public class ProductRewardRepositoryImpl implements ProductRewardRepository {
    // Implements ProductRewards Repository methods

    // Create DataSource object
    private DataSource dataSource = DataSourceBuilder.create()
            .driverClassName("com.mysql.cj.jdbc.Driver")
            .url("jdbc:mysql://127.0.0.1:3306/mysql")
            .username("root")
            .password("password")
            .build();
    
    // Get all ProductRewards
    @Override
    public List<ProductReward> findAllProductRewards() {
        String query = "SELECT * FROM ProductRewards";

        List<ProductReward> productRewards = new ArrayList<>();

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int product_reward_id = resultSet.getInt("product_reward_id");
                int product_id = resultSet.getInt("product_id");
                int supermarket_id = resultSet.getInt("supermarket_id");
                int rewards_points = resultSet.getInt("rewards_points");
                Timestamp last_updated = resultSet.getTimestamp("last_updated");

                ProductReward productReward = new ProductReward(product_reward_id, product_id, supermarket_id, rewards_points, last_updated);
                productRewards.add(productReward);
            }
        
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productRewards;
    }


    // Get ProductReward by product_reward_id
    @Override
    public Optional<ProductReward> findProductRewardByProductRewardId(int product_reward_id) {
        String query = "SELECT * FROM ProductRewards WHERE product_reward_id = ?";

        Optional<ProductReward> productRewardOptional = Optional.empty();

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, product_reward_id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int product_id = resultSet.getInt("product_id");
                int supermarket_id = resultSet.getInt("supermarket_id");
                int rewards_points = resultSet.getInt("rewards_points");
                Timestamp last_updated = resultSet.getTimestamp("last_updated");

                productRewardOptional = Optional.of(new ProductReward(product_reward_id, product_id, supermarket_id, rewards_points, last_updated));
            }
        
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productRewardOptional;
    }


    // Get ProductReward by product_id
    @Override
    public List<ProductReward> findProductRewardsByProductId(int product_id) {
        String query = "SELECT * FROM ProductRewards WHERE product_id = ?";

        List<ProductReward> productRewards = new ArrayList<>();

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, product_id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int product_reward_id = resultSet.getInt("product_reward_id");
                int supermarket_id = resultSet.getInt("supermarket_id");
                int rewards_points = resultSet.getInt("rewards_points");
                Timestamp last_updated = resultSet.getTimestamp("last_updated");

                ProductReward productReward = new ProductReward(product_reward_id, product_id, supermarket_id, rewards_points, last_updated);
                productRewards.add(productReward);
            }
        
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productRewards;
    }
    

    // Get ProductReward by supermarket_id
    @Override
    public List<ProductReward> findProductRewardsBySupermarketId(int supermarket_id) {
        String query = "SELECT * FROM ProductRewards WHERE supermarket_id = ?";

        List<ProductReward> productRewards = new ArrayList<>();

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, supermarket_id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int product_reward_id = resultSet.getInt("product_reward_id");
                int product_id = resultSet.getInt("product_id");
                int rewards_points = resultSet.getInt("rewards_points");
                Timestamp last_updated = resultSet.getTimestamp("last_updated");

                ProductReward productReward = new ProductReward(product_reward_id, product_id, supermarket_id, rewards_points, last_updated);
                productRewards.add(productReward);
            }
        
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productRewards;
    }


    // Save new ProductReward // TODO: Test this method
    @Override
    public Optional<ProductReward> saveProductReward(ProductReward productReward) {
        String query = "INSERT INTO ProductRewards (product_id, supermarket_id, rewards_points) VALUES (?, ?, ?)";

        Optional<ProductReward> productRewardOptional = Optional.empty();

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, productReward.getProductId());
            preparedStatement.setInt(2, productReward.getSupermarketId());
            preparedStatement.setInt(3, productReward.getRewardsPoints());
            preparedStatement.executeUpdate();

            productRewardOptional = findProductRewardByProductRewardId(productReward.getProductRewardId());
        
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productRewardOptional;
    }


    // Update ProductReward // TODO: Test this method
    @Override
    public Optional<ProductReward> updateProductReward(ProductReward productReward) {
        String query = "UPDATE ProductRewards SET product_id = ?, supermarket_id = ?, rewards_points = ? WHERE product_reward_id = ?";

        Optional<ProductReward> productRewardOptional = Optional.empty();

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, productReward.getProductId());
            preparedStatement.setInt(2, productReward.getSupermarketId());
            preparedStatement.setInt(3, productReward.getRewardsPoints());
            preparedStatement.setInt(5, productReward.getProductRewardId());
            preparedStatement.executeUpdate();

            productRewardOptional = findProductRewardByProductRewardId(productReward.getProductRewardId());
        
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productRewardOptional;
    }

}
