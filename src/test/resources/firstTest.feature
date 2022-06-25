Feature: The new customer creation test

  Scenario: Log in as Bank Manager and create new customer and delete

    Given I am on the Login page
    When I click on the Bank Manager Login
    And I click on Add Customer button
    And I accept the alert popup
    And I click on the Customers
    And I search the newly created customer by first name on Customers list
    And Assert that customer is added with correct info
    And I delete the newly created customer
    Then Assert customer is deleted


