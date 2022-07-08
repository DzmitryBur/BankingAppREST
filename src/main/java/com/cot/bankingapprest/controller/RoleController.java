package com.cot.bankingapprest.controller;

import com.cot.bankingapprest.model.Bank;
import com.cot.bankingapprest.model.Role;
import com.cot.bankingapprest.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    private RoleRepository roleRepository;

    @Autowired
    public RoleController(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }


    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> list = roleRepository.getAllRoles();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getRole(@PathVariable long id) {
        Role role = roleRepository.getRole(id);
        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createRole(@RequestBody Role role) {
        roleRepository.createRole(role);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateRole(@RequestBody Role role) {
        roleRepository.updateRole(role);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteRole(@PathVariable long id) {
        roleRepository.deleteRole(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}
