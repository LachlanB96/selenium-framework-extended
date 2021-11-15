#Feature: To test passing cucumber feature files and step defs
#
#  Scenario Outline: Test if I can pass a data table
#    Given I have the following table of names and initials
#      | Lachlan Brown | LB |
#      | John Smith    | JS |
#      | Test User     | TU |
#    When I search for a name by "LB" "<x>" "<y>"
#    Then I should get the name Lachlan Brown
#    Examples:
#      | x | y |
#      | 1 | 2 |
#      | 3 | 4 |
#
#  Scenario Outline: Buy clothes if they are cheap enough
#    Given I have the following table of clothes and prices
#      | Shirt | $25.50 |
#      | Pants | $50.10 |
#      | Hat   | $9.99  |
#    When I search for a item to buy "<itemToBuy>"
#    And If my lowest price "<lowestPrice>" is less than the cost price
#    Then I should be able to buy the item
#    Examples:
#      | itemToBuy | lowestPrice |
#      | Shirt | $30 |
#      | Shirt | $25 |
#      | Pants | $40 |
#      | Jumper | $40 |
#
#
#
#  Scenario Outline: Find numbers in list
#    Given I have the following list of numbers
#      | 1 | 2 | 3 | 40 | 50 | 600 |
#    When I add "<x>"
#    * I add another "<x>"
#    Then I should get a number from the given data table
#    Examples:
#      | x |
#      | 0 |
#      | 1 |
#      | 3 |
#      | 5 |
#      | 597 |
#
