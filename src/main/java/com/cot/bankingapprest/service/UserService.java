package com.cot.bankingapprest.service;


import com.cot.bankingapprest.repository.UserRepository;
import com.cot.bankingapprest.mapper.UserMapper;
import com.cot.bankingapprest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserRepository {

    private JdbcTemplate jdbcTemplate;
    private UserMapper userMapper;

    @Autowired
    public UserService(JdbcTemplate jdbcTemplate, UserMapper userMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.userMapper = userMapper;
    }

    @Override
    public List<User> getAllUsers() {
        return jdbcTemplate.query("SELECT * FROM users", userMapper);
    }

    @Override
    public User getUser(long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE id=?", userMapper, id);
    }

    @Override
    public int createUser(String name, String industry, String residency, String login, String password) {
        return jdbcTemplate.update("INSERT INTO users(id, name, industry, residency, login, password) VALUES (DEFAULT,?,?,?,?,?)", name, industry, residency, login, password);

    }

    @Override
    public void updateUser(long id, String name, String industry, String residency, String login, String password) {
    }


    @Override
    public void deleteUser(long id) {
        jdbcTemplate.update("DELETE FROM users WHERE id=?", id);
    }
}


