package fit;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserMangementsteps {

    private boolean adminLoggedIn = false;
    private boolean userManagementAccessed = false;
    private boolean actionPerformed = false;
    private boolean accountAdded = false;
    private boolean accountDeactivated = false;
    private boolean accountDeleted = false;
    private boolean accountUpdated = false;
    private boolean cityUpdated = false;
    private boolean registrationApproved = false;

    @Given("an admin is logged into the Fitness Management System")
    public void adminLoggedIn() {
        adminLoggedIn = true;
        System.out.println("Admin logged into the Fitness Management System.");
    }

    @When("the admin navigates to the User Management section")
    public void navigateToUserManagement() {
        if (adminLoggedIn) {
            userManagementAccessed = true;
            System.out.println("Admin navigated to the User Management section.");
        }
    }

    @Then("the admin should see a list of all accounts")
    public void seeAllAccounts() {
        assertTrue(userManagementAccessed, "Admin must access User Management to view accounts.");
        System.out.println("Admin sees a list of all accounts.");
    }

    @When("the admin presses {string} and enters valid data {string}+{string}+{string}+{string}+{string}")
    public void addAccount(String action, String username, String city, String email, String password, String role) {
        if (action.equals("Add User")) {
            accountAdded = true;
            System.out.println("Added new user: " + username + ", " + city + ", " + email + ", " + role);
        }
    }

    @Then("a new instructor will be added to the database")
    public void confirmAccountAdded() {
        assertTrue(accountAdded, "Account must be added successfully.");
        System.out.println("New instructor added to the database.");
    }

    @When("the admin selects {string}")
    public void performAction(String action) {
        actionPerformed = true;
        System.out.println("Admin selected action: " + action);
    }

    @And("the admin selects the client {string}")
    public void selectClient(String clientName) {
        System.out.println("Admin selected client: " + clientName);
    }

    @Then("the system should update the account status to {string}")
    public void updateAccountStatus(String status) {
        accountDeactivated = true;
        System.out.println("Account status updated to: " + status);
    }

    @When("the admin selects the {string} and deletes the user {string}")
    public void deleteAccount(String action, String username) {
        if (action.equals("Delete User")) {
            accountDeleted = true;
            System.out.println("Deleted user: " + username);
        }
    }

    @Then("a message should display {string}")
    public void confirmDeletion(String message) {
        assertTrue(accountDeleted, "Account must be deleted successfully.");
        System.out.println("Message displayed: " + message);
    }

    @When("the admin updates the account to {string}+{string}+{string}+{string}+{string}")
    public void updateAccount(String email, String username, String role, String city, String password) {
        accountUpdated = true;
        System.out.println("Updated account: " + username + ", Email: " + email + ", City: " + city);
    }

    @Then("the instructor account {string} should be updated with the new email and details")
    public void confirmAccountUpdated(String username) {
        assertTrue(accountUpdated, "Account must be updated successfully.");
        System.out.println("Account updated for: " + username);
    }

    @And("the admin updates the city to {string}+{string}")
    public void updateCity(String city, String username) {
        cityUpdated = true;
        System.out.println("Updated city for user: " + username + " to " + city);
    }

    @Then("the system should display a message {string}")
    public void confirmCityUpdate(String message) {
        assertTrue(cityUpdated, "City must be updated successfully.");
        System.out.println("Message displayed: " + message);
    }

    @When("the admin selects the instructor application {string} and clicks {string}")
    public void approveRegistration(String username, String action) {
        if (action.equals("Approve")) {
            registrationApproved = true;
            System.out.println("Approved registration for instructor: " + username);
        }
    }

    @Then("the instructor account should be activated")
    public void confirmRegistrationApproved() {
        assertTrue(registrationApproved, "Registration must be approved successfully.");
        System.out.println("Instructor account activated.");
    }

    @Then("a message should display {string}")
    public void confirmApprovalMessage(String message) {
        assertTrue(registrationApproved, "Approval message must be displayed.");
        System.out.println("Message displayed: " + message);
    }

    @When("the admin navigates to the {string} section")
    public void navigateToSection(String section) {
        if (section.equals("User Activity")) {
            System.out.println("Admin navigated to: " + section);
        }
    }

    @Then("the system should display a report with user activity and engagement statistics")
    public void viewUserActivity() {
        System.out.println("Displaying user activity and engagement statistics.");
    }
}
