package com.cot.bankingapprest.controller;

import com.cot.bankingapprest.model.Transaction;
import com.cot.bankingapprest.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private TransactionRepository transactionRepository;

    @Autowired
    public TransactionController(TransactionRepository transactionRepository) { this.transactionRepository = transactionRepository;
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> list = transactionRepository.getAllTransactions();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransaction(@PathVariable long id) {
        Transaction transaction = transactionRepository.getTransaction(id);
        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createTransaction(@RequestBody Transaction transaction) {
        transactionRepository.createTransaction(transaction);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateTransaction(@RequestBody Transaction transaction) {
        transactionRepository.updateTransaction(transaction);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTransaction(@PathVariable long id) {
        transactionRepository.deleteTransaction(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}


