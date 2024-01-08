package Test04;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBeforeAfter;

public class ActionPractice03 extends TestBeforeAfter {
    @Test
    public void test_action03() throws InterruptedException {
        driver.get("https://www.facebook.com");
        WebElement new_account = driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"));
        Actions actions = new Actions(driver);
        actions.click(new_account).perform();
        Thread.sleep(1000);
        actions.sendKeys("rufat").sendKeys(Keys.TAB).sendKeys("rasulov").sendKeys(Keys.TAB).sendKeys("12345691023").sendKeys(Keys.TAB).sendKeys("12345Ac").sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("Aug").sendKeys(Keys.TAB)
                .sendKeys("23").sendKeys(Keys.TAB).sendKeys("1990").sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.RIGHT).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

    }
}
