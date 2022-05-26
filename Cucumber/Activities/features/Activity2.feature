@Activity2
Feature: Login Test
  Scenario: Testing login
    Given User is on login page
    When User enters username and password
    Then Read the page title and confirm
    And Close the browser

