package com.example.ingress_ms1.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private String productName;
    private Integer quantity;
    private Double price;
}
