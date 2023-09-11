package au.edu.rmit.sept.SuperPrice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users") // Specify table name?
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;
    private int rewardsPoints;

    // Constructors
    public User() {}

    public User(int id, String name, String email, String password, int rewardsPoints) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.rewardsPoints = rewardsPoints;
    }

    // Getters TODO: Add setters


    // Setters TODO: Add setters
}
