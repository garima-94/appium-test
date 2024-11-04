package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import util.MobileActions;

import java.time.Duration;

public class CheckoutPaymentPage {
  AppiumDriver driver;
  MobileActions mobileActions;

  public CheckoutPaymentPage(AppiumDriver driver) {
    this.driver = driver;
    this.mobileActions = new MobileActions(driver);
    PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(20)), this);
  }

  @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/nameET")
  @iOSXCUITFindBy(iOSNsPredicate = "value == \"Maxim Winter\"")
  private WebElement fullNameTextBox;

  @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cardNumberET")
  @iOSXCUITFindBy(iOSNsPredicate = "value == \"3258 1265 7568 7896\"")
  private WebElement cardNumTextBox;

  @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/expirationDateET")
  @iOSXCUITFindBy(iOSNsPredicate = "value == \"03/25\"")
  private WebElement expirationTextBox;

  @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/securityCodeET")
  @iOSXCUITFindBy(iOSNsPredicate = "value == \"123\"")
  private WebElement securityTextBox;

  @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/paymentBtn")
  @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Review Order\"`]")
  private WebElement reviewOrderBtn;

  public void enterFullName(String name) {
    mobileActions.sendKeys(fullNameTextBox, name);
  }

  public void enterCardNum(String cardNum) {
    mobileActions.sendKeys(cardNumTextBox, cardNum);
  }

  public void enterExpiration(String expiration) {
    mobileActions.sendKeys(expirationTextBox, expiration);
  }

  public void enterCvv(String cvv) {
    mobileActions.sendKeys(securityTextBox, cvv);
  }

  public void tapOnReviewOrderBtn() {
    mobileActions.click(reviewOrderBtn);
  }
}
