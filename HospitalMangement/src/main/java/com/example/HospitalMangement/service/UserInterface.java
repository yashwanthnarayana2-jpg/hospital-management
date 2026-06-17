package com.example.HospitalMangement.service;
import java.util.List;
import com.example.HospitalMangement.model.User;
	public interface UserInterface {

	    User register(User user);

	    User findByUsername(String username);

	    List<User> getAllUsers();

	    User getUserById(Integer id);

	    void deleteUser(Integer id);
	}


