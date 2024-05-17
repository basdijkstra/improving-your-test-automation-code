@answers
Feature: Ordering a product - answers

  Scenario: Ordering a product - answers
    Given Susie Standard is a Sauce Web Shop user
    When they order the Sauce Labs backpack using
      | firstName | lastName | postalCode |
      | John | Doe | 90210 |
    Then their order is successful