package com.example.HospitalMangement.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Doctor{
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long doctorId;

	    private String doctorName;

	    private String specialization;

	    @Column(unique = true)
	    private String email;

	    private String phoneNumber;

	    private int experience;

	    private String qualification;

	    private String address;

	    private String password;

	    @OneToMany(mappedBy = "doctor",
	               cascade = CascadeType.ALL)
	    private List<Patient> patients;

	    @OneToMany(mappedBy = "doctor",
	               cascade = CascadeType.ALL)
	    private List<Appointment> appointments;

	    public Doctor() {
	    }

		public Long getDoctorId() {
			return doctorId;
		}

		public void setDoctorId(Long doctorId) {
			this.doctorId = doctorId;
		}

		public String getDoctorName() {
			return doctorName;
		}

		public void setDoctorName(String doctorName) {
			this.doctorName = doctorName;
		}

		public String getSpecialization() {
			return specialization;
		}

		public void setSpecialization(String specialization) {
			this.specialization = specialization;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public int getExperience() {
			return experience;
		}

		public void setExperience(int experience) {
			this.experience = experience;
		}

		public String getQualification() {
			return qualification;
		}

		public void setQualification(String qualification) {
			this.qualification = qualification;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public List<Patient> getPatients() {
			return patients;
		}

		public void setPatients(List<Patient> patients) {
			this.patients = patients;
		}

		public List<Appointment> getAppointments() {
			return appointments;
		}

		public void setAppointments(List<Appointment> appointments) {
			this.appointments = appointments;
		}


}
