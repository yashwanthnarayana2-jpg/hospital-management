package com.example.HospitalMangement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HospitalMangement.model.Patient;
import com.example.HospitalMangement.repository.PatientRepository;

@Service
public class PatientService implements PatientInterface {
	@Autowired
    private PatientRepository patientRepository;

    
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient updatePatient(Integer patientId, Patient patient) {

        Patient existingPatient =
                patientRepository.findById(patientId)
                .orElseThrow(() ->
                    new RuntimeException("Patient Not Found"));

        existingPatient.setPatientName(patient.getPatientName());
        existingPatient.setAge(patient.getAge());
        existingPatient.setGender(patient.getGender());
        existingPatient.setEmail(patient.getEmail());
        existingPatient.setPhoneNumber(patient.getPhoneNumber());
        existingPatient.setAddress(patient.getAddress());
        existingPatient.setBloodGroup(patient.getBloodGroup());
        existingPatient.setDisease(patient.getDisease());

        return patientRepository.save(existingPatient);
    }

    @Override
    public Patient getPatientById(Integer patientId) {
        return patientRepository.findById(patientId)
                .orElseThrow(() ->
                    new RuntimeException("Patient Not Found"));
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

  
    public void deletePatient( Integer patientId) {
        patientRepository.deleteById(patientId);
    }

}
