package com.example.ingress_ms2.repository;



import com.example.ingress_ms2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

