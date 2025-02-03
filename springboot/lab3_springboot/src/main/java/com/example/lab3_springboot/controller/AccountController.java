package com.example.lab3_springboot.controller;


import com.example.lab3_springboot.dto.AccountBean;
import com.example.lab3_springboot.entity.Account;
import com.example.lab3_springboot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    // Transfer money from one account to another
    @PostMapping("/transfer")
    public String transfer(@RequestBody AccountBean accountBean) {
        accountService.transfer(accountBean.getFrom(), accountBean.getTo(), accountBean.getAmount());
        return "Transfer successful from Account " + accountBean.getFrom() + " to Account " + accountBean.getTo();
    }

    // Deposit money into an account
    @PostMapping("/deposit/{id}/{amount}")
    public String deposit(@PathVariable int id, @PathVariable double amount) {
        accountService.deposit(id, amount);
        return "Amount " + amount + " deposited to Account " + id;
    }

    // Fetch account details
    @GetMapping("/{id}")
    public Account getAccount(@PathVariable int id) {
        return accountService.getAccount(id);
    }
}
