package au.edu.rmit.sept.SuperPrice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Orders") // Specify table name?
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userId;
    private int deliveryAddressId;
    private String orderStatus;
    private double orderTotalPrice;
    private double orderTotalRewards;

    // Constructors
    public Order() {}

    public Order(int orderId, int userId, int deliverAddressId, String orderStatus, double orderTotalPrice, double orderTotalRewards) {
        this.id = orderId;
        this.userId = userId;
        this.deliveryAddressId = deliverAddressId;
        this.orderStatus = orderStatus;
        this.orderTotalPrice = orderTotalPrice;
        this.orderTotalRewards = orderTotalRewards;
    }

    // Getters TODO: Add getters

    // Setters TODO: Add setters

}
