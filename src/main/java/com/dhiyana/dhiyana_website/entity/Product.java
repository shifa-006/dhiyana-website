package com.dhiyana.dhiyana_website.entity;

import jakarta.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;
    private Double price;

    // store as comma separated string in DB
    private String images;

    public Product() {}

    public Product(Long id, String name, String category, Double price, String images) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.images = images;
    }

    // GETTERS

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public Double getPrice() {
        return price;
    }

    public String getImages() {
        return images;
    }

    // SETTERS

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setImages(String images) {
        this.images = images;
    }

    // helper → convert string to list
    public List<String> getImageList() {
        if (images == null || images.isEmpty()) {
            return List.of();
        }

        return Arrays.asList(images.split(","));
    }
}