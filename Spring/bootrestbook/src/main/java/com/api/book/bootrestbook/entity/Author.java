package com.api.book.bootrestbook.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int aId;
	private String fName;
	private String lname;
	private String langauge;
	
	@OneToOne(mappedBy = "author")
	@JsonBackReference
	private Book book;
	
	

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getLangauge() {
		return langauge;
	}

	public void setLangauge(String langauge) {
		this.langauge = langauge;
	}

	public Author(int aId, String fName, String lname, String langauge) {
		super();
		this.aId = aId;
		this.fName = fName;
		this.lname = lname;
		this.langauge = langauge;
	}

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

}
