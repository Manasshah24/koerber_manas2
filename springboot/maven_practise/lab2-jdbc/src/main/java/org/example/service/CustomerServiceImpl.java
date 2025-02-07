package org.example.service;

import org.example.Exceptions.DaoException;
import org.example.dao.Customer;
import org.example.dao.CustomerDao;
import org.example.dao.CustomerDaoImpl;

public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao = new CustomerDaoImpl();

    @Override
    public Customer addCustomer(Customer customer) throws DaoException {

        return customerDao.addCustomer(customer);


    }
    @Override
    public Customer getById(int id) throws DaoException {
        return customerDao.findById(id);
    }

}
