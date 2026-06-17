package com.example.HospitalMangement.repository;

 

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HospitalMangement.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	User findByUsername(String username);

}
