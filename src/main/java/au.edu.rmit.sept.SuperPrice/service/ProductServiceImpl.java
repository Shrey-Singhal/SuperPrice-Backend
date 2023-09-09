package au.edu.rmit.sept.shoppingApp.service;

import au.edu.rmit.sept.shoppingApp.model.Product;
import au.edu.rmit.sept.shoppingApp.repository.ProductRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{


    private ProductRepositoryImpl ProductRepository;

    public ProductServiceImpl(ProductRepositoryImpl repository) {
        this.ProductRepository = repository;
    }

    @Override
    public List<Product> listAll() {
        return ProductRepository.listAll();
    }
}
