package util;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Common {
  private AppiumDriver driver;

  public Common(AppiumDriver driver) {
    this.driver = driver;
  }

  public static long WAIT_TIME = 8000;

  protected void waitForElementToBeDisplayed(WebElement webElement) {
    try {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME));
      wait.until(ExpectedConditions.visibilityOf(webElement));
    } catch (TimeoutException e) {
      System.out.println(
          String.format(
              "Element was not visible within %d seconds: %s", WAIT_TIME, e.getMessage()));
    } catch (Exception e) {
      System.out.println(
          String.format(
              "An error occurred while waiting for the element to be visible: %s", e.getMessage()));
    }
  }

  protected boolean waitForElementToBeDisappear(WebElement element) {
    try {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME));
      return wait.until(ExpectedConditions.invisibilityOf(element));
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return false;
    }
  }
}
