package com.example.HospitalMangement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HospitalMangement.DTO.LoginRequest;
import com.example.HospitalMangement.model.User;
import com.example.HospitalMangement.service.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
  
	@PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        return userService.login(request);
    }
    
	@GetMapping("/{id}")
	public User getUserById(@PathVariable int id) {
		return userService.getUserById(id);
	}

	@GetMapping("/all")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
		return "User Deleted Successfully";
	}
}
