package com.example.sms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.sms.entity.Student;
import com.example.sms.service.StudentService;

@Controller
public class HomeController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/signin")
	public String login() {
		return "login";
	}

//	List all students
	@GetMapping("/admin/show")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "admin/students";
	}

//	add student
	@GetMapping("/register")
	public String createStudentForm(Model model) {

		// created student object to hold student form data
		Student student = new Student();
		model.addAttribute("student", student);

		return "create_student";
	}

//	save student
	@PostMapping("/createStudent")
	public String saveStudent(@ModelAttribute Student student, HttpSession session) {
		boolean f = studentService.checkEmail(student.getEmail());

		if (f) {
			System.out.println("Email Id already Exists");
			session.setAttribute("msg", "Email Id already Exists");

		} else {
			Student studentDtls = studentService.saveStudent(student);

			if (studentDtls != null) {
				session.setAttribute("msg", "Register Sucessfully....");
				System.out.println("Register Sucessfully....");
			} else {
				session.setAttribute("msg", "Something error in server....");
				System.out.println("Something error in server....");
			}
		}
		return "redirect:/register";
	}

//	update student from page
	@GetMapping("/admin/edit/{id}")
	public String editStudent(@PathVariable Long id, Model model) {
		Student existingStudent = studentService.getStudentById(id);
		model.addAttribute("student", existingStudent);
		return "edit_student";
	}

//	update student actual 
	@PostMapping("/admin/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {
		// Get Student details from database
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setStudId(student.getStudId());
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setGender(student.getGender());
		existingStudent.setAge(student.getAge());
		existingStudent.setEmail(student.getEmail());
		existingStudent.setPassword(student.getPassword());

		// save updated student object
		studentService.updateStudent(existingStudent);

		return "redirect:/admin/show";
	}

//	delete student
	@GetMapping("/admin/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return "redirect:/admin/show";
	}

}
