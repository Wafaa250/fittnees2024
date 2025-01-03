package fit;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SubscriptionManagement {

    SubscriptionManagementSource subscription = new SubscriptionManagementSource();
    private boolean addResult;
    private boolean deleteResult;
    private boolean modifyResult;
    private boolean cancelResult;

    // الخطوة "the plan {string} exists"
    @Given("the plan {string} exists")
    public void thePlanExists(String planName) {
        addResult = subscription.addSubscriptionPlan(planName, 100); // 100 هو السعر الافتراضي
        assertTrue(addResult, "The plan was not added successfully.");
    }

    // الخطوة "I add a new plan {string} with price {int}"
    @When("I add a new plan {string} with price {int}")
    public void iAddANewPlanWithPrice(String planName, int price) {
        addResult = subscription.addSubscriptionPlan(planName, price);
    }

    @Then("the plan should be added")
    public void the_plan_should_be_added() {
        assertTrue(addResult, "The plan was not added successfully.");
    }

    // الخطوة "I delete the plan {string}"
    @When("I delete the plan {string}")
    public void iDeleteThePlan(String planName) {
        deleteResult = subscription.deleteSubscriptionPlan(planName);
    }

    @Then("it should be removed")
    public void itShouldBeRemoved() {
        assertTrue(deleteResult, "The plan was not removed successfully.");
    }

    // الخطوة "a client has requested an upgrade"
    @Given("a client has requested an upgrade with email {string}")
    public void aClientHasRequestedAnUpgrade(String email) {
        subscription.requestUpgrade(email);
    }

    // الخطوة "I reject the upgrade"
    @When("I reject the upgrade for client with email {string}")
    public void iRejectTheUpgrade(String email) {
        cancelResult = subscription.rejectSubscriptionUpgrade(email);
    }

    @Then("the client's subscription should stay the same")
    public void theClientSSubscriptionShouldStayTheSame() {
        assertTrue(cancelResult, "The subscription was incorrectly rejected.");
    }

    @Then("the client should be notified")
    public void theClientShouldBeNotified() {
        System.out.println("Client has been notified about the rejection.");
    }
}
