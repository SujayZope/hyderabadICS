package com.excel.db.utils;

import com.excel.db.model.Student;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.util.ByteArrayDataSource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Component
public class EmailUtils {

    private final JavaMailSender javaMailSender;

    public EmailUtils(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendErrorEmailWithAttachment(List<Student> studentsWithErrors) throws MessagingException, IOException, jakarta.mail.MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo("akhila.pentam@infinite.com");
        helper.setSubject("Error Report: Students with Errors");

        // Generate an Excel file with error report
        byte[] excelBytes = generateErrorReportExcel(studentsWithErrors);

        // Attach Excel file to the email
        ByteArrayDataSource dataSource = new ByteArrayDataSource(excelBytes, "application/vnd.ms-excel");
        helper.addAttachment("error_report.xlsx", dataSource);

        // Set email content
        helper.setText("Dear Akhila Pentam,\n\nPlease find attached the error report Excel file.\n\nRegards,\nInfinite Schools.");

        javaMailSender.send(message);
    }

    private byte[] generateErrorReportExcel(List<Student> studentsWithErrors) throws IOException {
        // Implement Excel generation logic here using Apache POI
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Error Report");

        // Create headers
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Hall Ticket Number");
        headerRow.createCell(1).setCellValue("First Name");
        headerRow.createCell(2).setCellValue("Last Name");
        headerRow.createCell(3).setCellValue("DOB");
        headerRow.createCell(4).setCellValue("First language");
        headerRow.createCell(5).setCellValue("Second language");
        headerRow.createCell(6).setCellValue("Third language");
        headerRow.createCell(7).setCellValue("Mathematics");
        headerRow.createCell(8).setCellValue("General science");
        headerRow.createCell(9).setCellValue("Social studies");
        headerRow.createCell(10).setCellValue("Error Remarks");

        // Populate data
        int rowIndex = 1;
        for (Student student : studentsWithErrors) {
            Row dataRow = sheet.createRow(rowIndex++);
            dataRow.createCell(0).setCellValue(student.getHallticketNumber());
            dataRow.createCell(1).setCellValue(student.getFirstName());
            dataRow.createCell(2).setCellValue(student.getLastName());
            dataRow.createCell(3).setCellValue(student.getDob());
            dataRow.createCell(4).setCellValue(student.getFirstLanguage());
            dataRow.createCell(5).setCellValue(student.getSecondLanguage());
            dataRow.createCell(6).setCellValue(student.getThirdLanguage());
            dataRow.createCell(7).setCellValue(student.getMathematics());
            dataRow.createCell(8).setCellValue(student.getGeneralScience());
            dataRow.createCell(9).setCellValue(student.getSocialStudies());
            dataRow.createCell(10).setCellValue(student.getErrorRemarks());
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();

        return outputStream.toByteArray();
    }
}
