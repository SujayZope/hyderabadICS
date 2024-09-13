package com.excel.db.utils;


import com.excel.db.model.Student;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ExcelUtils {

  

    public List<Student> processExcelFile(InputStream inputStream) throws IOException, ParseException {
        List<Student> students = new ArrayList<>();

        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
        HSSFSheet sheet = workbook.getSheetAt(0);
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            HSSFRow row = sheet.getRow(i);
            Student student = new Student();
            student.setHallticketNumber(getCellValue(row.getCell(0)));
            student.setFirstName(getCellValue(row.getCell(1)));
            student.setLastName(getCellValue(row.getCell(2)));
            String excelDateValue = getCellValue(row.getCell(3));
            Date dob = new SimpleDateFormat("dd-MM-yyyy").parse(excelDateValue);


            student.setDob(dob);

            student.setFirstLanguage(getCellValue(row.getCell(4)));
            student.setSecondLanguage(getCellValue(row.getCell(5)));
            student.setThirdLanguage(getCellValue(row.getCell(6)));
            student.setMathematics(getCellValue(row.getCell(7)));
            student.setGeneralScience(getCellValue(row.getCell(8)));
            student.setSocialStudies(getCellValue(row.getCell(9)));
            student.setErrorRemarks(getCellValue(row.getCell(10)));
            students.add(student);
        }

        workbook.close();
        return students;
    }


    public boolean isValidHeaders(InputStream inputStream) throws IOException {
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0); 
        Row headerRow = sheet.getRow(0);

        
        String[] expectedHeaders = {
                "Hall Ticket Number", "First Name", "Last Name", "dob", "First Language", "Second Language",
                "Third Language", "Mathematics", "General Science", "Social Studies"
        };

        for (int i = 0; i < expectedHeaders.length; i++) {
            Cell cell = headerRow.getCell(i);
            if (!getCellValue(cell).equalsIgnoreCase(expectedHeaders[i])) {

                workbook.close();
                return false;
            }
        }

        workbook.close();
        return true;
    }

    private String getCellValue(Cell cell) {
        if (cell == null) {
            return "";
        }
        if (cell.getCellType() == CellType.STRING) {
            return cell.getStringCellValue();
        } else if (cell.getCellType() == CellType.NUMERIC) {
            return String.valueOf((int) cell.getNumericCellValue());
        } else {
            return "";
        }
    }
}
