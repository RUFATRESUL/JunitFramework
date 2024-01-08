package Test04;

import org.junit.Test;
import utilities.TestBeforeAfter;

public class utilitiesTest extends TestBeforeAfter {
    @Test
    public void utilities_test(){
        driver.get("https://www.amazon.com.tr");
    }
}
