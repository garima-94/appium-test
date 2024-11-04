package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MenuItemsStep {
  @Then("I see native pop up asking for camera permissions")
  public void iSeeNativePopUpAskingForCameraPermissions() {}

  @Given("I open the hamburger menu of the app")
  public void iOpenTheHamburgerMenuOfTheApp() {}

  @When("I click on Webview from the menu")
  public void iClickOnWebviewFromTheMenu() {}

  @And("I enter the website url")
  public void iEnterTheWebsiteUrl() {}

  @And("I tap on the Go to site button")
  public void iTapOnTheGoToSiteButton() {}

  @Then("I see see a webpage is open in the app")
  public void iSeeSeeAWebpageIsOpenInTheApp() {}

  @And("I enter wrong website url")
  public void iEnterWrongWebsiteUrl() {}

  @Then("I should see error message as {string}")
  public void iShouldSeeErrorMessageAs(String arg0) {}

  @When("I click on QR code scanner from the menu")
  public void iClickOnQRCodeScannerFromTheMenu() {}

  @When("I select {string}")
  public void iSelect(String arg0) {}

  @Then("I should see the image")
  public void iShouldSeeTheImage() {}

  @Then("I should not see the image")
  public void iShouldNotSeeTheImage() {}
}
