Feature: Creates a user, checks if the user exists, then edits the user

  Scenario: Create multiple users
    Given I have initialised the APIHandler
    And I have the following table of field data for the users
      | first_name | last_name |
      | Lachlan    | Smith     |
      | Rob        | Tester    |
      | Stuart     | Brown     |
    When I create the user request
    Then The users should exist

    Scenario: Check if user was created by searching
      Given I have initialised the APIHandler
      And I have the following table of field data for the users
        | first_name | last_name |
        | Lachlan    | Smith     |
        | Rob        | Tester    |
        | Stuart     | Brown     |
      When I search for each user
      Then I should get a valid user in response