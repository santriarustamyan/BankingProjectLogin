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


    @Given("I am open the login page")
    public void i_am_open_the_login_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }

    @When("I click on the Bank Manager Login")
    public void i_click_on_the_bank_manager_login() {
        homePage = new HomePage(driver);
        homePage.clickBtnBankManagerLogin();
    }

    @When("I click on Add Customer button and added new customer")
    public void i_click_on_add_customer_button_and_added_new_customer() {
        managerPage = new BankManagerPage(driver);
        addCustomerPage = new AddCustomerPage(driver);

        managerPage.clickBtnAddCustomer();
        addCustomerPage.addCustomer();
    }

    @When("I accept the alert popup")
    public void i_accept_the_alert_popup() {
        addCustomerPage.acceptAlert();
    }

    @When("I clicked on the Customers")
    public void i_clicked_on_the_customers() {
        managerPage.clickBtnCustomers();
    }

    @When("I search the newly created customer by first name on Customers list")
    public void i_search_the_newly_created_customer_by_first_name_on_customers_list() {
        customersPage = new CustomersPage(driver);
        customersPage.searchCustomer(addCustomerPage.firstName);
    }

    @When("I was convinced the customer was added with the correct info")
    public void i_was_convinced_the_customer_was_added_with_the_correct_info() {
        assertsForCustomersPage = new AssertsForCustomersPage(driver) ;
        assertsForCustomersPage.customerIsAdded(addCustomerPage.firstName);
    }

    @When("I delete the newly created customer")
    public void i_delete_the_newly_created_customer() {
        customersPage.deleteCustomer();
    }

    @Then("I was convinced customer is deleted")
    public void i_was_convinced_customer_is_deleted() {
        assertsForCustomersPage.customerIsDeleted();
    }
}
