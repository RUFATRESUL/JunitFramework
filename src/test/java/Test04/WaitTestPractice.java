package Test04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBeforeAfter;

import java.time.Duration;

public class WaitTestPractice extends TestBeforeAfter {
    @Test
    public void test_pactice(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement enabled = driver.findElement(By.xpath("//*[@type='text']"));
        Assert.assertFalse(enabled.isEnabled());
        WebElement enable_button = driver.findElement(By.xpath("//*[text()='Enable']"));
        enable_button.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(enabled));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='message']")).isDisplayed());
        Assert.assertTrue(enabled.isEnabled());
    }
}
