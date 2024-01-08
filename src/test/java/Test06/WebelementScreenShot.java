package Test06;


import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBeforeAfter;

import java.io.File;
import java.io.IOException;


public class WebelementScreenShot extends TestBeforeAfter {
    @Test
    public void test_screen() throws InterruptedException, IOException {
        driver.get("https://www.amazon.com.tr");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='sp-cc-rejectall-link']")).click();
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Java", Keys.ENTER);
        WebElement search_result = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        //aldigimiz webelementin goruntusunu screen edirik OutputType.FILE methodu komekliyi ile alinan screen file deyisenine gonderirk
        File file = search_result.getScreenshotAs(OutputType.FILE);
        //FileUtils.copyFile komekliyi ile aldigimiz file deyisenini new File komekliyi ile target/WEScreenShot/WESS"+date+".jpeg sekilinde yadda saxlayiriq
        FileUtils.copyFile(file,new File("target/WEScreenShot/WESS"+date+".jpeg"));

    }


}
