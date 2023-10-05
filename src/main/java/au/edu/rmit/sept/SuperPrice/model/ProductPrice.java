package au.edu.rmit.sept.SuperPrice.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "ProductPrices") // Specify table name?
public class ProductPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_price_id", updatable = false)
    private int product_price_id;
    @Column(name = "product_id", updatable = false)
    private int product_id;
    @Column(name = "supermarket_id", updatable = false)
    private int supermarket_id;
    @Column(name = "product_price")
    private double product_price;
    @Column(name = "last_updated")
    private Timestamp last_updated;

    // Constructors
    public ProductPrice() {}

    public ProductPrice(int product_price_id, int product_id, int supermarket_id, double product_price, Timestamp last_updated) {
        this.product_price_id = product_price_id;
        this.product_id = product_id;
        this.supermarket_id = supermarket_id;
        this.product_price = product_price;
        this.last_updated = last_updated;
    }

    // Getters
    public int getProductPriceId() {
        return this.product_price_id;
    }

    public int getProductId() {
        return this.product_id;
    }

    public int getSupermarketId() {
        return this.supermarket_id;
    }

    public double getProductPrice() {
        return this.product_price;
    }

    public Timestamp getLastUpdated() {
        return this.last_updated;
    }


    // Setters
    public void setProductPriceId(int product_price_id) {
        this.product_price_id = product_price_id;
    }

    public void setProductId(int product_id) {
        this.product_id = product_id;
    }

    public void setSupermarketId(int supermarket_id) {
        this.supermarket_id = supermarket_id;
    }

    public void setProductPrice(double product_price) {
        this.product_price = product_price;
    }

    public void setLastUpdated(Timestamp last_updated) {
        this.last_updated = last_updated;
    }
}
