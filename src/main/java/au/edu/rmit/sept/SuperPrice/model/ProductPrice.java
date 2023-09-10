package au.edu.rmit.sept.SuperPrice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "ProductPrices") // Specify table name?
public class ProductPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int productId;
    private int superMarketId;
    private double productPrice;
    private Timestamp lastUpdated;

    // Constructors
    public ProductPrice() {}

    public ProductPrice(int productPriceId, int productId, int superMarketId, double productPrice, Timestamp lastUpdated) {
        this.id = productPriceId;
        this.productId = productId;
        this.superMarketId = superMarketId;
        this.productPrice = productPrice;
        this.lastUpdated = lastUpdated;
    }

    // Getters TODO: Add getters

    // Setters TODO: Add setters

}
