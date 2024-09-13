package com.excel.db.controller;



import com.excel.db.model.Student;
import com.excel.db.service.StudentService;
import com.excel.db.service.Impl.GradeCalculationService;
import com.excel.db.utils.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@Controller
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Autowired
    private GradeCalculationService gradeCalculationService; // Add this autowired service

    @GetMapping("/students")
    public String getAllStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        
        // Calculate grades for each student and set the grade field
        for (Student student : students) {
            String grade = gradeCalculationService.calculateGrade(
                student.getFirstLanguage(),
                student.getSecondLanguage(),
                student.getThirdLanguage(),
                student.getMathematics(),
                student.getGeneralScience(),
                student.getSocialStudies()
            );
            student.setGrade(grade);
            
        // Set status based on the grade
        if ("O".equals(grade) || "A+".equals(grade) || "A".equals(grade)|| "B+".equals(grade)||
        		"B".equals(grade)|| "C".equals(grade)) {
            student.setStatus("Pass");
        } else {
            student.setStatus("Fail");
        }
    }
        
        model.addAttribute("students", students);
        return "student-list";
    }

    @GetMapping("/upload")
    public String showUploadForm() {
        return "upload-form";
    }

    @PostMapping("/upload")
    public String uploadExcelFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        try {
            // Validate file format (optional)
            if (!file.getOriginalFilename().endsWith(".xls")) {
                redirectAttributes.addAttribute("error", "Please upload the excel file in .xls format");
                return "redirect:/upload";
            }

            // Create an instance of ExcelUtils
            ExcelUtils excelUtils = new ExcelUtils();

            // Process the uploaded Excel file
            List<Student> students = excelUtils.processExcelFile(file.getInputStream());

            // Validate headers
            if (!excelUtils.isValidHeaders(file.getInputStream())) {
                redirectAttributes.addAttribute("error", "Invalid headers please check the headers");
                return "redirect:/upload";
            }

            // Save students to the database
            studentService.processAndSaveStudents(students);

            return "redirect:/students";
        } catch (IOException e) {
            redirectAttributes.addAttribute("error", "There is a processing error please re-run and try again");
            return "redirect:/upload";
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


    
}
