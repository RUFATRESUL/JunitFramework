package Test05;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelFile04 {
    @Test
    public void excel_test04() throws IOException {
        String excel_path = "src/resources/Book (1).xlsx";
        FileInputStream fileInputStream = new FileInputStream(excel_path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        int EndRow = workbook.getSheet("Sheet2").getLastRowNum();
        System.out.println(EndRow);
        int expectedLastRow = 17;
        Assert.assertEquals(expectedLastRow,EndRow+1);
        int used_page_count = workbook.getSheet("Sheet2").getPhysicalNumberOfRows();
        System.out.println(used_page_count);
        int expected_used_page_count = 7;
        Assert.assertEquals(expected_used_page_count,used_page_count);
    }
}
