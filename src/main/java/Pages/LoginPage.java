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


    public LoginPage enterValidEmail(String email){
        emailInput.sendKeys(email);
        return this;
    }

    public LoginPage enterValidPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public LoginPage enterLoginCredentials(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        return this;
    }

    public LoginPage enterInvalidPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }
    public LoginPage enterInvalidEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public LoginPage clickLogin() {
        loginButton.click();
        return this;

    }

}
