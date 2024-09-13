package com.example.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sms.entity.Books;

public interface BooksRepository extends JpaRepository<Books, Long> {
    // Add custom methods if needed
}
