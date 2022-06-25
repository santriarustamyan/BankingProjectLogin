package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AddCustomerPage;
import pages.BankManagerPage;
import pages.HomePage;
import pages.customersPage.AssertsForCustomersPage;
import pages.customersPage.CustomersPage;

public class Steps {
    WebDriver driver;
    HomePage homePage;
    BankManagerPage managerPage;
    AddCustomerPage addCustomerPage;
    CustomersPage customersPage;
    AssertsForCustomersPage assertsForCustomersPage;

    @Given("I am on the Login page")
    public void i_am_on_the_login_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }

    @When("I click on the Bank Manager Login")
    public void i_click_on_the_bank_manager_login() {
        homePage = new HomePage(driver);
        homePage.clickBtnBankManagerLogin();
    }

    @When("I click on Add Customer button")
    public void i_click_on_add_customer_button() {
        managerPage = new BankManagerPage(driver);
        addCustomerPage = new AddCustomerPage(driver);

        managerPage.clickBtnAddCustomer();
        addCustomerPage.addCustomer();
    }

    @When("I accept the alert popup")
    public void i_accept_the_alert_popup() {
        addCustomerPage.acceptAlert();
    }

    @When("I click on the Customers")
    public void i_click_on_the_customers() {
        managerPage.clickBtnCustomers();
    }

    @When("I search the newly created customer by first name on Customers list")
    public void i_search_the_newly_created_customer_by_first_name_on_customers_list() {
        customersPage = new CustomersPage(driver);
        customersPage.searchCustomer(addCustomerPage.firstName);
    }

    @When("Assert that customer is added with correct info")
    public void assert_that_customer_is_added_with_correct_info() {
        assertsForCustomersPage = new AssertsForCustomersPage(driver) ;
        assertsForCustomersPage.customerIsAdded(addCustomerPage.firstName);
    }

    @When("I delete the newly created customer")
    public void i_delete_the_newly_created_customer() {
        customersPage.deleteCustomer();
    }

    @Then("Assert customer is deleted")
    public void assert_customer_is_deleted() {
        assertsForCustomersPage.customerIsDeleted();
    }
}
