package Test04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBeforeAfter;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileExistPractice extends TestBeforeAfter {
    @Test
    public void file_exist(){
        driver.get("https://the-internet.herokuapp.com/download");
        WebElement path_txt = driver.findElement(By.xpath("//*[text()='test-file.txt']"));
        path_txt.click();
        String file_link = "C:\\Users\\Lenovo\\Downloads\\test-file.txt";
        Assert.assertTrue(Files.exists(Paths.get(file_link)));
        System.out.println(Paths.get(file_link));

    }
}
