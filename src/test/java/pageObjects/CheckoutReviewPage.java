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
import java.util.List;

public class CheckoutReviewPage {
  AppiumDriver driver;
  MobileActions mobileActions;

  public CheckoutReviewPage(AppiumDriver driver) {
    this.driver = driver;
    this.mobileActions = new MobileActions(driver);
    PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(20)), this);
  }

  @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/paymentBtn")
  @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Place Order\"`]")
  private WebElement placeOrderBtn;

  @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/totalAmountTV")
  private WebElement totalAmount;

  @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText")
  private List<WebElement> productVal;

  public void tapOnPlaceOrderBtn() {
    mobileActions.click(placeOrderBtn);
  }

  public String getTotalAmount(String amount) {
    if (driver instanceof AndroidDriver) {
      return mobileActions.getText(totalAmount);
    } else {
      return productVal.stream()
          .filter(
              ele -> {
                var text = mobileActions.getAttribute(ele);
                return text != null && text.equals(amount.replace(" ", ""));
              })
          .map(ele -> mobileActions.getAttribute(ele))
          .findFirst()
          .orElse(null);
    }
  }
}
