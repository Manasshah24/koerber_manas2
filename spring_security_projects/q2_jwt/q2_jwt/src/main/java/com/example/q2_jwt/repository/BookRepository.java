package com.example.q2_jwt.repository;


import com.example.q2_jwt.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}