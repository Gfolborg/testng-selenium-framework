import Pages.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTestCases implements AppData {
    private final WebDriver driver = CommonActions.openBrowser("Chrome");
    CommonActions actions = new CommonActions();
    Screenshot screenshot = new Screenshot(driver);

    @BeforeMethod
    public void enterUrl() {
        actions.enterUrl();
    }

    @Test //Test Fails. Unable to continue due to Showstopper bug. Severe Bug reported.
    public void verifyLoginWithValidCredentials() throws InterruptedException {
        Home home = new Home(driver);
        LoginPage login = new LoginPage(driver);

        //Enters VALID Login Credentials
        home.clickMyAccount()
                .clickLogin();
        login.enterValidEmail(AppData.EMAIL)
                .enterValidPassword(AppData.PASSWORD)
                .clickLogin();
        String pageTitle = driver.getTitle();
        if (pageTitle.equals("Account Login")) {
            screenshot.screenshotOnFailure(pageTitle);
            Assert.fail("Verify Login With Valid Credentials: FAILED \nReason: No match for E-Mail Address and/or Password. \nTest Data\n Email: " + EMAIL + "\nPassword: " + PASSWORD);
        }

    }

    @AfterMethod
    public void closeBrowser(){
        actions.closeBrowser();
    }

}

