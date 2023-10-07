package au.edu.rmit.sept.SuperPrice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import au.edu.rmit.sept.SuperPrice.service.UserService;
import au.edu.rmit.sept.SuperPrice.model.User;

/**
 * UserController class handles requests for User data
 * Base URL: http://localhost:8080/SuperPrice
 * CrossOrigin: http://localhost:5173
 */
@RestController
@RequestMapping(value = "/SuperPrice/")
@CrossOrigin(value = "http://localhost:5173")
public class UserController {
    // User controller methods for the running of User service methods

    @Autowired
    private UserService userService;

    // Get all Users
    @GetMapping("v1/Users")
    public ResponseEntity<List<User>> getAllUsers() {
        // Get a list of Users
        List<User> users = this.userService.getAllUsers();

        // Convert to ResponseEntity
        if (!users.isEmpty()) {
            // OK
            return ResponseEntity.ok(users);
        } else {
            // No Content
            return ResponseEntity.noContent().build();
        }
    }


    // Get User by email
    @GetMapping("v1/User/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email) {
        Optional<User> userOptional = this.userService.getUserByEmail(email);
        return userOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    

    // Create new User TODO: Test this method
    @PostMapping("v1/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        Optional<User> userOptional = this.userService.createUser(user.getUserName(), user.getUserEmail(), user.getUserPassword());
        return userOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    // Update User TODO: Test this method
    @PutMapping("v1/updateUser")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        Optional<User> userOptional = this.userService.updateUser(user);
        return userOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}