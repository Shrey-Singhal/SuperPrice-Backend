package au.edu.rmit.sept.SuperPrice.repository;

import au.edu.rmit.sept.SuperPrice.model.Order;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * OrderRepositoryImpl class handles database operations related to the Order table
 */
@Repository
public class OrderRepositoryImpl implements OrderRepository {
    // Implements Order Repository methods

    // Create DataSource object
    private DataSource dataSource = DataSourceBuilder.create()
            .driverClassName("com.mysql.cj.jdbc.Driver")
            .url("jdbc:mysql://127.0.0.1:3306/mysql")
            .username("root")
            .password("password")
            .build();
    
    // Get all Orders
    public List<Order> findAllOrders() {
        String query = "SELECT * FROM Orders";

        List<Order> orders = new ArrayList<>();

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int order_id = resultSet.getInt("order_id");
                int user_id = resultSet.getInt("user_id");
                int order_total_price = resultSet.getInt("order_total_price");
                int order_total_rewards = resultSet.getInt("order_total_rewards");
                Timestamp order_date = resultSet.getTimestamp("order_date");
                String order_status = resultSet.getString("order_status");

                Order order = new Order(order_id, user_id, order_status, order_total_price, order_total_rewards, order_date);
                orders.add(order);
            }
        
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }


    // Get Order by order_id
    public Optional<Order> findOrderByOrderId(int order_id) {
        String query = "SELECT * FROM Orders WHERE order_id = ?";

        Optional<Order> orderOptional = Optional.empty();

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, order_id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int user_id = resultSet.getInt("user_id");
                int order_total_price = resultSet.getInt("order_total_price");
                int order_total_rewards = resultSet.getInt("order_total_rewards");
                Timestamp order_date = resultSet.getTimestamp("order_date");
                String order_status = resultSet.getString("order_status");

                orderOptional = Optional.of(new Order(order_id, user_id, order_status, order_total_price, order_total_rewards, order_date));
            }
        
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderOptional;
    }


    // Save new Order TODO: Test this method
    public Optional<Order> saveOrder(Order order) {
        String query = "INSERT INTO Orders (user_id, order_status, order_total_price, order_total_rewards, order_date) VALUES (?, ?, ?, ?, ?)";

        Optional<Order> orderOptional = Optional.empty();

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, order.getUserId());
            preparedStatement.setString(2, order.getOrderStatus());
            preparedStatement.setDouble(3, order.getOrderPrice());
            preparedStatement.setInt(4, order.getOrderRewards());
            preparedStatement.setTimestamp(5, order.getOrderDate());
            preparedStatement.executeUpdate();

            orderOptional = findOrderByOrderId(order.getOrderId());
        
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderOptional;
    }


    // Update Order TODO: Test this method
    public Optional<Order> updateOrder(Order order) {
        String query = "UPDATE Orders SET order_status = ?, order_total_price = ?, order_total_rewards = ? WHERE order_id = ?";

        Optional<Order> orderOptional = Optional.empty();

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, order.getOrderStatus());
            preparedStatement.setDouble(2, order.getOrderPrice());
            preparedStatement.setInt(3, order.getOrderRewards());
            preparedStatement.setInt(4, order.getOrderId());
            preparedStatement.executeUpdate();

            orderOptional = findOrderByOrderId(order.getOrderId());
        
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderOptional;
    }
}
