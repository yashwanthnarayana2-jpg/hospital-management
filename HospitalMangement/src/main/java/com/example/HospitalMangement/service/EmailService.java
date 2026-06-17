package com.example.HospitalMangement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.HospitalMangement.model.Appointment;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendAppointmentEmail(Appointment appointment) {

        String patientEmail = appointment.getPatient().getEmail();

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(patientEmail);
        message.setSubject("Appointment Confirmation");

        message.setText(
                "Dear " + appointment.getPatient().getPatientName() + ",\n\n" +
                "Your appointment has been confirmed.\n\n" +
                "Doctor: " + appointment.getDoctor().getDoctorName() + "\n" +
                "Specialization: " + appointment.getDoctor().getSpecialization() + "\n" +
                "Date: " + appointment.getAppointmentDate() + "\n" +
                "Time: " + appointment.getAppointmentTime() + "\n\n" +
                "Thank you."
        );

        mailSender.send(message);
    }
    public void sendConfirmedEmail(Appointment appointment) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(appointment.getPatient().getEmail());

        message.setSubject("Appointment Confirmed");

        message.setText(
                "Dear " + appointment.getPatient().getPatientName() +
                ",\n\nYour appointment has been confirmed.\n\n" +
                "Doctor: " + appointment.getDoctor().getDoctorName() +
                "\nDate: " + appointment.getAppointmentDate() +
                "\nTime: " + appointment.getAppointmentTime() +
                "\n\nRegards,\nHospital Management System"
        );

        mailSender.send(message);
    }
}