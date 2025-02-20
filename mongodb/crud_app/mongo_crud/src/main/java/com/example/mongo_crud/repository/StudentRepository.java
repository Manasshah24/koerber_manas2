package com.example.mongo_crud.repository;


import com.example.mongo_crud.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
    // Additional query methods can be added here
}

