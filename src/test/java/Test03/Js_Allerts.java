package Test03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Js_Allerts {
    WebDriver driver;
    @Before
    public void allert_start() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");


    }
    @After
    public void allert_end(){
//        driver.quit();
    }
    @Test
    public void acceptAlert() throws InterruptedException {
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        WebElement result_allert = driver.findElement(By.xpath("//*[@id='result'][1]"));
        System.out.println(result_allert.getText());
        String actualText = result_allert.getText();
        String expected_text = "You successfully clicked an alert";
        Assert.assertTrue(actualText.contains(expected_text));

    }
    @Test
    public void dismissAlert() throws InterruptedException {
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        Thread.sleep(2000);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
        WebElement result_confirm = driver.findElement(By.xpath("//*[text()='You clicked: Cancel']"));
        System.out.println(result_confirm.getText());
        String actual_dismiss = result_confirm.getText();
        String expected_dismiss = "successfully";
        Assert.assertFalse(actual_dismiss.contains(expected_dismiss));


    }
    @Test
    public void sendKeysAlert() throws InterruptedException {
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().sendKeys("rufat");
        driver.switchTo().alert().accept();
        WebElement allertBoxText = driver.findElement(By.xpath("//*[@id='result']"));
        System.out.println(allertBoxText.getText());
        String actualSearchText = allertBoxText.getText();
        String expectedSearchText = "rufat";
        Assert.assertTrue(actualSearchText.contains(expectedSearchText));


    }
}
