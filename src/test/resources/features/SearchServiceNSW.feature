Feature: Search Functionality
  Scenario Outline: Search a service
    Given I already on home page
    And I input "<service>" on search service field
    And I click search service button
    Then should be directed to search result page "<service>"
    When I click Find Location button
    Then should be directed to Service Center page
    When I input "<location>" on search location field
    And I click search location button
    Then search result for location should be appear
    Examples:
    |service|location|
    |apply for a number plate|Sydney Domestic Airport 2020|
