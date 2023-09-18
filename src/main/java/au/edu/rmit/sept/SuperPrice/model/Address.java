package au.edu.rmit.sept.SuperPrice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "UserAddresses") // Specify table name
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_address_id;
    private int user_id;
    private String address;
//    private double latitude;
//    private double longitude;

    // Constructors
    public Address() {}

    public Address(int user_address_id, int user_id, String address) {
        this.user_address_id = user_address_id;
        this.user_id = user_id;
        this.address = address;
    }

    // Getters
    public int getUserAddressId() {
        return this.user_address_id;
    }

    public int getUserId() {
        return this.user_id;
    }

    public String getUserAddress() {
        return this.address;
    }


    // Setters
    public void setUserAddressId(int user_address_id) {
        this.user_address_id = user_address_id;
    }

    public void setUserAddressUserId(int user_id) {
        this.user_id = user_id;
    }

    public void setUserAddress(String address) {
        this.address = address;
    }
}
