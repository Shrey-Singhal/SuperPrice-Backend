package au.edu.rmit.sept.SuperPrice.repository;

import au.edu.rmit.sept.SuperPrice.model.Product;
import au.edu.rmit.sept.SuperPrice.model.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductPriceRepository extends JpaRepository<ProductPrice, Long> {
    // TODO: Add methods
    List<ProductPrice> findProductPricesByProductId(int productId);
}
