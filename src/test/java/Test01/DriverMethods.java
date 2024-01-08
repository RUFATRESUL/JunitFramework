package Test01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverMethods {
    public static void main(String[] args) {
        //drivermethodlarimizi teyin edrik
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //get methodu ile website gedirik
        driver.get("https://www.amazon.com.tr");
        driver.manage().window().maximize();
        //getTitle sehifenin title aliriq
        System.out.println("Pages title :" + driver.getTitle());
        //getCurrentUrl ile sehifenin url unvani aliriq
        System.out.println("Pages URL :" + driver.getCurrentUrl());
//        System.out.println("Website page source :" + driver.getPageSource());
        //sehifenin uygunlugunu yoxlayiriq
        String actual = driver.getPageSource();
        String expected = "Gateway";
        if(actual.contains(expected)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }
        System.out.println("window handle : " + driver.getWindowHandle());

        driver.quit();
    }
}
