package com.example.sms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sms.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
	
	public boolean existsByEmail(String email);
	
	public Student findByEmail(String email);
	
	List<Student> findByRole(String role);

	public Student findByResetToken(String token);


}
