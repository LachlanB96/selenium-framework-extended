Feature: Login

  Scenario: Login to the Automation Practice Website
    Given I have the correct username
    And I have the correct password
    When I press the submit login button
    Then I will be logged in

  Scenario: Fail to login to the Automation Practice Website
    Given I have the wrong username
    And I have the wrong password
    When I press the submit login button
    Then I wont be logged in