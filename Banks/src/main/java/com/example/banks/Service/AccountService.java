package com.example.banks.Service;

import com.example.banks.Repository.AccountRepository;
import com.example.banks.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    public void save(Account account)  {

        account.setCreatedOn(LocalDateTime.now());
        accountRepository.save(account);
    }

    public List<Account> showAll() {
       return accountRepository.findAll();
    }
}
