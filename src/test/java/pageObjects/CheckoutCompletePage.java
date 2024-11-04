package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import util.MobileActions;

import java.time.Duration;

public class CheckoutCompletePage {

  AppiumDriver driver;
  MobileActions mobileActions;

  public CheckoutCompletePage(AppiumDriver driver) {
    this.driver = driver;
    this.mobileActions = new MobileActions(driver);
    PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(20)), this);
  }

  @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/completeTV")
  @iOSXCUITFindBy(accessibility = "Checkout Complete")
  private WebElement checkoutCompleteText;

  @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/thankYouTV")
  private WebElement thankYouText;

  @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/swagTV")
  @iOSXCUITFindBy(accessibility = "Your new swag is on its way")
  private WebElement swagText;

  @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/orderTV")
  private WebElement dispatchText;

  @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/shoopingBt")
  @iOSXCUITFindBy(accessibility = "ContinueShopping")
  private WebElement continueShoppingBtn;

  @iOSXCUITFindBy(
      accessibility =
          "Thank you for your order. Your order has been dispatched and will arrive as soon as possible!")
  private WebElement thanksText;

  public String getCheckoutCompleteText() {
    if (driver instanceof AndroidDriver) {
      return mobileActions.getText(checkoutCompleteText);
    } else {
      return mobileActions.getAttribute(checkoutCompleteText);
    }
  }

  public String getThankYouText() {
    return mobileActions.getText(thankYouText);
  }

  public String getSwagText() {
    if (driver instanceof AndroidDriver) {
      return mobileActions.getText(swagText);
    } else {
      return mobileActions.getAttribute(swagText);
    }
  }

  public String getDispatchText() {
    return mobileActions.getText(dispatchText);
  }

  public String getThanksText() {
    return mobileActions.getAttribute(thanksText);
  }

  public void tapContinueShoppingBtn() {
    mobileActions.click(continueShoppingBtn);
  }
}
