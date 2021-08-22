Feature: Test login functionalities

  Background:
    Given a user is on the login page

  @positive_test
  Scenario: Check login is successful with valid credentials
    When user enters username "Rifat" and password "12345"
    And click on login button
    Then user is navigated to home page

  @dataDriven_test
  Scenario Outline: Check login is successful with valid credentials for multiple users
    When user enters username "<username>" and password "<password>"
    And click on login button
    Then user is navigated to home page

    Examples:
      |username|password|
      |Rifat   |12345   |
      |Robert  |12345   |
      |Edward  |12345   |

  @negative_test
  Scenario: Check login is unsuccessful with invalid credentials
    When user enters username "Rifat" and password "44444"
    And click on login button
    Then user is failed to login

  @dataDriven_test
  Scenario: Check login is successful with valid credentials using data table
    When user click on login button upon entering credentials
    |username|password|
    |Rifat   |12345   |
    Then user is navigated to home page