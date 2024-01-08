package Test04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBeforeAfter;

public class ActionsTest extends TestBeforeAfter {
    @Test
    public void actionTest() throws InterruptedException {
        driver.get("https://www.amazon.com.tr");
        Thread.sleep(1000);
        driver.findElement(By.id("sp-cc-rejectall-link")).click();
        WebElement account = driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));
        WebElement list_create = driver.findElement(By.xpath("(//*[@class='nav-text'])[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(account).click(list_create).perform();
        WebElement search_box = driver.findElement(By.id("twotabsearchtextbox"));
        actions.click(search_box).keyDown(Keys.SHIFT).sendKeys("i").keyUp(Keys.SHIFT).sendKeys("phone").sendKeys(" ").sendKeys("15")
                .keyDown(Keys.SHIFT).sendKeys("p").keyUp(Keys.SHIFT).sendKeys("lus").sendKeys(Keys.ENTER).perform();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")).isDisplayed());



    }
}
