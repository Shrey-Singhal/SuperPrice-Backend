package au.edu.rmit.sept.SuperPrice.repository;

import au.edu.rmit.sept.SuperPrice.model.CustomDTOProductPrices;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomPriceRepositoryImpl implements CustomProductPriceRepository {
    @PersistenceContext
    private EntityManager entityManager;

    // Get contents of joined Product, ProductPrices & Supermarkets tables for given product_id
    @Override
    public List<CustomDTOProductPrices> retrieveCustomProductPriceData(int product_id) {
        // Custom query TODO: Add query joining Product, ProductPrices, & Supermarkets tables for given product_id
        String query = "SELECT p.product_id, p.product_name, p.product_category, pp.product_price_id, pp.product_price, s.supermarket_id, s.supermarket_name, s.supermarket_address FROM Product p " +
                "INNER JOIN ProductPrice pp ON p.product_id = pp.product_id " +
                "INNER JOIN Supermarkets s ON pp.supermarket_id = s.supermarket_id " +
                "WHERE p.product_id = :product_id";

        List<Object[]> queryResults = entityManager.createQuery(query)
                .setParameter("product_id", product_id)
                .getResultList();

        List<CustomDTOProductPrices> customQueryData = new ArrayList<>();
        for (Object[] result : queryResults) {
            CustomDTOProductPrices customDTOProductPrices = new CustomDTOProductPrices();
            customDTOProductPrices.setProduct_id((int) result[0]);
            customDTOProductPrices.setProduct_name((String) result[1]);
            customDTOProductPrices.setProduct_category((String) result[2]);
            customDTOProductPrices.setProduct_price_id((int) result[3]);
            customDTOProductPrices.setProduct_price((double) result[4]);
            customDTOProductPrices.setSupermarket_id((int) result[5]);
            customDTOProductPrices.setSupermarket_name((String) result[6]);
            customDTOProductPrices.setSupermarket_address((String) result[7]);
            customQueryData.add(customDTOProductPrices);
        }

//        return entityManager.createQuery(query, CustomDTOProductPrices.class)
//                .setParameter("product_id", product_id)
//                .getResultList();
        return customQueryData;
    }

}
