package Test06;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBeforeAfter;

public class JsExecutor extends TestBeforeAfter {
    @Test
    public void test_executor() throws InterruptedException {
        driver.get("https://www.amazon.com.tr");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='sp-cc-rejectall-link']")).click();
        WebElement carrer_button = driver.findElement(By.xpath("//*[text()='Kariyer']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(1000);
        js.executeScript("arguments[0].scrollIntoView(true);",carrer_button);
        js.executeScript("arguments[0].click();",carrer_button);
    }
}
