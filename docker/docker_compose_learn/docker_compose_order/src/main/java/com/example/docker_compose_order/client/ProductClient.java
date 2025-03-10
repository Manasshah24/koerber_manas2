package com.example.docker_compose_order.client;


import com.example.docker_compose_order.dto.ProductDTO;
import com.example.docker_compose_order.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@FeignClient(name = "product-service", url = "http://product-service:8082")
public interface ProductClient {
    @GetMapping("/api/products")
    List<ProductDTO> getAllProducts();
}
