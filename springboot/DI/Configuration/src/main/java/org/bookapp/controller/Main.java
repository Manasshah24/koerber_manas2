package org.bookapp.controller;

import org.bookapp.MyConfig;
import org.bookapp.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String args[]){
        ApplicationContext ctx =new AnnotationConfigApplicationContext(MyConfig.class);
        BookService bookService = (BookService) ctx.getBean("bs");
        bookService.getAllBooks().forEach(System.out::println);
    }

}
