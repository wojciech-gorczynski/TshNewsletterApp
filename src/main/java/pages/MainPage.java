package pages;

import base.SeleniumBasePage;
import helpers.GlobalMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.reporters.jq.Main;

public class MainPage extends SeleniumBasePage {

    GlobalMethods globalMethods;

    public MainPage(WebDriver driver){
        super(driver);
        globalMethods = new GlobalMethods(driver);
    }

    @FindBy(id = "newsletter_email")
    private WebElement fldEmail;

    @FindBy(id = "newsletter_name")
    private WebElement fldFirstName;

    @FindBy(id = "newsletter_surname")
    private WebElement fldSurname;

    @FindBy(css = "div[class*='ant-select-dropdown']")
    private WebElement dpdNewsletterType;

    @FindBy(css = "div[class='ant-calendar-input-wrap']")
    private WebElement dtpStartingDate;

    @FindBy(id = "#newsletter_endDate")
    private WebElement dtpEndingDate;

    @FindBy(id = "newsletter_Sex")
    private WebElement rdoSex;

    @FindBy(id = "newsletter_agreement")
    private WebElement chkNewsletterAgreement;

    @FindBy(css = "button[type=submit]")
    private WebElement btnSubmit;


    public MainPage initialTest(){
        globalMethods.setInput(fldEmail, "first test");
        return this;
    }




}
