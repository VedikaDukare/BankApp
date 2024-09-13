package com.techlabs.demo.service;

import com.techlabs.demo.dto.TransactionDto;
import com.techlabs.demo.entity.Account;
import com.techlabs.demo.entity.Transaction;
import com.techlabs.demo.repo.AccountRepository;
import com.techlabs.demo.repo.TransactionRepository;
import com.techlabs.demo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public void credit(TransactionDto transactionDto) {
        // Fetch the receiver's account using account number
        Account receiverAccount = accountRepository.findByAccountNumber(transactionDto.getReceiverAccountNumber())
                .orElseThrow(() -> new RuntimeException("Receiver account not found"));

        // Credit amount to the receiver's account
        receiverAccount.setBalance(receiverAccount.getBalance() + transactionDto.getAmount());

        // Save the updated account information
        accountRepository.save(receiverAccount);

        // Save the transaction record as CREDIT
        saveTransaction(transactionDto, "CREDIT");
    }

    @Override
    public void debit(TransactionDto transactionDto) {
        // Fetch the sender's account using account number
        Account senderAccount = accountRepository.findByAccountNumber(transactionDto.getSenderAccountNumber())
                .orElseThrow(() -> new RuntimeException("Sender account not found"));

        // Check if there is enough balance in the sender's account
        if (senderAccount.getBalance() < transactionDto.getAmount()) {
            throw new RuntimeException("Insufficient balance in sender's account");
        }

        // Debit amount from the sender's account
        senderAccount.setBalance(senderAccount.getBalance() - transactionDto.getAmount());

        // Save the updated account information
        accountRepository.save(senderAccount);

        // Save the transaction record as DEBIT
        saveTransaction(transactionDto, "DEBIT");
    }

    @Override
    public void transfer(TransactionDto transactionDto) {
        // Debit from sender's account
        debit(transactionDto);

        // Credit to receiver's account
        credit(transactionDto);

        // Save the transaction record as TRANSFER
        saveTransaction(transactionDto, "TRANSFER");
    }

	private void saveTransaction(TransactionDto transactionDto, String string) {
			
	}


}
