package com.example.payment_ms_3.entity;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  // If using Lombok, this should generate getters/setters
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderId;  // Ensure this field exists
    private Double amount;
    private String status;

    // If Lombok is not working, manually add getter
    public Long getOrderId() {
        return orderId;
    }
}
