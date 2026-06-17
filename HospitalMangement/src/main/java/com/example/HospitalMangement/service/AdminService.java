package com.example.HospitalMangement.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.HospitalMangement.model.Doctor;
import com.example.HospitalMangement.model.Patient;
import com.example.HospitalMangement.repository.DoctorRepository;
import com.example.HospitalMangement.repository.PatientRepository;



@Service
public class AdminService implements AdminInterface{

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

 
    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

 
    public void deleteDoctor(Integer doctorId) {
        doctorRepository.deleteById(doctorId);
    }

     
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

 
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

   
    public void deletePatient(Integer patientId) {
        patientRepository.deleteById(patientId);
    }

  
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }


	 
}
