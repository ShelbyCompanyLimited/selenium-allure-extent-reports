package pages;

import helper.PageObjectExtender;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObjectExtender {

    public HomePage(WebDriver driver) {

        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"mainNav\"]/li[5]/a")
    private WebElement SignInButton;



    public void NavigateToLoginPage() {

        waitForPageLoad();
        waitForElement(SignInButton);
        SignInButton.click();
    }
}
