package Test03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class WindovHandlePractice {
    WebDriver driver;
    @Before
    public void window_start() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



    }
    @After
    public void window_end(){
//        driver.quit();
    }
    @Test
    public void window_handle_test() throws InterruptedException {
        //amazon sehifesine getmek
        driver.get("https://www.amazon.com.tr");
        Thread.sleep(2000);
        driver.findElement(By.id("sp-cc-rejectall-link")).click();
        //url icinde amazon oldugunu test et
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));
        //yeni bir pencere acin ve https://www.bestbuy.com adressine gedin
        Thread.sleep(2000);
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.walmart.com");
        //title BestBuy oldugunu test et
        Assert.assertTrue(driver.getTitle().contains("Walmart"));
        //sehifelerin hash kodunu tapin
        List<String>WindowHashList = new ArrayList<>(driver.getWindowHandles());
        //evvelki sehifeye getmek
        driver.switchTo().window(WindowHashList.get(0));
        Thread.sleep(2000);
        //searchBox Java yazaraq axtaris vermek
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
        //alinan neticeni tapmaq
        WebElement result_java = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        //alinan neticenin icinde java oldugunu teest etmek
        String actual_java = result_java.getText();
        String expected_java = "java";
        Assert.assertFalse(actual_java.contains(expected_java));
        Thread.sleep(1000);
        //novbeti sehifeye getmek
        driver.switchTo().window(WindowHashList.get(1));
        //logonun oldugunun tesdiq etmek
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='db']")).isDisplayed());





    }
}
