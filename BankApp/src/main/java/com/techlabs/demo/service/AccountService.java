package com.techlabs.demo.service;

import java.util.List;
import com.techlabs.demo.dto.AccountDto;
import com.techlabs.demo.entity.Account;

public interface AccountService {

    String addBankAccount(AccountDto accountDto);
    
    List<Account> getAllAccounts();
}
