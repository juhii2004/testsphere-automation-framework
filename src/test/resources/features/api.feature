@api
Feature: API Testing

  Scenario: Get Users API
    Given user sends GET request to users API
    Then response status should be 200