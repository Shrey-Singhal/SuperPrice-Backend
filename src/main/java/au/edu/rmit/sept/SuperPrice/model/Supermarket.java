package au.edu.rmit.sept.SuperPrice.model;

public class Supermarket {
    // Supermarket attributes
    private int supermarket_id;
    private String supermarket_name;
    private String supermarket_address;
    private double latitude;
    private double longitude;

    // Constructors
    public Supermarket() {}

    public Supermarket(
            int supermarket_id,
            String supermarket_name,
            String supermarket_address,
            double latitude,
            double longitude) {
        this.supermarket_id = supermarket_id;
        this.supermarket_name = supermarket_name;
        this.supermarket_address = supermarket_address;
        this.latitude = latitude;
        this.longitude = longitude;
    }


    // Getters
    public int getSupermarket_id() {
        return supermarket_id;
    }

    public String getSupermarket_name() {
        return supermarket_name;
    }

    public String getSupermarket_address() {
        return supermarket_address;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }


    // Setters
    public void setSupermarket_id(int supermarket_id) {
        this.supermarket_id = supermarket_id;
    }

    public void setSupermarket_name(String supermarket_name) {
        this.supermarket_name = supermarket_name;
    }

    public void setSupermarket_address(String supermarket_address) {
        this.supermarket_address = supermarket_address;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
