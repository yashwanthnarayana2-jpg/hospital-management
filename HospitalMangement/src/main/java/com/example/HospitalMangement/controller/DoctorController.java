package com.example.HospitalMangement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.HospitalMangement.model.Appointment;
import com.example.HospitalMangement.model.Patient;
import com.example.HospitalMangement.service.AppointmentService;
import com.example.HospitalMangement.service.DoctorService;

@RestController
@CrossOrigin("*")
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private AppointmentService appointmentService;

    // Add Patient
    @PostMapping("/patients")
    public Patient addPatient(@RequestBody Patient patient) {
        return doctorService.addPatient(patient);
    }

    // Update Patient
    @PutMapping("/patients/{id}")
    public Patient updatePatient(
            @PathVariable Integer id,
            @RequestBody Patient patient) {

        return doctorService.updatePatient(id, patient);
    }

    // View All Patients
    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return doctorService.getAllPatients();
    }

    // View Patient By Id
    @GetMapping("/patients/{id}")
    public Patient getPatientById(@PathVariable Integer id) {
        return doctorService.getPatientById(id);
    }

    // View All Appointments
    @GetMapping("/appointments")
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    // Update Appointment Status
    @PutMapping("/appointments/{id}/status")
    public Appointment updateAppointmentStatus(
            @PathVariable  Integer id,
            @RequestParam String status) {

        Appointment appointment =
                appointmentService.getAppointmentById(id);

        appointment.setStatus(status);

        return appointmentService
                .updateAppointment(id, appointment);
    }

}
