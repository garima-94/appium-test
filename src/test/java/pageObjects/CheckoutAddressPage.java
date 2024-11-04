package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import util.MobileActions;

import java.time.Duration;

public class CheckoutAddressPage {
  AppiumDriver driver;
  MobileActions mobileActions;

  public CheckoutAddressPage(AppiumDriver driver) {
    this.driver = driver;
    this.mobileActions = new MobileActions(driver);
    PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(20)), this);
  }

  @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/fullNameET")
  @iOSXCUITFindBy(iOSNsPredicate = "value == \"Rebecca Winter\"")
  private WebElement fullNameTextBox;

  @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/address1ET")
  @iOSXCUITFindBy(iOSNsPredicate = "value == \"Mandorley 112\"")
  private WebElement addressLineOneTextBox;

  @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/address2ET")
  @iOSXCUITFindBy(iOSNsPredicate = "value == \"Entrance 1\"")
  private WebElement addressLineTwoTextBox;

  @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cityET")
  @iOSXCUITFindBy(iOSNsPredicate = "value == \"Truro\"")
  private WebElement cityTextBox;

  @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/zipET")
  @iOSXCUITFindBy(iOSNsPredicate = "value == \"89750\"")
  private WebElement zipCodeTextBox;

  @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/countryET")
  @iOSXCUITFindBy(iOSNsPredicate = "value == \"United Kingdom\"")
  private WebElement countryTextBox;

  @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/paymentBtn")
  @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"To Payment\"`]")
  private WebElement toPaymentBtn;

  public void enterFullName(String fullName) {
    mobileActions.sendKeys(fullNameTextBox, fullName);
  }

  public void enterAddressLineOne(String addressLineOne) {
    mobileActions.sendKeys(addressLineOneTextBox, addressLineOne);
  }

  public void enterAddressLineTwo(String addressLineTwo) {
    mobileActions.sendKeys(addressLineTwoTextBox, addressLineTwo);
  }

  public void enterCity(String city) {
    mobileActions.sendKeys(cityTextBox, city);
  }

  public void enterZipCode(String zipCode) {
    mobileActions.sendKeys(zipCodeTextBox, zipCode);
  }

  public void enterCountry(String country) {
    mobileActions.sendKeys(countryTextBox, country);
  }

  public void tapToPaymentBtn() {
    mobileActions.click(toPaymentBtn);
  }
}
