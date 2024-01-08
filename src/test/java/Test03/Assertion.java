package Test03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Assertion {
    WebDriver driver;
    @Before
    public void radio() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.com.tr");
        Thread.sleep(1000);
        driver.findElement(By.id("sp-cc-rejectall-link")).click();
    }
    @After
    public void radio_end(){
//        driver.quit();
    }
    //url icinde amazon oldugunu test etmek
    @Test
    public void get_website(){

        String actual_url = driver.getCurrentUrl();
        String expected_url = "amazon";
        Assert.assertTrue(actual_url.contains(expected_url));

    }
    //title icinde facebook oldugunu test etmek
    @Test
    public void get_website1(){

        String actual_title = driver.getTitle();
        String expected_title = "facebook";
        Assert.assertFalse(actual_title.contains(expected_title));

    }
    //logo amazon oldugunu test etmek
    @Test
    public void get_website2(){

        WebElement logo = driver.findElement(By.cssSelector("#nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed());

    }
    //url www.facebook.com ibaret oldugunu test etmek
    @Test
    public void get_website3(){

        String url = driver.getCurrentUrl();
        String expect = "www.facebook.com";
        Assert.assertFalse(url.contains(expect));

    }
}
