package com.techlabs.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.techlabs.demo.entity.Account;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
	
    Optional<Account> findByAccountNumber(String accountNumber);
}
