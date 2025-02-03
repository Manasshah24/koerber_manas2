package com.example.lab3_springboot.dao;



import com.example.lab3_springboot.entity.Account;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AccountDaoImpl implements AccountDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void update(Account account) {
        entityManager.merge(account);
    }

    @Override
    public Account find(int id) {
        return entityManager.find(Account.class, id);
    }
}
