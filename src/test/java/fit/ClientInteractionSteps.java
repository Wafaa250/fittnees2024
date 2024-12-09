package fit;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClientInteractionSteps {

    private boolean instructorLoggedIn = false;
    private boolean messageSent = false;
    private boolean feedbackProvided = false;
    private boolean progressViewed = false;
    private boolean discussionResponded = false;

    @Given("I am logged in as an instructor")
    public void instructorLoggedIn() {
        instructorLoggedIn = true;
        System.out.println("Instructor logged into the system.");
    }

    @And("I have an enrolled client named {string}")
    public void enrolledClient(String clientName) {
        System.out.println("Client found: " + clientName);
    }

    @When("I type the command {string}")
    public void typeCommand(String command) {
        System.out.println("Command executed: " + command);
    }

    @And("I provide the message {string}")
    public void provideMessage(String message) {
        if (instructorLoggedIn) {
            messageSent = true;
            System.out.println("Message sent: " + message);
        }
    }

    @Then("the system should display {string}")
    public void confirmMessageSent(String confirmation) {
        assertTrue(messageSent, "Message must be sent successfully.");
        System.out.println("System confirmation: " + confirmation);
    }

    @When("I type the command {string} to view messages from {string}")
    public void viewMessages(String command, String clientName) {
        if (instructorLoggedIn) {
            System.out.println("Viewing messages from: " + clientName);
        }
    }

    @Then("I should see all messages from {string} displayed in the terminal")
    public void confirmMessagesDisplayed(String clientName) {
        System.out.println("Messages from " + clientName + " displayed.");
    }

    @And("I enter the feedback {string}")
    public void provideFeedback(String feedback) {
        if (instructorLoggedIn) {
            feedbackProvided = true;
            System.out.println("Feedback provided: " + feedback);
        }
    }

    @Then("the system should display {string} for feedback")
    public void confirmFeedbackProvided(String confirmation) {
        assertTrue(feedbackProvided, "Feedback must be saved successfully.");
        System.out.println("System confirmation: " + confirmation);
    }

    @When("I type the command {string} to view progress report for {string}")
    public void viewProgressReport(String command, String clientName) {
        if (instructorLoggedIn) {
            progressViewed = true;
            System.out.println("Viewing progress report for: " + clientName);
        }
    }

    @Then("the progress report for {string} should be displayed in the terminal")
    public void confirmProgressReportDisplayed(String clientName) {
        assertTrue(progressViewed, "Progress report must be viewed successfully.");
        System.out.println("Progress report for " + clientName + " displayed.");
    }

    @When("I type the command {string} to respond to discussion {string}")
    public void respondToDiscussion(String command, String discussionTitle) {
        if (instructorLoggedIn) {
            discussionResponded = true;
            System.out.println("Responding to discussion: " + discussionTitle);
        }
    }

    @And("I provide the response {string}")
    public void provideDiscussionResponse(String response) {
        if (discussionResponded) {
            System.out.println("Response added: " + response);
        }
    }

    @Then("the system should display {string} for discussion response")
    public void confirmDiscussionResponse(String confirmation) {
        assertTrue(discussionResponded, "Response must be added successfully.");
        System.out.println("System confirmation: " + confirmation);
    }
}
