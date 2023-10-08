package au.edu.rmit.sept.SuperPrice.repository;

// import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Repository;
import au.edu.rmit.sept.SuperPrice.config.DataSourceConfig;
import au.edu.rmit.sept.SuperPrice.model.User;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;


/**
 * UserRepositoryImpl class handles database operations related to the User table
 */
@Repository
public class UserRepositoryImpl implements UserRepository {
    // Implements User Repository methods

    // Create DataSource object
    private DataSource dataSource = DataSourceConfig.getDataSource();

    // Get all Users
    @Override
    public List<User> findAllUsers() {
        String query = "SELECT * FROM Users";

        List<User> users = new ArrayList<>();

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int user_id = resultSet.getInt("user_id");
                String user_name = resultSet.getString("user_name");
                String email = resultSet.getString("email");
                String password_hash = resultSet.getString("password_hash");
                int user_rewards_points = resultSet.getInt("user_rewards_points");

                User user = new User(user_id, user_name, email, password_hash, user_rewards_points);
                users.add(user);
            }
        
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    // Get User by email
    @Override
    public Optional<User> findUserByEmail(String email) {
        String query = "SELECT * FROM Users WHERE email = ?";

        Optional<User> user = Optional.empty();

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int user_id = resultSet.getInt("user_id");
                String user_name = resultSet.getString("user_name");
                String password_hash = resultSet.getString("password_hash");
                int user_rewards_points = resultSet.getInt("user_rewards_points");

                // Create Optional container object & add User object to it if it exists
                user = Optional.of(new User(user_id, user_name, email, password_hash, user_rewards_points));
            }
        
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }


    // Create new User TODO: Test this method
    @Override
    public Optional<User> saveUser(User user) {
        String query = "INSERT INTO Users (user_name, email, password_hash) VALUES (?, ?, ?)";

        Optional<User> userOptional = Optional.empty();

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getUserEmail());
            preparedStatement.setString(3, user.getUserPassword());
            preparedStatement.executeUpdate();

            // Get the newly created User from the database and return it
            userOptional = findUserByEmail(user.getUserEmail());
        
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userOptional;
    }


    // Update User TODO: Test this method
    @Override
    public Optional<User> updateUser(User user) {
        String query = "UPDATE Users SET user_name = ?, email = ?, password_hash = ?, user_rewards_points = ? WHERE user_id = ?";

        Optional<User> userOptional = Optional.empty();

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getUserEmail());
            preparedStatement.setString(3, user.getUserPassword());
            preparedStatement.setInt(4, user.getUserRewardsPoints());
            preparedStatement.setInt(5, user.getUserId());
            preparedStatement.executeUpdate();

            userOptional = findUserByEmail(user.getUserEmail());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userOptional;
    }

}
