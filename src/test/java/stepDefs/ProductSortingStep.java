package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSortingStep {
  @When("I tap on the sorting icon on the top corner")
  public void iTapOnTheSortingIconOnTheTopCorner() {}

  @Given("I am on the products list page of the app")
  public void iAmOnTheProductsListPageOfTheApp() {}

  @And("I select {string} from the drop down")
  public void iSelectFromTheDropDown(String arg0) {}

  @Then("I see all the products have been sorted in ascending order by name")
  public void iSeeAllTheProductsHaveBeenSortedInAscendingOrderByName() {}

  @Then("I see all the products have been sorted in descending order by name")
  public void iSeeAllTheProductsHaveBeenSortedInDescendingOrderByName() {}

  @Then("I see all the products have been sorted in ascending order by price")
  public void iSeeAllTheProductsHaveBeenSortedInAscendingOrderByPrice() {}

  @Then("I see all the products have been sorted in descending order by price")
  public void iSeeAllTheProductsHaveBeenSortedInDescendingOrderByPrice() {}
}
