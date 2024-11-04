package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class IncorrectInformationStep {
    @Then("I should see error message {string} for username and user should not proceed further")
    public void iShouldSeeErrorMessageForUsernameAndUserShouldNotProceedFurther(String arg0) {
    }

    @And("I enter {string} as username")
    public void iEnterAsUsername(String arg0) {
    }

    @Then("I should see error message {string} for password and user should not proceed further")
    public void iShouldSeeErrorMessageForPasswordAndUserShouldNotProceedFurther(String arg0) {
    }

    @And("I do not pass anything in all the mandatory fields")
    public void iDoNotPassAnythingInAllTheMandatoryFields() {
    }

    @Then("I should see error messages for all the required fields and user should not proceed further")
    public void iShouldSeeErrorMessagesForAllTheRequiredFieldsAndUserShouldNotProceedFurther() {
    }
}
