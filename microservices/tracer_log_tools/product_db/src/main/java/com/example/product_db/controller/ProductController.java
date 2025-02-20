package com.example.product_db.controller;



import com.example.product_db.model.Product;
import com.example.product_db.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;


@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private Tracer tracer; // Inject the Tracer

    @GetMapping
    public List<Product> getAllProducts() {
        // Start a span for this operation
        Span span = tracer.spanBuilder("getAllProducts").startSpan();
        try (var scope = span.makeCurrent()) {
            return productRepository.findAll();
        } finally {
            // End the span
            span.end();
        }
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        // Start a span for this operation
        Span span = tracer.spanBuilder("getProductById").startSpan();
        try (var scope = span.makeCurrent()) {
            return productRepository.findById(id).orElse(null);
        } finally {
            // End the span
            span.end();
        }
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        // Start a span for this operation
        Span span = tracer.spanBuilder("createProduct").startSpan();
        try (var scope = span.makeCurrent()) {
            return productRepository.save(product);
        } finally {
            // End the span
            span.end();
        }
    }
}