Feature: To test passing cucumber feature files and step defs

  Scenario Outline: Test if I can pass a data table
    Given I have the following table of names and initials
      | Lachlan Brown | LB |
      | John Smith    | JS |
      | Test User     | TU |
    When I search for a name by "LB" "<x>" "<y>"
    Then I should get the name Lachlan Brown
    Examples:
      | x | y |
      | 1 | 2 |
      | 3 | 4 |

