Feature: Integration test

  Scenario: Call an endpoint
    When The client makes a GET request to  "/data/jpa/1"
    Then The HTTP status code should be 200