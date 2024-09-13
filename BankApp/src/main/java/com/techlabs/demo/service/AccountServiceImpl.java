package com.techlabs.demo.service;

import com.techlabs.demo.dto.AccountDto;
import com.techlabs.demo.entity.Account;
import com.techlabs.demo.entity.Customer;
import com.techlabs.demo.repo.AccountRepository;
import com.techlabs.demo.repo.CustomerRepository;
import com.techlabs.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public String addBankAccount(AccountDto accountDto) {
        // Fetch customer by customerId
        Customer customer = customerRepository.findById(accountDto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + accountDto.getCustomerId()));

        // Create a new Account entity and populate its fields
        Account account = new Account();
        account.setAccountNumber(accountDto.getAccountNumber());
        account.setBalance(accountDto.getBalance());
       // account.setCustomer(customer);

        // Save the account entity to the database
        accountRepository.save(account);

        return "Account successfully created for Customer ID: " + accountDto.getCustomerId();
    }

    @Override
    public List<Account> getAllAccounts() {
        // Retrieve and return all accounts from the database
        return accountRepository.findAll();
    }
}
