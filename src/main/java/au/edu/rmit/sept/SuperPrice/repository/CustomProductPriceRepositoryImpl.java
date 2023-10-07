package au.edu.rmit.sept.SuperPrice.repository;

import au.edu.rmit.sept.SuperPrice.model.CustomDTOProductPrices;
// import jakarta.persistence.EntityManager;
// import jakarta.persistence.PersistenceContext;
// import jakarta.persistence.TypedQuery;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
// import javax.xml.crypto.Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;

/**
 * Custom repository class handles custom queries returning aggregated data for ProductPrices & related tables
 */
@Repository
public class CustomProductPriceRepositoryImpl implements CustomProductPriceRepository {
    // Create DataSource object
    private DataSource dataSource = DataSourceBuilder.create()
            .driverClassName("com.mysql.cj.jdbc.Driver")
            .url("jdbc:mysql://127.0.0.1:3306/mysql")
            .username("root")
            .password("password")
            .build();
    
    // CUSTOM PRODUCTPRICES REPOSITORY METHODS

    // Get custom ProductPrices data by selected product_id (related Products, ProductPrices, ProductRewards & Supermarkets data)
    @Override
    public List<CustomDTOProductPrices> retrieveProductPricesByProductId(int product_id) {
        // Custom query joining Product, ProductPrices, & Supermarkets tables for given product_id
        String query = "SELECT p.product_id, p.product_name, p.product_category, pp.product_price_id, pp.product_price, pr.rewards_points, s.supermarket_id, s.supermarket_name, s.supermarket_address " +
                "FROM Products p " +
                "INNER JOIN ProductPrices pp ON p.product_id = pp.product_id " +
                "INNER JOIN Supermarkets s ON pp.supermarket_id = s.supermarket_id " +
                "INNER JOIN ProductRewards pr ON pp.supermarket_id = pr.supermarket_id AND pp.product_id = pr.product_id " +
                "WHERE p.product_id = ?";
        
        // Store query results
        List<CustomDTOProductPrices> customQueryData = new ArrayList<>();

        // Execute query
        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, product_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            // Process query results
            while (resultSet.next()) {
                CustomDTOProductPrices customDTOProductPrices = new CustomDTOProductPrices();
                customDTOProductPrices.setProduct_id(resultSet.getInt("product_id"));
                customDTOProductPrices.setProduct_name(resultSet.getString("product_name"));
                customDTOProductPrices.setProduct_category(resultSet.getString("product_category"));
                customDTOProductPrices.setProduct_price_id(resultSet.getInt("product_price_id"));
                customDTOProductPrices.setProduct_price(resultSet.getDouble("product_price"));
                customDTOProductPrices.setRewards_points(resultSet.getInt("rewards_points"));
                customDTOProductPrices.setSupermarket_id(resultSet.getInt("supermarket_id"));
                customDTOProductPrices.setSupermarket_name(resultSet.getString("supermarket_name"));
                customDTOProductPrices.setSupermarket_address(resultSet.getString("supermarket_address"));
                customQueryData.add(customDTOProductPrices);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customQueryData;
    }


    // Get Products, ProductPrices, ProductRewards & Supermarket data for selected supermarket_id
    @Override
    public List<CustomDTOProductPrices> retrieveProductPricesBySupermarketId(int supermarket_id) {
        // Custom query joining Product, ProductPrices, & Supermarkets tables by given supermarket_id
        String query = "SELECT p.product_id, p.product_name, p.product_category, pp.product_price_id, pp.product_price, pr.rewards_points, s.supermarket_id, s.supermarket_name, s.supermarket_address " +
                "FROM Products p " +
                "INNER JOIN ProductPrices pp ON p.product_id = pp.product_id " +
                "INNER JOIN Supermarkets s ON pp.supermarket_id = s.supermarket_id " +
                "INNER JOIN ProductRewards pr ON pp.supermarket_id = pr.supermarket_id AND pp.product_id = pr.product_id " +
                "WHERE s.supermarket_id = ?";

        // Store query results
        List<CustomDTOProductPrices> customQueryData = new ArrayList<>();

        // Execute query
        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, supermarket_id);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Process query results
            while (resultSet.next()) {
                CustomDTOProductPrices customDTOProductPrices = new CustomDTOProductPrices();
                customDTOProductPrices.setProduct_id(resultSet.getInt("product_id"));
                customDTOProductPrices.setProduct_name(resultSet.getString("product_name"));
                customDTOProductPrices.setProduct_category(resultSet.getString("product_category"));
                customDTOProductPrices.setProduct_price_id(resultSet.getInt("product_price_id"));
                customDTOProductPrices.setProduct_price(resultSet.getDouble("product_price"));
                customDTOProductPrices.setRewards_points(resultSet.getInt("rewards_points"));
                customDTOProductPrices.setSupermarket_id(resultSet.getInt("supermarket_id"));
                customDTOProductPrices.setSupermarket_name(resultSet.getString("supermarket_name"));
                customDTOProductPrices.setSupermarket_address(resultSet.getString("supermarket_address"));
                customQueryData.add(customDTOProductPrices);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customQueryData;
    }


    // Get distinct product categories for given supermarket_id
    @Override
    public List<CustomDTOProductPrices> retrieveProductCategoriesBySupermarketId(int supermarket_id) {
        // Custom query joining Product, ProductPrices, & Supermarkets tables by given supermarket_id
        String query = "SELECT DISTINCT p.product_category " +
                "FROM Products p " +
                "INNER JOIN ProductPrices pp ON p.product_id = pp.product_id " +
                "INNER JOIN Supermarkets s ON pp.supermarket_id = s.supermarket_id " +
                "INNER JOIN ProductRewards pr ON pp.supermarket_id = pr.supermarket_id AND pp.product_id = pr.product_id " +
                "WHERE s.supermarket_id = ?";

        // Store query results
        List<CustomDTOProductPrices> customQueryData = new ArrayList<>();

        // Execute query
        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, supermarket_id);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Process query results
            while (resultSet.next()) {
                CustomDTOProductPrices customDTOProductPrices = new CustomDTOProductPrices();
                customDTOProductPrices.setProduct_category(resultSet.getString("product_category"));
                customQueryData.add(customDTOProductPrices);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customQueryData;
    }


    // Get products, product prices, & product rewards for selected category & supermarket_id
    @Override
    public List<CustomDTOProductPrices> retrieveProductPricesBySupermarketIdAndProductCategory(int supermarket_id, String product_category) {
        // Custom query joining Product, ProductPrices, & Supermarkets tables by given product_category & supermarket_id
        String query = "SELECT p.product_id, p.product_name, p.product_category, pp.product_price_id, pp.product_price, pr.rewards_points, s.supermarket_id, s.supermarket_name, s.supermarket_address " +
                "FROM Products p " +
                "INNER JOIN ProductPrices pp ON p.product_id = pp.product_id " +
                "INNER JOIN Supermarkets s ON pp.supermarket_id = s.supermarket_id " +
                "INNER JOIN ProductRewards pr ON pp.supermarket_id = pr.supermarket_id AND pp.product_id = pr.product_id " +
                "WHERE s.supermarket_id = ? AND LOWER(p.product_category) = LOWER(?)";

        // Store query results
        List<CustomDTOProductPrices> customQueryData = new ArrayList<>();

        // Execute query
        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, supermarket_id);
            preparedStatement.setString(2, product_category);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Process query results
            while (resultSet.next()) {
                CustomDTOProductPrices customDTOProductPrices = new CustomDTOProductPrices();
                customDTOProductPrices.setProduct_id(resultSet.getInt("product_id"));
                customDTOProductPrices.setProduct_name(resultSet.getString("product_name"));
                customDTOProductPrices.setProduct_category(resultSet.getString("product_category"));
                customDTOProductPrices.setProduct_price_id(resultSet.getInt("product_price_id"));
                customDTOProductPrices.setProduct_price(resultSet.getDouble("product_price"));
                customDTOProductPrices.setRewards_points(resultSet.getInt("rewards_points"));
                customDTOProductPrices.setSupermarket_id(resultSet.getInt("supermarket_id"));
                customDTOProductPrices.setSupermarket_name(resultSet.getString("supermarket_name"));
                customDTOProductPrices.setSupermarket_address(resultSet.getString("supermarket_address"));
                customQueryData.add(customDTOProductPrices);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customQueryData;
    }

}
