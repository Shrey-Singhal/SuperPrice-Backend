package au.edu.rmit.sept.SuperPrice.repository;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Repository;

import au.edu.rmit.sept.SuperPrice.model.Product;

import java.util.List;
import java.util.Optional;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
// import java.sql.Timestamp;

import javax.sql.DataSource;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    // Create DataSource object
    private DataSource dataSource = DataSourceBuilder.create()
            .driverClassName("com.mysql.cj.jdbc.Driver")
            .url("jdbc:mysql://127.0.0.1:3306/mysql")
            .username("root")
            .password("password")
            .build();
    
    // Find all Products
    @Override
    public List<Product> findAllProducts() {
        String query = "SELECT * FROM Products";

        List<Product> products = new ArrayList<>();

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int product_id = resultSet.getInt("product_id");
                String product_name = resultSet.getString("product_name");
                String product_category = resultSet.getString("product_category");

                Product product = new Product(product_id, product_name, product_category);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    // Find all distinct Product categories
    @Override
    public List<String> findProductCategories() {
        String query = "SELECT DISTINCT product_category FROM Products";

        List<String> productCategories = new ArrayList<>();

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String product_category = resultSet.getString("product_category");
                productCategories.add(product_category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productCategories;
    }


    // Find all Products by product_category
    @Override
    public List<Product> findProductsByCategory(String product_category) {
        String query = "SELECT * FROM Products WHERE product_category = ?";

        List<Product> products = new ArrayList<>();

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, product_category);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int product_id = resultSet.getInt("product_id");
                String product_name = resultSet.getString("product_name");

                Product product = new Product(product_id, product_name, product_category);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }


    // Find Product by product_id
    @Override
    public Optional<Product> findProductById(Long product_id) {
        String query = "SELECT * FROM Products WHERE product_id = ?";

        Optional<Product> productOptional = Optional.empty();

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, product_id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int productId = resultSet.getInt("product_id");
                String product_name = resultSet.getString("product_name");
                String product_category = resultSet.getString("product_category");

                productOptional = Optional.of(new Product(productId, product_name, product_category));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productOptional;
    }


    // Find Product by product_name
    @Override
    public Optional<Product> findProductByProductName(String product_name) {
        String query = "SELECT product_id FROM Products WHERE product_name = ?";

        Optional<Product> productOptional = Optional.empty();

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, product_name);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int product_id = resultSet.getInt("product_id");
                String product_category = resultSet.getString("product_category");

                productOptional = Optional.of(new Product(product_id, product_name, product_category));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productOptional;
    }


    // Save new Product TODO: Test this method
    @Override
    public Optional<Product> saveProduct(Product product) {
        String query = "INSERT INTO Products (product_name, product_category) VALUES (?, ?)";

        Optional<Product> productOptional = Optional.empty();

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setString(2, product.getProductCategory());
            preparedStatement.executeUpdate();

            productOptional = Optional.of(product);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productOptional;
    }

}
