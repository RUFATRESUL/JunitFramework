package Test04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBeforeAfter;

import java.time.Duration;

public class WaitTest extends TestBeforeAfter {
    @Test
    public void implicity_wait(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement remove_button = driver.findElement(By.xpath("//*[text()='Remove']"));
        remove_button.click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='message']")).isDisplayed());
        driver.findElement(By.xpath("//*[text()='Add']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='message']")).isDisplayed());
    }
    @Test
    public void expilicity_wait(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement remove_button = driver.findElement(By.xpath("//*[text()='Remove']"));
        remove_button.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement itsGoneWait = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        Assert.assertTrue(itsGoneWait.isDisplayed());
        driver.findElement(By.xpath("//*[text()='Add']")).click();
        WebElement itsBackWait = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        Assert.assertTrue(itsBackWait.isDisplayed());

    }

}
