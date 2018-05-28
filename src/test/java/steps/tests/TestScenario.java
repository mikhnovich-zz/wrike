package steps.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import resources.Browser;
import steps.pages.FreeTrialPage;
import steps.pages.LoginPage;
import steps.pages.MainPage;
import steps.pages.QAFormPage;
import steps.resources.GetProperty;

import java.io.IOException;

public class TestScenario {
    static private MainPage mainPage;
    static private LoginPage loginPage;
    static private FreeTrialPage freeTrialPage;
    static private QAFormPage qaFormPage;
    private static Browser browser = Browser.getInstance();
    private static GetProperty property = new GetProperty();
    public static WebDriver driver;


    @Before
    public void setUp() throws IOException {
        driver = browser.getDriver();
        driver.get(property.getProperty("URL"));
    }

    @After
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Test
    public void testScenario() {
        mainPage = PageFactory.initElements(driver, MainPage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        freeTrialPage = PageFactory.initElements(driver, FreeTrialPage.class);
        qaFormPage = PageFactory.initElements(driver, QAFormPage.class);

        mainPage.loginBtn.click();
        loginPage.createAccountLink.click();
        freeTrialPage.createAccount();
        freeTrialPage.createAccountBtn.click();

        //Fill in the Q&A section at the left part of the page (like randomly generated answers)
        qaFormPage.fillInQASection();

        //Check with assertion that you are moved to the next page
        Assert.assertEquals("https://www.wrike.com/resend/", driver.getCurrentUrl());
        qaFormPage.submitResultsBtn.click();

        //Check with assertion that your answers are submitted
        Assert.assertTrue(driver.findElement(By.xpath("//button/span[contains(@style,'display: block;')]")).isDisplayed());
        qaFormPage.resendEmailBtn.click();

        //Check that section "Follow us" at the site footer contains the "Twitter" button that leads to the correct url
        Assert.assertEquals("https://twitter.com/wrike", qaFormPage.twitterLink.getAttribute("href"));
        Assert.assertTrue(qaFormPage.check.isDisplayed());




    }
}


