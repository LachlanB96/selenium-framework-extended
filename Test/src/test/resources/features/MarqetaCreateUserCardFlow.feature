Feature: Creates a user, creates a card for that user, adds balance to the card, then removes a payment from card

  Scenario: Create a user
    Given I have initialised the APIHandler for use
    And I have the following table of field data for the user
      | first_name | Lachlan |
      | last_name  | Smith   |
    When I create the user
    Then I should get a 201 server response and I store the user token

  Scenario: Create a Card Product
    Given I have initialised the APIHandler for use
    And I have the following table of field data for the card product
      | name        | LachlanCard |
      | start_date  | 2021-01-01  |
    When I create the card
    Then I should get a 201 server response and I store the card product token