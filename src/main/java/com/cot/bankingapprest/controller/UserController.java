package com.cot.bankingapprest.controller;

import com.cot.bankingapprest.model.User;
import com.cot.bankingapprest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/getUsers")
    public String getAllUsers(ModelMap map) {
        List<User> list = userRepository.getAllUsers();
        map.addAttribute("list", list);
//        map.addAttribute("someUser", user.toString() );
        return "resultUser";
    }

    @GetMapping("/getUsers/{id}")
    public String getUser(@PathVariable long id, ModelMap map) {
        User user = userRepository.getUser(id);
        map.addAttribute("list", user);
//        map.addAttribute("list", user.toString() );
        return "resultUser";
    }
    @PostMapping("/createUsers")
    public String createUser(@RequestParam String name, String industry, String residency, String login, String password) {
        if (userRepository.createUser(name, industry, residency, login,password) == 1) {
            return "successfully";
        } else {
            return "unsuccessfully";
        }
    }

    @PutMapping("/updateUsers")
    public void updateUser(@RequestParam long id, String name, String industry, String residency, String login, String password) {
        userRepository.updateUser(id, name, industry, residency, login,password);
    }

    @DeleteMapping("/deleteUsers/{id}")
    public void deleteUser(@PathVariable long id) {
        userRepository.deleteUser(id);
    }


}
