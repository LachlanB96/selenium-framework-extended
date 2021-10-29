Feature: Login

  Scenario: Test cucumber tests
    Given A string containing "123"
    When I check if the given string is 123
    Then Cucumber tests are working

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

#  Scenario: Login to the Automation Practice Website
#    Given I am on the AP homepage
#    And I have the correct credentials
#    When I enter my credentials
#    Then I will be logged in
#
