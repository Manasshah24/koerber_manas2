package com.example.assignment_5.service;



import com.example.assignment_5.entity.Product;
import com.example.assignment_5.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class ProductService {


    private ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getListOfAllProducts() {
        return productRepository.getListOfAllProducts();
    }

    public List<Product> getListOfAllProductsBasedOnName(String name) {
        return productRepository.getListOfAllProductsBasedOnName(name);
    }

    public List<Product> getListOfAllProductsBasedOnNameV2(String name) {
        return productRepository.getListOfAllProductsBasedOnNameV2(name);
    }

    public List<Product> getListOfAllProductsBasedOnNameAndPrice(String name, BigDecimal price) {
        return productRepository.getListOfAllProductsBasedOnNameAndPrice(name, price);
    }

    public List<Product> getListOfAllProductsBasedOnNameOrPrice(String name, BigDecimal price) {
        return productRepository.getListOfAllProductsBasedOnNameOrPrice(name, price);
    }

    public List<Product> getProductsByName(String name) {
        return productRepository.findByName(name);
    }

    public List<Product> getProductsByNameContaining(String name) {
        return productRepository.findByNameContaining(name);
    }

    public List<Product> getProductsByNameLike(String name) {
        return productRepository.findByNameLike(name);
    }

    public List<Product> getProductsByNameStartingWith(String name) {
        return productRepository.findByNameStartingWith(name);
    }

    public List<Product> getProductsByNameEndingWith(String name) {
        return productRepository.findByNameEndingWith(name);
    }

    public List<Product> getProductsByNameIgnoreCase(String name) {
        return productRepository.findByNameIgnoreCase(name);
    }

    public List<Product> getProductsByMfgDateAfter(LocalDate date) {
        return productRepository.findByMfgDateAfter(date);
    }

    public List<Product> getProductsByMfgDateBefore(LocalDate date) {
        return productRepository.findByMfgDateBefore(date);
    }

    public List<Product> getProductsByMfgDateBetween(LocalDate date1, LocalDate date2) {
        return productRepository.findByMfgDateBetween(date1, date2);
    }
}
