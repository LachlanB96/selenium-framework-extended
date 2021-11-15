#Feature: Login
#  # Background: find examples and use
#
#  Scenario: Test cucumber tests
#    Given A string containing "123"
#    When I check if the given string is 123
#    Then Cucumber tests are working
#
#  Scenario Outline: Test cucumber scenario outline tests
#    Given A value of <a>
#    And And a value of <b>
#    When I compare the value of a + b it should be <sum>
#    Then We compare if sum was the desired output of "<outcome>"
#    Examples:
#      | a | b | sum | outcome |
#      | 1 | 2 | 3   | true    |
#      | 3 | 2 | 4   | false   |
#      | 4 | 5 | 9   | true    |
#
#  Scenario: Login to the Automation Practice Website
#    Given I have the correct username
#    And I have the correct password
#    When I press the submit login button
#    Then I will be logged in
#
#  Scenario: Fail to login to the Automation Practice Website
#    Given I have the wrong username
#    And I have the wrong password
#    When I press the submit login button
#    Then I wont be logged in
#
#  Scenario Outline: Login to the Automation Practice Website using a list of map
#    Given I have the "<username>" username and the "<password>" password
#    When I submit the login information
#    Then I will be logged in if the "<expectedOutcome>" is true
#    Examples:
#      | username | password | expectedOutcome |
#      | test@lachlanb.com | password | true |
#      | fake@fake.com | wrongpassword | false |
#
#  Scenario Outline: Test
#    Given I log the value of <x> and <y>
#    And I have another <y>
#    Examples:
#  | x | y |
#  | 1 | 5 |
#  | 2 | 4 |
#  | 3 | 3 |
#  | 4 | 2 |

#  Scenario Template:
#    Examples:
#      |  |
#


#  Scenario: Login to the Automation Practice Website
#    Given I am on the AP homepage
#    And I have the correct credentials
#    When I enter my credentials
#    Then I will be logged in
#

#  | username | password | expectedOutcome |
#  | test@lachlanb.com | password | true |
#  | fake@fake.com | wrongpassword | false |

  #map, list, and list of maps