package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {

    @FindBy(id = "newsletter_email")
    private WebElement fldEmail;

    @FindBy(id = "newsletter_name")
    private WebElement fldFirstName;

    @FindBy(id = "newsletter_surname")
    private WebElement fldSurname;

    @FindBy(id = "newsletter_newsType")
    private WebElement cboNewsletterType;

    @FindBy(css = "div[class='ant-calendar-input-wrap']")
    private WebElement dtpStartingDate;

    @FindBy(id = "#newsletter_endDate")
    private WebElement dtpEndingDate;

    @FindBy(id = "newsletter_Sex")
    private WebElement rdoSex;

    @FindBy(id = "#newsletter_agreement")
    private WebElement chkNewsletterAgreement;

    





}
