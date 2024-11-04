@purchase

Feature: To test the product purchase flow

  Scenario: To test successful purchase of a product
#    Given I am on the "Products" page of the demo app
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
    And I enter "zilch" as name, "4567239812374569" as card number, "03/25" as Expiration, "123" as security code
    And I tap on review order button
    And I see price, after adding delivery charge of "$ 5.99" has been changed to "$ 35.98"
    And I tap on Place order
    Then I see my order is placed by verifying text
      | successful text                                                                               |
      | Checkout Complete                                                                             |
      | Thank you for your order                                                                      |
      | Your new swag is on its way                                                                   |
      | Your order has been dispatched and will arrive as fast as the pony gallops!                   |
      | Thank you for your order. Your order has been dispatched and will arrive as soon as possible! |


