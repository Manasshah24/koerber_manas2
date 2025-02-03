package org.example.Service;

import org.example.Exceptions.BookNotFoundException;
import org.example.dto.BookRepo;
import org.example.dto.BookRepoImpl;
import org.example.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value="bs")
public class BookServiceImpl implements BookService{


    private BookRepo bookRepo;

    @Autowired
    public BookServiceImpl(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override

    public Book addBook(Book book) {
        bookRepo.addBook(book);
        return book;
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> books=bookRepo.getAllBooks();
        return books;
    }

    @Override
    public void deleteBook(int id) {
        bookRepo.deleteBook(id);

    }

    @Override
    public Book getBookById(int id)  {
        Book b=bookRepo.getBookById(id);
        if (b==null){
            throw new BookNotFoundException("Book not found");
        }
        else {
            return b;
        }
    }

    @Override
    public void updateBook(int id, Book book) {
        bookRepo.updateBook(id,book);

    }
}
