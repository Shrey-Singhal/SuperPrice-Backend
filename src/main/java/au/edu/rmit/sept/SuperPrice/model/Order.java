package au.edu.rmit.sept.SuperPrice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;

@Entity
@Table(name = "Orders") // Specify table name?
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_id;
    private int user_id;
//    private int delivery_address_id;
    private String order_status;
    private double order_total_price;
    private int order_total_rewards;
    private Timestamp order_date;

    // Constructors
    public Order() {}

    public Order(int user_id) {
        this.user_id = user_id;
    }

    public Order(int order_id, int user_id, String order_status, double order_total_price, int order_total_rewards, Timestamp order_date) {
        this.order_id = order_id;
        this.user_id = user_id;
//        this.delivery_address_id = delivery_address_id;
        this.order_status = order_status;
        this.order_total_price = order_total_price;
        this.order_total_rewards = order_total_rewards;
        this.order_date = order_date;
    }

    // Getters
    public int getOrderId() {
        return this.order_id;
    }

    public int getUserId() {
        return this.user_id;
    }

//    public int getDeliveryAddressId() {
//        return this.delivery_address_id;
//    }

    public String getOrderStatus() {
        return this.order_status;
    }

    public double getOrderPrice() {
        return this.order_total_price;
    }

    public int getOrderRewards() {
        return this.order_total_rewards;
    }

    public Timestamp getOrderDate() {
        return this.order_date;
    }


    // Setters
    public void setOrderId(int order_id) {
        this.order_id = order_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

//    public void setDeliveryAddressId(int delivery_address_id) {
//        this.delivery_address_id = delivery_address_id;
//    }

    public void setOrderStatus(String order_status) {
        this.order_status = order_status;
    }

    public void setOrderPrice(double order_total_price) {
        this.order_total_price = order_total_price;
    }

    public void setOrderRewards(int order_total_rewards) {
        this.order_total_rewards = order_total_rewards;
    }

}
