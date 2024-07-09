Feature: ReportsController

  Scenario: Send message
    Given the application is running
    When I send a GET request with message "hello"
    Then the response should be "hello"