package com.example.HospitalMangement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HospitalMangement.model.Appointment;
import com.example.HospitalMangement.model.Patient;
import com.example.HospitalMangement.service.AppointmentService;
import com.example.HospitalMangement.service.PatientService;

@RestController
@CrossOrigin("*")
@RequestMapping("/patient")
public class PatientController {
	@Autowired
	private PatientService patientService;

	@Autowired
	private AppointmentService appointmentService;

	// View Profile
	@GetMapping("/{id}")
	public Patient getPatientById(@PathVariable int id) {
		return patientService.getPatientById(id);
	}

	// Update Profile
	@PutMapping("/{id}")
	public Patient updatePatient(@PathVariable int id, @RequestBody Patient patient) {

		return patientService.updatePatient(id, patient);
	}

	// Book Appointment
	@PostMapping("/appointments")
	public Appointment bookAppointment(@RequestBody Appointment appointment) {

		return appointmentService.bookAppointment(appointment);
	}

	// View All Appointments
	@GetMapping("/appointments")
	public List<Appointment> getAllAppointments() {
		return appointmentService.getAllAppointments();
	}

	// Cancel Appointment
	@DeleteMapping("/appointments/{id}")
	public String cancelAppointment(@PathVariable int id) {

		appointmentService.cancelAppointment(id);

		return "Appointment Cancelled Successfully";
	}

}
