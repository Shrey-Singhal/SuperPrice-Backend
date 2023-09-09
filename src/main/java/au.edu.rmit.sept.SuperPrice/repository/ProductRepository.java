package au.edu.rmit.sept.SuperPrice.repository;

import au.edu.rmit.sept.SuperPrice.model.Product;

import java.util.List;

public interface ProductRepository {
    public List<Product> listAll();
}
