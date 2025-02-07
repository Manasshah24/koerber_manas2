package com.assignment5.controller;

import com.assignment5.entities.Product;
import com.assignment5.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "products")
public class ProductControllerPagination {

    private ProductService productService;

    @Autowired
    public ProductControllerPagination(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("productsorted")
    public ResponseEntity<List<Product>> getAllProductsSorted(@RequestParam String field) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProductSorted(field));
    }

    @GetMapping(path = "productpage")
    public ResponseEntity<Page<Product>> getAllProductPage(@RequestParam int offset, @RequestParam int pageSize) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProductPage(offset, pageSize));
    }

    @GetMapping(path = "productpagesorted")
    public ResponseEntity<Page<Product>> getAllProductPageSorted(@RequestParam String field, @RequestParam int offset, @RequestParam int pageSize) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProductPageSorted(field, offset, pageSize));
    }
}
