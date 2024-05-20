Feature: Negative Scenarios

  Background: Login on the application
    Given User clicked login page
    When Enter  username as "mngr571223" and password as "vejUzYt"
    And user click on the login button

  Scenario: Verify the user is able to see the message to enter the customer id with wrong details
    Then  Edit customer with wrong customer id

  Scenario: Verify the user is able to see the message to enter the numerical values
    And User click on the edit option
    And User enters character values in the account number text box
    Then User should able to see the error message to update correct values

    Scenario: Verify user should see prompt message while deleting the customer
      And user clicks on delete button
      And clicks submit button
      Then Gets a prompt message

