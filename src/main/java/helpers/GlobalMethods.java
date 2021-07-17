package helpers;

import base.SeleniumBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    public String getTextFromElement(WebElement element){
        wait.until(visibilityOf(element));
        return element.getAttribute("value");
    }

    public void setRadioButton(WebElement radioButtonElement, String text){
        wait.until(visibilityOf(radioButtonElement));
        boolean isOptionAvailable = false;

        List<WebElement> elements = radioButtonElement.findElements(By.cssSelector("input[class='ant-radio-input']"));
        for(WebElement elem : elements){
            if(elem.getAttribute("value").equals(text)){
                elem.click();
                isOptionAvailable = true;
            }
        }
        if(!isOptionAvailable) {
            throw new NoSuchElementException("No such radiobutton option available");
        }
    }

    public void setDropdown(WebElement dpdElement, String text){
        wait.until(visibilityOf(dpdElement));
        boolean isAvailable = false;
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
        dtpElement.clear();
        dtpElement.sendKeys(date);
    }


}
