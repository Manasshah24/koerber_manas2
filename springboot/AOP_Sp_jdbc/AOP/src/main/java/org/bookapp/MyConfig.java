package org.bookapp;

import org.bookapp.dao.BookDao;
import org.bookapp.dao.BookDaoImpl;
import org.bookapp.service.BookService;
import org.bookapp.service.BookServiceImpl;
import org.bookapp.service.aspect.LoggerAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "org.bookapp")
@EnableAspectJAutoProxy
public class MyConfig {

    @Bean
    public LoggerAspect loggerAspect() {
        return new LoggerAspect();
    }
    @Bean
    public BookDao bookDao() {
        return new BookDaoImpl();
    }

    @Bean
    public BookService bookService(BookDao bookDao) {
        return new BookServiceImpl(bookDao);
    }
}
