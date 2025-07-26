package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Home implements AppData {
    WebDriver driver;

    public Home (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@title='My Account']")
    WebElement myAccountButton;
    @FindBy(xpath = "//a[text()='Register']")
    WebElement registrationButton;
    @FindBy(xpath = "//a[contains(@href, 'account/login')]")
    WebElement loginButton;
    @FindBy(xpath = "//input[@name='search' and @class='form-control input-lg']")
    WebElement searchBox;

    public Home clickMyAccount(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        myAccountButton.click();
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        return this;
    }

    public Home clickLogin(){
        loginButton.click();
        return this;
    }

    public Home clickRegistration(){
        registrationButton.click();
        return this;
    }

    public Home searchItem(String item) {
        searchBox.sendKeys(item);
        return this;
    }

}
