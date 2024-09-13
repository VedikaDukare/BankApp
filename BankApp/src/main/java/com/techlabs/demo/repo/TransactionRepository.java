package com.techlabs.demo.repo;

import com.techlabs.demo.entity.Account;
import com.techlabs.demo.entity.Transaction;
import java.util.List;

import com.techlabs.demo.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByAccountNumber(String accountNumber);
}




