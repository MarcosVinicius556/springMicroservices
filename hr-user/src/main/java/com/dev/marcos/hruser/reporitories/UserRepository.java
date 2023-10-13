package com.dev.marcos.hruser.reporitories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.marcos.hruser.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);
	
}
