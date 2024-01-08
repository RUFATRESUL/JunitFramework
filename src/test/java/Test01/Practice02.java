package Test01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Practice02 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.heroku.com/home");
        driver.findElement(By.linkText("Sign Up")).click();
        driver.findElement(By.id("first_name")).sendKeys("selim");
        driver.findElement(By.id("last_name")).sendKeys("dydfh");
        driver.findElement(By.id("email")).sendKeys("ab123@gmail.com");
        driver.findElement(By.id("company")).sendKeys("Soft");
        WebElement dropdown = driver.findElement(By.id("role"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Other");
        WebElement country = driver.findElement(By.id("self_declared_country"));
        Select select1 = new Select(country);
        select1.selectByVisibleText("United States");
        WebElement language = driver.findElement(By.id("main_programming_language"));
        Select select2 = new Select(language);
        select2.selectByVisibleText("Ruby");
        driver.findElement(By.cssSelector(".btn btn-alt full-width")).click();



    }
}
