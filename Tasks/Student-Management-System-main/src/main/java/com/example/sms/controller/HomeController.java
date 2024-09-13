package com.example.sms.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.sms.entity.Student;
import com.example.sms.service.EmailService;
import com.example.sms.service.StudentService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private EmailService emailService;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/signin")
	public String login() {
		return "login";
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
	public String saveStudent(@ModelAttribute Student student, RedirectAttributes redirectAttributes) {
		boolean f = studentService.checkEmail(student.getEmail());

		if (f) {
			System.out.println("Email Id already Exists");
			redirectAttributes.addFlashAttribute("msg", "Email Id already Exists");

		} else {
			Student studentDtls = studentService.saveStudent(student);

			if (studentDtls != null) {
				redirectAttributes.addFlashAttribute("msg", "Register Sucessfully....");
				System.out.println("Register Sucessfully....");
			} else {
				redirectAttributes.addFlashAttribute("msg", "Something error in server....");
				System.out.println("Something error in server....");
			}
		}
		return "redirect:/register";
	}

	@GetMapping("/forgot-password")
	public String showForgotPasswordForm(Model model) {
		model.addAttribute("student", new Student());
		return "forgot_password";
	}

	@PostMapping("/forgot-password")
	public String processForgotPassword(@ModelAttribute("student") Student student, HttpServletRequest request,
			Model model) {
		Student existingStudent = studentService.findByEmail(student.getEmail());
		if (existingStudent != null) {
			String resetToken = UUID.randomUUID().toString();
			System.out.println("resetToken  = " + resetToken);
			existingStudent.setResetToken(resetToken);
			studentService.updateStudent(existingStudent);

			String resetLink = request.getRequestURL().toString().replace(request.getServletPath(), "")
					+ "/reset-password?token=" + resetToken;
			emailService.sendPasswordResetEmail(existingStudent.getEmail(), resetLink);
			return "forgot_password_confirmation";
		}

		else {
			model.addAttribute("error", "Invalid email address. Please provide a valid email address.");
			return "forgot_password"; // Return to the forgot password form with an error message
		}
	}

	@GetMapping("/reset-password")
	public String showResetPasswordForm(@RequestParam("token") String token, Model model) {
		Student student = studentService.findByResetToken(token);
		if (student != null) {
			model.addAttribute("token", token);
			return "reset_password";
		} else {
			return "reset_password_error";
		}
	}

	@PostMapping("/reset-password")
	public String processResetPassword(@RequestParam("token") String token, @RequestParam("password") String password) {
		Student student = studentService.findByResetToken(token);
		if (student != null) {
			student.setPassword(password);
			student.setResetToken(null);
			studentService.updateStudent(student);
			return "reset_password_success";
		} else {
			return "reset_password_error";
		}
	}

}
