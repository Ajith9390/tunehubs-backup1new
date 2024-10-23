package com.example.tunenub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tunenub.entity.User;

public interface UserRepository extends JpaRepository<User, String>{
	
 public User findByEmail(String email);

	

}
