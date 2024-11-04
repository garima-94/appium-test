package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.FileUtil;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Map;

public class BaseDriver {
  protected static AppiumDriver driver;
  private static AppiumDriverLocalService appiumDriverLocalService;
  private static final Logger logger = LoggerFactory.getLogger(BaseDriver.class);

  public static AppiumDriver getDriver() {

    if (driver == null) {
      throw new IllegalStateException("Driver has not been initialized. Call setUp() method first");
    }
    return driver;
  }

  public static AppiumDriver setUp(String platform) throws MalformedURLException {
    startAppiumService();
    Map<String, String> cap = FileUtil.getCap(platform);
    var projectPath = System.getProperty("user.dir");
    if (platform.equalsIgnoreCase("android")) {
      logger.info("Initializing Android Driver");
      UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();
      uiAutomator2Options.setDeviceName(cap.get("deviceName"));
      uiAutomator2Options.setApp(projectPath + cap.get("appPath"));
      uiAutomator2Options.setAppPackage(cap.get("appPackage"));
      uiAutomator2Options.setAppActivity(cap.get("appActivity"));
      driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), uiAutomator2Options);
    } else if (platform.equalsIgnoreCase("ios")) {
      logger.info("Initializing iOS  Driver");
      XCUITestOptions xcuiTestOptions = new XCUITestOptions();
      xcuiTestOptions.setDeviceName(cap.get("deviceName"));
      xcuiTestOptions.setPlatformVersion(cap.get("platformVersion"));
      xcuiTestOptions.setApp(projectPath + cap.get("app"));
      xcuiTestOptions.setWdaLaunchTimeout(Duration.ofSeconds(20));
      xcuiTestOptions.setCapability("autoGrantPermissions", true);
      xcuiTestOptions.setCapability("noReset", true);
      driver = new IOSDriver(new URL("http://127.0.0.1:4723"), xcuiTestOptions);
    }
    logger.info("Driver initialization completed");
    return driver;
  }

  private static void startAppiumService() {
    if (appiumDriverLocalService == null) {
      appiumDriverLocalService =
          new AppiumServiceBuilder()
              .withAppiumJS(
                  new File("//opt//homebrew//lib//node_modules//appium//build//lib//main.js"))
              .withIPAddress("127.0.0.1")
              .usingPort(4723)
              .build();
      appiumDriverLocalService.start();
    }
  }

  public static void tearDown() {
    if (driver != null) {
      if (driver instanceof IOSDriver) {
        try {
          ((IOSDriver) driver).terminateApp("com.saucelabs.mydemo.app.ios");
        } catch (Exception e) {
          logger.info("Error terminating the app");
        }
      }
      driver.quit();
    }
    if (appiumDriverLocalService != null) {
      appiumDriverLocalService.stop();
    }
  }
}
