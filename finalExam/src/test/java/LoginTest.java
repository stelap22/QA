import lt.ITacademy.pom.LoginPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest{
    //Šio testo įgyvendinimui, duomenų bazėje privalo egzistuoti useris antanas12345/antanas12345

    LoginPage loginPage;

    @ParameterizedTest
    @CsvFileSource(resources = "/loginData.csv")
    public void LoginIntoAccount(String userName, String password, boolean success, String expectedMessage) {

        loginPage = new LoginPage(driver);

        userName = checkNull(userName);
        password = checkNull(password);

        loginPage.enterUserName(userName);
        loginPage.enterPassword(password);
        loginPage.selectButtonLogin();

        if (success) {
            WebElement alertMessage = loginPage.getAlertMessage();
            assertTrue(alertMessage.isDisplayed(), "Alert is not visible");
            assertEquals(expectedMessage, alertMessage.getText(), "Error while creating account");

        } else {
            WebElement errorMessage = loginPage.getErrorMessage();
            assertTrue(errorMessage.isDisplayed(), "Error message is not visible");
            assertEquals(expectedMessage, errorMessage.getText(), "Error while creating account");
        }
    }

    private String checkNull(String mainString) {
        return mainString != null ? mainString : "";
    }
}




