package com.example.kafka_serializer_consumer.entity;

public class MyObject {
    private String id;
    private String name;
    private int age;

    // Default constructor (needed for deserialization)
    public MyObject() {}

    public MyObject(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    @Override
    public String toString() {
        return "MyObject{id='" + id + "', name='" + name + "', age=" + age + "}";
    }
}
