package Test06;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBeforeAfter;

import java.io.File;
import java.io.IOException;

public class ScreenShot extends TestBeforeAfter {
    @Test
    public void screen() throws IOException {
        driver.get("https://www.amazon.com.tr");
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File file = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("target/ekrangoruntusu/AllPage"+date+".jpeg"));

    }
}
