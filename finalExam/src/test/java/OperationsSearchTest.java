import lt.ITacademy.pom.CalculatorPage;
import lt.ITacademy.pom.LoginPage;
import lt.ITacademy.pom.NavBar;
import lt.ITacademy.pom.OperationsListPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.devtools.v112.domstorage.model.Item;
import org.testng.Assert;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OperationsSearchTest extends BaseTest{

    CalculatorPage calculatorPage;
    NavBar navBar;
    LoginPage loginPage;
    OperationsListPage operationsListPage;

    @ParameterizedTest
    @CsvFileSource(resources = "/operations.csv")
    public void SearchOperationInTheList(String firstNumber, String sign, String secondNumber, int operationIndex, String result, boolean exists) {

        loginPage = new LoginPage(driver);
        calculatorPage = new CalculatorPage(driver);
        navBar = new NavBar(driver);

        loginPage.enterUserName("antanas12345");
        loginPage.enterPassword("antanas12345");
        loginPage.selectButtonLogin();

        calculatorPage.deleteFirstNumber();
        calculatorPage.enterFirstNumber(firstNumber);
        calculatorPage.deleteSecondNumber();
        calculatorPage.enterSecondNumber(secondNumber);
        calculatorPage.selectButtonOperationDropdown(operationIndex);
        calculatorPage.selectButtonCalculate();

        navBar.selectButtonToOperationsList();

        //nepabaigtas -> is pradziu sukuriu irasa, o veliau reiketu ieskoti sukurto iraso paskutineje eiluteje.

    }


}
