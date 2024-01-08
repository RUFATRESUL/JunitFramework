package Test01;

import com.github.dockerjava.api.model.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ManageMethods {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com.tr");
        System.out.println("Sehifenin movqeyi" + driver.manage().window().getPosition());
        System.out.println("Sehifenin olcusu" + driver.manage().window().getSize());
        driver.manage().window().minimize();
        Thread.sleep(2000);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.manage().window().fullscreen();
        System.out.println("Sehifenin fullscreen movqeyi" + driver.manage().window().getPosition());
        System.out.println("Sehifenin fullscreen olcusu" + driver.manage().window().getSize());
        driver.manage().window().setPosition(new Point(20,20));
        driver.manage().window().setSize(new Dimension(800,400));
        System.out.println("Sehifenin istenilen movqeyi" + driver.manage().window().getPosition());
        System.out.println("Sehifenin istenilen olcusu" + driver.manage().window().getSize());
        driver.quit();

    }
}
