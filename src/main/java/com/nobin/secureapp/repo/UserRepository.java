package com.nobin.secureapp.repo;



import org.springframework.data.jpa.repository.JpaRepository;


import com.nobin.secureapp.Users;

public interface UserRepository extends JpaRepository< Users, Long> {
	Users findByUsername(String username); 
}
