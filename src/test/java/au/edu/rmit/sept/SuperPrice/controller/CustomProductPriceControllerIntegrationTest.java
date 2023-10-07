package au.edu.rmit.sept.SuperPrice.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import au.edu.rmit.sept.SuperPrice.SuperPriceApp;
import au.edu.rmit.sept.SuperPrice.model.CustomDTOProductPrices;
import au.edu.rmit.sept.SuperPrice.service.CustomProductPriceService;

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

    @Test
    public void get_ProductPrices_product_id_1() throws Exception {
        CustomDTOProductPrices productPrices = new CustomDTOProductPrices();
        productPrices.setProduct_id(1);
        productPrices.setProduct_name("Full Cream Milk");
        productPrices.setProduct_category("Dairy Products");
        productPrices.setProduct_price_id(1);
        productPrices.setProduct_price(1.50);
        productPrices.setSupermarket_id(1);
        productPrices.setSupermarket_name("Woolworths");
        productPrices.setSupermarket_address("1 Park St, Sydney, NSW 2000");
        productPrices.setRewards_points(0);
        
        mvc.perform(get("/SuperPrice/v2/ProductPrices/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].product_id", is(productPrices.getProduct_id())))
                .andExpect(jsonPath("$[0].product_name", is(productPrices.getProduct_name())))
                .andExpect(jsonPath("$[0].product_category", is(productPrices.getProduct_category())))
                .andExpect(jsonPath("$[0].product_price_id", is(productPrices.getProduct_price_id())))
                .andExpect(jsonPath("$[0].product_price", is(productPrices.getProduct_price())))
                .andExpect(jsonPath("$[0].supermarket_id", is(productPrices.getSupermarket_id())))
                .andExpect(jsonPath("$[0].supermarket_name", is(productPrices.getSupermarket_name())))
                .andExpect(jsonPath("$[0].supermarket_address", is(productPrices.getSupermarket_address())))
                .andExpect(jsonPath("$[0].rewards_points", is(productPrices.getRewards_points())));
    }
















    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

}
