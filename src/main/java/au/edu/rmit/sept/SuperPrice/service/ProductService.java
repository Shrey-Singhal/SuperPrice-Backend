package au.edu.rmit.sept.SuperPrice.service;

import au.edu.rmit.sept.SuperPrice.model.*;
import au.edu.rmit.sept.SuperPrice.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class ProductService {
    // Declare repository instances
    @Autowired
    private ProductRepository productRepository;

    private UserRepository userRepository;

    private OrderRepository orderRepository;

    @Autowired
    private ProductPriceRepository productPriceRepository;


    // Initialise repository instance
//    @Autowired
//    public ProductService(
//            ProductRepository productRepository,
////            UserRepository userRepository,
////            OrderRepository orderRepository,
//            ProductPriceRepository productPriceRepository) {
//        this.productRepository = productRepository;
////        this.userRepository = userRepository;
////        this.orderRepository = orderRepository;
//        this.productPriceRepository = productPriceRepository;
//    }

    // TODO: Get all Products in the database
    public List<Product> getAllProducts() {
        return this.productRepository.findAllByIdNotNull();
    }

    // TODO: Get Product by name
//    public List<Product> getProductsByName(String productName) {
//        return this.productRepository.findProductsByName(productName);
//    }

    // TODO: Get User/s
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    // TODO: Create (add) User

    // TODO: Get Order/s

    // TODO: Create (add) Order

    // TODO: Get Product/s by Name
//    public List<Product> getProductsByName(String productName) {
//        return productRepository.findProductsByName(productName);
//    }

    // TODO: Get ProductPrice/s
    public List<ProductPrice> getProductPrices(int productId) {
        return productPriceRepository.findProductPricesByProductId(productId);
    }

    // TODO: Add Products to Order & Update / Display Order Totals (Price & Rewards Points)

    // TODO: Remove Products to Order & Update / Display Order Totals (Price & Rewards Points)

    // TODO: Process Order -> Add Order to Order History & Update Users Rewards Points

    // TODO: Get Users Rewards Points


}
