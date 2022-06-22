package pages.customersPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AssertsForCustomersPage {
    WebDriver driver;
    private final By searchResultPath = By.cssSelector("tbody td:nth-child(1)");
    private final By countPath = By.xpath(".//tbody");
    private final int  expectedCount = 0;

    public AssertsForCustomersPage(WebDriver driver){
        this.driver = driver;
    }
    public void  customerIsAdded(String firstName){
        Assert.assertEquals(driver.findElement(searchResultPath).getText(), firstName);
    }
    public void customerIsDeleted(){
        Assert.assertEquals(driver.findElement(countPath).getSize().height, expectedCount);
    }
}
