package com.example.HospitalMangement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.HospitalMangement.model.Appointment;
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{
 
	Appointment findByConfirmationToken(String token);

}
