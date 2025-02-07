package com.example.payment_ms_3.service;

import com.example.payment_ms_3.clients.OrderClient;
import com.example.payment_ms_3.dto.Order;
import com.example.payment_ms_3.entity.Payment;
import com.example.payment_ms_3.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private OrderClient orderClient; // Feign Client to call orders_ms_2

    public Payment processPayment(Payment payment) {
        // Fetch order details from orders_ms_2
        Order order = orderClient.getOrderById(payment.getOrderId());

        if (order != null) {
            // Calculate payment amount based on order total price
            payment.setAmount(order.getTotalPrice());
            payment.setStatus("SUCCESS"); // Simulating a successful payment
            return paymentRepository.save(payment);
        } else {
            throw new RuntimeException("Order not found");
        }
    }

    public Payment getPaymentByOrderId(Long orderId) {
        return paymentRepository.findByOrderId(orderId).orElse(null);
    }
}