package com.example.sms.service.impl;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sms.entity.Books;
import com.example.sms.repository.BooksRepository;

@Service
public class BooksService {

	private static final Logger logger = LogManager.getLogger(BooksService.class);

	@Autowired
	private BooksRepository booksRepository;

	public List<Books> getAllBooks() {
		return booksRepository.findAll();
	}

	public void saveBooks(Books books) {
		booksRepository.save(books);
	}

	public Books getBookById(Long bookId) {
		return booksRepository.findById(bookId)
				.orElseThrow(() -> new IllegalArgumentException("Book not found with id: " + bookId));
	}
}
