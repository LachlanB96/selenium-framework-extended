Feature: Creates a marqeta user, card product, and card for that user


    Scenario: Create a Marqeta User
      Given I set the environment to "MARQETA_SANDBOX"
      And I create a "CREATE_USER" request with the following
        | @header: contentType  | JSON              |
        | first_name            | Lach              |
        | last_name             | Bro               |
        | address1              | 1234 Grove Street |
        | city                  | Berkeley          |
        | state                 | CA                |
        | country               | USA               |
        | postal_code           | 94702             |
        | @assert: responseCode | 201               |
        | @extract: token       | userTokenVar      |
        | @extract: first_name  | userFirstNameVar  |
      When I send the request off and store the response
      Then I assert and extract the variables

#
#  Scenario: Create a user
#    Given I have initialised the APIHandler for use
#    And I have the following table of field data for the user
#      | first_name  | Marqeta           |
#      | last_name   | Me                |
#      | address1    | 1234 Grove Street |
#      | city        | Berkeley          |
#      | state       | CA                |
#      | country     | USA               |
#      | postal_code | 94702             |
#    When I create the user
#    Then I should get a 201 server response and I store the user token
#
#  Scenario: Create a Card Product
#    Given I have initialised the APIHandler for use
#    And I have the following table of field data for the card product
#      | name        | MarqetaCard |
#      | start_date  | 2021-01-01  |
#    When I create the card product
#    Then I should get a 201 server response and I store the card product token
#
#  Scenario: Create a Card
#    Given I have initialised the APIHandler for use
#    And I have the following table of field data for the card
#      | token | MarqetaCardID |
#    When I create the card
#    Then I should get a 201 server response and I store the card token