package com.example.HospitalMangement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long adminId;

	    private String adminName;

	    @Column(unique = true)
	    private String email;

	    private String username;

	    private String password;

	    private String role;  

	    private String phoneNumber;

	    public Admin() {
	    }

	    public Admin(Long adminId, String adminName, String email,
	                 String username, String password,
	                 String role, String phoneNumber) {
	        this.adminId = adminId;
	        this.adminName = adminName;
	        this.email = email;
	        this.username = username;
	        this.password = password;
	        this.role = role;
	        this.phoneNumber = phoneNumber;
	    }

		public Long getAdminId() {
			return adminId;
		}

		public void setAdminId(Long adminId) {
			this.adminId = adminId;
		}

		public String getAdminName() {
			return adminName;
		}

		public void setAdminName(String adminName) {
			this.adminName = adminName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

}
