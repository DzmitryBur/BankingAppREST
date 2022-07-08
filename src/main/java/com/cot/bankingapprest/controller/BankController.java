package com.cot.bankingapprest.controller;

import com.cot.bankingapprest.model.Bank;
import com.cot.bankingapprest.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank")
public class BankController {

    private BankRepository bankRepository;

    @Autowired
    public BankController(BankRepository bankRepository){
        this.bankRepository = bankRepository;
    }


    @GetMapping
    public ResponseEntity<List<Bank>> getAllBanks() {
        List<Bank> list = bankRepository.getAllBanks();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bank> getBank(@PathVariable long id) {
        Bank bank = bankRepository.getBank(id);
        return new ResponseEntity<>(bank, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody Bank bank) {
        bankRepository.createBank(bank);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateBank(@RequestBody Bank bank) {
        bankRepository.updateBank(bank);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBank(@PathVariable long id) {
        bankRepository.deleteBank(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}

