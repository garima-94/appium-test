package util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;

public class MobileActions {

  private AppiumDriver driver;
  private Common commonBehavior;

  public MobileActions(AppiumDriver driver) {
    this.driver = driver;
    this.commonBehavior = new Common(driver);
  }

  public void hideKeyboard() {
    if (driver instanceof AndroidDriver) {
      ((AndroidDriver) driver).hideKeyboard();
    } else if (driver instanceof IOSDriver) {
      ((IOSDriver) driver).hideKeyboard();
    } else {
      throw new UnsupportedOperationException("Keyboard hiding not supported for this driver");
    }
  }

  public void click(WebElement webElement) {
    commonBehavior.waitForElementToBeDisplayed(webElement);
    webElement.click();
  }

  public void sendKeys(WebElement webElement, String text) {
    commonBehavior.waitForElementToBeDisplayed(webElement);
    webElement.sendKeys(text);
  }

  public String getText(WebElement webElement) {
    commonBehavior.waitForElementToBeDisplayed(webElement);
    return webElement.getText();
  }

  public String getAttribute(WebElement webElement) {
    return webElement.getAttribute("label");
  }

  public Boolean isDisplayed(WebElement webElement) {
    commonBehavior.waitForElementToBeDisplayed(webElement);
    return webElement.isDisplayed();
  }

  public boolean isNotDisplayed(WebElement element) {
    return commonBehavior.waitForElementToBeDisappear(element);
  }

  public void clickOniOS(WebElement element) {
    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
    int centerX = element.getLocation().getX() + (element.getSize().getWidth() / 2);
    int centerY = element.getLocation().getY() + (element.getSize().getHeight() / 2);

    Sequence tap = new Sequence(finger, 1);
    tap.addAction(
        finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, centerY));
    tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
    tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

    driver.perform(Arrays.asList(tap));
  }
}
