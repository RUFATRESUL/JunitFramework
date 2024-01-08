package Test01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Locators {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://www.amazon.com.tr");
        Thread.sleep(2000);
        WebElement cookies = driver.findElement(By.id("sp-cc-rejectall-link"));
        cookies.click();
        Thread.sleep(2000);
        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("Iphone", Keys.ENTER);

        List<WebElement> tag = driver.findElements(By.tagName("a"));
        System.out.println("a tag nin sayisi :" + tag.size());

        List<WebElement> label = driver.findElements(By.tagName("label"));
        System.out.println("label tag nin sayisi :" + label.size());
        WebElement result = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(result.isDisplayed());

//        driver.quit();
    }
}
