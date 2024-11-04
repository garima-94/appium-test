package stepDefs;

import base.BaseDriver;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import util.AppiumUtil;

import java.net.MalformedURLException;

public class Hooks {

  private static AppiumDriver driver;
  private static AppiumUtil appiumUtil;

  @Before
  public static void setUp() throws MalformedURLException {
    String platform = System.getProperty("platform");
    driver = BaseDriver.setUp(platform);
    appiumUtil = new AppiumUtil(driver);
  }

  @After
  public void tearDown(Scenario scenario) {
    if (scenario.isFailed()) {
      appiumUtil.takeScreenshot(scenario);
    }
    BaseDriver.tearDown();
  }
}
