package com.cot.bankingapprest.repository;

import com.cot.bankingapprest.model.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository {

    List<Account> getAllAccounts();

    Account getAccount(long id);

    int createAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(long id);
}
