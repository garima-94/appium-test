@ignore

Feature: To test the sorting feature of the products

  Scenario: To test the successful sorting by name in ascending order
    Given I am on the products list page of the app
    When I tap on the sorting icon on the top corner
    And I select "Name Ascending" from the drop down
    Then I see all the products have been sorted in ascending order by name

  Scenario: To test the successful sorting by name in descending order
    Given I am on the products list page of the app
    When I tap on the sorting icon on the top corner
    And I select "Name Descending" from the drop down
    Then I see all the products have been sorted in descending order by name

  Scenario: To test the successful sorting by price in ascending order
    Given I am on the products list page of the app
    When I tap on the sorting icon on the top corner
    And I select "Price Ascending" from the drop down
    Then I see all the products have been sorted in ascending order by price

  Scenario: To test the successful sorting by price in descending order
    Given I am on the products list page of the app
    When I tap on the sorting icon on the top corner
    And I select "Price Descending" from the drop down
    Then I see all the products have been sorted in descending order by price