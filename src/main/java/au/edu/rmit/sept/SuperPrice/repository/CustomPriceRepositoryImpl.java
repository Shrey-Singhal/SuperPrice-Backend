package au.edu.rmit.sept.SuperPrice.repository;

import au.edu.rmit.sept.SuperPrice.model.CustomDTOProductPrices;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomPriceRepositoryImpl implements CustomProductPriceRepository {
    @PersistenceContext
    private EntityManager entityManager;

    // Get Product, ProductPrices, ProductRewards & Supermarkets data for selected product_id
    @Override
    public List<CustomDTOProductPrices> retrieveCustomProductPriceData(int product_id) {
        // Custom query joining Product, ProductPrices, & Supermarkets tables for given product_id
        String query = "SELECT p.product_id, p.product_name, p.product_category, pp.product_price_id, pp.product_price, pr.rewards_points, s.supermarket_id, s.supermarket_name, s.supermarket_address " +
                "FROM Product p " +
                "INNER JOIN ProductPrice pp ON p.product_id = pp.product_id " +
                "INNER JOIN Supermarkets s ON pp.supermarket_id = s.supermarket_id " +
                "INNER JOIN ProductRewards pr ON pp.supermarket_id = pr.supermarket_id AND pp.product_id = pr.product_id " +
                "WHERE p.product_id = :product_id";

        // Execute query
        TypedQuery<Object[]> typedQuery = entityManager.createQuery(query, Object[].class).setParameter("product_id", product_id);

        // Get query results
        List<Object[]> queryResults = typedQuery.getResultList();

        // Process query results
        List<CustomDTOProductPrices> customQueryData = new ArrayList<>();
        for (Object[] result : queryResults) {
            CustomDTOProductPrices customDTOProductPrices = new CustomDTOProductPrices();
            customDTOProductPrices.setProduct_id((int) result[0]);
            customDTOProductPrices.setProduct_name((String) result[1]);
            customDTOProductPrices.setProduct_category((String) result[2]);
            customDTOProductPrices.setProduct_price_id((int) result[3]);
            customDTOProductPrices.setProduct_price((double) result[4]);
            customDTOProductPrices.setRewards_points((int) result[5]);
            customDTOProductPrices.setSupermarket_id((int) result[6]);
            customDTOProductPrices.setSupermarket_name((String) result[7]);
            customDTOProductPrices.setSupermarket_address((String) result[8]);
            customQueryData.add(customDTOProductPrices);
        }

        return customQueryData;
    }


    // Get Products, ProductPrices, ProductRewards & Supermarket data for selected supermarket_id
    @Override
    public List<CustomDTOProductPrices> retrieveCustomProductPriceDataBySupermarket(int supermarket_id) {
        // Custom query joining Product, ProductPrices, & Supermarkets tables for given supermarket_id
        String query = "SELECT p.product_id, p.product_name, p.product_category, pp.product_price_id, pp.product_price, pr.rewards_points, s.supermarket_id, s.supermarket_name, s.supermarket_address " +
                "FROM Product p " +
                "INNER JOIN ProductPrice pp ON p.product_id = pp.product_id " +
                "INNER JOIN Supermarkets s ON pp.supermarket_id = s.supermarket_id " +
                "INNER JOIN ProductRewards pr ON pp.supermarket_id = pr.supermarket_id AND pp.product_id = pr.product_id " +
                "WHERE s.supermarket_id = :supermarket_id";

        // Execute query 
        TypedQuery<Object[]> typedQuery = entityManager.createQuery(query, Object[].class).setParameter("supermarket_id", supermarket_id);
        
        // Get query results
        List<Object[]> queryResults = typedQuery.getResultList();

        // Process query results
        List<CustomDTOProductPrices> customQueryData = new ArrayList<>();
        for (Object[] result : queryResults) {
            CustomDTOProductPrices customDTOProductPrices = new CustomDTOProductPrices();
            customDTOProductPrices.setProduct_id((int) result[0]);
            customDTOProductPrices.setProduct_name((String) result[1]);
            customDTOProductPrices.setProduct_category((String) result[2]);
            customDTOProductPrices.setProduct_price_id((int) result[3]);
            customDTOProductPrices.setProduct_price((double) result[4]);
            customDTOProductPrices.setRewards_points((int) result[5]);
            customDTOProductPrices.setSupermarket_id((int) result[6]);
            customDTOProductPrices.setSupermarket_name((String) result[7]);
            customDTOProductPrices.setSupermarket_address((String) result[8]);
            customQueryData.add(customDTOProductPrices);
        }

        return customQueryData;
    }


    // Get distinct product categories for given supermarket_id
    @Override
    public List<CustomDTOProductPrices> retrieveCustomDistinctProductCategoryDataBySupermarketId(int supermarket_id) {
        // Custom query joining Product, ProductPrices, & Supermarkets tables for given supermarket_id
        String query = "SELECT DISTINCT p.product_category " +
                "FROM Product p " +
                "INNER JOIN ProductPrice pp ON p.product_id = pp.product_id " +
                "INNER JOIN Supermarkets s ON pp.supermarket_id = s.supermarket_id " +
                "INNER JOIN ProductRewards pr ON pp.supermarket_id = pr.supermarket_id AND pp.product_id = pr.product_id " +
                "WHERE s.supermarket_id = :supermarket_id";

        // Execute query
        TypedQuery<Object[]> typedQuery = entityManager.createQuery(query, Object[].class).setParameter("supermarket_id", supermarket_id);

        // Get query results
        List<Object[]> queryResults = typedQuery.getResultList();

        // Process query results
        List<CustomDTOProductPrices> customQueryData = new ArrayList<>();
        for (Object[] result : queryResults) {
            CustomDTOProductPrices customDTOProductPrices = new CustomDTOProductPrices();
            customDTOProductPrices.setProduct_category((String) result[0]);
            customQueryData.add(customDTOProductPrices);
        }

        return customQueryData;
    }


    // Get products, product prices, & product rewards for selected category & supermarket_id
    @Override
    public List<CustomDTOProductPrices> retrieveCustomProductCategoryProductPriceDataBySupermarketId(int supermarket_id, String product_category) {
        // Custom query joining Product, ProductPrices, & Supermarkets tables for given supermarket_id
        String query = "SELECT p.product_id, p.product_name, p.product_category, pp.product_price_id, pp.product_price, pr.rewards_points, s.supermarket_id, s.supermarket_name, s.supermarket_address " +
                "FROM Product p " +
                "INNER JOIN ProductPrice pp ON p.product_id = pp.product_id " +
                "INNER JOIN Supermarkets s ON pp.supermarket_id = s.supermarket_id " +
                "INNER JOIN ProductRewards pr ON pp.supermarket_id = pr.supermarket_id AND pp.product_id = pr.product_id " +
                "WHERE s.supermarket_id = :supermarket_id AND LOWER(p.product_category) = LOWER(:product_category)";

        // Execute query
        TypedQuery<Object[]> typedQuery = entityManager.createQuery(query, Object[].class)
                .setParameter("supermarket_id", supermarket_id)
                .setParameter("product_category", product_category);
        
        // Get query results
        List<Object[]> queryResults = typedQuery.getResultList();

        // Process query results
        List<CustomDTOProductPrices> customQueryData = new ArrayList<>();
        for (Object[] result : queryResults) {
            CustomDTOProductPrices customDTOProductPrices = new CustomDTOProductPrices();
            customDTOProductPrices.setProduct_id((int) result[0]);
            customDTOProductPrices.setProduct_name((String) result[1]);
            customDTOProductPrices.setProduct_category((String) result[2]);
            customDTOProductPrices.setProduct_price_id((int) result[3]);
            customDTOProductPrices.setProduct_price((double) result[4]);
            customDTOProductPrices.setRewards_points((int) result[5]);
            customDTOProductPrices.setSupermarket_id((int) result[6]);
            customDTOProductPrices.setSupermarket_name((String) result[7]);
            customDTOProductPrices.setSupermarket_address((String) result[8]);
            customQueryData.add(customDTOProductPrices);
        }

        return customQueryData;
    }

}
