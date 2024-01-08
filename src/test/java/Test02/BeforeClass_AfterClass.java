package Test02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BeforeClass_AfterClass {
    static WebDriver driver;
    @BeforeClass
    public static void before(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @Test
    public void test1(){
        driver.get("https://www.amazon.com.tr");
    }
    @Test
    public void test2(){
        driver.get("https://www.walmart.com");
    }
    @AfterClass
    public static void test3(){
        driver.quit();
    }


}
