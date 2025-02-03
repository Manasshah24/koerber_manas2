package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Service.BookService;
import org.example.Service.BookServiceImpl;
import org.example.config.MyConfig;
import org.example.dto.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx=new AnnotationConfigApplicationContext(MyConfig.class);
        BookService bookService=ctx.getBean("bs",BookService.class);
        bookService.getAllBooks().forEach(System.out::println);

    }


    }

