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

public class AssertionPractice {
    WebDriver driver;
    @Before
    public void radio() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.youtube.com");

    }
    @After
    public void radio_end(){
//        driver.quit();
    }
    @Test
    public void titleTest(){
        String actual_title = driver.getTitle();
        String expected_title="YouTube";
        Assert.assertTrue(actual_title.contains(expected_title));
    }
    @Test
    public void imageTest(){
        WebElement image = driver.findElement(By.xpath("(//*[@class='yt-spec-icon-shape'])[5]"));
        Assert.assertTrue(image.isDisplayed());

    }
    @Test
    public void searchBox(){
        WebElement search = driver.findElement(By.id("search-input"));
        Assert.assertTrue(search.isEnabled());
    }
    @Test
    public void titleText(){
       String actualTitle = driver.getTitle();
       String expectedTitle = "youtube";
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }
}
