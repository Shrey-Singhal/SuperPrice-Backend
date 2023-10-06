package au.edu.rmit.sept.SuperPrice.repository;

import  au.edu.rmit.sept.SuperPrice.model.User;
// import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository {
    // User Repository methods (Table queries)

    // Get all Users
    List<User> findAll();

    // Get User by email
    Optional<User> findUserByEmail(String email);

    // Create new User
    Optional<User> saveUser(User user);
}
