package com.excel.db.repository;


import com.excel.db.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByErrorRemarksIsNull();
    List<Student> findByErrorRemarksIsNotNull();


}


