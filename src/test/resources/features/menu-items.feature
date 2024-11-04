@ignore

Feature: To test the hamburger menu items

  Scenario: To test the Webview from the app
    Given I open the hamburger menu of the app
    When I click on Webview from the menu
    And I enter the website url
    And I tap on the Go to site button
    Then I see see a webpage is open in the app

  Scenario: To test the webview when wrong url has been entered
    Given I open the hamburger menu of the app
    When I click on Webview from the menu
    And I enter wrong website url
    Then I should see error message as "Please provide correct https url"

  Scenario: To test the QR scanner
    Given I open the hamburger menu of the app
    When I click on QR code scanner from the menu
    Then I see native pop up asking for camera permissions
    When I select "only this time"
    Then I should see the image

  Scenario: To test the QR scanner when permission is denied
    Given I open the hamburger menu of the app
    When I click on QR code scanner from the menu
    Then I see native pop up asking for camera permissions
    When I select "Don't allow"
    Then I should not see the image

  Scenario: To test the QR scanner when permission is accepted forever
    Given I open the hamburger menu of the app
    When I click on QR code scanner from the menu
    Then I see native pop up asking for camera permissions
    When I select "While using the app"
    Then I should see the image
