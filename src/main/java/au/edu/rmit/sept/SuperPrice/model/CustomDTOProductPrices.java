package au.edu.rmit.sept.SuperPrice.model;

public class CustomDTOProductPrices {
    // Custom DTO variables
    private int product_id;
    private String product_name;
    private String product_category;
    private int product_price_id;
    private double product_price;
    private int rewards_points;
    private int supermarket_id;
    private String supermarket_name;
    private String supermarket_address;

    // Constructors
    public CustomDTOProductPrices() {}
    public CustomDTOProductPrices(int product_id, String product_name, String product_category, int supermarket_id, String supermarket_name, String supermarket_address, int product_price_id, double product_price, int rewards_points) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_category = product_category;
        this.product_price_id = product_price_id;
        this.product_price = product_price;
        this.rewards_points = rewards_points;
        this.supermarket_id = supermarket_id;
        this.supermarket_name = supermarket_name;
        this.supermarket_address = supermarket_address;
        //this.rewards_points = (int) Math.round(product_price * 0.1);
    }

    // Setters & Getters
    public int getProduct_id() {
        return this.product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return this.product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_category() {
        return this.product_category;
    }

    public void setProduct_category(String product_category) {
        this.product_category = product_category;
    }

    public int getSupermarket_id() {
        return this.supermarket_id;
    }

    public void setSupermarket_id(int supermarket_id) {
        this.supermarket_id = supermarket_id;
    }

    public String getSupermarket_name() {
        return this.supermarket_name;
    }

    public void setSupermarket_name(String supermarket_name) {
        this.supermarket_name = supermarket_name;
    }

    public String getSupermarket_address() {
        return this.supermarket_address;
    }

    public void setSupermarket_address(String supermarket_address) {
        this.supermarket_address = supermarket_address;
    }

    public int getProduct_price_id() {
        return this.product_price_id;
    }

    public void setProduct_price_id(int product_price_id) {
        this.product_price_id = product_price_id;
    }

    public double getProduct_price() {
        return this.product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    public int getRewards_points() {
        return this.rewards_points;
    }

    public void setRewards_points(int rewards_points) {
        this.rewards_points = rewards_points;
    }
}
