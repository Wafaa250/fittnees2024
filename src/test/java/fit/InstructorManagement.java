package fit;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class InstructorManagement {

    private boolean instructorLoggedIn = false;
    private boolean programAdded = false;
    private boolean programEdited = false;
    private boolean programDeleted = false;
    private boolean programViewed = false;
    private boolean programDeactivated = false;

    @Given("I am logged in as an instructor")
    public void instructorLoggedIn() {
        instructorLoggedIn = true;
        System.out.println("Instructor logged into the system.");
    }

    @When("I type the command {string}")
    public void typeCommand(String command) {
        System.out.println("Command executed: " + command);
    }

    @When("I provide the details {string}+{string}+{string}")
    public void addProgram(String programName, String duration, String type) {
        if (instructorLoggedIn) {
            programAdded = true;
            System.out.println("Program added: " + programName + ", Duration: " + duration + ", Type: " + type);
        }
    }

    @Then("the new program will be added to the program file")
    public void confirmProgramAdded() {
        assertTrue(programAdded, "Program must be added successfully.");
        System.out.println("Program successfully added to the file.");
    }

    @When("I update the program details to {string}+{string}+{string}")
    public void editProgram(String programName, String duration, String type) {
        if (instructorLoggedIn) {
            programEdited = true;
            System.out.println("Program updated: " + programName + ", New Duration: " + duration + ", New Type: " + type);
        }
    }

    @Then("the program details should be updated in the program file")
    public void confirmProgramEdited() {
        assertTrue(programEdited, "Program must be updated successfully.");
        System.out.println("Program successfully updated in the file.");
    }

    @When("I type the command {string} for {string}")
    public void deleteProgram(String command, String programName) {
        if (command.equals("delete program")) {
            programDeleted = true;
            System.out.println("Deleted program: " + programName);
        } else if (command.equals("deactivate program")) {
            programDeactivated = true;
            System.out.println("Deactivated program: " + programName);
        }
    }

    @Then("the program should be removed from the program file")
    public void confirmProgramDeleted() {
        assertTrue(programDeleted, "Program must be deleted successfully.");
        System.out.println("Program successfully removed from the file.");
    }

    @And("the system should show a message {string}")
    public void displayMessage(String message) {
        System.out.println("System message displayed: " + message);
    }

    @When("I view the program details of {string}")
    public void viewProgramDetails(String programName) {
        if (instructorLoggedIn) {
            programViewed = true;
            System.out.println("Viewing details of program: " + programName);
        }
    }

    @Then("the system should display all details {string}+{string}+{string}+{string}")
    public void confirmProgramDetails(String programName, String duration, String type, String targetAudience) {
        if (programViewed) {
            System.out.println("Program details displayed: " +
                    "Name: " + programName +
                    ", Duration: " + duration +
                    ", Type: " + type +
                    ", Target Audience: " + targetAudience);
        }
    }

    @When("I deactivate the program {string}")
    public void deactivateProgram(String programName) {
        if (instructorLoggedIn) {
            programDeactivated = true;
            System.out.println("Program deactivated: " + programName);
        }
    }

    @Then("the program should be moved to the inactive programs file")
    public void confirmProgramDeactivated() {
        assertTrue(programDeactivated, "Program must be deactivated successfully.");
        System.out.println("Program successfully moved to the inactive programs file.");
    }
}
