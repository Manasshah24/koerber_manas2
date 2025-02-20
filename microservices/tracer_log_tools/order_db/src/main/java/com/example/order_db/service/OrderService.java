package com.example.order_db.service;

import com.example.order_db.entity.Order;
import com.example.order_db.clients.ProductClient;
import com.example.order_db.dto.Product;
import com.example.order_db.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductClient productClient;

    @Autowired
    private Tracer tracer; // Inject the Tracer

    public OrderService(OrderRepository orderRepository, ProductClient productClient) {
        this.orderRepository = orderRepository;
        this.productClient = productClient;
    }

    public Order placeOrder(Long productId, int quantity) {
        // Start a span for this operation
        Span span = tracer.spanBuilder("placeOrder").startSpan();
        try (var scope = span.makeCurrent()) {
            // Call Product Service
            Product product = productClient.getProductById(productId);

            if (product == null) {
                throw new RuntimeException("Product not found or price unavailable");
            }

            double totalPrice = product.getPrice() * quantity; // Calculate total price

            Order order = new Order();
            order.setProductId(productId);
            order.setQuantity(quantity);
            order.setTotalPrice(totalPrice);  // Set total price
            return orderRepository.save(order);
        } finally {
            // End the span
            span.end();
        }
    }

    public List<Order> getAllOrders() {
        // Start a span for this operation
        Span span = tracer.spanBuilder("getAllOrders").startSpan();
        try (var scope = span.makeCurrent()) {
            return orderRepository.findAll();
        } finally {
            // End the span
            span.end();
        }
    }
}