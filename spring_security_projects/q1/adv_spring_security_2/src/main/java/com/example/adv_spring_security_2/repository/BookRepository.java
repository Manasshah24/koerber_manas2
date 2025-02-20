package com.example.adv_spring_security_2.repository;


import com.example.adv_spring_security_2.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
