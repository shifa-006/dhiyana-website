package com.dhiyana.dhiyana_website.controller;

import com.dhiyana.dhiyana_website.entity.Product;
import com.dhiyana.dhiyana_website.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    // GET ALL PRODUCTS
    @GetMapping
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    // GET BY CATEGORY
    @GetMapping("/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category) {
        return repository.findByCategory(category);
    }

    // SEARCH BY NAME
    @GetMapping("/search/{name}")
    public List<Product> searchProducts(@PathVariable String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    // ADD PRODUCT
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return repository.save(product);
    }

    // UPDATE PRODUCT
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id,
                                 @RequestBody Product product) {

        product.setId(id);
        return repository.save(product);
    }

    // DELETE PRODUCT
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        repository.deleteById(id);
    }
}