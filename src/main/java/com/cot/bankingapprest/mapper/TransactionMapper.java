package com.cot.bankingapprest.mapper;

import com.cot.bankingapprest.model.Transaction;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TransactionMapper implements RowMapper<Transaction> {


    @Override
    public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
        Transaction transaction = new Transaction();
        transaction.setId(rs.getLong("id"));
        transaction.setAmount(rs.getLong("amount"));
        transaction.setDate(rs.getTimestamp("date"));
        transaction.setId_accounts(rs.getLong("id_accounts"));
        return transaction;
    }
}
