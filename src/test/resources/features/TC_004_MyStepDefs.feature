Feature: Search Functionality feature

  In order to check the functional search
  I need to search for multiple topics



  @search
  Scenario Outline: Topic search
    Given I open wikipedia page
    When I search for <country>
    Then I'm on page of <country>

  Examples:
    | country |
    | Uganda   |
    | Brazil  |
    | Egypt   |


