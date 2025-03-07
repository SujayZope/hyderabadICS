package com.example.sms.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "admin")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studId;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "age")
	private String age;

	@Column(name = "Gender")
	private String gender;

	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "password")
	private String password;

	@OneToMany
    @JoinColumn(name = "roleId")
    private Role role;


	

	
	
	
	
}
