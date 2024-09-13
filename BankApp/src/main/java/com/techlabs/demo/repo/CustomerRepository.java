package com.techlabs.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techlabs.demo.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    
	
}

