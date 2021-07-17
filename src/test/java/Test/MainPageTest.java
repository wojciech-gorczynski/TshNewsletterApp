package Test;

import base.SeleniumBaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;

import java.util.UUID;

public class MainPageTest extends SeleniumBaseTest {

    MainPage mainPage;
    public MainPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp(){
        mainPage = new MainPage(driver);
    }



    @Test
    public void verifyEmailFieldInput(){
        String emailInput = "e2eEmail"+ UUID.randomUUID().toString().substring(0, 3) + "@test.com";

        mainPage.setInputForEmailField(emailInput);
        Assert.assertEquals(new MainPage(driver).getInputFromEmailField(emailInput), emailInput,
        "Input provided in email field is not visible");
    }

}
