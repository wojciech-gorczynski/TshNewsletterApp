package Test;

import base.SeleniumBaseTest;
import config.EmailConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import static io.restassured.RestAssured.given;
import java.util.UUID;

public class MainPageTest extends SeleniumBaseTest {

    MainPage mainPage;
    EmailConfig emailConfig;

    public MainPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        mainPage = new MainPage(driver);
        emailConfig = new EmailConfig();
    }

    @Test
    public void verifyEmailFieldInput() {
        String emailInput = "e2eEmail" + UUID.randomUUID().toString().substring(0, 3) + "@test.com";

        mainPage.setInputForEmailField(emailInput);
        Assert.assertEquals(new MainPage(driver).getInputFromEmailField(), emailInput,
                "Input provided in email field is not visible");
    }

    @Test
    public void verifyFirstNameFieldInput() {
        String firstNameInput = "e2eFirstName" + UUID.randomUUID().toString().substring(0, 3);

        mainPage.setInputForNameField(firstNameInput);
        Assert.assertEquals(new MainPage(driver).getInputFromNameField(), firstNameInput,
                "Input provided in First name field is not visible");
    }

    @Test
    public void verifySurnameFieldInput() {
        String surnameInput = "e2eSurname" + UUID.randomUUID().toString().substring(0, 3);

        mainPage.setInputForSurnameField(surnameInput);
        Assert.assertEquals(new MainPage(driver).getInputFromSurnameField(), surnameInput,
                "Input provided in Surname field is not visible");
    }

    @Test
    public void verifySelectedNewsletterOption() {
        String newsletterOption = "Medical";

        mainPage.setInputForNewsletterType(newsletterOption);

        Assert.assertEquals(mainPage.getOptionFromNewsletterDropdown(), newsletterOption, "Selected dropdown " +
                "option is not visible");
    }

    @Test
    public void verifyProvidedStartingDate() {
        String startingDate = "2021-08-20";

        mainPage.setCalendarStartingDate(startingDate);
        Assert.assertEquals(mainPage.getCalendarStartingDate(), startingDate, "Provided calendar starting date is not visible");
    }

    @Test
    public void verifyProvidedEndDate() {
        String endDate = "2021-09-20";
        mainPage.setCalendarEndDate(endDate);

        Assert.assertEquals(mainPage.getCalendarEndingDate(), endDate, "Provided calendar ending date is not visible");
    }

    @Test
    public void VerifySelectedRadioButton() {
        String rdoChoice = "male";

        mainPage.setSexRadiobutton(rdoChoice);

        Assert.assertEquals(mainPage.getSexRadiobuttonValue(), rdoChoice, "Selected radio button is not visible");
    }

    @Test
    public void VerifyIfCheckboxIsSelected() {
        mainPage.clickCheckbox();
        Assert.assertTrue(mainPage.getCheckboxState());
    }

    @Test
    public void SendEmail() {
        String e2eSuffix = UUID.randomUUID().toString().substring(0, 3);
        String emailInput = "e2eEmail" + e2eSuffix + "@test.com";
        String firstNameInput = "e2eFirstName" + e2eSuffix;
        String surnameInput = "e2eSurname" + e2eSuffix;
        String newsletterOption = "Medical";
        String startingDate = "2021-09-20";
        String endDate = "2021-11-20";
        String rdoChoice = "male";
        String mailProjectId = config.getMailTrapProjectId();
        String bearerToken = config.getMailTrapBearerToken();
        String emailId = UUID.randomUUID().toString().substring(0, 3);
        String emailSubjectToVerify = "This is the e2eTest Subject for email with ID" + emailId;
        Response response;

        mainPage.setInputForEmailField(emailInput)
                .setInputForNameField(firstNameInput)
                .setInputForSurnameField(surnameInput)
                .setInputForNewsletterType(newsletterOption)
                .setCalendarStartingDate(startingDate)
                .setSexRadiobutton(rdoChoice)
                .setCalendarEndDate(endDate)
                .clickCheckbox()
                .scrollToSubmitButton()
                .clickOnSubmitButton()
                .closeConfirmDialog();

        emailConfig.sendEmail(emailId);

        response = given()
                .headers(
                        "Authorization",
                        "Bearer " + bearerToken,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .port(443)
                .when()
                .get("https://mailtrap.io/api/v1/inboxes/" + mailProjectId + "/messages/");

        Assert.assertTrue(response.jsonPath().getString("subject").contains(emailSubjectToVerify));
    }


}
