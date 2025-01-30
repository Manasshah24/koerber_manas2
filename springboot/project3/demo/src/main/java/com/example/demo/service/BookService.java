package com.example.demo.service;



import com.example.demo.entity.Book;

import java.util.List;

public interface BookService {
    public List<Book> getAll();
    public Book getById(int id);
    public Book save(Book book);
    public void delete(int id);
    public Book update(int id, Book book);
}