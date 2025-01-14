package com.api.book.bootrestbook.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.book.bootrestbook.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	public Book findById(int id);
}
