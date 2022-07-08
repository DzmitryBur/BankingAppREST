package com.cot.bankingapprest.controller;

import com.cot.bankingapprest.model.Role;
import com.cot.bankingapprest.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RoleController {

    private RoleRepository roleRepository;

    @Autowired
    public RoleController(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }


    @GetMapping("/getRoles")
    public String getAllRoles(ModelMap map) {
        List<Role> list = roleRepository.getAllRoles();
        map.addAttribute("list", list);
//        map.addAttribute("someRole", role.toString() );
        return "resultRole";
    }

    @GetMapping("/getRoles/{id}")
    public String getRole(@PathVariable long id, ModelMap map) {
        Role role = roleRepository.getRole(id);
        map.addAttribute("list", role);
//        map.addAttribute("someBank", bank.toString() );
        return "resultRole";
    }
    @PostMapping("/createRoles")
    public String createRole(@RequestParam String role) {
        if (roleRepository.createRole(role) == 1) {
            return "successfully";
        } else {
            return "unsuccessfully";
        }
    }

    @PutMapping("/updateRoles")
    public void updateRole(@RequestParam long id, String role) {
        roleRepository.updateRole(id, role);
    }

    @DeleteMapping("/deleteRoles/{id}")
    public void deleteRole(@PathVariable long id) {
        roleRepository.deleteRole(id);
    }


}
