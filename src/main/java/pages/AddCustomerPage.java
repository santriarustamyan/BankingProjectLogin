package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddCustomerPage {
    WebDriver driver;
    Faker faker = new Faker();
    public String firstName = faker.name().firstName();
    private String lastName = faker.name().lastName();
    private String postCode = faker.address().zipCode();
    private final By firstNamePath = By.cssSelector("[ng-model='fName']");
    private final By lastNamePath = By.cssSelector("[ng-model='lName']");
    private final By postCodePath = By.cssSelector("[ng-model='postCd']");
    private final By btnAddCustomerPath = By.cssSelector("button[type='submit']");

    public AddCustomerPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addCustomer() {
        driver.findElement(firstNamePath).sendKeys(firstName);
        driver.findElement(lastNamePath).sendKeys(lastName);
        driver.findElement(postCodePath).sendKeys(postCode);
        driver.findElement(btnAddCustomerPath).click();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }
}
