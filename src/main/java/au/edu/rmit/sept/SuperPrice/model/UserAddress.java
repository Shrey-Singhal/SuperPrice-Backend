package au.edu.rmit.sept.SuperPrice.model;

public class UserAddress {
    private int user_address_id;
    private int user_id;
    private String address;
//    private double latitude;
//    private double longitude;

    // Constructors
    public UserAddress() {}

    public UserAddress(int user_address_id, int user_id, String address) {
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
