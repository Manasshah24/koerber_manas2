package com.example.lab3_springboot.service;

import com.example.lab3_springboot.entity.Account;
public interface AccountService {
    void transfer(int from, int to, int amount);
    void deposit(int id ,double amount);
    Account getAccount(int id);
}
