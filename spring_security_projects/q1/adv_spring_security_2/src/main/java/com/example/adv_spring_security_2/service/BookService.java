package com.example.adv_spring_security_2.service;



import com.example.adv_spring_security_2.entity.Book;
import com.example.adv_spring_security_2.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book book) {
        book.setId(id);
        return bookRepository.save(book);
    }

    @PreAuthorize("hasRole('TEACHER')") // Only TEACHER can delete books
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
