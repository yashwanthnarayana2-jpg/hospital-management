package com.example.HospitalMangement.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HospitalMangement.DTO.LoginRequest;
import com.example.HospitalMangement.model.User;
import com.example.HospitalMangement.repository.UserRepository;

@Service
public class UserService implements UserInterface {
	   @Autowired
	    private UserRepository userRepository;
	   
	   
	// Register
	    public String register1(User user) {

	        User existingUser =
	                userRepository.findByUsername(user.getUsername());

	        if (existingUser != null) {
	            return "Username already exists";
	        }

	        userRepository.save(user);

	        return "User Registered Successfully";
	    }

	    // Login
	    public String login(LoginRequest request) {

	        User user =
	                userRepository.findByUsername(request.getUsername());

	        if (user == null) {
	            return "User Not Found";
	        }

	        if (request.getPassword().equals(user.getPassword())) {
	            return "Login Successful. Role: " + user.getRole();
	        }

	        return "Invalid Credentials";
	    }
	
	    @Override
	    public User register(User user) {
	        return userRepository.save(user);
	    }
	    @Override
	    public User findByUsername(String username) {

	        return userRepository.findByUsername(username);

	    }

	    @Override
	    public List<User> getAllUsers() {

	        return userRepository.findAll();
	    }

	    @Override
	    public User getUserById(Integer id) {

	        return userRepository
	                .findById(id)
	                .orElse(null);
	    }

	    @Override
	    public void deleteUser(Integer id) {

	        userRepository.deleteById(id);
	    }
	}
	 

