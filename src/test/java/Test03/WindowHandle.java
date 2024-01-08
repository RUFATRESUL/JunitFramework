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
import java.util.ArrayList;
import java.util.List;

public class WindowHandle {
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
    public void window_test() throws InterruptedException {
        //website getmek
        driver.get("https://the-internet.herokuapp.com/windows");
        //daxil oldugumuz sehefenin hash kodunu tapir
        String hoappWindowHandle = driver.getWindowHandle();
        System.out.println(hoappWindowHandle);
        //daxil oldugumuz sehefenin Opening new Window yazisinin dogru qeyd edildiyini test et
        String actual = driver.findElement(By.xpath("//*[text()='Opening a new window']")).getText();
        String expected = "Opening a new window";
        Assert.assertTrue(actual.contains(expected));
        System.out.println(actual);
        //sehife basliginin The Internet oldugunu test et
        String actual_title = driver.getTitle();
        String expected_title = "The Internet";
        Assert.assertTrue(actual_title.contains(expected_title));
        System.out.println(actual_title);
        //Click Here button click et
        WebElement link_text = driver.findElement(By.linkText("Click Here"));
        link_text.click();
        //butun sehifelerin hash kodlarini bir array yigmaq
        List<String> windowHashList = new ArrayList<>(driver.getWindowHandles());
        System.out.println(windowHashList);
        //novbeti sehifenin index tapmaq
        driver.switchTo().window(windowHashList.get(1));
        //daxil oldugumuz sehefenin title tapmaq
        Thread.sleep(2000);
        String new_actual_title = driver.getTitle();
        String new_expected_title = "New Window";
        Assert.assertEquals(new_expected_title,new_actual_title);
        System.out.println(new_actual_title);
        //sehifedeki textin New Window oldugunu tesdiq edin
        String actual_text = driver.findElement(By.xpath("(//*[text()='New Window'])[2]")).getText();
        String expected_text = "New Window";
        Assert.assertTrue(actual_text.contains(expected_text));
        //evvelki sehifeye daxil olun ve sehife basliginin The Internet oldugunu tesdiq edin
        driver.switchTo().window(windowHashList.get(0));
        Assert.assertTrue(driver.getTitle().contains("The Internet"));


    }
}
