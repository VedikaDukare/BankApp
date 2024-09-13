package com.techlabs.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.List;

import com.techlabs.demo.dto.CustomerDto;

@Entity
@Table(name="accounts")
public class Account {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="accountId")
    private Long accountId;
    
    @NotNull(message = "Account number cannot be null")
    @Size(min = 10, max = 12, message = "Account number must be between 10 and 12 characters")
    @Column(name="accountNumber", unique = true, nullable = false)
    private String accountNumber;
    
    @NotNull(message = "Balance cannot be null")
    @Min(value = 0, message = "Balance must be a positive amount")
    @Column(name="balance", nullable = false)
    private Double balance;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerDto customer;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Transaction> transactions;

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

	public CustomerDto getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDto customer) {
		this.customer = customer;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

}