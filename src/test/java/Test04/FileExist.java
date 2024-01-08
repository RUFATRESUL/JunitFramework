package Test04;

import org.junit.Test;

public class FileExist {
    @Test
    public void test(){
        System.out.println(System.getProperty("user.dir"));
        String home_path= System.getProperty("user.home");
        System.out.println(home_path);
    }
}
