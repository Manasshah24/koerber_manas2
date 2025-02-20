package com.example.ingress_ms1.repository;

import com.example.ingress_ms1.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
