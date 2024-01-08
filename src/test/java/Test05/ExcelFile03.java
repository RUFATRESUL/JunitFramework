package Test05;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelFile03 {
    @Test
    public void excel_test03() throws IOException {
        String excel_path = "src/resources/Book (1).xlsx";
        FileInputStream fileInputStream = new FileInputStream(excel_path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        //sutundaki butun datalari aliriq for komekliyi ile
        String A_sutunu ="";
        for (int i = 0; i < 12; i++) {
            A_sutunu = workbook.getSheet("Sheet1").getRow(i).getCell(1).toString();
            System.out.println(A_sutunu);
        }
    }
    }


