Feature: Is it Friday yet?
  As a regular weekday worker
  I want to know if it's Friday yet
  So that I can look forward to the weekend

  @SmokeTest
  Scenario Outline: Today is or is not Friday // to start press here
    Given today is "<day>"
    When I ask whether it's Friday yet
    Then I should be told "<response>"

    Examples:
      | day            | response |
      | Friday         | Yes      |
      | Sunday         | Nope     |
      | anything else! | Nope     |