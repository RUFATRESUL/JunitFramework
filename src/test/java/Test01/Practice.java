package Test01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");

        //Facebook sehifesine gedin ve sehife basligi(title) "facebook" oldugunu tesdiqleyin
        //Sehife basligi dogru deyilse sehife title yazin
        if(driver.getTitle().contains("facebook")){
            System.out.println("Test Passed");
        }else{
            System.out.println("actual title :" + driver.getTitle());
        }
        //Sehifenin URL-nin icinde "facebook" var oldugunu dogrulayin  eger deyilse, actual URL ni yazdirir
        if (driver.getCurrentUrl().contains("facebook")){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("Actual URL :" + driver.getCurrentUrl());
        }

        Thread.sleep(2000);
        driver.get("https://www.walmart.com");
        if (driver.getTitle().contains("Walmart.com")){
            System.out.println("TEST PASSED");
        }else{
            System.out.println( "Actual title" + driver.getTitle());
        }

        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().refresh();
        driver.manage().window().maximize();
//        driver.close();



    }
}
