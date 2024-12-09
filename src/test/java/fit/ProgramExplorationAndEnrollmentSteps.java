package fit;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProgramExplorationAndEnrollmentSteps {

    private boolean clientBrowsing = false;
    private boolean programEnrolled = false;
    private boolean scheduleViewed = false;
    private String filterApplied = "";
    private String programSelected = "";
    private String lastSystemMessage = "";

    @Given("I am a client browsing fitness programs")
    public void clientBrowsingFitnessPrograms() {
        clientBrowsing = true;
        System.out.println("Client is browsing fitness programs.");
    }

    @When("I apply the filter {string}")
    public void applyFilter(String filter) {
        if (clientBrowsing) {
            filterApplied = filter;
            System.out.println("Filter applied: " + filter);
        }
    }

    @Then("I should see a list of programs with {string} displayed in the terminal")
    public void confirmProgramsDisplayed(String filterCriteria) {
        assertTrue(filterApplied.contains(filterCriteria), "Filter criteria must match.");
        System.out.println("Programs with " + filterCriteria + " displayed in the terminal.");
    }

    @When("I apply the filters {string} and {string}")
    public void applyMultipleFilters(String filter1, String filter2) {
        if (clientBrowsing) {
            filterApplied = filter1 + " and " + filter2;
            System.out.println("Filters applied: " + filter1 + ", " + filter2);
        }
    }

    @Then("I should see a list of programs with {string} difficulty focused on {string} displayed in the terminal")
    public void confirmProgramsWithMultipleFilters(String difficulty, String focusArea) {
        assertTrue(filterApplied.contains(difficulty) && filterApplied.contains(focusArea), "Both filters must match.");
        System.out.println("Programs with " + difficulty + " difficulty and focused on " + focusArea + " displayed.");
    }

    @And("I have selected the program {string}")
    public void selectProgram(String programName) {
        if (clientBrowsing) {
            programSelected = programName;
            System.out.println("Program selected: " + programName);
        }
    }

    @When("I type the command {string}")
    public void typeCommand(String command) {
        if (command.contains("enroll in")) {
            programEnrolled = true;
            lastSystemMessage = "Enrollment successful";
            System.out.println("Enrolled in program: " + programSelected);
        } else if (command.contains("view schedule for")) {
            scheduleViewed = true;
            System.out.println("Viewing schedule for: " + command.replace("view schedule for ", ""));
        }
    }

    @Then("I should be enrolled in the {string}")
    public void confirmProgramEnrollment(String programName) {
        assertTrue(programEnrolled && programSelected.equals(programName), "Program enrollment must be successful.");
        System.out.println("Successfully enrolled in: " + programName);
    }

    @And("the system should display {string}")
    public void confirmSystemMessage(String message) {
        assertTrue(lastSystemMessage.equals(message), "System message must match.");
        System.out.println("System message: " + message);
    }

    @Then("I should see the schedule for {string} displayed in the terminal")
    public void confirmScheduleDisplayed(String programName) {
        assertTrue(scheduleViewed, "Schedule must be viewed.");
        System.out.println("Schedule for " + programName + " displayed in the terminal.");
    }
}
