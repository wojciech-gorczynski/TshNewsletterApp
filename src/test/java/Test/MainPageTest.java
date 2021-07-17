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
        Assert.assertEquals(new MainPage(driver).getInputFromEmailField(), emailInput,
        "Input provided in email field is not visible");
    }

    @Test
    public void verifyFirstNameFieldInput(){
        String firstNameInput = "e2eFirstName"+ UUID.randomUUID().toString().substring(0, 3);

        mainPage.setInputForNameField(firstNameInput);
        Assert.assertEquals(new MainPage(driver).getInputFromNameField(), firstNameInput,
                "Input provided in First name field is not visible");
    }

    @Test
    public void verifySurnameFieldInput(){
        String surnameInput = "e2eSurname"+ UUID.randomUUID().toString().substring(0, 3);

        mainPage.setInputForSurnameField(surnameInput);
        Assert.assertEquals(new MainPage(driver).getInputFromSurnameField(), surnameInput,
                "Input provided in Surname field is not visible");
    }

    @Test
    public void verifySelectedNewsletterOption(){
        String newsletterOption = "Medical";

        mainPage.setInputForNewsletterType(newsletterOption);

        Assert.assertEquals(mainPage.getOptionFromNewsletterDropdown(), newsletterOption, "Dropdown " +
                "option do not match");
    }

    @Test
    public void verifyProvidedStartingDate(){
        String startingDate = "2021-08-20";

        mainPage.setCalendarStartingDate(startingDate);
        Assert.assertEquals(mainPage.getCalendarStartingDate(), startingDate, "dates START do not match");
    }

    @Test
    public void verifyProvidedEndDate(){
        String endDate = "2021-09-20";
        mainPage.setCalendarEndDate(endDate);

        Assert.assertEquals(mainPage.getCalendarEndingDate(), endDate, "dates END do not match");
    }

    @Test
    public void VerifySelectedRadioButton(){
        String rdoChoice = "male";

        mainPage.setSexRadiobutton(rdoChoice);

        Assert.assertEquals(mainPage.getSexRadiobuttonValue(), rdoChoice, "radio not selected");
    }

}
