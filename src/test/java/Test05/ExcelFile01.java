package Test05;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelFile01 {
    @Test
    public void excel_test02() throws IOException {
        //fayil yolunu string deyisenine gonderirik
        String excel_file02 = "src/resources/Book (1).xlsx";
        //FileInputStream objecti yaradiriq
        FileInputStream fileInputStream = new FileInputStream(excel_file02);
        //Workbook objectini yaradiriq
        Workbook workbook = WorkbookFactory.create(fileInputStream);
//        Sheet sheet = workbook.getSheet("Sheet1");
//        Row row = sheet.getRow(4);
//        Cell cell = row.getCell(2);
        //lazim olan datani getSheet,getRow,getCell methodlarindan istifade ederek toString methodundan istifade ederek yazdiririq ve string deyisenine gonderirik
        String actual_data = workbook.getSheet("Sheet1").getRow(2).getCell(1).toString();
        //konsolda cap edirik
        System.out.println(actual_data);
    }
}
