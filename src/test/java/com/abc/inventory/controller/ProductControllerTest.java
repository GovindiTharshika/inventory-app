package com.abc.inventory.controller;

import com.abc.inventory.model.Product;
import com.abc.inventory.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
class ProductControllerTest {
    @Autowired MockMvc mvc;
    @MockBean ProductService service;
    @Test void returnsProducts() throws Exception {
        when(service.findAll()).thenReturn(List.of(new Product(1L,"Laptop","Electronics",5,1000.0)));
        mvc.perform(get("/api/products")).andExpect(status().isOk()).andExpect(jsonPath("$[0].name").value("Laptop"));
    }
}
