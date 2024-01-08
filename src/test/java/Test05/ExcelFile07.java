package Test05;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelFile07 {
    @Test
    public void excel_test07() throws IOException {
        String excel_path = "src/resources/Book (1).xlsx";
        FileInputStream fileInputStream = new FileInputStream(excel_path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheet("Sheet1");
        Row row = sheet.getRow(2);
        Cell cell = row.getCell(2);
        row.removeCell(cell);



        FileOutputStream fileOutputStream = new FileOutputStream(excel_path);
        workbook.write(fileOutputStream);
    }
}
