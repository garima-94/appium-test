package pageObjects;

import io.appium.java_client.AppiumDriver;

public class PageObjectManager {
  private AppiumDriver driver;
  private ProductListPage productListPage;
  private ProductDetailsPage productDetailsPage;
  private CheckoutPage checkoutPage;
  private CheckoutAddressPage checkoutAddressPage;
  private CheckoutPaymentPage checkoutPaymentPage;
  private CheckoutReviewPage checkoutReviewPage;
  private LoginPage loginPage;
  private CheckoutCompletePage checkoutCompletePage;

  public PageObjectManager(AppiumDriver driver) {
    this.driver = driver;
  }

  public ProductListPage getProductListPage() {
    if (productListPage == null) {
      productListPage = new ProductListPage(driver);
    }
    return productListPage;
  }

  public ProductDetailsPage getProductDetailsPage() {
    if (productDetailsPage == null) {
      productDetailsPage = new ProductDetailsPage(driver);
    }
    return productDetailsPage;
  }

  public CheckoutPage getCheckoutPage() {
    if (checkoutPage == null) {
      checkoutPage = new CheckoutPage(driver);
    }
    return checkoutPage;
  }

  public CheckoutAddressPage getCheckoutAddressPage() {
    if (checkoutAddressPage == null) {
      checkoutAddressPage = new CheckoutAddressPage(driver);
    }
    return checkoutAddressPage;
  }

  public CheckoutPaymentPage getCheckoutPaymentPage() {
    if (checkoutPaymentPage == null) {
      checkoutPaymentPage = new CheckoutPaymentPage(driver);
    }
    return checkoutPaymentPage;
  }

  public CheckoutReviewPage getCheckoutReviewPage() {
    if (checkoutReviewPage == null) {
      checkoutReviewPage = new CheckoutReviewPage(driver);
    }
    return checkoutReviewPage;
  }

  public LoginPage getLogin() {
    if (loginPage == null) {
      loginPage = new LoginPage(driver);
    }
    return loginPage;
  }

  public CheckoutCompletePage getCheckoutCompletePage() {
    if (checkoutCompletePage == null) {
      checkoutCompletePage = new CheckoutCompletePage(driver);
    }
    return checkoutCompletePage;
  }
}
