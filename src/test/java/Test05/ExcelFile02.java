package Test05;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelFile02 {
    @Test
    public void excel_test02() throws IOException {
        int setir = 5;
        int sutun = 3;
        String excel_path = "src/resources/Book (1).xlsx";
        FileInputStream fileInputStream = new FileInputStream(excel_path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        String actual_data = workbook.getSheet("Sheet1").getRow(setir).getCell(sutun).toString();
        String expected_data = "Milan";
        Assert.assertEquals(expected_data,actual_data);
        System.out.println(actual_data);

    }
}
