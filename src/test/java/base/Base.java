package base;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import helper.ReadFromPom;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class Base {

    protected WebDriver driver;
    protected HomePage homePage;
    protected LoginPage loginPage;

    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public ExtentTest test;
    public static String reportDestination = System.getProperty("user.dir") + "/ExtentReport/ExtentReport.html";
    protected final Logger logger = LogManager.getLogger(getClass());


//    @BeforeSuite(alwaysRun = true)
//    public void setUp() throws IOException {
//
////        extentReport();
//
//    }


    @BeforeTest(alwaysRun = true)
    public void beforeTest() throws IOException {

        openBrowser();
        //Initialize all Page Elements before test starts
        homePage = PageFactory.initElements(driver, HomePage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);

        //Read Host from properties
        ReadFromPom readFromPom = new ReadFromPom();
        driver.navigate().to(readFromPom.getPropertyFomPom("BaseURL"));

    }


    @AfterTest
    public void afterSuite() {

        driver.close();


    }
//
//    @AfterSuite
//    public void afterSuite() {
//
//        driver.close();
////        extent.flush();
//
//    }

//    @AfterClass
//    public void afterClass() {
//
//        driver.close();
//    }

//    @AfterMethod
//    public void tearDown(ITestResult result) {
//
//        if (result.getStatus() == ITestResult.FAILURE) {
//            test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName());
//            test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable());
//
//        } else if (result.getStatus() == ITestResult.SKIP) {
//            test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
//        } else if (result.getStatus() == ITestResult.SUCCESS) {
//            test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
//        }
//
//    }

    public void extentReport() throws IOException {

        htmlReporter = new ExtentHtmlReporter(reportDestination);
        ReadFromPom readFromPom = new ReadFromPom();
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Browser Name", readFromPom.getPropertyFomPom("BrowserName"));
        extent.setSystemInfo("Environment", readFromPom.getPropertyFomPom("Environment"));
        extent.setSystemInfo("Base URL", readFromPom.getPropertyFomPom("BaseURL"));
        extent.setSystemInfo("User Name", "Test Username - Need to be defined");
        extent.setSystemInfo("User Email", "Test Username - Need to be defined");


        htmlReporter.config().setDocumentTitle("Automation Testing Report");
        htmlReporter.config().setReportName("Automation Test Suite");
        htmlReporter.config().setTheme(Theme.DARK);

    }


    public void openBrowser() throws IOException {

        ReadFromPom readFromPom = new ReadFromPom();
        if (System.getProperty("os.name").equalsIgnoreCase("Mac OS X")) {
            if (readFromPom.getPropertyFomPom("BrowserName").equalsIgnoreCase("chrome")) {

                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
                System.setProperty("webdriver.chrome.logfile", "./logs/chromeLogs.txt");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized", "gecko.switches", "--disable-extensions");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            } else if (readFromPom.getPropertyFomPom("BrowserName").equalsIgnoreCase("firefox")) {

                System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
                System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "./logs/FirefoxLogs.txt");
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--start-maximized", "gecko.switches", "--disable-extensions");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            } else if (readFromPom.getPropertyFomPom("BrowserName").equalsIgnoreCase("safari")) {

                SafariOptions options = new SafariOptions();
                driver = new SafariDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            } else {

                ChromeOptions options = new ChromeOptions();
                options.setHeadless(true);
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
                driver = new ChromeDriver(options);
            }

        } else if (readFromPom.getPropertyFomPom("BrowserName").equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
            System.setProperty("webdriver.chrome.logfile", "./logs/chromeLogs.txt");

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized", "gecko.switches", "--disable-extensions");

            driver = new ChromeDriver();
            System.out.println(driver);
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } else {

            System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\geckodriver.exe");
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "./logs/FirefoxLogs.txt");
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--start-maximized", "gecko.switches", "--disable-extensions");
            driver = new FirefoxDriver();
            System.out.println(driver);
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

    }
}