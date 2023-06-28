package lt.ITacademy.pom;

import lt.ITacademy.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage{


    @FindBy(xpath = "//input[@name='username']")
    private WebElement inputUserName;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonLogin;

    @FindBy(css = "a.navbar-brand")
    private WebElement alertMessage;
    //Skaičiuotuvas

    @FindBy(css = "input+span")
    private WebElement errorMessage;
    // visais kitais atvejais - Įvestas prisijungimo vardas ir/ arba slaptažodis yra neteisingi

    @FindBy(xpath = "//a[text()='Sukurti naują paskyrą']")
    private WebElement buttonRegister;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUserName (String userName) {inputUserName.sendKeys(userName);}

    public void enterPassword (String password) {inputPassword.sendKeys(password);}

    public void selectButtonLogin() {buttonLogin.click();}

    public WebElement getAlertMessage() {
        scrollToElement(alertMessage);
        return WaitUtils.getVisibleWithWait(alertMessage, driver);
    }

    public WebElement getErrorMessage() {
        scrollToElement(errorMessage);
        return WaitUtils.getVisibleWithWait(errorMessage, driver);
    }

    //public void navigateToLogin() {buttonLogin.click();}

    public void navigateToRegister() {buttonRegister.click();}

}
