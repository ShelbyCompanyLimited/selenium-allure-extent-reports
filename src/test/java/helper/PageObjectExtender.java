package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class PageObjectExtender {
    protected WebDriver driver;

    //Function to wait for full page to be loaded
    public void waitForPageLoad() {
        driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.MINUTES);

    }

    //Function to wait for some element to be visible
    public void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    //Function to wait for some element to be clickable
    public void waitForElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    //Function to select some option from Dropdown by Value which is present in the DOM file
    public void selectOptionFromDropDown(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);

    }

}
