package com.cot.bankingapprest.repository;

import com.cot.bankingapprest.model.Bank;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankRepository {
    List<Bank> getAllBanks();

    Bank getBank(long id);

    int createBank(Bank bank);

    void updateBank(Bank bank);

    void deleteBank(long id);

}
