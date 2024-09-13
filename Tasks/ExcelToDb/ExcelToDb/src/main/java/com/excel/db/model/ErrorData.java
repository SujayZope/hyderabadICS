package com.excel.db.model;


public class ErrorData {
    private Student student;
    private String errorMessage;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ErrorData(Student student, String errorMessage) {
        this.student = student;
        this.errorMessage = errorMessage;
    }

    public ErrorData(){}
}
