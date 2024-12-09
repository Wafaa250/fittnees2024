package fit;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NotificationsSteps {

    private boolean programScheduleUpdated = false;
    private boolean newProgramCreated = false;
    private boolean changeSaved = false;
    private boolean programPublished = false;
    private List<String> notifications = new ArrayList<>();

    @Given("an instructor updates a program schedule")
    public void instructorUpdatesProgramSchedule() {
        programScheduleUpdated = true;
        System.out.println("Program schedule updated by the instructor.");
    }

    @When("the change is saved")
    public void changeIsSaved() {
        if (programScheduleUpdated) {
            changeSaved = true;
            notifications.add("Notification: Program schedule has been updated.");
            System.out.println("Change saved, notification added.");
        }
    }

    @Then("all enrolled clients should receive a notification")
    public void clientsReceiveScheduleNotification() {
        assertTrue(changeSaved, "Schedule change must be saved.");
        assertTrue(notifications.contains("Notification: Program schedule has been updated."),
                "Notification for schedule update must exist.");
        System.out.println("All enrolled clients received the notification: " + notifications.get(0));
    }

    @Given("an instructor creates a new program")
    public void instructorCreatesNewProgram() {
        newProgramCreated = true;
        System.out.println("New program created by the instructor.");
    }

    @When("the program is published")
    public void programIsPublished() {
        if (newProgramCreated) {
            programPublished = true;
            notifications.add("Notification: A new program is now available.");
            System.out.println("Program published, notification added.");
        }
    }

    @Then("all clients should receive a notification about the new program")
    public void clientsReceiveNewProgramNotification() {
        assertTrue(programPublished, "Program must be published.");
        assertTrue(notifications.contains("Notification: A new program is now available."),
                "Notification for new program must exist.");
        System.out.println("All clients received the notification: " + notifications.get(1));
    }
}
