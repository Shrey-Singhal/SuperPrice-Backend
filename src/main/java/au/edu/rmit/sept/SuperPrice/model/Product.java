package au.edu.rmit.sept.SuperPrice.model;

public class Product {
    // Product attributes
    private int product_id;
    private String product_name;
    private String product_category;

    // Constructors
    public Product() {}

    public Product(int product_id, String product_name, String product_category) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_category = product_category;
    }


    // Getters
    public int getProductId() {
        return this.product_id;
    }

    public String getProductName() {
        return this.product_name;
    }

    public String getProductCategory() {
        return this.product_category;
    }


    // Setters
    public void setProductId(int product_id) {
        this.product_id = product_id;
    }

    public void setProductName(String product_name) {
        this.product_name = product_name;
    }

    public void setProductCategory(String product_category) {
        this.product_category = product_category;
    }
}
