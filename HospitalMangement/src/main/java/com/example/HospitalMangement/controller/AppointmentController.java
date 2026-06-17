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
import com.example.HospitalMangement.service.AppointmentService;

@RestController
@CrossOrigin("*")
@RequestMapping("/appointments")
public class AppointmentController {
	@Autowired
    private AppointmentService appointmentService;

 
    @PostMapping
    public Appointment bookAppointment(
            @RequestBody Appointment appointment) {

        return appointmentService.bookAppointment(appointment);
    }

   
    @GetMapping("/{id}")
    public Appointment getAppointmentById(
            @PathVariable  Integer id) {

        return appointmentService.getAppointmentById(id);
    }

 
    @GetMapping
    public List<Appointment> getAllAppointments() {

        return appointmentService.getAllAppointments();
    }

     
    @PutMapping("/{id}")
    public Appointment updateAppointment(
            @PathVariable  Integer  id,
            @RequestBody Appointment appointment) {

        return appointmentService.updateAppointment(id, appointment);
    }

    
    @DeleteMapping("/{id}")
    public String cancelAppointment(
            @PathVariable Integer id) {

        appointmentService.cancelAppointment(id);

        return "Appointment Cancelled Successfully";
    }

   
    @GetMapping("/confirm/{token}")
    public String confirmAppointment(
            @PathVariable String token) {

        return appointmentService.confirmAppointment(token);
    }

}
