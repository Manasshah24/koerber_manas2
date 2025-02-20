package com.example.q2_jwt.controller;


import com.example.q2_jwt.model.Book;
import com.example.q2_jwt.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_TEACHER')")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_TEACHER')")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
