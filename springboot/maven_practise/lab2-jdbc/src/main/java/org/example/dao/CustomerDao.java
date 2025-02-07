package org.example.dao;

public interface CustomerDao {
    public Customer addCustomer(Customer customer);
    public Customer findById(int id);
}
