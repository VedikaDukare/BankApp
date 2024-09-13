package com.techlabs.demo.repo;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techlabs.demo.entity.User;


public interface UsersRepository extends JpaRepository<User, Integer> {
Optional<User> findByUserName(String username);
	
	boolean existsByUserName(String username);

}