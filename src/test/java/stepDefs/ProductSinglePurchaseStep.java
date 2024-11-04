package stepDefs;

import base.BaseDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.*;
import util.MobileActions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductSinglePurchaseStep {

  private PageObjectManager pageObjectManager;
  private ProductListPage productListPage;
  private ProductDetailsPage productDetailsPage;
  private CheckoutPage checkoutPage;
  private CheckoutAddressPage checkoutAddressPage;
  private CheckoutPaymentPage checkoutPaymentPage;
  private CheckoutReviewPage checkoutReviewPage;
  private LoginPage loginPage;
  private CheckoutCompletePage checkoutCompletePage;
  private MobileActions mobileActions;

  public ProductSinglePurchaseStep() {
    pageObjectManager = new PageObjectManager(BaseDriver.getDriver());
    productListPage = pageObjectManager.getProductListPage();
    productDetailsPage = pageObjectManager.getProductDetailsPage();
    checkoutPage = pageObjectManager.getCheckoutPage();
    checkoutAddressPage = pageObjectManager.getCheckoutAddressPage();
    checkoutPaymentPage = pageObjectManager.getCheckoutPaymentPage();
    checkoutReviewPage = pageObjectManager.getCheckoutReviewPage();
    loginPage = pageObjectManager.getLogin();
    checkoutCompletePage = pageObjectManager.getCheckoutCompletePage();
    mobileActions = new MobileActions(BaseDriver.getDriver());
  }

  @Given("I am on the {string} page of the demo app")
  public void iAmOnTheProductPageOfTheDemoApp(String text) {
    var productText = productListPage.getProductText();
    assertThat(productText)
        .withFailMessage(
            "Expected result: %s, doesn't match with actual result: %s", text, productText)
        .isEqualTo(text);
  }

  @When("I select {string} from the product list page")
  public void iSelectFromTheProductListPage(String productName) {
    productListPage.tapOnProduct(productName);
  }

  @And("I select {string} bag")
  public void iSelectBag(String color) {
    productDetailsPage.selectColor(color);
  }

  @And("I tap on {string} button on product detail page")
  public void iTapOnButtonOnProductDetailPage(String arg0) {
    productDetailsPage.tapOnAddToCartBtn();
  }

  @And("I tap on checkout basket")
  public void iTapOnCheckoutBasket() {
    productDetailsPage.tapCheckOutBasket();
  }

  @Then("I see in my selection of {int} {string} in my cart")
  public void iSeeInMySelectionOfOfColorInMyCart(int count, String name) {
    var actualCount = checkoutPage.getProductCount(String.valueOf(count));
    var actualName = checkoutPage.getProductName(name);
    assertAll(
        "validating product before checkout",
        () -> assertEquals(count, Integer.parseInt(actualCount), "Count mismatch"),
        () -> assertEquals(name, actualName, " Product name mismatch"));
  }

  @When("I tap on Proceed to Checkout button")
  public void iTapOnProceedToCheckoutButton() {
    checkoutPage.tapOnProceedToCheckoutBtn();
  }

  @And("I enter {string} as username and {string} as password in the app")
  public void iEnterAsUsernameAndAsPasswordInTheApp(String username, String password) {
    loginPage.enterUsername(username);
    loginPage.enterPassword(password);
  }

  @And("I tap on login button")
  public void iTapOnLoginButton() {
    loginPage.tapLogin();
  }

  @And(
      "I enter {string} as name, {string} as Address Line one, {string} as city, {string} as Zipcode, {string} as Country")
  public void iEnterAsNameAsAddressLineAsCityAsZipcodeAsCountry(
      String fullName, String addressLineOne, String city, String zipcode, String country) {
    checkoutAddressPage.enterFullName(fullName);
    checkoutAddressPage.enterAddressLineOne(addressLineOne);
    checkoutAddressPage.enterCity(city);
    checkoutAddressPage.enterZipCode(zipcode);
    checkoutAddressPage.enterCountry(country);
  }

  @And("I tap on payment button")
  public void iTapOnPaymentButton() {
    checkoutAddressPage.tapToPaymentBtn();
  }

  @And(
      "I enter {string} as name, {string} as card number, {string} as Expiration, {string} as security code")
  public void iEnterAsNameAsCardNumberAsExpirationAsSecurityCode(
      String fullName, String cardNumber, String expiration, String cvv) {
    checkoutPaymentPage.enterFullName(fullName);
    checkoutPaymentPage.enterCardNum(cardNumber);
    checkoutPaymentPage.enterExpiration(expiration);
    checkoutPaymentPage.enterCvv(cvv);
  }

  @And("I tap on review order button")
  public void iTapOnReviewOrderButton() {
    checkoutPaymentPage.tapOnReviewOrderBtn();
  }

  @And("I see price, after adding delivery charge of {string} has been changed to {string}")
  public void iSeePriceAfterAddingDeliveryChargeOfHasBeenChangedTo(
      String deliveryPrice, String finalPrice) {
    var actualTotalPrice = checkoutReviewPage.getTotalAmount(finalPrice);
    if (BaseDriver.getDriver() instanceof IOSDriver) {
      finalPrice = finalPrice.replace(" ", "");
    }
    assertThat(finalPrice)
        .withFailMessage(
            "Expected Price: %s, doesn't match with actual price: %s", finalPrice, actualTotalPrice)
        .isEqualTo(actualTotalPrice);
  }

  @And("I tap on Place order")
  public void iTapOnPlaceOrder() {
    checkoutReviewPage.tapOnPlaceOrderBtn();
  }

  @Then("I see my order is placed by verifying text")
  public void iSeeMyOrderIsPlacedByVerifyingBelowText(DataTable dataTable) {
    var messages = dataTable.asList(String.class);
    if (BaseDriver.getDriver() instanceof AndroidDriver) {
      assertAll(
          "Validation successful purchase",
          () -> assertEquals(messages.get(1), checkoutCompletePage.getCheckoutCompleteText()),
          () -> assertEquals(messages.get(2), checkoutCompletePage.getThankYouText()),
          () -> assertEquals(messages.get(3), checkoutCompletePage.getSwagText()),
          () -> assertEquals(messages.get(4), checkoutCompletePage.getDispatchText()));
    } else {
      assertAll(
          "Validating purchase order",
          () -> assertEquals(messages.get(3), checkoutCompletePage.getSwagText()),
          () -> assertEquals(messages.get(5), checkoutCompletePage.getThanksText()),
          () -> assertEquals(messages.get(1), checkoutCompletePage.getCheckoutCompleteText()));
    }
  }

  @And("I navigate to product list screen")
  public void iNavigateToProductListScreen() {
    productListPage.clickOnHamburgerBtn();
    productListPage.clickOnCataLog();
  }
}
