package com.cot.bankingapprest.controller;

import com.cot.bankingapprest.model.Bank;
import com.cot.bankingapprest.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BankController {

    private BankRepository bankRepository;

    @Autowired
    public BankController(BankRepository bankRepository){
        this.bankRepository = bankRepository;
    }


    @GetMapping("/getBanks")
    public String getAllBanks(ModelMap map) {
        List<Bank> list = bankRepository.getAllBanks();
        map.addAttribute("list", list);
//        map.addAttribute("someBank", bank.toString() );
        return "resultBank";
    }

    @GetMapping("/getBanks/{id}")
    public String getBank(@PathVariable long id, ModelMap map) {
        Bank bank = bankRepository.getBank(id);
        map.addAttribute("list", bank);
//        map.addAttribute("someBank", bank.toString() );
        return "resultBank";
    }
    @PostMapping("/createBanks")
    public String createBank(@RequestParam String name, String swift) {
        if (bankRepository.createBank(name, swift) == 1) {
            return "successfully";
        } else {
            return "unsuccessfully";
        }
    }

    @PutMapping("/updateBanks")
    public void updateBank(@RequestParam long id, String name, String swift) {
        bankRepository.updateBank(id, name, swift);
    }

    @DeleteMapping("/deleteBanks/{id}")
    public void deleteBank(@PathVariable long id) {
        bankRepository.deleteBank(id);
    }


}

