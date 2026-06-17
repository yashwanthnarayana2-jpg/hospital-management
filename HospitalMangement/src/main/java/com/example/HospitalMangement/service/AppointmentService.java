package com.example.HospitalMangement.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HospitalMangement.model.Appointment;
import com.example.HospitalMangement.repository.AppointmentRepository;
@Service
public class AppointmentService implements AppointInterface {
	@Autowired
	private AppointmentRepository appointmentRepository;
	@Autowired
	private EmailService emailService;
	@Override
	public Appointment bookAppointment(Appointment appointment) {

		appointment.setStatus("PENDING");
		appointment.setConfirmationToken(UUID.randomUUID().toString());
		Appointment savedAppointment = appointmentRepository.save(appointment);

		  try {
		        emailService.sendAppointmentEmail(savedAppointment);
		    } catch (Exception e) {
		        System.out.println("Email sending failed: " + e.getMessage());
		    }
	    return savedAppointment;
		 
	}

	@Override
	public Appointment updateAppointment(Integer appointmentId, Appointment appointment) {

		Appointment exist = appointmentRepository.findById(appointmentId)
				.orElseThrow(() -> new RuntimeException("Appointment Not Found"));

		exist.setAppointmentDate(appointment.getAppointmentDate());

		exist.setAppointmentTime(appointment.getAppointmentTime());

		exist.setStatus(appointment.getStatus());

		return appointmentRepository.save(exist);
	}

	@Override
	public Appointment getAppointmentById(Integer appointmentId) {

		return appointmentRepository.findById(appointmentId)
				.orElseThrow(() -> new RuntimeException("Appointment Not Found"));
	}

	@Override
	public List<Appointment> getAllAppointments() {
		return appointmentRepository.findAll();
	}

	@Override
	public void cancelAppointment(Integer id) {

		Appointment appointment = appointmentRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Appointment Not Found"));

		appointment.setStatus("CANCELLED");

		appointmentRepository.save(appointment);
	}
	

	@Override
	public String confirmAppointment(String token) {

	    Appointment appointment =
	            appointmentRepository.findByConfirmationToken(token);

	    if (appointment == null) {
	        return "Invalid Confirmation Link";
	    }

	    appointment.setStatus("CONFIRMED");

	    appointmentRepository.save(appointment);

	    emailService.sendConfirmedEmail(appointment);

	    return "Appointment Confirmed Successfully";
	}

}
