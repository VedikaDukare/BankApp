package com.techlabs.demo.controller.controller;

import com.techlabs.demo.dto.AccountDto;
import com.techlabs.demo.entity.Account;
import com.techlabs.demo.service.AccountService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private  AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/add")
    public String addBankAccount(@RequestBody AccountDto account) {
        return accountService.addBankAccount(account);
    }

    @GetMapping("/all")
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }
}
