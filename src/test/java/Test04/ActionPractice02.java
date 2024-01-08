package Test04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBeforeAfter;

public class ActionPractice02 extends TestBeforeAfter {
    @Test
    public void action_test02() throws InterruptedException {
        driver.get("https://demoqa.com/droppable");
        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("(//*[@id='droppable'])[1]"));
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag,drop).perform();
        Assert.assertEquals("Dropped!",driver.findElement(By.xpath("//*[text()='Dropped!']")).getText());
    }
}
