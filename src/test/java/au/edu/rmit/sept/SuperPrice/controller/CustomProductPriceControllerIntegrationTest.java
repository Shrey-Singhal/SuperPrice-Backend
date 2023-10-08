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
import au.edu.rmit.sept.SuperPrice.model.CustomDTOProductPrices;
import au.edu.rmit.sept.SuperPrice.service.CustomProductPriceService;

import java.util.ArrayList;
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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = SuperPriceApp.class)
@AutoConfigureMockMvc
public class CustomProductPriceControllerIntegrationTest {
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
    private CustomProductPriceService customProductPriceService;

    @InjectMocks
    private CustomProductPriceController customProductPriceController;


    // Test get custom ProductPrices data by product id
    @Test
    public void get_ProductPrices_product_id_1() throws Exception {
        // Prepare mock data
        List<CustomDTOProductPrices> productPrices = new ArrayList<>();
        CustomDTOProductPrices productPrice = new CustomDTOProductPrices();
        productPrice.setProduct_id(1);
        productPrice.setProduct_name("Full Cream Milk");
        productPrice.setProduct_category("Dairy Products");
        productPrice.setProduct_price_id(1);
        productPrice.setProduct_price(1.50);
        productPrice.setSupermarket_id(1);
        productPrice.setSupermarket_name("Woolworths");
        productPrice.setSupermarket_address("1 Park St, Sydney, NSW 2000");
        productPrice.setRewards_points(0);
        productPrices.add(productPrice);
        int productId = 1;

        // Mock service method
        when(customProductPriceService.getProductPricesByProductId(productId)).thenReturn(productPrices);

        mvc.perform(get("/SuperPrice/v2/ProductPrices/{product_id}", productId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].product_id", is(productPrices.get(0).getProduct_id())))
                .andExpect(jsonPath("$[0].product_name", is(productPrices.get(0).getProduct_name())))
                .andExpect(jsonPath("$[0].product_category", is(productPrices.get(0).getProduct_category())))
                .andExpect(jsonPath("$[0].product_price_id", is(productPrices.get(0).getProduct_price_id())))
                .andExpect(jsonPath("$[0].product_price", is(productPrices.get(0).getProduct_price())))
                .andExpect(jsonPath("$[0].supermarket_id", is(productPrices.get(0).getSupermarket_id())))
                .andExpect(jsonPath("$[0].supermarket_name", is(productPrices.get(0).getSupermarket_name())))
                .andExpect(jsonPath("$[0].supermarket_address", is(productPrices.get(0).getSupermarket_address())));
                // .andExpect(jsonPath("$[0].rewards_points", is(productPrices.getRewards_points())));
    }


    // Test get custom ProductPrices data by supermarket_id
    @Test
    public void get_ProductPrices_supermarket_id_1() throws Exception {
        // Prepare mock data
        List<CustomDTOProductPrices> productPrices = new ArrayList<>();
        CustomDTOProductPrices productPrice = new CustomDTOProductPrices();
        productPrice.setProduct_id(1);
        productPrice.setProduct_name("Full Cream Milk");
        productPrice.setProduct_category("Dairy Products");
        productPrice.setProduct_price_id(1);
        productPrice.setProduct_price(1.50);
        productPrice.setSupermarket_id(1);
        productPrice.setSupermarket_name("Woolworths");
        productPrice.setSupermarket_address("1 Park St, Sydney, NSW 2000");
        productPrice.setRewards_points(0);
        productPrices.add(productPrice);
        int supermarketId = 1;

        // Mock service method
        when(customProductPriceService.getProductPricesBySupermarketId(supermarketId)).thenReturn(productPrices);
        
        mvc.perform(get("/SuperPrice/v2/ProductPrices/Supermarket/{supermarketId}", supermarketId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].product_id", is(productPrices.get(0).getProduct_id())))
                .andExpect(jsonPath("$[0].product_name", is(productPrices.get(0).getProduct_name())))
                .andExpect(jsonPath("$[0].product_category", is(productPrices.get(0).getProduct_category())))
                .andExpect(jsonPath("$[0].product_price_id", is(productPrices.get(0).getProduct_price_id())))
                .andExpect(jsonPath("$[0].product_price", is(productPrices.get(0).getProduct_price())))
                .andExpect(jsonPath("$[0].supermarket_id", is(productPrices.get(0).getSupermarket_id())))
                .andExpect(jsonPath("$[0].supermarket_name", is(productPrices.get(0).getSupermarket_name())))
                .andExpect(jsonPath("$[0].supermarket_address", is(productPrices.get(0).getSupermarket_address())));
                // .andExpect(jsonPath("$[0].rewards_points", is(productPrices.getRewards_points())));
    }


    // Test get distinct Product categories by supermarket_id
    @Test
    public void get_ProductCategories_supermarket_id_1() throws Exception {
        // Prepare mock data
        List<CustomDTOProductPrices> productCategories = new ArrayList<>();
        CustomDTOProductPrices productCategory = new CustomDTOProductPrices();
        productCategory.setProduct_category("Dairy Products");
        productCategories.add(productCategory);
        int supermarketId = 1;

        // Mock service method
        when(customProductPriceService.getProductCategoriesBySupermarketId(supermarketId)).thenReturn(productCategories);
        
        mvc.perform(get("/SuperPrice/v2/ProductPrices/Categories/{supermarketId}", supermarketId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].product_category", is(productCategories.get(0).getProduct_category())));
    }


    // Test get custom ProductPrices data by selected supermarket_id & product_category
    @Test
    public void get_ProductPrices_supermarket_id_1_product_category_Dairy_Products() throws Exception {
        // Prepare mock data
        List<CustomDTOProductPrices> productPrices = new ArrayList<>();
        CustomDTOProductPrices productPrice = new CustomDTOProductPrices();
        productPrice.setProduct_id(1);
        productPrice.setProduct_name("Full Cream Milk");
        productPrice.setProduct_category("Dairy Products");
        productPrice.setProduct_price_id(1);
        productPrice.setProduct_price(1.50);
        productPrice.setSupermarket_id(1);
        productPrice.setSupermarket_name("Woolworths");
        productPrice.setSupermarket_address("1 Park St, Sydney, NSW 2000");
        productPrice.setRewards_points(0);
        productPrices.add(productPrice);
        int supermarketId = 1;
        String productCategory = "Dairy Products";

        // Mock service method
        when(customProductPriceService.getProductPricesBySupermarketIdAndProductCategory(supermarketId, productCategory)).thenReturn(productPrices);
        
        mvc.perform(get("/SuperPrice/v2/ProductPrices/Supermarket/Category/{supermarketId}/{productCategory}", supermarketId, productCategory)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].product_id", is(productPrices.get(0).getProduct_id())))
                .andExpect(jsonPath("$[0].product_name", is(productPrices.get(0).getProduct_name())))
                .andExpect(jsonPath("$[0].product_category", is(productPrices.get(0).getProduct_category())))
                .andExpect(jsonPath("$[0].product_price_id", is(productPrices.get(0).getProduct_price_id())))
                .andExpect(jsonPath("$[0].product_price", is(productPrices.get(0).getProduct_price())))
                .andExpect(jsonPath("$[0].supermarket_id", is(productPrices.get(0).getSupermarket_id())))
                .andExpect(jsonPath("$[0].supermarket_name", is(productPrices.get(0).getSupermarket_name())))
                .andExpect(jsonPath("$[0].supermarket_address", is(productPrices.get(0).getSupermarket_address())));
                // .andExpect(jsonPath("$[0].rewards_points", is(productPrices.getRewards_points())));
    }

    
    // Generate JSON string from Object
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

}
