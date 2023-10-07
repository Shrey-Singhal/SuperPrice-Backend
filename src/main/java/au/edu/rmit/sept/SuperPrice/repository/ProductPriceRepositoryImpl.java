package au.edu.rmit.sept.SuperPrice.repository;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Repository;
import au.edu.rmit.sept.SuperPrice.model.ProductPrice;

import java.util.List;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.sql.DataSource;


/**
 * ProductPriceRepositoryImpl class handles the retrieval of ProductPrice data from the database
 */
@Repository
public class ProductPriceRepositoryImpl implements ProductPriceRepository {
    // Create DataSource object
    private DataSource dataSource = DataSourceBuilder.create()
            .driverClassName("com.mysql.cj.jdbc.Driver")
            .url("jdbc:mysql://127.0.0.1:3306/mysql")
            .username("root")
            .password("password")
            .build();

    // Get all ProductPrices
    @Override
    public List<ProductPrice> retrieveAllProductPrices() {
        String query = "SELECT * FROM ProductPrices";

        List<ProductPrice> productPrices = new ArrayList<>();

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int product_price_id = resultSet.getInt("product_price_id");
                int product_id = resultSet.getInt("product_id");
                int supermarket_id = resultSet.getInt("supermarket_id");
                double product_price = resultSet.getDouble("product_price");
                Timestamp last_updated = resultSet.getTimestamp("last_updated");

                ProductPrice productPrice = new ProductPrice(product_price_id, product_id, supermarket_id, product_price, last_updated);
                productPrices.add(productPrice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productPrices;
    }

    // Get ProductPrices by product_id
    @Override
    public List<ProductPrice> retrieveProductPricesByProductId(int product_id) {
        String query = "SELECT * FROM ProductPrices WHERE product_id = ?";

        List<ProductPrice> productPrices = new ArrayList<>();

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, product_id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int product_price_id = resultSet.getInt("product_price_id");
                int supermarket_id = resultSet.getInt("supermarket_id");
                double product_price = resultSet.getDouble("product_price");
                Timestamp last_updated = resultSet.getTimestamp("last_updated");

                ProductPrice productPrice = new ProductPrice(product_price_id, product_id, supermarket_id, product_price, last_updated);
                productPrices.add(productPrice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productPrices;
    }

    // Get ProductPrices by supermarket_id
    @Override
    public List<ProductPrice> retrieveProductPricesBySupermarketId(int supermarket_id) {
        String query = "SELECT * FROM ProductPrices WHERE supermarket_id = ?";

        List<ProductPrice> productPrices = new ArrayList<>();

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, supermarket_id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int product_price_id = resultSet.getInt("product_price_id");
                int product_id = resultSet.getInt("product_id");
                double product_price = resultSet.getDouble("product_price");
                Timestamp last_updated = resultSet.getTimestamp("last_updated");

                ProductPrice productPrice = new ProductPrice(product_price_id, product_id, supermarket_id, product_price, last_updated);
                productPrices.add(productPrice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productPrices;
    }

}
