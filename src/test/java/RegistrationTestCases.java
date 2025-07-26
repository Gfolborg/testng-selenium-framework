import Pages.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class RegistrationTestCases implements AppData {
    private WebDriver driver;
    private CommonActions actions;
    private Home home;
    private Registration register;

    @BeforeMethod
    public void openBrowser(){
        actions.enterUrl();
    }

    @Test
    public void verifyRegistrationSignUp() {
        //Fills Out Registration Form
        home.clickMyAccount()
                .clickRegistration();
        register.firstNameInput(AppData.FIRSTNAME)
                .lastNameInput(AppData.LASTNAME)
                .emailInput(AppData.EMAIL)
                .telephoneInput(TELEPHONE)
                .passwordConfirm(AppData.PASSWORD, AppData.PASSWORD)
                .newsletterSubscribeButton("Yes")
                .privatePolicyCheckbox()
                .continueButton();

        //Validate Registration
        String pageTitle = driver.getTitle();
        if(!pageTitle.equals("Your Account Has Been Created!")) {
            Assert.fail("Verify Registration Sign Up = FAILED \nReason: E-Mail Address is already registered! \n \nTest Data \n Email: John.Smith@gmail.com \n Password: Test@1234");
        } else {
            Assert.assertEquals("Verify Registration Sign Up = PASSED", "Your Account Has Been Created!", pageTitle);
        }
    }

    @AfterMethod
    public void closeBrowser(){
        actions.closeBrowser();
    }
}
