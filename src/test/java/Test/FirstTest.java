package Test;

import base.SeleniumBaseTest;
import org.testng.annotations.Test;
import pages.MainPage;

public class FirstTest extends SeleniumBaseTest {

    @Test
    public void firstTest(){
        new MainPage(driver)
                .initialTest();
    }

}
