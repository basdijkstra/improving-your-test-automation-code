Feature: Ordering a product

  Scenario: Ordering a product
    Given I am on the Sauce Web Shop login page
    When I log in with username standard_user and password secret_sauce
    And I add the Sauce Labs backpack to my shopping cart
    And I open the shopping cart
    And I go to the checkout page
    And I complete the order using
    | firstName | lastName | postalCode |
    | John | Doe | 90210 |
    Then I see "Thank you for your order!" as a confirmation message
