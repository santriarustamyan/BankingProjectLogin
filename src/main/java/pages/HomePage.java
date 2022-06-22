package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    private final By btnBankManagerLoginPath = By.cssSelector("[ng-click='manager()']");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void clickBtnBankManagerLogin(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.findElement(btnBankManagerLoginPath).click();
    }

}
