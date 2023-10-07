package au.edu.rmit.sept.SuperPrice.service;

import au.edu.rmit.sept.SuperPrice.repository.UserRepository;
import au.edu.rmit.sept.SuperPrice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    // User service methods for the running of User repository methods

    @Autowired
    private UserRepository userRepository;

    // Get all Users
    public List<User> getAllUsers() {
        return this.userRepository.findAllUsers();
    }


    // Get User by email
    public Optional<User> getUserByEmail(String email) {
        Optional<User> user = this.userRepository.findUserByEmail(email);
        return user;
    }


    // Create new User TODO: Test this method
    public Optional<User> createUser(String user_name, String email, String password_hash) {
        User newUser = new User();
        newUser.setUserName(user_name);
        newUser.setUserEmail(email);
        newUser.setUserPassword(password_hash);

        return this.userRepository.saveUser(newUser);
    }


    // Update User TODO: Test this method
    public Optional<User> updateUser(User user) {
        return this.userRepository.updateUser(user);
    }
}
