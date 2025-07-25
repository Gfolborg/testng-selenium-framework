import Pages.AppData;
import Pages.CommonActions;
import Pages.Home;
import Pages.Registration;
import org.junit.Assert;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class RegistrationTestCases implements AppData {
    WebDriver driver = CommonActions.openBrowser(BROWSER_TYPE);
    CommonActions actions = new CommonActions();
    Home home = new Home(driver);
    Registration register = new Registration(driver);

    @BeforeMethod
    public void openBrowser(){
        actions.enterUrl();
    }

    @Test
    public void verifyRegistrationSignUp() throws InterruptedException {
        home.clickMyAccount();
        home.clickRegistration();
        register.firstNameInput(AppData.VALID_FIRSTNAME);
        register.lastNameInput(AppData.VALID_LASTNAME);
        register.emailInput(AppData.VALID_EMAIL);
        register.telephoneInput(TELEPHONE);
        register.passwordConfirm(AppData.VALID_PASSWORD, AppData.VALID_PASSWORD);
        register.newsletterSubscribeButton("Yes");
        register.privatePolicyCheckbox();
        register.continueButton();
        String nextPage = driver.getTitle();
        Assert.assertEquals("Register Account", nextPage);
        System.out.println("Current page title: " + nextPage);

    }

    public void verifyLoginWithValidCredentials() {
        home.clickMyAccount();
        home.clickLogin();

    }

    @AfterMethod
    public void closeBrowser(){
        actions.closeBrowser();
    }
}
