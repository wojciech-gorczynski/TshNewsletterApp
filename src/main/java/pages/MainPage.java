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
import org.testng.reporters.jq.Main;

import java.security.Key;

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


    public MainPage checkSetDropdown(){
        WebElement elem = driver.findElement(By.id("newsletter_newsType"));
        Actions builder = new Actions(driver);
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        builder.sendKeys(elem,Keys.DOWN).build().perform();
        globalMethods.setDropdown(dpdNewsletterType, "Medical");

        return this;
    }

    public void setInputForEmailField(String txt){
        globalMethods.setInput(fldEmail,txt);
    }

    public String getInputFromEmailField(String txt){
        return globalMethods.getTextFromElement(fldEmail);
    }

    public void setInputForNameField(String txt){
        globalMethods.setInput(fldFirstName,txt);

    }

    public String getInputFromNameField(String txt){
        return globalMethods.getTextFromElement(fldFirstName);
    }

    public void setInputForSurnameField(String txt){
        globalMethods.setInput(fldSurname,txt);

    }

    public String getInputFromSurnameField(String txt){
        return globalMethods.getTextFromElement(fldSurname);

    }

    public void setInputForNewsletterType(String txt){
        globalMethods.setDropdown(dpdNewsletterType,txt);
    }

}
