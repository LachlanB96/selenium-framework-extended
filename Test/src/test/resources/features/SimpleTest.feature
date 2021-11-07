Feature: Login
  # Background: find examples and use

  Scenario: Test cucumber tests
    Given A string containing "123"
    When I check if the given string is 123
    Then Cucumber tests are working

  Scenario Outline: Test cucumber scenario outline tests
    Given A value of <a>
    And And a value of <b>
    When I compare the value of a + b it should be <sum>
    Then We compare if sum was the desired output of "<outcome>"
    Examples:
      | a | b | sum | outcome |
      | 1 | 2 | 3   | true    |
      | 3 | 2 | 4   | false   |
      | 4 | 5 | 9   | true    |