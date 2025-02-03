package org.example.Service;
import org.example.dto.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookService {
    public List<Book> getAllBooks();
    public Book addBook(Book book);
    public void deleteBook(int id);
    public void updateBook(int id, Book book);
    public Book getBookById(int id) ;

}
