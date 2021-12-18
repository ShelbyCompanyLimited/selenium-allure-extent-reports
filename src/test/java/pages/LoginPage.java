package pages;

import helper.PageObjectExtender;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObjectExtender {

    public LoginPage(WebDriver driver) {

        this.driver = driver;

    }

    @FindBy(xpath = "//*[@id=\"edit-mail\"]")
    private WebElement emailTextField;

    @FindBy(xpath = "//*[@id=\"edit-pass\"]")
    private WebElement passwordTextField;

    @FindBy(xpath = "//*[@id=\"edit-submit\"]")
    private WebElement loginButton;


    public void LoginToThePage(String email, String password) {

        waitForPageLoad();
        waitForElement(emailTextField);
        waitForElement(passwordTextField);
        waitForElement(loginButton);

        emailTextField.sendKeys(email);
        passwordTextField.sendKeys(password);
        loginButton.click();

    }

}
