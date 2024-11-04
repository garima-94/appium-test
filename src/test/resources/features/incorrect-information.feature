@ignore

Feature: To validate the purchase when wrong or no information is passed to screens

  Scenario: To verify purchase should not happen when no credentials have been passed
    When I select "Sauce Labs Backpack" from the product list page
    And I select "Black" bag
    And I tap on "Add to Cart" button on product detail page
    And I tap on checkout basket
    Then I see in my selection of 1 "Sauce Labs Backpack" in my cart
    When I tap on Proceed to Checkout button
    And I enter "" as username and "" as password in the app
    And I tap on login button
    Then I should see error message "Username is required" for username and user should not proceed further
    And I enter "username" as username
    And I tap on login button
    Then I should see error message "Enter password" for password and user should not proceed further

  Scenario: To verify purchase should not happen when no shipping address is provided
    When I select "Sauce Labs Backpack" from the product list page
    And I select "Black" bag
    And I tap on "Add to Cart" button on product detail page
    And I tap on checkout basket
    Then I see in my selection of 1 "Sauce Labs Backpack" in my cart
    When I tap on Proceed to Checkout button
    And I enter "visual@example.com" as username and "10203040" as password in the app
    And I tap on login button
    And I do not pass anything in all the mandatory fields
    And I tap on payment button
    Then I should see error messages for all the required fields and user should not proceed further

  Scenario: To verify purchase should not happen when no payment method is provided
    When I select "Sauce Labs Backpack" from the product list page
    And I select "Black" bag
    And I tap on "Add to Cart" button on product detail page
    And I tap on checkout basket
    Then I see in my selection of 1 "Sauce Labs Backpack" in my cart
    When I tap on Proceed to Checkout button
    And I enter "visual@example.com" as username and "10203040" as password in the app
    And I tap on login button
    And I enter "zilch" as name, "111 Buckingham Palace" as Address Line one, "London" as city, "12345" as Zipcode, "United Kingdom" as Country
    And I tap on payment button
    And I do not pass anything in all the mandatory fields
    And I tap on review order button
    Then I should see error messages for all the required fields and user should not proceed further

