import lt.ITacademy.pom.CalculatorPage;
import lt.ITacademy.pom.LoginPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculationTest extends BaseTest{
    //Šio testo įgyvendinimui, duomenų bazėje privalo egzistuoti useris antanas12345/antanas12345

    LoginPage loginPage;
    CalculatorPage calculatorPage;

    @ParameterizedTest
    @CsvFileSource(resources = "/calculationData.csv")
    public void CalculateNumbers(String firstNumber, String secondNumber, int opertionIndex, boolean success, String expectedResult) {
        loginPage = new LoginPage(driver);
        calculatorPage = new CalculatorPage(driver);

        loginPage.enterUserName("antanas12345");
        loginPage.enterPassword("antanas12345");
        loginPage.selectButtonLogin();

        firstNumber = checkNull(firstNumber);
        secondNumber = checkNull(secondNumber);

        calculatorPage.deleteFirstNumber();
        calculatorPage.enterFirstNumber(firstNumber);
        calculatorPage.deleteSecondNumber();
        calculatorPage.enterSecondNumber(secondNumber);
        calculatorPage.selectButtonOperationDropdown(opertionIndex);
        calculatorPage.selectButtonCalculate();

        if (success) {
            WebElement calculationResult = calculatorPage.getCalculationResult();
            assertTrue(calculationResult.isDisplayed(), "Calculation was not completed");
            assertEquals(expectedResult, calculationResult.getText(), "Error while completing calculation");


        } else {
            WebElement errorMessage = calculatorPage.getErrorMessage();
            assertTrue(errorMessage.isDisplayed(), "Error message is not visible");
            assertTrue(errorMessage.getText().contains(expectedResult),"Error while completing calculation");
        }

    }
    private String checkNull(String mainString) {
        return mainString != null ? mainString : "";
    }

}
