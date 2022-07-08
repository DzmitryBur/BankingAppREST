package com.cot.bankingapprest.repository;

import com.cot.bankingapprest.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {
    List<User> getAllUsers();

    User getUser(long id);

    int createUser(String name, String industry, String residency, String login, String password);

    void updateUser(long id, String name, String industry, String residency, String login, String password);

    void deleteUser(long id);
}
