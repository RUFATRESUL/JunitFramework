package Test05;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;

public class ExcelFile05 {
    @Test
    public void excel_test05() throws IOException {
        String excel_path = "src/resources/Book (1).xlsx";
        FileInputStream fileInputStream = new FileInputStream(excel_path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        //excel fayilindaki butun datalari almaq
        for (int i = 0; i < 12; i++) {
            String table1 = workbook.getSheet("Sheet1").getRow(i).getCell(0).toString();
            String table2 = workbook.getSheet("Sheet1").getRow(i).getCell(1).toString();
            String table3 =workbook.getSheet("Sheet1").getRow(i).getCell(2).toString();
            String table4 =workbook.getSheet("Sheet1").getRow(i).getCell(3).toString();
            String tableRow = String.format("%-20s %-20s %-20s %-20s",table1,table2,table3,table4);

            System.out.println(tableRow);


        }
    }
}
