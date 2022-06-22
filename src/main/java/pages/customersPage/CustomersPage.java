package pages.customersPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomersPage {
    WebDriver driver;
    private final By searchCustomerPath = By.cssSelector("[ng-model='searchCustomer']");
    private final By deleteBtnPath = By.cssSelector("button[ng-click='deleteCust(cust)']");

    public CustomersPage(WebDriver driver){
        this.driver = driver;
    }

    public void searchCustomer(String firstName){

        driver.findElement(searchCustomerPath).sendKeys(firstName);
    }
    public void deleteCustomer(){
        driver.findElement(deleteBtnPath).click();

    }
}
