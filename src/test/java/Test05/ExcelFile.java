package Test05;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelFile {
    @Test
    public void readExcel() throws IOException {
        String excel_path="src/resources/Book (1).xlsx";
        FileInputStream file = new FileInputStream(excel_path);
        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheet("Sheet1");
        Row row = sheet.getRow(2);
        Cell cell = row.getCell(2);
        String expected_data = "Oslo";

        String actual_data = cell.toString();

        Assert.assertEquals(expected_data,actual_data);
        System.out.println(actual_data);



    }
}

