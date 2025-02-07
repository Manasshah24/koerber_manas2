package com.example.assignment_5.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product")  // Optional: Ensure correct table name mapping
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;

    // Constructors, Getters, Setters
}
