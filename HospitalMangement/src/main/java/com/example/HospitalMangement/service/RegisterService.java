//package com.example.HospitalMangement.service;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.HospitalMangement.model.Register;
//import com.example.HospitalMangement.repository.RegisterRepository;
//@Service
//public class RegisterService {
//	 @Autowired
//	  private  RegisterRepository repo;
//
//	 public String register(Register reg) {
//
//		    Optional<Register> existingUser =
//		            Optional.ofNullable(repo.findByUsername(reg.getUsername()));
//
//		    if (existingUser.isPresent()) {
//		        return "Username already exists";
//		    }
//
//		    repo.save(reg);
//
//		    return "User Registered Successfully";
//		}
//
//}
