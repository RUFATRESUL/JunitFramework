package Test03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BasicAuthentication {
    WebDriver driver;
    @Before
    public void auth_start() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



    }
    @After
    public void auth_end(){
//        driver.quit();
    }
    @Test
    public void auth_test(){
        //driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        driver.get("https://the-internet.herokuapp.com/basic_auth");


    }
}
