package com.dhiyana.dhiyana_website.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhiyana.dhiyana_website.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory(String category);

    List<Product> findByNameContainingIgnoreCase(String name);

}