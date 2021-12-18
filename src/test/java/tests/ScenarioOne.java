package tests;

import base.Base;
import helper.ReadFromPropertiesFile;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

//
//@Epic("Web Application Regression Testing using JUnit5")
//@Feature("Dashboard Page Tests")
public class ScenarioOne extends Base {

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description : Login to the application")
    public void VerifyItemsToCheckout() {

        ReadFromPropertiesFile readFromPropertiesFile = new ReadFromPropertiesFile();

//        test = extent.createTest("Scenario One");
        logger.info("Open and Verify Hope Page");
        //This function will verify elements on the HomePage and click on Login Button
        homePage.NavigateToLoginPage();
//        test.log(Status.INFO, "OpenAndVerifyHomePage");
        logger.info("OpenAndVerifyHomePage");

//        test.log(Status.INFO, "Login To the Page");
        logger.info("Login To the Page");
        loginPage.LoginToThePage(readFromPropertiesFile.getEmail(), readFromPropertiesFile.getPassword());
    }
}


