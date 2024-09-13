package com.example.sms.service.impl;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.sms.entity.Student;
import com.example.sms.repository.StudentRepository;
import com.example.sms.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	private static final Logger logger = LogManager.getLogger(StudentServiceImpl.class);


	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncode;
	
	@Override
	public List<Student> getAllStudents() {
		System.out.println("get all students");
		 logger.debug("Debug message");
	        logger.info("Info message");
	        logger.warn("Warning message");
	        logger.error("Error message");
		return (List<Student>) studentRepository.findByRole("ROLE_STUDENT");
	}

	@Override
	public Student saveStudent(Student student) {
		student.setPassword(passwordEncode.encode(student.getPassword()));
		student.setRole("ROLE_STUDENT");
		return studentRepository.save(student);
	}

	@Override
	public Student getStudentById(Long studentId) {
		return studentRepository.findById(studentId).get();
	}

	@Override
	public Student updateStudent(Student student) {
		student.setPassword(passwordEncode.encode(student.getPassword()));
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudent(Long studentId) {
		studentRepository.deleteById(studentId);
	}

	@Override
	public boolean checkEmail(String email) {
		// TODO Auto-generated method stub
		return studentRepository.existsByEmail(email);
	}

	@Override
	public Student findByEmail(String email) {
		// TODO Auto-generated method stub
		return studentRepository.findByEmail(email);
	}

	@Override
	public Student findByResetToken(String token) {
		// TODO Auto-generated method stub
		return studentRepository.findByResetToken(token);
	}

}
