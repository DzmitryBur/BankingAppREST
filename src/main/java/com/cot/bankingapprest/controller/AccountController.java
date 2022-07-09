package com.cot.bankingapprest.controller;

import com.cot.bankingapprest.model.Account;
import com.cot.bankingapprest.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    private AccountRepository accountRepository;

    @Autowired
    public AccountController(AccountRepository accountRepository) { this.accountRepository = accountRepository;
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> list = accountRepository.getAllAccounts();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable long id) {
        Account account = accountRepository.getAccount(id);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createAccount(@RequestBody Account account) {
        accountRepository.createAccount(account);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateAccount(@RequestBody Account account) {
        accountRepository.updateAccount(account);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAccount(@PathVariable long id) {
        accountRepository.deleteAccount(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}

