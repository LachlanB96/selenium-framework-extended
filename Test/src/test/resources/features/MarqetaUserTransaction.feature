Feature: Test the users card balance

  Scenario:
    Given I have initialised the APIHandler for use
    And I have the following table of field data for the user
      | token | 1406fbe0-197c-4457-a3db-81a21ad46ccd |
    When I make a transaction
    Then my balance should be lower than before