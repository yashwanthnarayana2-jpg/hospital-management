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

import com.example.HospitalMangement.model.Appointment;
import com.example.HospitalMangement.model.Doctor;
import com.example.HospitalMangement.model.Patient;
import com.example.HospitalMangement.service.AdminService;
import com.example.HospitalMangement.service.AppointmentService;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class Admincontroller {
	@Autowired
	private AdminService adminService;

	@Autowired
	private AppointmentService appointmentService;
	

	// Add Doctor
	@PostMapping("/doctors")
	public Doctor addDoctor(@RequestBody Doctor doctor) {
		return adminService.addDoctor(doctor);
	}

	// Delete Doctor
	@DeleteMapping("/doctors/{id}")
	public String deleteDoctor(@PathVariable int id) {
		adminService.deleteDoctor(id);
		return "Doctor Deleted Successfully";
	}

	// View All Doctors
	@GetMapping("/doctors")
	public List<Doctor> getAllDoctors() {
		return adminService.getAllDoctors();
	}

	// Add Patient
	@PostMapping("/patients")
	public Patient addPatient(@RequestBody Patient patient) {
		return adminService.addPatient(patient);
	}

	// Delete Patient
	@DeleteMapping("/patients/{id}")
	public String deletePatient(@PathVariable int id) {
		adminService.deletePatient(id);
		return "Patient Deleted Successfully";
	}

	// View All Patients
	@GetMapping("/patients")
	public List<Patient> getAllPatients() {
		return adminService.getAllPatients();
	}

	// View All Appointments
	@GetMapping("/appointments")
	public List<Appointment> getAllAppointments() {
		return appointmentService.getAllAppointments();
	}

}
