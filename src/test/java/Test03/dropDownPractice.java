package Test03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class dropDownPractice {
    WebDriver driver;
    @Before
    public void radio() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



    }
    @After
    public void radio_end(){
//        driver.quit();
    }
    @Test
    public void dropDownTest() throws InterruptedException {
        driver.get("https://www.amazon.com.tr");
        Thread.sleep(2000);
        driver.findElement(By.id("sp-cc-rejectall-link")).click();
        List<WebElement> all = driver.findElements(By.xpath("//option"));
        for (WebElement w:all) {
            System.out.println(w.getText());
        }
        int count = all.size();
        System.out.println(count);
        System.out.println("DROPDOWN SIZE :" + all.size());
        if (all.size()==40){
            System.out.println("TRUE");
        }else{
            System.out.println("FALSE");
        }
        Thread.sleep(2000);
        WebElement dropDownMenu = driver.findElement(By.xpath("//select"));
        Select select = new Select(dropDownMenu);
        select.selectByVisibleText("Kitaplar");
        System.out.println("----------------");
        Thread.sleep(2000);
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Java", Keys.ENTER);
        WebElement result = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(result.getText());
        WebElement java_result = driver.findElement(By.xpath("//*[@class='a-color-state a-text-bold']"));
        System.out.println(java_result.getText());
        String actualText = result.getText();
        String expectedText = "Java";
        Assert.assertTrue(actualText.contains(expectedText));


    }
}
