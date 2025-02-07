package com.example.order_ms_2.clients;

import com.example.order_ms_2.dto.Product;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Component;

@FeignClient(name = "product-service", fallback = ProductClientFallback.class)
public interface ProductClient {

    @GetMapping("/products/{id}")
    @CircuitBreaker(name = "productService", fallbackMethod = "fallbackGetProductById")
    Product getProductById(@PathVariable Long id);

    // Fallback method (will be handled in ProductClientFallback class)
    default Product fallbackGetProductById(Long id, Throwable throwable) {
        return new Product(id, "Default Product", 0.0); // Return default product
    }
}

@Component
class ProductClientFallback implements ProductClient {
    @Override
    public Product getProductById(Long id) {
        return new Product(id, "Fallback Product", 0.0);
    }
}
