package com.abc.inventory.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank private String name;
    @NotBlank private String category;
    @Min(0) private int quantity;
    @DecimalMin("0.0") private double price;

    public Product() {}
    public Product(Long id, String name, String category, int quantity, double price) {
        this.id=id; this.name=name; this.category=category; this.quantity=quantity; this.price=price;
    }
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getName(){return name;} public void setName(String name){this.name=name;}
    public String getCategory(){return category;} public void setCategory(String category){this.category=category;}
    public int getQuantity(){return quantity;} public void setQuantity(int quantity){this.quantity=quantity;}
    public double getPrice(){return price;} public void setPrice(double price){this.price=price;}
}
