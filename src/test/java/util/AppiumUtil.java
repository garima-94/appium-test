package util;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class AppiumUtil {
  private AppiumDriver driver;

  public AppiumUtil(AppiumDriver driver) {
    this.driver = driver;
  }

  public void takeScreenshot(Scenario scenario) {
    var screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    scenario.attach(screenshot, "image/png", scenario.getName());
  }
}
