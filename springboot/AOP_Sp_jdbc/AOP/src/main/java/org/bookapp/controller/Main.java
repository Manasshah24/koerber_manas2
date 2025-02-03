package org.bookapp.controller;

import org.bookapp.MyConfig;
import org.bookapp.service.BookService;
import org.bookapp.service.BookServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String args[]){
        ApplicationContext ctx =new AnnotationConfigApplicationContext(MyConfig.class);
        BookService bookService = ctx.getBean("bs",BookService.class);
        System.out.println("All books");
        bookService.getAllBooks().forEach(System.out::println);
        System.out.println("Delete Book");
        bookService.deleteBook(1);
    }

}
