package Test03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class IframePractice {
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
        driver.get("https://html.com/tags/iframe/");
        List<WebElement> iframe_video = driver.findElements(By.xpath("//iframe"));
        driver.switchTo().frame(iframe_video.get(0));
        driver.findElement(By.xpath("//*[@aria-label='Play']")).click();
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
    }
}
