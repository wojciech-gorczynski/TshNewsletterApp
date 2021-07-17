package pages;

import base.SeleniumBasePage;
import helpers.GlobalMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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


    public void setInputForEmailField(String txt){
        globalMethods.setInput(fldEmail,txt);
    }

    public String getInputFromEmailField(){
        return globalMethods.getTextFromInputElement(fldEmail);
    }

    public void setInputForNameField(String txt){
        globalMethods.setInput(fldFirstName,txt);

    }

    public String getInputFromNameField(){
        return globalMethods.getTextFromInputElement(fldFirstName);
    }

    public void setInputForSurnameField(String txt){
        globalMethods.setInput(fldSurname,txt);

    }

    public String getInputFromSurnameField(){
        return globalMethods.getTextFromInputElement(fldSurname);

    }

    public MainPage setInputForNewsletterType(String txt){
        globalMethods.setDropdown(dpdNewsletterType,txt);
        return this;
    }

    public String getOptionFromNewsletterDropdown(){
        return globalMethods.getTextFromDropdown(dpdNewsletterType);
    }

    public void setCalendarStartingDate(String date){
        globalMethods.setCalendarDate(dtpStartingDate,date);
    }

    public String getCalendarStartingDate(){
        return globalMethods.getDateFromCalendar(dtpStartingDate);
    }

    public void setCalendarEndDate(String date){
        globalMethods.setCalendarDate(dtpEndingDate,date);
    }

    public String getCalendarEndingDate(){
        return globalMethods.getDateFromCalendar(dtpEndingDate);
    }

    public void setSexRadiobutton(String choice){
        globalMethods.setRadioButton(rdoSex, choice);
    }

    public String getSexRadiobuttonValue(){
        return globalMethods.getOptionFromRadiobutton(rdoSex);
    }

}
