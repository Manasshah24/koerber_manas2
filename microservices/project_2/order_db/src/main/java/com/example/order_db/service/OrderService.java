package com.example.order_db.service;

import com.example.order_db.entity.Order;
import com.example.order_db.clients.ProductClient;
import com.example.order_db.dto.Product;
import com.example.order_db.repository.OrderRepository;
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
}
