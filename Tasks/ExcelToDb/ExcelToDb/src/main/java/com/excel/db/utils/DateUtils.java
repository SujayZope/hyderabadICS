package com.excel.db.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    private static final int EXCEL_EPOCH_OFFSET = 25569; // Offset for Excel's epoch (1900-01-01)

    public static Date convertExcelDateToJavaDate(double excelDateNumber) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1900, Calendar.JANUARY, 1, 0, 0, 0); // Excel's epoch date
        calendar.add(Calendar.DAY_OF_YEAR, (int) excelDateNumber - EXCEL_EPOCH_OFFSET);

        return calendar.getTime();
    }
}
