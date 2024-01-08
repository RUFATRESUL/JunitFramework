package Test01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class css_selector {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        /*
        css_selector id ve class atributlari ucun nezerde tutlub
        class atributlarini baslangic hissesine . qoyulur
        id atributunun baslangic hissesine # isaresi qoyulur

        * */

        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        WebElement element = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        Thread.sleep(2000);
        element.click();

        WebElement delete = driver.findElement(By.cssSelector(".added-manually"));
        if ((delete.isDisplayed())){
            System.out.println(" Delete Button gorunur");
        }else {
            System.out.println("Test failed");
        }
        Thread.sleep(2000);
        delete.click();
        WebElement title = driver.findElement(By.xpath("//*[text()='Add/Remove Elements']"));
        if(title.isDisplayed()){
            System.out.println("Add/Remove Elements yazisi goronur");
        }else {
            System.out.println("test failed");
        }
    }
}
