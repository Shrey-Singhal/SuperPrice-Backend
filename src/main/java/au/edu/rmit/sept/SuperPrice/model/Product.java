package au.edu.rmit.sept.SuperPrice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Products") // Specify table name
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_id;
    private String product_name;
    private String product_category;

    // Constructors
    public Product() {}

    public Product(int id, String name, String category) {
        this.product_id = id;
        this.product_name = name;
        this.product_category = category;
    }

    public int getId() {
        return this.product_id;
    }

    public String getName() {
        return this.product_name;
    }

    public String getCategory() {
        return this.product_category;
    }

    public String getProduct() {
        return String.format("Product id: %d, name: %s, category: %s", this.product_id, this.product_name, this.product_category);
    }
}
