package com.abc.inventory;

import com.abc.inventory.model.Product;
import com.abc.inventory.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryApplication {
    public static void main(String[] args) { SpringApplication.run(InventoryApplication.class, args); }

    @Bean
    CommandLineRunner seed(ProductRepository repository) {
        return args -> {
            repository.save(new Product(null, "Laptop", "Electronics", 12, 1250.00));
            repository.save(new Product(null, "Wireless Mouse", "Accessories", 30, 25.50));
            repository.save(new Product(null, "Office Chair", "Furniture", 8, 210.00));
        };
    }
}
