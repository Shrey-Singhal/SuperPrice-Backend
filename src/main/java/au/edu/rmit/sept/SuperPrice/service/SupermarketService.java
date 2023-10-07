package au.edu.rmit.sept.SuperPrice.service;

import au.edu.rmit.sept.SuperPrice.model.Supermarket;
import au.edu.rmit.sept.SuperPrice.repository.SupermarketRepositoryImpl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class SupermarketService {
    // Declare repository instances
    @Autowired
    private SupermarketRepositoryImpl supermarketRepository;

    // Get all Supermarkets
    public List<Supermarket> getAllSupermarkets() {
        return this.supermarketRepository.findAllSupermarkets();
    }

    // Get Supermarket by id
    public Optional<Supermarket> getSupermarketById(int supermarket_id) {
        return this.supermarketRepository.findSupermarketById(supermarket_id);
    }

    // Get Supermarket by name
    public Optional<Supermarket> getSupermarketByName(String supermarket_name) {
        return this.supermarketRepository.findSupermarketByName(supermarket_name);
    }

    // Add a new Supermarket to the database TODO: Test this method
    public Optional<Supermarket> createSupermarket(Supermarket supermarket) {
        // Add Supermarket to the database
        return this.supermarketRepository.saveSupermarket(supermarket);
    }
}
