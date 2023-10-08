package au.edu.rmit.sept.SuperPrice.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import au.edu.rmit.sept.SuperPrice.SuperPriceApp;
import au.edu.rmit.sept.SuperPrice.model.Product;
import au.edu.rmit.sept.SuperPrice.service.ProductService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = SuperPriceApp.class)
@AutoConfigureMockMvc
public class ProductControllerIntegrationTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private Flyway flyway;

    @BeforeEach
    public void setUp() {
        flyway.migrate();
    }

    // @AfterEach
    // public void tearDown() {
    //     flyway.clean();
    // }

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    
    // Test get all products
    @Test
    public void get_products() throws Exception {
        // Prepare mock data
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Full Cream Milk", "Dairy Products"));
        products.add(new Product(2, "Wholemeal Bread", "Bakery Products"));
        
        // Mock the service method
        when(productService.getAllProducts()).thenReturn(products);
        
        // Perform GET request
        mvc.perform(get("/SuperPrice/v1/Products")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].productName", is("Full Cream Milk")))
                .andExpect(jsonPath("$[0].productCategory", is("Dairy Products")));
    }


    // Test get product categories
    @Test
    public void get_product_categories() throws Exception {
        // Prepare mock data
        List<String> categories = new ArrayList<>();
        categories.add("Dairy Products");
        categories.add("Bakery Products");
        
        // Mock the service method
        when(productService.getAllProductCategories()).thenReturn(categories);
        
        // Perform GET request
        mvc.perform(get("/SuperPrice/v1/Products/Categories")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0]", is("Dairy Products")))
                .andExpect(jsonPath("$[1]", is("Bakery Products")));
    }


    // Test get product by product_id
    @Test
    public void get_product_product_id_1() throws Exception {
        // Prepare mock data
        Product product = new Product(1, "Full Cream Milk", "Dairy Products");
        int productId = 1;

        // Mock the service method
        when(productService.getProductById(productId)).thenReturn(Optional.of(product));
        
        // Perform GET request
        mvc.perform(get("/SuperPrice/v1/Product/{product_id}", productId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.productName", is("Full Cream Milk")))
                .andExpect(jsonPath("$.productCategory", is("Dairy Products")));
    }


    // Test get product by product_name
    @Test
    public void get_product_product_name_Full_Cream_Milk() throws Exception {
        // Prepare mock data
        Product product = new Product(1, "Full Cream Milk", "Dairy Products");
        String productName = "Full Cream Milk";

        // Mock the service method
        when(productService.getProductByProductName(productName)).thenReturn(Optional.of(product));
        
        // Perform GET request
        mvc.perform(get("/SuperPrice/v1/Product/Name/{product_name}", productName)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.productId", is(1)))
                .andExpect(jsonPath("$.productName", is("Full Cream Milk")))
                .andExpect(jsonPath("$.productCategory", is("Dairy Products")));
    }


    // Test get product by product_name
    @Test
    public void get_product_product_name_Wholemeal_Bread() throws Exception {
        // Prepare mock data
        Product product = new Product(2, "Wholemeal Bread", "Bakery Products");
        String productName = "Wholemeal Bread";
        
        // Mock the service method
        when(productService.getProductByProductName(productName)).thenReturn(Optional.of(product));
        
        // Perform GET request
        mvc.perform(get("/SuperPrice/v1/Product/Name/{product_name}", productName)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.productId", is(2)))
                .andExpect(jsonPath("$.productName", is("Wholemeal Bread")))
                .andExpect(jsonPath("$.productCategory", is("Bakery Products")));
    }


    // Test get product by product_name - product not found
    @Test
    public void get_product_product_name_NonExistentProduct() throws Exception {
        // Prepare mock data
        String productName = "NonExistentProduct";
        
        // Mock the service method
        when(productService.getProductByProductName(productName)).thenReturn(Optional.empty());
        
        // Perform GET request
        mvc.perform(get("/SuperPrice/v1/Product/Name/{product_name}", productName)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }


    // Test get all products by product_category
    @Test
    public void get_products_product_category_Dairy_Products() throws Exception {
        // Prepare mock data
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Full Cream Milk", "Dairy Products"));
        products.add(new Product(2, "Wholemeal Bread", "Bakery Products"));
        products.add(new Product(6, "Low Fat Yoghurt", "Dairy Products"));
        String productCategory = "Dairy Products";
        
        // Mock the service method
        when(productService.getAllProductsByCategory(productCategory)).thenReturn(products);
        
        // Perform GET request
        mvc.perform(get("/SuperPrice/v1/Products/Category/{product_category}", productCategory)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].productName", is("Full Cream Milk")))
                .andExpect(jsonPath("$[0].productCategory", is("Dairy Products")))
                .andExpect(jsonPath("$[1].productName", is("Low Fat Yoghurt")))
                .andExpect(jsonPath("$[1].productCategory", is("Dairy Products")));
    }


    // Test get all products by product_category - category not found
    @Test
    public void get_products_product_category_NonExistentCategory() throws Exception {
        // Prepare mock data
        // List<Product> products = new ArrayList<>();
        String productCategory = "NonExistentCategory";
        
        // Mock the service method
        when(productService.getAllProductsByCategory(productCategory)).thenReturn(new ArrayList<>());
        
        // Perform GET request
        mvc.perform(get("/SuperPrice/v1/Products/Category/{product_category}", productCategory)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    
    // Generate JSON string from Object
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}

