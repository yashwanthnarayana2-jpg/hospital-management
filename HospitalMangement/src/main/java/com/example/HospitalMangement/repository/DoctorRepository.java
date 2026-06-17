package com.example.HospitalMangement.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.HospitalMangement.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository <Doctor, Integer>{

}
