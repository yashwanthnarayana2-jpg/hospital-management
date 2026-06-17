package com.example.HospitalMangement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HospitalMangement.model.Doctor;
import com.example.HospitalMangement.model.Patient;
import com.example.HospitalMangement.repository.DoctorRepository;
import com.example.HospitalMangement.repository.PatientRepository;

@Service
public class DoctorService implements DoctorInterface{
	 
	    @Autowired
	    private DoctorRepository doctorRepository;

	    @Autowired
	    private PatientRepository patientRepository;

	    @Override
	    public Doctor getDoctorById(Integer doctorId) {
	        return doctorRepository.findById(doctorId)
	                .orElseThrow(() ->
	                        new RuntimeException("Doctor Not Found"));
	    }

	    @Override
	    public List<Doctor> getAllDoctors() {
	        return doctorRepository.findAll();
	    }

	    @Override
	    public Patient addPatient(Patient patient) {
	        return patientRepository.save(patient);
	    }

	    @Override
	    public Patient updatePatient( Integer patientId, Patient patient) {

	        Patient ep =
	                patientRepository.findById(patientId)
	                .orElseThrow(() ->
	                        new RuntimeException("Patient Not Found"));

	        ep.setPatientName(patient.getPatientName());
	        ep.setAge(patient.getAge());
	        ep.setGender(patient.getGender());
	        ep.setEmail(patient.getEmail());
	        ep.setPhoneNumber(patient.getPhoneNumber());
	        ep.setAddress(patient.getAddress());
	        ep.setBloodGroup(patient.getBloodGroup());
	        ep.setDisease(patient.getDisease());

	        return patientRepository.save(ep);
	    }

	    @Override
	    public Patient getPatientById( Integer patientId) {
	        return patientRepository.findById(patientId)
	                .orElseThrow(() ->
	                        new RuntimeException("Patient Not Found"));
	    }

	    @Override
	    public List<Patient> getAllPatients() {
	        return patientRepository.findAll();
	    }
	}


