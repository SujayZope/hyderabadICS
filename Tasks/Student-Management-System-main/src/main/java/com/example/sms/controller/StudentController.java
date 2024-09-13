package com.example.sms.controller;

import java.net.MalformedURLException;
import java.nio.file.Paths;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.sms.entity.Books;
import com.example.sms.entity.Student;
import com.example.sms.repository.StudentRepository;
import com.example.sms.service.impl.BooksService;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentRepository studRepo;

	@ModelAttribute
	private void studentDetails(Model m, Principal p) {
		String email = p.getName();

		Student student = studRepo.findByEmail(email);

		m.addAttribute("student", student);

	}

	@GetMapping("/")
	public String home() {
		return "user/home";
	}

	@GetMapping("/download")
	public String books() {
		return "user/download";
	}

	@Autowired
	private BooksService booksService;

	@GetMapping("/books/all")
	public String getAllBooks(Model model) {
		model.addAttribute("books", booksService.getAllBooks());
		return "user/books"; // This will return books.html template
	}

	@GetMapping("/books/download/{bookId}")
	public ResponseEntity<Resource> downloadNote(@PathVariable Long bookId) throws MalformedURLException {
		// Fetch book by ID
		System.out.println("download");
		Books book = booksService.getBookById(bookId);
		if (book == null) {
			return ResponseEntity.notFound().build();
		}

		// Retrieve file URL and create Resource object
		Resource resource = new UrlResource(Paths.get(book.getFileUrl()).toUri());

		// Check if resource exists and is readable
		if (!resource.exists() || !resource.isReadable()) {
			return ResponseEntity.notFound().build();
		}

		// Return file for download
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF)
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}

}