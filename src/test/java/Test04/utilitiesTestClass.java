package Test04;

import org.junit.Test;
import utilities.TestBeforeAfterClass;

public class utilitiesTestClass extends TestBeforeAfterClass {
    @Test
    public void test01(){
        driver.get("https://www.facebook.com");
    }
    @Test
    public void test02(){
        driver.get("https://www.walmart.com");
    }
}
