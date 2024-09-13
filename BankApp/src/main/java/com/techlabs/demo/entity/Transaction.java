package com.techlabs.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @NotBlank(message = "Transaction type cannot be blank")
    @Column(name = "transactionType", nullable = false)
    private String transactionType;

    @Positive(message = "Amount must be greater than zero")
    @Column(name = "amount", nullable = false)
    private double amount;

    @NotBlank(message = "Sender account number cannot be blank")
    @Size(min = 10, max = 20, message = "Sender account number must be between 10 and 20 characters")
    @Column(name = "senderAccNo", nullable = false)
    private String senderAccNo;

    @NotBlank(message = "Receiver account number cannot be blank")
    @Size(min = 10, max = 20, message = "Receiver account number must be between 10 and 20 characters")
    @Column(name = "reciverAccNo", nullable = false)
    private String receiverAccNo;

    @PastOrPresent(message = "Transaction date must be in the past or present")
    @Column(name = "transactionDate", nullable = false)
    private LocalDateTime transactionDate;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    public Transaction() {}

    public Transaction(String transactionType, double amount, String senderAccNo, String receiverAccNo, LocalDateTime transactionDate, Account account) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.senderAccNo = senderAccNo;
        this.receiverAccNo = receiverAccNo;
        this.transactionDate = transactionDate;
        this.account = account;
    }

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getSenderAccNo() {
		return senderAccNo;
	}

	public void setSenderAccNo(String senderAccNo) {
		this.senderAccNo = senderAccNo;
	}

	public String getReceiverAccNo() {
		return receiverAccNo;
	}

	public void setReceiverAccNo(String receiverAccNo) {
		this.receiverAccNo = receiverAccNo;
	}

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public void setType(String type) {
		// TODO Auto-generated method stub
		
	}

	public void setSenderAccountNumber(String senderAccountNumber) {
		// TODO Auto-generated method stub
		
	}

	public void setReceiverAccountNumber(String receiverAccountNumber) {
		// TODO Auto-generated method stub
		
	}

}
