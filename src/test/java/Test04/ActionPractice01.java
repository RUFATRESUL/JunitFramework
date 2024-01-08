package Test04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class ActionPractice01 extends TestBeforeAfter {
    @Test
    public void practice01() throws InterruptedException {
        //websayita getmek
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //bos kvadrat sahenin locatorun tapmaq
        WebElement empty_field = driver.findElement(By.xpath("//*[@id='hot-spot']"));
        //bos kvadrat saheye sag click etmek
        Actions actions = new Actions(driver);
        actions.contextClick(empty_field).perform();
        //allert sahesinde You selected a context menu textin oldugunu tesdiq etmek
        String actualText = driver.switchTo().alert().getText();
        String expectedText = "You selected a context menu";
        Assert.assertEquals(expectedText,actualText);
        Thread.sleep(1000);
        //acilmis allert xanasinin aaccept etmek
        driver.switchTo().alert().accept();
        //altda yazilan Elemental Selenium yaazisina click etmek
        driver.findElement(By.linkText("Elemental Selenium")).click();
        //acilmis yeni pencerede h1 taq icinde Elemental Selenium yazisinin oldugunu test etmek
        List<String> hash_code_page = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(hash_code_page.get(1));
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='themedImage_ToTc themedImage--light_HNdA'])[1]")).isDisplayed());




    }
}
