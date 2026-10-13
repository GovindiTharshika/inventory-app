package com.abc.inventory.controller;

import com.abc.inventory.model.Product;
import com.abc.inventory.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductController {
    private final ProductService service;
    public ProductController(ProductService service){this.service=service;}
    @GetMapping public List<Product> all(){return service.findAll();}
    @GetMapping("/{id}") public Product one(@PathVariable Long id){return service.findById(id);}
    @PostMapping public ResponseEntity<Product> create(@Valid @RequestBody Product product){return ResponseEntity.status(HttpStatus.CREATED).body(service.save(product));}
    @PutMapping("/{id}") public Product update(@PathVariable Long id,@Valid @RequestBody Product product){return service.update(id,product);}
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id){service.delete(id);return ResponseEntity.noContent().build();}
    @ExceptionHandler(IllegalArgumentException.class) public ResponseEntity<String> notFound(IllegalArgumentException ex){return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());}
}
