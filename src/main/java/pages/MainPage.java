package pages;

import base.SeleniumBasePage;
import helpers.GlobalMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends SeleniumBasePage {

    GlobalMethods globalMethods;

    public MainPage(WebDriver driver) {
        super(driver);
        globalMethods = new GlobalMethods(driver);
    }

    @FindBy(id = "newsletter_email")
    private WebElement fldEmail;

    @FindBy(id = "newsletter_name")
    private WebElement fldFirstName;

    @FindBy(id = "newsletter_surname")
    private WebElement fldSurname;

    @FindBy(css = "ul[class*='ant-select-dropdown-menu']")
    private WebElement dpdNewsletterType;

    @FindBy(id = "newsletter_startDate")
    private WebElement dtpStartingDate;

    @FindBy(id = "newsletter_endDate")
    private WebElement dtpEndingDate;

    @FindBy(id = "newsletter_Sex")
    private WebElement rdoSex;

    @FindBy(id = "newsletter_agreement")
    private WebElement chkNewsletterAgreement;

    @FindBy(css = "button[type=submit]")
    private WebElement btnSubmit;


    public MainPage setInputForEmailField(String txt) {
        globalMethods.setInput(fldEmail, txt);

        return this;
    }

    public String getInputFromEmailField() {
        return globalMethods.getTextFromInputElement(fldEmail);
    }

    public MainPage setInputForNameField(String txt) {
        globalMethods.setInput(fldFirstName, txt);

        return this;
    }

    public String getInputFromNameField() {
        return globalMethods.getTextFromInputElement(fldFirstName);
    }

    public MainPage setInputForSurnameField(String txt) {
        globalMethods.setInput(fldSurname, txt);

        return this;
    }

    public String getInputFromSurnameField() {
        return globalMethods.getTextFromInputElement(fldSurname);
    }

    public MainPage setInputForNewsletterType(String txt) {
        globalMethods.setDropdown(dpdNewsletterType, txt);
        return this;
    }

    public String getOptionFromNewsletterDropdown() {
        return globalMethods.getTextFromDropdown(dpdNewsletterType);
    }

    public MainPage setCalendarStartingDate(String date) {
        globalMethods.setCalendarDate(dtpStartingDate, date);

        return this;
    }

    public String getCalendarStartingDate() {
        return globalMethods.getDateFromCalendar(dtpStartingDate);
    }

    public MainPage setCalendarEndDate(String date) {
        globalMethods.setCalendarDate(dtpEndingDate, date);

        return this;
    }

    public String getCalendarEndingDate() {
        return globalMethods.getDateFromCalendar(dtpEndingDate);
    }

    public MainPage setSexRadiobutton(String choice) {
        globalMethods.setRadioButton(rdoSex, choice);

        return this;
    }

    public String getSexRadiobuttonValue() {
        return globalMethods.getOptionFromRadiobutton(rdoSex);
    }

    public MainPage clickCheckbox() {
        globalMethods.setCheckboxElement(chkNewsletterAgreement);

        return this;
    }

    public boolean getCheckboxState() {
        return globalMethods.getCheckboxElementState(chkNewsletterAgreement);
    }

    public MainPage clickOnSubmitButton() {
        globalMethods.clickOnButton(btnSubmit);

        return this;
    }

    public MainPage scrollToSubmitButton() {
        globalMethods.scrollToElement(btnSubmit);

        return this;
    }

    public MainPage closeConfirmDialog() {
        btnSubmit.click();

        return this;
    }


}
