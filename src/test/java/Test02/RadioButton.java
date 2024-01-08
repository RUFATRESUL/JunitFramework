package Test02;

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

public class RadioButton {
    WebDriver driver;
    @Before
    public void radio(){
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
    public void radio_test() throws InterruptedException {
        driver.get("https://www.facebook.com");
        WebElement submit = driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"));
        submit.click();
        driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[1]")).sendKeys("Gullu");
        driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[2]")).sendKeys("Rasulov");
        driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[3]")).sendKeys("gula@gmail.com");
        driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[4]")).sendKeys("gula@gmail.com");
        driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[5]")).sendKeys("Gul1997");
        WebElement month_select = driver.findElement(By.xpath("(//*[@class='_9407 _5dba _9hk6 _8esg'])[1]"));
        Select select = new Select(month_select);
        select.selectByVisibleText("Aug");
        WebElement day_select = driver.findElement(By.xpath("(//*[@class='_9407 _5dba _9hk6 _8esg'])[2]"));
        Select select1 = new Select(day_select);
        select1.selectByVisibleText("20");
        WebElement year_select = driver.findElement(By.xpath("(//*[@class='_9407 _5dba _9hk6 _8esg'])[3]"));
        Select select2 = new Select(year_select);
        select2.selectByVisibleText("1998");
        WebElement gender = driver.findElement(By.xpath("(//*[@name='sex'])[2]"));

        if (!gender.isSelected()){
            gender.click();
        }
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class='_6j mvm _6wk _6wl _58mi _3ma _6o _6v']")).click();
        WebElement text = driver.findElement(By.xpath("//h2[@class='uiHeaderTitle']"));
        System.out.println(text.getText());
    }
}
