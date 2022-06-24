Feature: The new customer creation test

  Scenario: Log in as Bank Manager and create new customer and delete

    Given I am open the login page
    When I click on the Bank Manager Login
    And I click on Add Customer button and added new customer
    And I accept the alert popup
    And I clicked on the Customers
    And I search the newly created customer by first name on Customers list
    And I was convinced the customer was added with the correct info
    And I delete the newly created customer
    Then I was convinced customer is deleted


