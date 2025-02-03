package org.example.config;

import org.example.Service.BookService;
import org.example.Service.BookServiceImpl;
import org.example.dto.BookRepo;
import org.example.dto.BookRepoImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "org.example")
@EnableAspectJAutoProxy
@PropertySource(value = "classpath:jdbc.properties")
public class MyConfig {


        @Value(("${jdbc.drivername}"))
        private String driver;

        @Value(("${jdbc.url}"))
        private String url;

        @Value(("${jdbc.username}"))
        private String username;

        @Value(("${jdbc.password}"))
        private String password;

        @Bean
        public DataSource dataSource(){
            DriverManagerDataSource dataSource=new DriverManagerDataSource();
            dataSource.setDriverClassName(driver);
            dataSource.setUrl(url);
            dataSource.setUsername(username);
            dataSource.setPassword(password);

            return dataSource;
        }
        @Bean
        public BookRepo bookRepo(DataSource dataSource) {
            return new BookRepoImpl(dataSource);

    }
    @Bean
    public BookService bookService(BookRepo bookRepo) {
        return new BookServiceImpl(bookRepo);
    }
}
