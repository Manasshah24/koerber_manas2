package com.example.order_ms_2.service;

import com.example.order_ms_2.entity.Order;
import com.example.order_ms_2.clients.ProductClient;
import com.example.order_ms_2.dto.Product;
import com.example.order_ms_2.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductClient productClient;

    public OrderService(OrderRepository orderRepository, ProductClient productClient) {
        this.orderRepository = orderRepository;
        this.productClient = productClient;
    }

    public Order placeOrder(Long productId, int quantity) {
        Product product = productClient.getProductById(productId); // Call Product Service

        if (product == null ) {
            throw new RuntimeException("Product not found or price unavailable");
        }

        double totalPrice = product.getPrice() * quantity; // Calculate total price

        Order order = new Order();
        order.setProductId(productId);
        order.setQuantity(quantity);
        order.setTotalPrice(totalPrice);  // Set total price
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }
}