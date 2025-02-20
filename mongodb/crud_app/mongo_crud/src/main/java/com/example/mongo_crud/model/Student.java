package com.example.mongo_crud.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "students") // Specifies MongoDB collection name
public class Student {
    @Id
    private String id; // MongoDB generates this automatically
    private String name;
    private int age;
    private String email;
}

