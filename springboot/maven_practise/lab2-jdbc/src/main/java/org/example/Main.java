package org.example;

import org.example.dao.Customer;
import org.example.service.CustomerService;
import org.example.service.CustomerServiceImpl;

public class Main {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerServiceImpl();
        customerService.addCustomer(new Customer("John Doe", "123 Main Street", "55561234"));
        customerService.addCustomer(new Customer("Nisarga kUNDER", "456 Main Street", "8735335"));
        System.out.println(customerService.getById(2));

    }
}