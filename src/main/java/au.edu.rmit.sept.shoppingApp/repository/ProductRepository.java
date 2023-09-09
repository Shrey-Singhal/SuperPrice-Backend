package au.edu.rmit.sept.shoppingApp.repository;

import au.edu.rmit.sept.shoppingApp.model.Product;

import java.util.List;

public interface ProductRepository {
    public List<Product> listAll();
}
