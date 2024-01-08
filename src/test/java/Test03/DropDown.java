package Test03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class DropDown {
    WebDriver driver;
    @Before
    public void radio() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/dropdown");


    }
    @After
    public void radio_end(){
//        driver.quit();
    }
    @Test
    public void dropDown() throws InterruptedException {
        WebElement dropDownList = driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select select = new Select(dropDownList);
        Thread.sleep(1000);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("--------------------------");
        Thread.sleep(2000);
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("----------------------------");
        Thread.sleep(2000);
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("-----------------------------");
        Thread.sleep(2000);
        select.selectByVisibleText("Option 2");
        System.out.println(select.getFirstSelectedOption().getText());
        List<WebElement> allDropDown = driver.findElements(By.xpath("//option"));
        for (WebElement w: allDropDown) {
            System.out.println(w.getText());
        }
        System.out.println("Dropdown element sayisi :" + allDropDown.size());
        if (allDropDown.size() ==4){
            System.out.println("TRUE");
        }else {
            System.out.println("fALSE");
        }
    }

}
