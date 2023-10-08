package au.edu.rmit.sept.SuperPrice.repository;

// import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Repository;
import au.edu.rmit.sept.SuperPrice.config.DataSourceConfig;
import au.edu.rmit.sept.SuperPrice.model.Supermarket;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;


/**
 * SupermarketRepositoryImpl class handles database operations related to the Supermarket table
 */
@Repository
public class SupermarketRepositoryImpl implements SupermarketRepository {
    // Implements Supermarket Repository methods

    // Create DataSource object
    private DataSource dataSource = DataSourceConfig.getDataSource();
    
    // Get all Supermarkets
    @Override
    public List<Supermarket> findAllSupermarkets() {
        String query = "SELECT * FROM Supermarkets";

        List<Supermarket> supermarkets = new ArrayList<>();

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int supermarket_id = resultSet.getInt("supermarket_id");
                String supermarket_name = resultSet.getString("supermarket_name");
                String supermarket_address = resultSet.getString("supermarket_address");
                double latitude = resultSet.getDouble("latitude");
                double longitude = resultSet.getDouble("longitude");

                Supermarket supermarket = new Supermarket(supermarket_id, supermarket_name, supermarket_address, latitude, longitude);
                supermarkets.add(supermarket);
            }
        
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return supermarkets;
    }


    // Get Supermarket by id
    @Override
    public Optional<Supermarket> findSupermarketById(int id) {
        String query = "SELECT * FROM Supermarkets WHERE supermarket_id = ?";

        Optional<Supermarket> supermarketOptional = Optional.empty();

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String supermarket_name = resultSet.getString("supermarket_name");
                String supermarket_address = resultSet.getString("supermarket_address");
                double latitude = resultSet.getDouble("latitude");
                double longitude = resultSet.getDouble("longitude");

                supermarketOptional = Optional.of(new Supermarket(id, supermarket_name, supermarket_address, latitude, longitude));
            }
        
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return supermarketOptional;
    }


    // Get Supermarket by name
    @Override
    public Optional<Supermarket> findSupermarketByName(String name) {
        String query = "SELECT * FROM Supermarkets WHERE supermarket_name = ?";

        Optional<Supermarket> supermarketOptional = Optional.empty();

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int supermarket_id = resultSet.getInt("supermarket_id");
                String supermarket_address = resultSet.getString("supermarket_address");
                double latitude = resultSet.getDouble("latitude");
                double longitude = resultSet.getDouble("longitude");

                supermarketOptional = Optional.of(new Supermarket(supermarket_id, name, supermarket_address, latitude, longitude));
            }
        
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return supermarketOptional;
    }


    // Create new Supermarket
    @Override
    public Optional<Supermarket> saveSupermarket(Supermarket supermarket) {
        String query = "INSERT INTO Supermarkets (supermarket_name, supermarket_address, supermarket_suburb, supermarket_state, supermarket_postcode, supermarket_phone, supermarket_email, supermarket_password_hash, supermarket_rewards_points) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Optional<Supermarket> supermarketOptional = Optional.empty();

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, supermarket.getSupermarket_name());
            preparedStatement.setString(2, supermarket.getSupermarket_address());
            preparedStatement.setDouble(3, supermarket.getLatitude());
            preparedStatement.setDouble(4, supermarket.getLongitude());
            preparedStatement.executeUpdate();

            supermarketOptional = findSupermarketByName(supermarket.getSupermarket_name());
        
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return supermarketOptional;
    }
}
