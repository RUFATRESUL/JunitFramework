//package Test05;
//
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.junit.Test;
//
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//
//public class ExcelFile06 {
//    @Test
//    public void excel_test06() throws IOException {
//        String excel = "src/resources/Book (1).xlsx";
//        FileInputStream fileInputStream = new FileInputStream(excel);
//        Workbook workbook = WorkbookFactory.create(fileInputStream);
//        //excel fayilina data qeyd etmek
//        workbook.getSheet("Sheet1").getRow(0).createCell(4).setCellValue("Ehalisi");
//        workbook.getSheet("Sheet1").getRow(1).createCell(4).setCellValue("20000");
//        workbook.getSheet("Sheet1").getRow(9).createCell(4).setCellValue("72000");
//        //qeydler apardigimiz fayili yadda saxlamaq
////
//        FileOutputStream  fileOutputStream = new FileOutputStream(excel);
//        workbook.write(fileOutputStream);
//        //fayili baglamq
//        fileInputStream.close();
//        fileOutputStream.close();
//        workbook.close();
//    }
//}
//
package Test05;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelFile06 {
    @Test
    public void excel_test06() throws IOException {
        String excelPath = "src/resources/Book (1).xlsx";
        String modifiedExcelPath = "src/resources/Book (1)_modified.xlsx";

        FileInputStream fileInputStream = new FileInputStream(excelPath);
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        // Modify the workbook
        workbook.getSheet("Sheet1").getRow(0).createCell(4).setCellValue("Ehalisi");
        workbook.getSheet("Sheet1").getRow(1).createCell(4).setCellValue("20000");
        workbook.getSheet("Sheet1").getRow(9).createCell(4).setCellValue("72000");

        // Write to a different file
        FileOutputStream fileOutputStream = new FileOutputStream(modifiedExcelPath);
        workbook.write(fileOutputStream);

        // Close all resources
        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();
    }
}
