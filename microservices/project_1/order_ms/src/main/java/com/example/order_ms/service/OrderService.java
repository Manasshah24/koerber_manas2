package com.example.order_ms.service;


import com.example.order_ms.model.Order;
import com.example.order_ms.repository.OrderRepository;
import com.example.product_ms.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    private static final String PRODUCT_SERVICE_URL = "http://localhost:8081/products";

    public Order createOrder(Order order) {
        // Fetch product details from Product Service
        String productUrl = PRODUCT_SERVICE_URL + "/" + order.getProductId();
        Product product = restTemplate.getForObject(productUrl, Product.class);

        if (product != null) {
            // Calculate total price
            order.setTotalPrice(product.getPrice() * order.getQuantity());
            return orderRepository.save(order);
        } else {
            throw new RuntimeException("Product not found");
        }
    }
}
