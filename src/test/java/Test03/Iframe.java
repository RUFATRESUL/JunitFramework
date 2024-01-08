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

public class Iframe {
    WebDriver driver;
    @Before
    public void iframe_start() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



    }
    @After
    public void iframe_end(){
//        driver.quit();
    }
    @Test
    public void iframe_test() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement iframeText = driver.findElement(By.xpath("//h3"));
        System.out.println(iframeText.getText());
        Assert.assertTrue(iframeText.isDisplayed());
        WebElement textArea = driver.findElement(By.xpath("//*[@id='mce_0_ifr']"));
        driver.switchTo().frame(textArea);
        WebElement childText = driver.findElement(By.xpath("//p"));
        childText.clear();
        Thread.sleep(2000);
        childText.sendKeys("salam dunya");
        driver.switchTo().defaultContent();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).isDisplayed());
        System.out.println(driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).getText());

    }
}
