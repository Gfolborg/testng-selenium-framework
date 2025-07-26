package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Registration implements AppData{
    WebDriver driver;

    public Registration(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@type='text' and @id='input-firstname']")
    WebElement fName;
    @FindBy(xpath = "//input[@type='text' and @id = 'input-lastname']")
    WebElement lName;
    @FindBy(id = "input-email")
    WebElement emailTextBox;
    @FindBy(id = "input-telephone")
    WebElement phone;
    @FindBy(xpath = "//input[@type='password' and @name='password']")
    WebElement passwordInput;
    @FindBy(xpath = "//input[@type='password' and @name='confirm']")
    WebElement passwordConfirmation;
    @FindBy(xpath = "//input[@type='submit' and @value='Continue']")
    WebElement continueButton;
    @FindBy(xpath = "//label[@class='radio-inline']/input[@value='1']")
    WebElement newsletterYesLabel;
    @FindBy(xpath = "//input[@type='checkbox' and @name='agree']")
    WebElement privacyCheck;


    public Registration firstNameInput(String firstName){
        fName.sendKeys(firstName);
        return this;
    }

    public Registration lastNameInput(String lastName){
        lName.sendKeys(lastName);
        return this;
    }

    public Registration emailInput(String email){
        emailTextBox.sendKeys(email);
        return this;
    }

    public Registration telephoneInput(String phoneNumber){
        phone.sendKeys(TELEPHONE);
        return this;
    }

    public Registration passwordConfirm(String password, String passwordConfirm) {
        passwordInput.sendKeys(password);
        passwordConfirmation.sendKeys(passwordConfirm);
        return this;
    }

    public Registration newsletterSubscribeButton(String yesOrNo) {
        if (yesOrNo.equalsIgnoreCase("Yes")) {
            newsletterYesLabel.click();
        }
        return this;

    }
    public Registration privatePolicyCheckbox() {
        privacyCheck.click();
        return this;
    }

    public Registration continueButton(){
        continueButton.click();
        return this;
    }
}
