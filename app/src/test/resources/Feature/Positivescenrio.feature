Feature: Positive Scenarios

  Background: Login on the application
    Given User is on login page
    When Enter the username as "mngr571223" and password as "vejUzYt"
    And user click  login button

  Scenario: Verify the user is able to banking application
    Then User should able to verify the manager Id


  Scenario: Verify that the user is able to see the available option in the banking application
    Then  User should able to see the list of banking services provided

  Scenario: Verify the user is able to click on logout button in application
    And User clicks on  logout button
    Then User should able to see the alert window

