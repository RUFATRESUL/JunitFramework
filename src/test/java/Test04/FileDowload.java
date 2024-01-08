package Test04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBeforeAfter;

public class FileDowload extends TestBeforeAfter {
    @Test
    public void file_download(){
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement choose_box = driver.findElement(By.xpath("//*[@id='file-upload']"));
//        choose_box.click();
        String copy_path = "C:\\Users\\Lenovo\\Downloads\\test-file (2).txt";
        choose_box.sendKeys(copy_path);
        driver.findElement(By.xpath("//*[@id='file-submit']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='File Uploaded!']")).isDisplayed());
    }
}
