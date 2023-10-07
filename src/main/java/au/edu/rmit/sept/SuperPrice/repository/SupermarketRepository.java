package au.edu.rmit.sept.SuperPrice.repository;

import au.edu.rmit.sept.SuperPrice.model.Supermarket;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


/**
 * SupermarketRepository interface handles database operations related to the Supermarket table
 */
@Repository
public interface SupermarketRepository {
    // Supermarket Repository methods

    // Get all Supermarkets
    List<Supermarket> findAllSupermarkets();

    // Get Supermarket by id
    Optional<Supermarket> findSupermarketById(int id);

    // Get Supermarket by name
    Optional<Supermarket> findSupermarketByName(String name);

    // Create new Supermarket
    Optional<Supermarket> saveSupermarket(Supermarket supermarket);
}
