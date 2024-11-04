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

public class CheckoutPage {

  AppiumDriver driver;
  MobileActions mobileActions;

  public CheckoutPage(AppiumDriver driver) {
    this.driver = driver;
    this.mobileActions = new MobileActions(driver);
    PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(20)), this);
  }

  @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/removeBt")
  @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Remove Item\"`]")
  private WebElement removeItm;

  @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartBt")
  @iOSXCUITFindBy(accessibility = "ProceedToCheckout")
  private WebElement proceedToCheckoutBtn;

  @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/titleTV")
  @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText")
  private WebElement productTitle;

  @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/priceTV")
  @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText")
  private WebElement productPrice;

  @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/colorIV")
  @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText")
  private WebElement productColor;

  @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/noTV")
  private WebElement productCount;

  @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText")
  private List<WebElement> productVal;

  @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/totalPriceTV")
  @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText")
  private WebElement totalPrice;

  @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/itemsTV")
  @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText")
  private WebElement totalItems;

  public void tapOnProceedToCheckoutBtn() {
    mobileActions.click(proceedToCheckoutBtn);
  }

  public String getProductName(String name) {
    if (driver instanceof AndroidDriver) {
      return mobileActions.getText(productTitle);
    } else {
      return getItemVal(productVal, name);
    }
  }

  public String getProductPrice(String price) {
    if (driver instanceof AndroidDriver) {
      return mobileActions.getText(productPrice);
    } else {
      return getItemVal(productVal, price);
    }
  }

  public String getProductCount(String count) {
    if (driver instanceof AndroidDriver) {
      return mobileActions.getText(productCount);
    } else {
      return getItemVal(productVal, count);
    }
  }

  public String getProductColor(String color) {
    if (driver instanceof AndroidDriver) {
      return mobileActions.getText(productColor);
    } else {
      return getItemVal(productVal, color);
    }
  }

  public String getTotalPrice(String price) {
    if (driver instanceof AndroidDriver) {
      return mobileActions.getText(totalPrice);
    } else {
      return getItemVal(productVal, price);
    }
  }

  public String getTotalItems(String items) {
    if (driver instanceof AndroidDriver) {
      return mobileActions.getText(totalItems);
    } else {
      return getItemVal(productVal, items);
    }
  }

  private String getItemVal(List<WebElement> webElementList, String count) {
    return webElementList.stream()
        .filter(ele -> mobileActions.getAttribute(ele).equals(count))
        .map(ele -> mobileActions.getAttribute(ele))
        .findFirst()
        .orElse(null);
  }
}
