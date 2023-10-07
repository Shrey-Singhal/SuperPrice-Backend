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

    @Test
    public void get_products_product_id_1() throws Exception {
        // Prepare mock data
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Full Cream Milk", "Dairy Products"));
        products.add(new Product(2, "Wholemeal Bread", "Bakery Products"));
        
        // Mock the service method
        when(productService.getAllProducts()).thenReturn(products);
        
        // Perform GET request
        mvc.perform(get("/SuperPrice/v1/Product/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.productName", is("Full Cream Milk")))
                .andExpect(jsonPath("$.productCategory", is("Dairy Products")));
    }







    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}

