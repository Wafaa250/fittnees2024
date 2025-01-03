package fit;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ProgramMonitoringsteps {

    private ProgramMonitoring programMonitoring;
    private List<ProgramMonitoring.FitnessProgram> popularPrograms;
    private Map<String, Double> revenueReport;
    private Map<String, Integer> attendanceStatistics;
    private Map<String, String> clientProgressReport;
    private Map<String, List<ProgramMonitoring.FitnessProgram>> activeAndCompletedPrograms;
    
    @Given("I am logged in as an admin for program monitoring")
    public void iAmLoggedInAsAnAdminForProgramMonitoring() {
        programMonitoring = new ProgramMonitoring(); // Initialize the ProgramMonitoring system
    }



    @When("I access the program statistics section")
    public void iAccessTheProgramStatisticsSection() {
        popularPrograms = programMonitoring.getPopularPrograms();
    }

    @Then("I should see a list of programs sorted by their popularity based on enrollment")
    public void iShouldSeeAListOfProgramsSortedByTheirPopularityBasedOnEnrollment() {
        assertNotNull(popularPrograms);
        assertEquals("Advanced Cardio", popularPrograms.get(0).getName());
        assertEquals("Strength Training", popularPrograms.get(popularPrograms.size() - 1).getName());
    }

    @When("I select to generate a revenue report")
    public void iSelectToGenerateARevenueReport() {
        revenueReport = programMonitoring.generateRevenueReport();
    }

    @Then("I should receive a detailed report on revenue sorted by program")
    public void iShouldReceiveADetailedReportOnRevenueSortedByProgram() {
        assertNotNull(revenueReport);
        assertEquals(1200.0, revenueReport.get("Yoga Basics"));
        assertEquals(2500.0, revenueReport.get("Advanced Cardio"));
    }

    @When("I access the attendance tracking section")
    public void iAccessTheAttendanceTrackingSection() {
        attendanceStatistics = programMonitoring.getAttendanceStatistics();
    }

    @Then("I should see attendance statistics for each program")
    public void iShouldSeeAttendanceStatisticsForEachProgram() {
        assertNotNull(attendanceStatistics);
        assertEquals(30, attendanceStatistics.get("Yoga Basics"));
        assertEquals(50, attendanceStatistics.get("Advanced Cardio"));
    }

    @When("I choose to generate a progress report for clients")
    public void iChooseToGenerateAProgressReportForClients() {
        clientProgressReport = programMonitoring.generateClientProgressReport();
    }

    @Then("I should receive a report detailing client progress in various programs")
    public void iShouldReceiveAReportDetailingClientProgressInVariousPrograms() {
        assertNotNull(clientProgressReport);
        assertTrue(clientProgressReport.containsKey("Client A"));
        assertEquals("Completed Yoga Basics, Active in Advanced Cardio", clientProgressReport.get("Client A"));
    }

    @When("I look at the current program roster")
    public void iLookAtTheCurrentProgramRoster() {
        activeAndCompletedPrograms = programMonitoring.getActiveAndCompletedPrograms();
    }

    @Then("I should see lists differentiating active from completed programs")
    public void iShouldSeeListsDifferentiatingActiveFromCompletedPrograms() {
        assertNotNull(activeAndCompletedPrograms);
        assertTrue(activeAndCompletedPrograms.containsKey("Active"));
        assertTrue(activeAndCompletedPrograms.containsKey("Completed"));

        List<ProgramMonitoring.FitnessProgram> activePrograms = activeAndCompletedPrograms.get("Active");
        List<ProgramMonitoring.FitnessProgram> completedPrograms = activeAndCompletedPrograms.get("Completed");

        assertEquals(3, activePrograms.size());
        assertEquals(1, completedPrograms.size());

        assertTrue(activePrograms.stream().anyMatch(p -> p.getName().equals("Yoga Basics")));
        assertTrue(completedPrograms.stream().anyMatch(p -> p.getName().equals("Strength Training")));
    }
}
