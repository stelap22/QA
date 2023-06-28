import lt.ITacademy.pom.LoginPage;
import lt.ITacademy.pom.RegisterPage;
import lt.ITacademy.utils.WaitUtils;
import lt.ITacademy.utils.RandomUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterTest extends BaseTest{

    LoginPage loginPage;
    RegisterPage registerPage;


        @ParameterizedTest
        @CsvFileSource(resources = "/registerData.csv")
        public void RegisterNewAccount(String userName, String password, String passwordConfirm, boolean success, String expectedMessage) {

            loginPage = new LoginPage(driver);
            registerPage = new RegisterPage(driver);

            loginPage.navigateToRegister();
            WaitUtils.waitPageToLoad(driver);

            String suffix = RandomUtils.randomNumber(4);
            userName = join(userName, suffix);
            password = join(password, suffix);
            passwordConfirm= join(passwordConfirm, suffix);

            registerPage.enterUserName(userName);
            registerPage.enterPassword(password);
            registerPage.enterPasswordConfirm(passwordConfirm);
            registerPage.clickOnButtonCreate();

            if (success) {
                WebElement alertMessage = registerPage.getAlertMessage();
                assertTrue(alertMessage.isDisplayed(), "Alert is not visible");
                assertEquals(expectedMessage, alertMessage.getText(), "Error while creating account");

            } else {
                WebElement errorMessage = registerPage.getErrorMessage();
                assertTrue(errorMessage.isDisplayed(), "Error message is not visible");
                assertTrue(errorMessage.getText().contains(expectedMessage));
            }
        }

    private String join(String mainString, String appendedString) {
        return mainString == null ? null : (mainString + appendedString);
    }

}
