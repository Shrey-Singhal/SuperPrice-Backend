package au.edu.rmit.sept.SuperPrice.repository;

import au.edu.rmit.sept.SuperPrice.model.CustomDTOProductPrices;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomProductPriceRepository {
    List<CustomDTOProductPrices> retrieveCustomProductPriceData(int product_id);

    // TODO: Add any further custom methods

}