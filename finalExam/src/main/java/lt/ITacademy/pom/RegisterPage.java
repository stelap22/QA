package lt.ITacademy.pom;

import lt.ITacademy.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RegisterPage extends AbstractPage{

    @FindBy(css = "input#username")
    private WebElement inputUserName;

    @FindBy(css = "input#password")
    private WebElement inputPassword;

    @FindBy(css = "input#passwordConfirm")
    private WebElement inputPasswordConfirm;

//    @FindBy(xpath = "//input[@type='checkbox']")
//    private WebElement checkbox;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonCreate;

    @FindBy(css = "a.navbar-brand")
    private WebElement alertMessage;
//Skaiciuotuvas

    @FindBy(css = "span")
    private WebElement errorMessage;
    //1. Šį laukelį būtina užpildyti Privaloma įvesti nuo 3 iki 32 simbolių
    //2. Šį laukelį būtina užpildyti Privaloma įvesti bent 3 simbolius
    //3. Įvesti slaptažodžiai nesutampa

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    private String emptyIfNull(Object value) {
        return value == null ? "" : value.toString();
    }


    public void enterUserName(String userName) {
        inputUserName.sendKeys(emptyIfNull(userName));
    }

    public void enterPassword (String password) {
        inputPassword.sendKeys(emptyIfNull(password));
    }

    public void enterPasswordConfirm(String password) {
        inputPasswordConfirm.sendKeys(emptyIfNull(password));
    }

    //public void markCheckbox() {checkbox.click();}

    public void clickOnButtonCreate() {buttonCreate.click();}

    public WebElement getAlertMessage() {
        scrollToElement(alertMessage);
        return WaitUtils.getVisibleWithWait(alertMessage, driver);
    }

    public WebElement getErrorMessage() {
        scrollToElement(errorMessage);
        return WaitUtils.getVisibleWithWait(errorMessage, driver);
    }




}
