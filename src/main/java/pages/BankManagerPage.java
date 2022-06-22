package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BankManagerPage {
    WebDriver driver;
    private final By btnAddCustomerPath = By.cssSelector("button[ng-click='addCust()']");
    private final By btnCustomerPath = By.cssSelector("button[ng-click='showCust()']");

    public BankManagerPage(WebDriver driver){
        this.driver = driver;
    }
    public void clickBtnAddCustomer(){
        driver.findElement(btnAddCustomerPath).click();
    }
    public void clickBtnCustomers() {
        driver.findElement(btnCustomerPath).click();
    }

}
