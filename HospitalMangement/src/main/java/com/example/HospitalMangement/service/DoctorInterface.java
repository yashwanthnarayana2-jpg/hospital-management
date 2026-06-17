package com.example.HospitalMangement.service;
import java.util.List;
import com.example.HospitalMangement.model.Doctor;
import com.example.HospitalMangement.model.Patient;

public interface DoctorInterface {
	Doctor getDoctorById(Integer doctorId);

    List<Doctor> getAllDoctors();

    Patient addPatient(Patient patient);

    Patient updatePatient(Integer patientId, Patient patient);

    Patient getPatientById(Integer patientId);

    List<Patient> getAllPatients();
}

