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

public class ProductDetailsPage {

  AppiumDriver driver;
  MobileActions mobileActions;

  public ProductDetailsPage(AppiumDriver driver) {
    this.driver = driver;
    this.mobileActions = new MobileActions(driver);
    PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(20)), this);
  }

  @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/priceTV")
  @iOSXCUITFindBy(accessibility = "Price")
  private WebElement productPrice;

  @AndroidFindBy(accessibility = "Black color")
  private WebElement color;

  @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton")
  private List<WebElement> colorLists;

  @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartBt")
  @iOSXCUITFindBy(accessibility = "AddToCart")
  private WebElement addToCardBtn;

  @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartCircleRL")
  @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText")
  private WebElement noOfElementsInCart;

  @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartRL")
  @iOSXCUITFindBy(accessibility = "Cart")
  private WebElement checkoutBasket;

  public void tapOnAddToCartBtn() {
    mobileActions.click(addToCardBtn);
  }

  public String getPrice() {
    return mobileActions.getText(productPrice);
  }

  public void selectColor(String colorToBeSelected) {
    if (driver instanceof AndroidDriver) {
      mobileActions.click(color);
    } else {
      colorLists.stream()
          .filter(
              ele -> {
                var text = mobileActions.getAttribute(ele);
                return text != null && text.contains(colorToBeSelected);
              })
          .findFirst()
          .ifPresent(WebElement::click);
    }
  }

  public void tapCheckOutBasket() {
    if (driver instanceof AndroidDriver) {
      mobileActions.click(checkoutBasket);
    } else {
      mobileActions.clickOniOS(checkoutBasket);
    }
  }
}
