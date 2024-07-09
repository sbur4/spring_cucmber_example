Feature: Send DTO

  @CustomTest
  Scenario: Send DTO
    Given the application is running
    When I send a POST request with the following DTO
      | name | age | lang    |
      | John | 30  | English |
      | John | 30  | Spanish |
    Then the response should have the following DTO
      | name | age | lang    |
      | John | 30  | English |
      | John | 30  | Spanish |