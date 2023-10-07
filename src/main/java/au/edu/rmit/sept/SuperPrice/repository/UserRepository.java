package au.edu.rmit.sept.SuperPrice.repository;

import  au.edu.rmit.sept.SuperPrice.model.User;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * UserRepository interface handles database operations related to the User table
 */
@Repository
public interface UserRepository {
    // User Repository methods

    // Find all Users
    List<User> findAllUsers();

    // Find User by email
    Optional<User> findUserByEmail(String email);

    // Save new User
    Optional<User> saveUser(User user);

    // Update User
    Optional<User> updateUser(User user);
}
