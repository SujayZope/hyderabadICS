package com.example.sms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "students")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "age")
	private String age;
	
	@Column(name = "Gender")
	private String gender;
	
	@Column(name = "token")
	private String resetToken;
	
	@Column(name = "role")
	private String role;

	@Column(name = "email", unique = true)
	private String email;
	
	@Column(name = "password")
	private String password;
	
	

	
	

}
