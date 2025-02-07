package com.example.payment_ms_3.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Order {
    private Long id;
    private Long productId;
    private Integer quantity;
    private Double totalPrice;
}