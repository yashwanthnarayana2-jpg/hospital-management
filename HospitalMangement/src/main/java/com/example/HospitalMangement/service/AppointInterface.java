package com.example.HospitalMangement.service;

import java.util.List;

import com.example.HospitalMangement.model.Appointment;

public interface AppointInterface {
	Appointment bookAppointment(Appointment appointment);
	public String confirmAppointment(String token);

    Appointment updateAppointment(Integer appointmentId, Appointment appointment);

    Appointment getAppointmentById(Integer appointmentId);

    List<Appointment> getAllAppointments();

    void cancelAppointment(Integer appointmentId);

}
