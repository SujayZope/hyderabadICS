package com.excel.db.service.Impl;

import org.springframework.stereotype.Service;

@Service
public class GradeCalculationService {
	    public String calculateGrade(String firstLanguage, String secondLanguage, String thirdLanguage, String mathematics, String generalScience, String socialStudies) {
	        try {
	            int marks1 = Integer.parseInt(firstLanguage);
	            int marks2 = Integer.parseInt(secondLanguage);
	            int marks3 = Integer.parseInt(thirdLanguage);
	            int marks4 = Integer.parseInt(mathematics);
	            int marks5 = Integer.parseInt(generalScience);
	            int marks6 = Integer.parseInt(socialStudies);

	            int totalMarks = marks1 + marks2 + marks3 + marks4 + marks5 + marks6;
	            double averageMarks = totalMarks / 6.0;

	            if (averageMarks >= 90) {
	                return "O";
	            } else if (averageMarks >= 80) {
	                return "A+";
	            } else if (averageMarks >= 70) {
	                return "A";
	            } else if (averageMarks >= 60) {
	                return "B+";
	            } else if (averageMarks >= 50) {
	                return "B";
	            }else if(averageMarks >=40) {
	            	return "C";
	            } else{
	                return "F";
	            }
	            
	        } catch (NumberFormatException e) {
	            return "F";
	        }
	    }
	}
