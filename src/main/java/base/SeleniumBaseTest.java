package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import config.Config;

public class SeleniumBaseTest {
    protected WebDriver driver;
    protected Config config;

    @BeforeMethod
    public void baseBeforeMethod(){
        config = new Config();
        System.setProperty("webdriver.chrome.driver", config.getChromedriverPath());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(config.getApplicationUrl());
    }

    @AfterMethod
    public void baseAfterMethod(){
        driver.quit();
    }
}
