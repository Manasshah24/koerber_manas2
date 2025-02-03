package com.example.lab3_springboot.service;



import com.example.lab3_springboot.dao.AccountDao;
import com.example.lab3_springboot.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    @Transactional
    public void transfer(int from, int to, int amount) {
        Account sender = accountDao.find(from);
        Account receiver = accountDao.find(to);

        if (sender == null || receiver == null) {
            throw new RuntimeException("Invalid account ID(s).");
        }
        if (sender.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance.");
        }

        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);

        accountDao.update(sender);
        accountDao.update(receiver);
    }

    @Override
    @Transactional
    public void deposit(int id, double amount) {
        Account account = accountDao.find(id);
        if (account == null) {
            throw new RuntimeException("Account not found.");
        }
        account.setBalance(account.getBalance() + amount);
        accountDao.update(account);
    }

    @Override
    public Account getAccount(int id) {
        return accountDao.find(id);
    }
}
