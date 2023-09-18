package au.edu.rmit.sept.SuperPrice.controller;

import java.sql.Timestamp;

public class ControllerFilters {
    // Filter variables
    private int product_id;
    private String product_name;
    private String product_category;
    private int supermarket_id;
    private int product_price_id;
    private double product_price;
    private String user_name;
    private String email;
    private String password_hash;
    private int user_rewards_points;
    private int order_id;
    private String order_status;
    private double order_total_price;
    private int order_total_rewards;
    private Timestamp order_date;

    // Setters & Getters
    public int getProductId() {
        return this.product_id;
    }

    public void setProductId(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_category() {
        return product_category;
    }

    public void setProduct_category(String product_category) {
        this.product_category = product_category;
    }

    public int getSupermarket_id() {
        return supermarket_id;
    }

    public void setSupermarket_id(int supermarket_id) {
        this.supermarket_id = supermarket_id;
    }

    public int getProduct_price_id() {
        return product_price_id;
    }

    public void setProduct_price_id(int product_price_id) {
        this.product_price_id = product_price_id;
    }

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public int getUser_rewards_points() {
        return user_rewards_points;
    }

    public void setUser_rewards_points(int user_rewards_points) {
        this.user_rewards_points = user_rewards_points;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public double getOrder_total_price() {
        return order_total_price;
    }

    public void setOrder_total_price(double order_total_price) {
        this.order_total_price = order_total_price;
    }

    public int getOrder_total_rewards() {
        return order_total_rewards;
    }

    public void setOrder_total_rewards(int order_total_rewards) {
        this.order_total_rewards = order_total_rewards;
    }

    public Timestamp getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Timestamp order_date) {
        this.order_date = order_date;
    }
}
