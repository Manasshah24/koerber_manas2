package org.example.dao;

import org.example.Exceptions.DaoException;
import org.example.factory.FactoryConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CustomerDaoImpl implements CustomerDao {

    private Connection connection;

    public CustomerDaoImpl() {
        this.connection = FactoryConnection.getConnection();
    }
    @Override
    public Customer addCustomer(Customer customer) throws DaoException {

        try{
            PreparedStatement preparedStatement= connection.prepareStatement("insert into customer(name, address, phone) values(?,?,?)");
            preparedStatement.setString(1,customer.getName());
            preparedStatement.setString(2,customer.getAddress());
            preparedStatement.setString(3, customer.getPhone());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            throw new DaoException("Customer Already Exists",e);
        }
        return customer;

    }


    @Override
    public Customer findById(int id) {
        Customer customer = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from customer where id=?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                customer = new Customer(rs.getString("name"), rs.getString("address"), rs.getString("phone"));
            }
        } catch (SQLException e) {
            throw new DaoException("Book not found", e);
        }
return customer;
    }
}
