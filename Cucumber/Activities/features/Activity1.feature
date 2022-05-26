@Activity1
Feature: Google Search
  Scenario: Performing google search for Cheese
    Given User is on the google home page
    When User types Cheese and hits enter
    Then Show how many search results are shown
    And Close the browser