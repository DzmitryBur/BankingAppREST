package com.cot.bankingapprest.mapper;

import com.cot.bankingapprest.model.Bank;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class BankMapper implements RowMapper<Bank> {


    @Override
    public Bank mapRow(ResultSet rs, int rowNum) throws SQLException {
        Bank bank = new Bank();
        bank.setId(rs.getLong("id"));
        bank.setName(rs.getString("name"));
        bank.setSwift(rs.getString("swift"));
        return bank;
    }
}