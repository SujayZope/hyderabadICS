package com.excel.db.service;

import com.excel.db.model.Student;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);
    List<Student> getAllStudents();
    List<Student> getStudentsWithoutErrors();

    List<Student> getStudentsWithErrors();
    void processAndSaveStudents(List<Student> students);
   
}

