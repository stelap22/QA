package lt.ITacademy.pom;

import lt.ITacademy.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class OperationsListPage extends AbstractPage{

    @FindBy(tagName = "tr")
    private List<WebElement> OperationsListRows;

    @FindBy(css = "tbody")
    private WebElement operationsList;

    List<WebElement> noOfRows = driver.findElements(By.xpath("//table/tbody/tr"));

    List<WebElement> cols = driver.findElements(By.xpath("//table/tbody/td"));


    public OperationsListPage(WebDriver driver) {
        super(driver);
    }


    public List<String> getAllOperations() {
        return OperationsListRows.stream().map(e -> e.getText()).collect(Collectors.toList());
    }

    public WebElement getOperationResult() {
        scrollToElement(operationsList);
        return WaitUtils.getVisibleWithWait(operationsList, driver);
    }

//    public WebElement getlastRow() {noOfRows.get(noOfRows.size()-1);
//    return noOfRows.size()-1;}

}
