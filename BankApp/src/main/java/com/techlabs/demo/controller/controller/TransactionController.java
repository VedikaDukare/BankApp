package com.techlabs.demo.controller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.techlabs.demo.dto.TransactionDto;
import com.techlabs.demo.service.TransactionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/credit")
    public ResponseEntity<String> credit(@Valid @RequestBody TransactionDto transactionDto) {
        transactionService.credit(transactionDto);
        return new ResponseEntity<>("Amount credited successfully", HttpStatus.OK);
    }

    @PostMapping("/debit")
    public ResponseEntity<String> debit(@Valid @RequestBody TransactionDto transactionDto) {
        transactionService.debit(transactionDto);
        return new ResponseEntity<>("Amount debited successfully", HttpStatus.OK);
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@Valid @RequestBody TransactionDto transactionDto) {
        transactionService.transfer(transactionDto);
        return new ResponseEntity<>("Amount transferred successfully", HttpStatus.OK);
    }
}
