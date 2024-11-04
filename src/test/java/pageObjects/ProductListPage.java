package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import util.MobileActions;

import java.time.Duration;
import java.util.List;
import java.util.stream.IntStream;

public class ProductListPage {

  AppiumDriver driver;
  MobileActions mobileActions;

  public ProductListPage(AppiumDriver driver) {
    this.driver = driver;
    this.mobileActions = new MobileActions(driver);
    PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(20)), this);
  }

  @AndroidFindBy(
      xpath =
          "//android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/titleTV']")
  @iOSXCUITFindBy(iOSClassChain = "**XCUIElementTypeStaticText[`name == 'Product Name'`]")
  private List<WebElement> productListItemsTitle;

  @AndroidFindBy(
      xpath =
          "//android.widget.ImageView[@resource-id='com.saucelabs.mydemoapp.android:id/productIV']")
  @iOSXCUITFindBy(iOSClassChain = "**XCUIElementTypeImage[`name == 'Product Image'`]")
  private List<WebElement> productImage;

  @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/productTV")
  private WebElement productText;

  @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/menuIV")
  private WebElement productCatalog;

  @AndroidFindBy(
      xpath =
          "//android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/topViewTV']/following-sibling::android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/itemTV']")
  private WebElement catalog;

  public void tapOnProduct(String productName) {
    IntStream.range(0, productListItemsTitle.size())
        .filter(
            i -> {
              String text = null;
              if (driver instanceof AndroidDriver) {
                text = mobileActions.getText(productListItemsTitle.get(i));
              } else if (driver instanceof IOSDriver) {
                text = mobileActions.getAttribute(productListItemsTitle.get(i));
              }
              return text != null && text.equalsIgnoreCase(productName);
            })
        .findFirst()
        .ifPresent(i -> productImage.get(i).click());
  }

  public String getProductText() {

    return mobileActions.getText(productText);
  }

  public void clickOnHamburgerBtn() {
    mobileActions.click(productCatalog);
  }

  public void clickOnCataLog() {
    mobileActions.click(catalog);
  }
}
