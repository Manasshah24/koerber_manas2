package com.assignment5.controller;

import com.assignment5.entities.Product;
import com.assignment5.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "products/name")
public class ProductControllerSpringData {

    private final ProductService productService;

    @Autowired
    public ProductControllerSpringData(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("startsWith")
    public ResponseEntity<List<Product>> getProductsByNameStartingWith(@RequestParam String startsWith) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProductsStartingWithName(startsWith));
    }

    @GetMapping("endsWith")
    public ResponseEntity<List<Product>> getProductsByNameEndingWith(@RequestParam String endsWith) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProductsEndingWithName(endsWith));
    }

    @GetMapping("{name}")
    public ResponseEntity<List<Product>> getProductsByName(@PathVariable String name) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProductsByName(name));
    }
 }
