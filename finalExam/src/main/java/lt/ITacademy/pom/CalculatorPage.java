package lt.ITacademy.pom;

import lt.ITacademy.utils.WaitUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CalculatorPage extends AbstractPage{

    @FindBy(css = "#sk1")
    private WebElement inputFirstNumber;

    @FindBy(css = "#sk2")
    private WebElement inputSecondNumber;

    @FindBy(xpath = "//select[@name='zenklas']")
    private WebElement buttonOperationDropdown;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement buttonCalculate;

    @FindBy(css = "h4")
    private WebElement calculationResult;

    @FindBy(css = "input+span")
    private WebElement errorMessage;
    // Validacijos klaida: skaičius negali būti neigiamas

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    public void deleteFirstNumber () {inputFirstNumber.clear();}

    public void enterFirstNumber (String firstNumber) {inputFirstNumber.sendKeys(firstNumber);}

    public void deleteSecondNumber () {inputSecondNumber.clear();}

    public void enterSecondNumber (String secondNumber) {inputSecondNumber.sendKeys(secondNumber);}

    public void selectButtonOperationDropdown(int index){
        Select select = new Select(buttonOperationDropdown);
        select.selectByIndex(index);
    }

    public void selectButtonCalculate() {buttonCalculate.click();}

    public WebElement getCalculationResult() {
        scrollToElement(calculationResult);
        return WaitUtils.getVisibleWithWait(calculationResult, driver);
    }

    public WebElement getErrorMessage() {
        scrollToElement(errorMessage);
        return WaitUtils.getVisibleWithWait(errorMessage, driver);
    }

//    public WebElement getCalculationResult() {
//        scrollToElement(calculationResult);
//        return calculationResult;
//    }
//
//    public WebElement getErrorMessage() {
//        scrollToElement(errorMessage);
//        return errorMessage;
//    }

}
