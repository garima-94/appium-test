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

public class LoginPage {

  AppiumDriver driver;
  MobileActions mobileActions;

  public LoginPage(AppiumDriver driver) {
    this.driver = driver;
    this.mobileActions = new MobileActions(driver);
    PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(20)), this);
  }

  @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/nameET")
  @iOSXCUITFindBy(iOSNsPredicate = "type == \"XCUIElementTypeTextField\"")
  private WebElement usernameText;

  @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/passwordET")
  @iOSXCUITFindBy(iOSNsPredicate = "type == \"XCUIElementTypeSecureTextField\"")
  private WebElement passwordText;

  @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/loginBtn")
  @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Login\"`]")
  private WebElement loginBtn;

  @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"bob@example.com\"`]")
  private WebElement userNamePassword;

  @iOSXCUITFindBy(accessibility = "Passwords")
  private WebElement keyBoardPassword;

  public void enterUsername(String username) {
    mobileActions.sendKeys(usernameText, username);
  }

  public void enterPassword(String password) {
    mobileActions.sendKeys(passwordText, password);
  }

  public void tapLogin() {
    if (driver instanceof AndroidDriver) {
      mobileActions.click(loginBtn);
    } else {
      mobileActions.click(keyBoardPassword);
      if (mobileActions.isNotDisplayed(keyBoardPassword)) {
        mobileActions.click(loginBtn);
      }
    }
  }
}
