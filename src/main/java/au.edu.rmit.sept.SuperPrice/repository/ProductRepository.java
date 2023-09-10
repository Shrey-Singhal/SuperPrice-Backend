package au.edu.rmit.sept.SuperPrice.repository;

import au.edu.rmit.sept.SuperPrice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product> {}