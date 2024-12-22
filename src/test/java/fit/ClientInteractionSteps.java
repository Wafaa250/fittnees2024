package fit;

import io.cucumber.java.en.*;
import static org.junit.Assert.*;

import java.util.List;

public class ClientInteractionSteps {

    private String result;
    private List<String> messages;
    private String feedback;
    private String progress;

    @Given("I select the client {string}")
    public void iSelectTheClient(String clientName) {
        // Simulate selecting a client (validation is optional here)
        System.out.println("Selected client: " + clientName);
    }

    @When("I send a message {string}")
    public void iSendAMessage(String message) {
        result = ClientInteraction.sendMessage("Rasmiya", "Hiba", message);
    }

    @Then("the client {string} should receive the message {string}")
    public void theClientShouldReceiveTheMessage(String clientName, String expectedMessage) {
        messages = ClientInteraction.viewMessages(clientName);
        assertTrue("Message received by client", messages.contains("From Rasmiya: " + expectedMessage));
    }

    @When("I view the messages from the client")
    public void iViewTheMessagesFromTheClient() {
        messages = ClientInteraction.viewMessages("Hiba");
    }

    @Then("I should see the client messages")
    public void iShouldSeeTheClientMessages() {
        assertNotNull("Client messages should not be null", messages);
        System.out.println("Messages: " + messages);
    }

    @When("I provide feedback {string}")
    public void iProvideFeedback(String feedbackMessage) {
        result = ClientInteraction.provideFeedback("Hiba", feedbackMessage);
    }

    @Then("the client {string} should receive the feedback {string}")
    public void theClientShouldReceiveTheFeedback(String clientName, String expectedFeedback) {
        feedback = ClientInteraction.viewFeedback(clientName);
        assertEquals("Feedback received by client", expectedFeedback, feedback);
    }

    @When("I view the client progress")
    public void iViewTheClientProgress() {
        progress = ClientInteraction.viewProgress("Hiba");
    }

    @Then("I should see the progress details for {string}")
    public void iShouldSeeTheProgressDetailsFor(String clientName) {
        assertNotNull("Progress details should not be null", progress);
        System.out.println("Progress for " + clientName + ": " + progress);
    }

    @When("I respond to the discussion with {string}")
    public void iRespondToTheDiscussionWith(String response) {
        result = ClientInteraction.sendMessage("Rasmiya", "Hiba", response);
    }

    @Then("the client {string} should see the response {string}")
    public void theClientShouldSeeTheResponse(String clientName, String expectedResponse) {
        messages = ClientInteraction.viewMessages(clientName);
        assertTrue("Response received by client", messages.contains("From Rasmiya: " + expectedResponse));
    }
    
    @Given("I select the discussion with the client {string}")
    public void iSelectTheDiscussionWithTheClient(String clientName) {
        // Simulate selecting a discussion with the client
        List<String> messages = ClientInteraction.viewMessages(clientName);
        if (messages.isEmpty()) {
            throw new IllegalArgumentException("No discussion found with the client: " + clientName);
        } else {
            System.out.println("Selected discussion with client: " + clientName);
            System.out.println("Messages: " + messages);
        }
    }

}
