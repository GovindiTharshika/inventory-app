package com.abc.inventory.service;

import com.abc.inventory.model.Product;
import com.abc.inventory.repository.ProductRepository;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {
    private ProductService service;
    @BeforeEach void setup(){service=new ProductService(mock(ProductRepository.class));}
    @Test void calculatesStockValue(){assertEquals(250.0, service.calculateStockValue(new Product(1L,"Mouse","Accessories",10,25.0)));}
    @Test void identifiesLowStock(){assertTrue(service.isLowStock(new Product(1L,"Chair","Furniture",8,200.0)));}
    @Test void tenItemsAreNotLowStock(){assertFalse(service.isLowStock(new Product(1L,"Keyboard","Accessories",10,50.0)));}
}
