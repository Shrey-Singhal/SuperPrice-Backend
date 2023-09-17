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
    private int user_id;
    private String user_name;
    private String email;
    private String password_hash;
    private int user_rewards_points;

    // Constructors
    public User() {}

    public User(int user_id, String user_name, String email, String password_hash, int user_rewards_points) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.email = email;
        this.password_hash = password_hash;
        this.user_rewards_points = user_rewards_points;
    }

    // Getters
    public int getUserId() {
        return this.user_id;
    }

    public String getUserName() {
        return this.user_name;
    }

    public String getUserEmail() {
        return this.email;
    }

    public String getUserPassword() {
        return this.password_hash;
    }

    public int getUserRewardsPoints() {
        return this.user_rewards_points;
    }


    // Setters
    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public void setUserName(String user_name) {
        this.user_name = user_name;
    }

    public void setUserEmail(String email) {
        this.email = email;
    }

    public void setUserPassword(String password_hash) {
        this.password_hash = password_hash;
    }

    public void setUserRewardsPoints(int user_rewards_points) {
        this.user_rewards_points = user_rewards_points;
    }


    // TODO: Add any additional methods as needed

}
