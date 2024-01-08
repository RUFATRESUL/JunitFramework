package Test04;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBeforeAfter;

public class FakerTest extends TestBeforeAfter {
    @Test
    public void faker_test() throws InterruptedException {
        driver.get("https://www.facebook.com");
        WebElement new_account = driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"));
        Actions actions = new Actions(driver);
        actions.click(new_account).perform();
        Faker faker = new Faker();
        String faker_email = faker.internet().emailAddress();
        Thread.sleep(2000);
        actions.sendKeys(faker.name().firstName()).sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).sendKeys(Keys.TAB).sendKeys(faker_email).sendKeys(Keys.TAB)
                .sendKeys(faker_email).sendKeys(Keys.TAB).sendKeys(faker.internet().password()).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("Aug").sendKeys(Keys.TAB)
                .sendKeys(faker.number().digit()).sendKeys(Keys.TAB)
                .sendKeys("1990").sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.RIGHT)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

    }
}
