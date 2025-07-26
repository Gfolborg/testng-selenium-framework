package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage implements AppData{
    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "input-email")
    WebElement emailInput;
    @FindBy(id = "input-password")
    WebElement passwordInput;
    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginButton;


    public void enterValidEmail(String email){
        emailInput.sendKeys(email);
    }

    public void enterValidPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void enterLoginCredentials(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
    }

    public void enterInvalidPassword(String password) {
        passwordInput.sendKeys(password);
    }
    public void enterInvalidEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void clickLogin() {
        loginButton.click();

    }

}
