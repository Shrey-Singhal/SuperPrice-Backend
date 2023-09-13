package au.edu.rmit.sept.SuperPrice.repository;

import au.edu.rmit.sept.SuperPrice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // TODO: Add methods

}
