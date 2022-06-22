import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.AddCustomerPage;
import pages.BankManagerPage;
import pages.customersPage.AssertsForCustomersPage;
import pages.customersPage.CustomersPage;
import pages.HomePage;

public class BaseTest {
    WebDriver driver;
    HomePage homePage;
    BankManagerPage managerPage;
    AddCustomerPage addCustomerPage;
    CustomersPage customersPage;
    AssertsForCustomersPage assertsForCustomersPage;

    @BeforeSuite
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeClass
    public void navigateHomePage(){
        //1. Open the page https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        managerPage = new BankManagerPage(driver);
        addCustomerPage = new AddCustomerPage(driver);
        customersPage = new CustomersPage(driver);
        assertsForCustomersPage = new AssertsForCustomersPage(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void AddSearchDeleteTest(){
        //2. Click on the "Bank Manager Login"
        homePage.clickBtnBankManagerLogin();

        managerPage.clickBtnAddCustomer();

        //3. Add Customer
        addCustomerPage.addCustomer();

        //4. Accept the alert  popup
        addCustomerPage.acceptAlert();

        //5. Click on the "Customers"
        managerPage.clickBtnCustomers();

        //6. Search the customer on Customers list
        customersPage.searchCustomer(addCustomerPage.firstName);

        //7. Assert that customer is added with correct info
        assertsForCustomersPage.customerIsAdded(addCustomerPage.firstName);

        //8. Delete customer
        customersPage.deleteCustomer();

        //9. Assert that customer is deleted
        assertsForCustomersPage.customerIsDeleted();

    }
}
