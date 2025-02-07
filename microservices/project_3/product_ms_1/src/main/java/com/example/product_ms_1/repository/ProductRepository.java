package com.example.product_ms_1.repository;



import com.example.product_ms_1.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}