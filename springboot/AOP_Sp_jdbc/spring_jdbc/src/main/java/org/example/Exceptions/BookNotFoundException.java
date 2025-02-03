package org.example.Exceptions;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String bookNotFound) {
        super(bookNotFound);
    }
}
