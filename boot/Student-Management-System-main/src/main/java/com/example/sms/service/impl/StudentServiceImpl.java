package com.example.sms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.sms.entity.Student;
import com.example.sms.repository.StudentRepository;
import com.example.sms.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncode;

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		student.setPassword(passwordEncode.encode(student.getPassword()));
		//student.setRole("ROLE_STUDENT");
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

}
