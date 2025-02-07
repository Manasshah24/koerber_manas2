package org.example.service;

import org.example.dao.Customer;

public interface CustomerService {
    public Customer addCustomer(Customer customer) ;
    public Customer getById(int id);

    }

