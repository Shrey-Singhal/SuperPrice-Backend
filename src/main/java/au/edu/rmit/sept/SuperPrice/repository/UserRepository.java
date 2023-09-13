package au.edu.rmit.sept.SuperPrice.repository;

import  au.edu.rmit.sept.SuperPrice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // TODO: Add methods

    // TODO: Find User rewards points by email address

}
