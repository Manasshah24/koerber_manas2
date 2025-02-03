package org.bookapp.service;

import org.bookapp.dao.Book;
import org.bookapp.dao.BookDao;
import org.bookapp.dao.BookDaoImpl;

import java.util.List;

public  class BookServiceImpl implements BookService {

    //BAD CODE HARD CODING....

    private BookDao dao;

    public void setDao(BookDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Book> getAllBooks() {
        return dao.getAllBooks();
    }

    @Override
    public Book addBook(Book book) {
        return dao.addBook(book);
    }

    @Override
    public void deleteBook(int id) {
        dao.deleteBook(id);
    }

    @Override
    public void updateBook(int id, Book book) {
        dao.updateBook(id, book);
    }

    @Override
    public Book getBookById(int id) {
        return dao.getBookById(id);
    }

}
