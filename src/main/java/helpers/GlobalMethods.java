package helpers;
import base.SeleniumBasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;


public class GlobalMethods extends SeleniumBasePage {

    public GlobalMethods(WebDriver driver){
        super(driver);
    }

    public void setInput(WebElement inputElement, String text){
        wait.until(visibilityOf(inputElement));
        inputElement.clear();
        inputElement.sendKeys(text);
    }

    public String getTextFromInputElement(WebElement element){
        wait.until(visibilityOf(element));
        return element.getAttribute("value");
    }

    public void setRadioButton(WebElement radioButtonElement, String text){
        wait.until(visibilityOf(radioButtonElement));

        WebElement element = radioButtonElement.findElement(By.cssSelector("input[class='ant-radio-input'][value="+ text +"]"));
        element.click();
//
    }

    public void setDropdown(WebElement dpdElement, String text){
        boolean isAvailable = false;
        WebElement elemDD = driver.findElement(By.id("newsletter_newsType"));

        wait.until(ExpectedConditions.elementToBeClickable(elemDD));
        Actions builder = new Actions(driver);
        builder.sendKeys(elemDD, Keys.DOWN).build().perform();

        List<WebElement> elements = dpdElement.findElements(By.cssSelector("li[role='option']"));
        for(WebElement elem : elements){
            if(elem.getText().equals(text)){
                wait.until(elementToBeClickable(elem));
                elem.click();
                isAvailable = true;
            }
        }
        if(!isAvailable) {
            throw new NoSuchElementException("No such dropdown option available");
        }
    }

    public void setCalendarDate(WebElement dtpElement, String date){
        wait.until(visibilityOf(dtpElement));
        dtpElement.click();
        WebElement elem = driver.findElement(By.cssSelector("input.ant-calendar-input"));
        wait.until(visibilityOf(elem));
        elem.clear();
        elem.sendKeys(date);
        Actions builder = new Actions(driver);
        builder.sendKeys(dtpElement, date).sendKeys(Keys.ENTER).build().perform();
    }

    public void setCheckboxElement(WebElement chkElement){
        if(!chkElement.isSelected()){
            chkElement.click();
        }
    }

    public boolean getChechboxElementState(WebElement chkElement){
        return chkElement.isSelected();
    }

    public String getDateFromCalendar(WebElement dtpElement){
        WebElement elem = dtpElement.findElement(By.cssSelector(".ant-calendar-picker-input"));
        return elem.getAttribute("value");
    }

    public String getTextFromDropdown(WebElement dpdElement){
        WebElement element = dpdElement.findElement(By.cssSelector("li[role='option'][aria-selected='true']"));
        return element.getText();
    }

    public String getOptionFromRadiobutton(WebElement elem) {
        WebElement element = elem.findElement(By.cssSelector("span[class*='ant-radio-checked']>input"));
        return element.getAttribute("value");
    }
}
