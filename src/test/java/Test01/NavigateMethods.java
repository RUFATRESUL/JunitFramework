package Test01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateMethods {
    public static void main(String[] args) throws InterruptedException {
        //Webdriver teyin olunur
        WebDriverManager.chromedriver().setup();
        //yeni ChromeDriver driver adina beraber edirik
        WebDriver driver = new ChromeDriver();
        //sehifeni butov ekran edirik
        driver.manage().window().maximize();
        //navigate method ile google sehifesine gedirik
        driver.navigate().to("https://www.google.com");
        //navigate methodu ile amazon sehifesine gedirik
        driver.navigate().to("https://www.amazon.com.tr");
        //Thread ile fasile veririk
        Thread.sleep(1000);
        //navigate.back methodu ile geriye gedirik
        driver.navigate().back();
        //daha sonra 1 saniye gozleyirik
        Thread.sleep(1000);
        //foreard ile novbeti sehifeye gedirik
        driver.navigate().forward();
        //1 saniye gozleyirik
        Thread.sleep(1000);
        //sonda refresh method ile sehifeni refresh edirik
        driver.navigate().refresh();
        //sehifeden baglayiriq
        driver.quit();



    }
}
