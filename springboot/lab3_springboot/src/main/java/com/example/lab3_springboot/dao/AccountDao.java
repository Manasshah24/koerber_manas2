package com.example.lab3_springboot.dao;



import com.example.lab3_springboot.entity.Account;

public interface AccountDao {
    void update(Account account);
    Account find(int id);
}