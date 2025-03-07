package com.excel.db.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "students_new")
public class Student {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@NotNull @Size(min = 1, max = 10)
	@Column(name = "hallticket_number") 
	private String hallticketNumber;
	
	@NotBlank @Size(min = 1, max = 50)
	@Column(name = "first_name")
	private String firstName;
	
	@NotBlank @Size(min = 1, max = 50) 
	@Column(name = "last_name") 
	private String lastName;
	
	@NotNull @Past
	@Column(name = "dob") 
	@Temporal(TemporalType.DATE) 
	private Date dob;
	
	@Size(max = 50) 
	@Column(name = "first_language") 
	private String firstLanguage; 
	
	@Size(max = 50) 
	@Column(name = "second_language") 
	private String secondLanguage; 
	
	@Size(max = 50) 
	@Column(name = "third_language") 
	private String thirdLanguage;
	
	@Size(max = 50) 
	@Column(name = "mathematics") 
	private String mathematics;
	
	@Size(max = 50) 
	@Column(name = "general_science") 
	private String generalScience;
	
	@Size(max = 50)
	@Column(name = "social_studies") 
	private String socialStudies; 
	
	@Size(max = 1000) 
	@Column(name = "error_remarks") 
	private String errorRemarks;
    
    @Column(name="grade")
    private String grade;
    
    @Column(name="status")
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHallticketNumber() {
        return hallticketNumber;
    }

    public void setHallticketNumber(String hallticketNumber) {
        this.hallticketNumber = hallticketNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getFirstLanguage() {
        return firstLanguage;
    }

    public void setFirstLanguage(String firstLanguage) {
        this.firstLanguage = firstLanguage;
    }

    public String getSecondLanguage() {
        return secondLanguage;
    }

    public void setSecondLanguage(String secondLanguage) {
        this.secondLanguage = secondLanguage;
    }

    public String getThirdLanguage() {
        return thirdLanguage;
    }

    public void setThirdLanguage(String thirdLanguage) {
        this.thirdLanguage = thirdLanguage;
    }

    public String getMathematics() {
        return mathematics;
    }

    public void setMathematics(String mathematics) {
        this.mathematics = mathematics;
    }

    public String getGeneralScience() {
        return generalScience;
    }

    public void setGeneralScience(String generalScience) {
        this.generalScience = generalScience;
    }

    public String getSocialStudies() {
        return socialStudies;
    }

    public void setSocialStudies(String socialStudies) {
        this.socialStudies = socialStudies;
    }

    public String getErrorRemarks() {
        return errorRemarks;
    }

    public void setErrorRemarks(String errorRemarks) {
        this.errorRemarks = errorRemarks;
    }

    public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}



    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

	public Student(Long id, String hallticketNumber, String firstName, String lastName, Date dob, String firstLanguage,
			String secondLanguage, String thirdLanguage, String mathematics, String generalScience,
			String socialStudies, String errorRemarks, String grade, String status) {
		super();
		this.id = id;
		this.hallticketNumber = hallticketNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.firstLanguage = firstLanguage;
		this.secondLanguage = secondLanguage;
		this.thirdLanguage = thirdLanguage;
		this.mathematics = mathematics;
		this.generalScience = generalScience;
		this.socialStudies = socialStudies;
		this.errorRemarks = errorRemarks;
		this.grade = grade;
		this.status = status;
	}

	public Student(){}
}
