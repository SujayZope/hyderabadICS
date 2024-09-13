package com.thymeleaf.controller;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

	@GetMapping("/about")
	public String about(Model model) {

		System.out.println("Inside about handler...");
		// putting data module
		model.addAttribute("name", "Sujay Zope");
		model.addAttribute("currentDate", new Date().toLocaleString());
		return "about";
		// about.html
	}

	// HANDLING ITERATION

	@GetMapping("/example-loop")
	public String iterateHandler(Model m) {

		List<String> names = List.of("Anikit", "Laxmi", "Karan", "john");
		m.addAttribute("names", names);

		return "iterate";
	}

	// HANDLER FOR CONDITIONAL STATEMENT
	@GetMapping("/condition")
	public String ConditionHandler(Model m) {
		System.out.println("Condition handler executed..");
		m.addAttribute("isActive", false);
		m.addAttribute("gender", "F");

		List<Integer> list = List.of(232, 34, 325, 56, 43, 6, 4);
		m.addAttribute("mylist", list);

		return "condition";
	}

	
	// HANDLER FOR INCLUDING FRAGMENT
	@GetMapping("/service")
	public String servicesHandler(Model m) {
		m.addAttribute("title","I like to eat samosa");
		m.addAttribute("subtitle", LocalDateTime.now().toString());
		return "service";
	}

}
