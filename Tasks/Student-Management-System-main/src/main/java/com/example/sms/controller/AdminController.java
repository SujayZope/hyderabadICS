package com.example.sms.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.sms.entity.Books;
import com.example.sms.entity.Student;
import com.example.sms.repository.StudentRepository;
import com.example.sms.service.StudentService;
import com.example.sms.service.impl.BooksService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private StudentRepository studRepo;

	@Autowired
	private StudentService studentService;

	@ModelAttribute
	private void studentDetails(Model m, Principal p) {
		String email = p.getName();

		Student student = studRepo.findByEmail(email);

		m.addAttribute("student", student);

	}

	@GetMapping("/")
	public String home() {
		return "admin/home";
	}

//	update student from page
	@GetMapping("/edit/{id}")
	public String editStudent(@PathVariable Long id, Model model) {
		Student existingStudent = studentService.getStudentById(id);
		model.addAttribute("student", existingStudent);
		return "edit_student";
	}

//	update student actual 
	@PostMapping("/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {
		// Get Student details from database
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setId(student.getId());
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
	@GetMapping("/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return "redirect:/admin/show";
	}

//	List all students
	@GetMapping("/show")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "admin/students";
	}

	@Autowired
	private BooksService booksService;

	@GetMapping("/books")
	public String booksForm() {

		return "admin/uploadBooks";
	}

	@PostMapping("/books/upload")
	public ResponseEntity<String> uploadNote(@RequestParam("file") MultipartFile file,
			@RequestParam("title") String title, @RequestParam("description") String description) {
		// Handle file upload, save to storage, and get the file URL
		// For simplicity, let's assume we save it to a local directory
		System.out.println("inside books controller");
		String fileUrl = saveFileLocally(file);

		// Create Note object and save it to the database
		Books book = new Books();
		book.setTitle(title);
		book.setDescription(description);
		book.setFileUrl(fileUrl);
		booksService.saveBooks(book);

		return ResponseEntity.ok("Books uploaded successfully");
	}

	// Method to save file locally and return the URL
	public String saveFileLocally(MultipartFile file) {
		// Define the directory where you want to save the uploaded files
		String uploadDir = "D:\\Data"; // Update this with your desired directory

		// Create the directory if it doesn't exist
		File directory = new File(uploadDir);
		if (!directory.exists()) {
			directory.mkdirs();
		}

		try {
			// Get the original filename
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());

			// Define the path where the file will be saved
			Path filePath = Paths.get(uploadDir + File.separator + fileName);

			// Copy the file to the target location
			Files.copy(file.getInputStream(), filePath);

			// Construct and return the URL of the saved file
			String fileUrl = uploadDir +"/"+ fileName; // Assuming uploads directory is accessible publicly
			return fileUrl;
		} catch (IOException ex) {
			// Handle file I/O exception
			ex.printStackTrace();
			return null;
		}
	}
}