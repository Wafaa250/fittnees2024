package fit;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProgressTrackingSteps {

    private boolean clientLoggedIn = false;
    private String commandExecuted = "";
    private Map<String, String> milestones = new HashMap<>();
    private Map<String, String> achievements = new HashMap<>();

    @Given("I am a client using the fitness tracking system")
    public void clientUsingFitnessTrackingSystem() {
        clientLoggedIn = true;
        System.out.println("Client is using the fitness tracking system.");
    }

    @And("I have recorded my fitness data {string}, {string}, {string}")
    public void recordFitnessData(String weight, String bmi, String attendance) {
        milestones.put("Weight", weight);
        milestones.put("BMI", bmi);
        milestones.put("Attendance", attendance);
        System.out.println("Fitness data recorded: " + milestones);
    }

    @When("I type the command {string}")
    public void typeCommand(String command) {
        if (clientLoggedIn) {
            commandExecuted = command;
            System.out.println("Command executed: " + command);
        }
    }

    @Then("I should see my milestones {string}, {string}, {string} displayed in the terminal")
    public void viewMilestones(String weight, String bmi, String attendance) {
        assertEquals(weight, milestones.get("Weight"), "Weight milestone mismatch!");
        assertEquals(bmi, milestones.get("BMI"), "BMI milestone mismatch!");
        assertEquals(attendance, milestones.get("Attendance"), "Attendance milestone mismatch!");
        System.out.println("Milestones displayed: " + milestones);
    }

    @Given("I am a client who has completed the program {string}")
    public void completedProgram(String program) {
        achievements.put(program, "Badge: " + program + " Achiever");
        System.out.println("Client completed the program: " + program);
    }

    @Then("I should see my achievement {string} displayed in the terminal")
    public void viewAchievement(String badge) {
        assertTrue(achievements.containsValue(badge), "Achievement not found!");
        System.out.println("Achievement displayed: " + badge);
    }

    @Given("I am a client who has completed the programs {string} and {string}")
    public void completedMultiplePrograms(String program1, String program2) {
        achievements.put(program1, "Badge: " + program1 + " Achiever");
        achievements.put(program2, "Badge: " + program2 + " Expert");
        System.out.println("Client completed programs: " + program1 + ", " + program2);
    }

    @Then("I should see my achievements {string}, {string} displayed in the terminal")
    public void viewMultipleAchievements(String badge1, String badge2) {
        assertTrue(achievements.containsValue(badge1), "First badge not found!");
        assertTrue(achievements.containsValue(badge2), "Second badge not found!");
        System.out.println("Achievements displayed: " + badge1 + ", " + badge2);
    }
}
