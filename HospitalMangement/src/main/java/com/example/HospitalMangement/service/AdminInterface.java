package com.example.HospitalMangement.service;

import java.util.List;

import com.example.HospitalMangement.model.Doctor;
import com.example.HospitalMangement.model.Patient;

public interface AdminInterface {
	Doctor addDoctor(Doctor doctor);

    void deleteDoctor(Integer doctorId);

    List<Doctor> getAllDoctors();

    Patient addPatient(Patient patient);

    void deletePatient( Integer patientId);

    List<Patient> getAllPatients();

}
