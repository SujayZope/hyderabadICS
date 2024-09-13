package com.excel.db.service.Impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excel.db.model.Student;
import com.excel.db.repository.StudentRepository;
import com.excel.db.service.StudentService;
import com.excel.db.utils.EmailUtils;
import com.excel.db.utils.ExcelUtils;

@Service
public class StudentServiceImpl implements StudentService {

	private final StudentRepository studentRepository;
	private final ExcelUtils excelUtils;
	private final EmailUtils emailUtils;

	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository, ExcelUtils excelUtils, EmailUtils emailUtils) {
		this.studentRepository = studentRepository;
		this.excelUtils = excelUtils;
		this.emailUtils = emailUtils;
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public List<Student> getStudentsWithoutErrors() {
		return studentRepository.findByErrorRemarksIsNull();
	}

	@Override
	public List<Student> getStudentsWithErrors() {
		return studentRepository.findByErrorRemarksIsNotNull();
	}

	@Override
	public void processAndSaveStudents(List<Student> students) {
		List<Student> studentsWithErrors = new ArrayList<>();
		for (Student student : students) {
			// Perform processing and set error remarks if needed
			String errorRemarks = validateStudentData(student);
			student.setErrorRemarks(errorRemarks);
			// Check if validation failed (errorRemarks is not null or empty)
			if (errorRemarks != null && !errorRemarks.isEmpty()) {
				studentsWithErrors.add(student);
			}
		}
		// Send error email with Excel attachment only if there are students with errors
		if (!studentsWithErrors.isEmpty()) {
			try {
				emailUtils.sendErrorEmailWithAttachment(studentsWithErrors);
			} catch (MessagingException | IOException | jakarta.mail.MessagingException e) {
				// Handle email sending exception
				e.printStackTrace();
			}
		}
		// Save students (whether they have errors or not)
		studentRepository.saveAll(students);
	}

	public String validateStudentData(Student student) {
		StringBuilder errorRemarks = new StringBuilder();

		// Example validation: Check if subject marks are missing

		if (student.getFirstName() == null || student.getFirstName().isEmpty()) {
			errorRemarks.append("First Name missing. ");
		}
		if (student.getLastName() == null || student.getLastName().isEmpty()) {
			errorRemarks.append("Second Name missing. ");
		}
		if (student.getHallticketNumber() == null || student.getHallticketNumber().isEmpty()) {
			errorRemarks.append("Hall ticket Number missing. ");
		}
		if (student.getDob() == null) {
			errorRemarks.append("Date of birth missing. ");
		}
		if (student.getFirstLanguage() == null || student.getFirstLanguage().isEmpty()) {
			errorRemarks.append("First Language subject marks are missing. ");
		}
		if (student.getSecondLanguage() == null || student.getSecondLanguage().isEmpty()) {
			errorRemarks.append("Second Language subject marks are missing. ");
		}
		if (student.getThirdLanguage() == null || student.getThirdLanguage().isEmpty()) {
			errorRemarks.append("Third Language subject marks are missing. ");
		}
		if (student.getMathematics() == null || student.getMathematics().isEmpty()) {
			errorRemarks.append("Mathematics subject marks are missing. ");
		}
		if (student.getGeneralScience() == null || student.getGeneralScience().isEmpty()) {
			errorRemarks.append("General Science subject marks are missing. ");
		}
		if (student.getSocialStudies() == null || student.getSocialStudies().isEmpty()) {
			errorRemarks.append("Social Studies subject marks are missing. ");
		}

		// Return error remarks or an empty string if no errors
		return errorRemarks.toString();
	}
}
