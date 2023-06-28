package lt.ITacademy.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavBar extends AbstractPage{

    @FindBy(xpath = "//a[@href='/skaiciai']")
    private WebElement buttonOperationsList;

    public NavBar(WebDriver driver) {
        super(driver);
    }

    public void selectButtonToOperationsList() {buttonOperationsList.click();}


}
