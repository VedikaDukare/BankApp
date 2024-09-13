package com.techlabs.demo.dto;

import jakarta.validation.constraints.*;
import java.util.List;

public class AccountDto {

    private Long accountId;

    @NotBlank(message = "Account number cannot be blank")
    @Size(min = 10, max = 20, message = "Account number must be between 10 and 20 characters")
    private String accountNumber;

    @NotNull(message = "Balance cannot be null")
    @PositiveOrZero(message = "Balance must be zero or positive")
    private Double balance;

    @NotNull(message = "Customer ID cannot be null")
    private Long customerId;

    private List<TransactionDto> transactions;

    public AccountDto() {}

    public AccountDto(Long accountId, String accountNumber, Double balance, Long customerId, List<TransactionDto> transactions) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerId = customerId;
        this.transactions = transactions;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<TransactionDto> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionDto> transactions) {
        this.transactions = transactions;
    }
}
