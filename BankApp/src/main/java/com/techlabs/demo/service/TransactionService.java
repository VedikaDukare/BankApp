package com.techlabs.demo.service;

import java.util.List;
import com.techlabs.demo.dto.TransactionDto;
import com.techlabs.demo.entity.Account;

public interface TransactionService {

    void credit(TransactionDto transactionDto);
    
    void debit(TransactionDto transactionDto);
    
    void transfer(TransactionDto transactionDto);
    
  //  List<Account> getAllTransactions();
}
