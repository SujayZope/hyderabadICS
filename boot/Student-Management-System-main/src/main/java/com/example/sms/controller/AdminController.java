package com.example.sms.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.sms.entity.Student;
import com.example.sms.repository.StudentRepository;

@Controller
@RequestMapping("/admin/")
public class AdminController {
	
	@Autowired
	private StudentRepository studRepo;
	
	@ModelAttribute
	private void studentDetails(Model m,Principal p) {
		String email = p.getName();
		
		Student student = studRepo.findByEmail(email);
		
		m.addAttribute("student",student);
		
	}
	
	@GetMapping("/")
	public String home() {
		return "admin/home";
	}
	
	
}