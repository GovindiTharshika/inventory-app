package com.abc.inventory.service;

import com.abc.inventory.model.Product;
import com.abc.inventory.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;
    public ProductService(ProductRepository repository){this.repository=repository;}
    public List<Product> findAll(){return repository.findAll();}
    public Product findById(Long id){return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found: " + id));}
    public Product save(Product product){return repository.save(product);}
    public Product update(Long id, Product input){
        Product product=findById(id);
        product.setName(input.getName()); product.setCategory(input.getCategory());
        product.setQuantity(input.getQuantity()); product.setPrice(input.getPrice());
        return repository.save(product);
    }
    public void delete(Long id){repository.delete(findById(id));}
    public boolean isLowStock(Product product){return product.getQuantity() < 10;}
    public double calculateStockValue(Product product){return product.getQuantity() * product.getPrice();}
}
