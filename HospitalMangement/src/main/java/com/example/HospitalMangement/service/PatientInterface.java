package com.example.HospitalMangement.service;
import java.util.List;
import com.example.HospitalMangement.model.Patient;

public interface PatientInterface {
	//Patient addPatient(Patient patient);

    Patient updatePatient(Integer patientId, Patient patient);

    Patient getPatientById(Integer patientId);

    List<Patient> getAllPatients();

    //void deletePatient(Integer patientId);
	

}
