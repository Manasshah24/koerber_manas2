package com.example.payment_ms_3.repository;
import java.util.Optional;



import com.example.payment_ms_3.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Optional<Payment> findByOrderId(Long orderId);
}

