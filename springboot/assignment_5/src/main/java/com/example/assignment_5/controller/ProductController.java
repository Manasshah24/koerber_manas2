package com.example.assignment_5.controller;



import com.example.assignment_5.entity.Product;
import com.example.assignment_5.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {


    private ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public List<Product> getListOfAllProducts() {
        return productService.getListOfAllProducts();
    }

    @GetMapping("/byname")
    public List<Product> getListOfProductsByName(@RequestParam String name) {
        return productService.getListOfAllProductsBasedOnName(name);
    }

    @GetMapping("/bynamev2")
    public List<Product> getListOfProductsByNameV2(@RequestParam String name) {
        return productService.getListOfAllProductsBasedOnNameV2(name);
    }

    @GetMapping("/bynameandprice")
    public List<Product> getListOfProductsByNameAndPrice(@RequestParam String name, @RequestParam BigDecimal price) {
        return productService.getListOfAllProductsBasedOnNameAndPrice(name, price);
    }

    @GetMapping("/bynameorprice")
    public List<Product> getListOfProductsByNameOrPrice(@RequestParam String name, @RequestParam BigDecimal price) {
        return productService.getListOfAllProductsBasedOnNameOrPrice(name, price);
    }

    @GetMapping("/search")
    public List<Product> getProductsByName(@RequestParam String name) {
        return productService.getProductsByName(name);
    }

    @GetMapping("/search/contains")
    public List<Product> getProductsByNameContaining(@RequestParam String name) {
        return productService.getProductsByNameContaining(name);
    }

    // Add more endpoints as needed...
}

