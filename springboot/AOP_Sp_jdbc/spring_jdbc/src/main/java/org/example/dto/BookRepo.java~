package org.example.Repository;

import org.example.Exceptions.DaoException;
import org.example.dto.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookRepo {
    public List<Book> getAllBooks()throws DaoException;
    public Book addBook(Book book) throws DaoException;
    public void deleteBook(int id) throws DaoException;
    public void updateBook(int id, Book book) throws DaoException;
    public Book getBookById(int id) throws DaoException;

}
