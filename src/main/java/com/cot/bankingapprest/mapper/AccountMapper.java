package com.cot.bankingapprest.mapper;

import com.cot.bankingapprest.model.Account;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AccountMapper implements RowMapper<Account> {


    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account account = new Account();
        account.setId(rs.getLong("id"));
        account.setIban(rs.getString("iban"));
        account.setBalance(rs.getLong("balance"));
        account.setBanks_id(rs.getLong("banks_id"));
        account.setUser_id(rs.getLong("user_id"));
        return account;
    }
}
