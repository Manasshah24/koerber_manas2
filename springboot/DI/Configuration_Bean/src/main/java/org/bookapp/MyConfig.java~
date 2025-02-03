package org.bookapp;

import org.bookapp.dao.BookDao;
import org.bookapp.dao.BookDaoImpl;
import org.bookapp.service.BookService;
import org.bookapp.service.BookServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.bookapp")
public class MyConfig {
    @Bean
    public BookDao bookDao() {
        return new BookDaoImpl();
    }
    @Bean
    public BookService bookService(BookDao bookDao) {
        return new BookServiceImpl(bookDao);
    }

}
