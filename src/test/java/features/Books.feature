Feature: Inventory API Testing

  Scenario: Get all menu items
    When I send a GET request
    Then the response should contain at least 9 items
    And each item should contain fields "id", "name", "price", "image"

  Scenario: Filter item by id
    When I send a GET request with filter id
    Then the response should contain item with:
      | id    | 3                   |
      | name  | Baked Rolls x 8     |
      | price | $12                |
      | image | baked-rolls.png    |

  Scenario: Add item for non-existent id
    Given I have a new inventory item with id "10", name "Hawaiian", image "hawaiian.png", and price "$14"
    When I send a POST request
    Then the response status code should be 200

  Scenario: Add item with existing id
    Given I have a new inventory item with id "10", name "Hawaiian", image "hawaiian.png", and price "$14"
    When I send a POST request
    Then the response status code should be 400

  Scenario: Add item with missing info
    Given I create a request with missing field "id"
    When I send a POST request
    Then the response status code should be 400 for missing Field
    And the response should contain message "Not all requirements are met"

  Scenario: Validate item added is in inventory
    When I send a GET request
    Then the response should contain item with:
      | id    | 10         |
      | name  | Hawaiian   |
      | price | $14        |
      | image | hawaiian.png |
