package com.example.adv_spring_security_1.controller;



import com.example.adv_spring_security_1.entity.Book;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private List<Book> books = new ArrayList<>();

    public BookController() {
        // Adding some books for testing
        books.add(new Book(1L, "Book 1", "Author 1"));
        books.add(new Book(2L, "Book 2", "Author 2"));
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return books;
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        books.add(book);
        return book;
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('TEACHER')") // Only TEACHER can delete a book
    public String deleteBook(@PathVariable Long id) {
        books.removeIf(book -> book.getId().equals(id));
        return "Book deleted successfully!";
    }
}
