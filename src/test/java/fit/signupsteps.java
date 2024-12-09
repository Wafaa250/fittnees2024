package fit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

public class signupsteps {
    public MyAppT obj;

    public signupsteps(MyAppT iobj) {
        super();
        this.obj = iobj;
    }

    @Given("I am on the sign-up page")
    public void iAmOnTheSignUpPage() {
        // Ensure the user is not logged in and is on the signup page
        assertFalse("User should not be logged in initially", obj.isLogedin);
        System.out.println("User is on the sign-up page.");
    }

    @When("I enter a valid username {string}")
    public void iEnterAValidUsername(String username) {
        obj.Username = username;
        System.out.println("Entered username: " + username);
    }

    @When("I enter a valid email {string}")
    public void iEnterAValidEmail(String email) {
        obj.Email = email;
        System.out.println("Entered email: " + email);
    }

    @When("I enter a valid role {string}")
    public void iEnterAValidRole(String role) {
        obj.Role = role;
        System.out.println("Entered role: " + role);
    }

    @When("I enter a valid password {string}")
    public void iEnterAValidPassword(String password) {
        obj.Password = password;
        System.out.println("Entered password: " + password);
    }

    @When("I confirm the password {string}")
    public void iConfirmThePassword(String confirmPassword) {
        obj.ConfirmPassword = confirmPassword;
        System.out.println("Confirmed password: " + confirmPassword);
    }

    @When("I click the sign-up button")
    public void iClickTheSignUpButton() {
        // Validation logic for signup
        if (obj.Username == null || obj.Username.isEmpty()) {
            obj.signupMessage = "Invalid username. It must be alphanumeric and not exceed 15 characters";
        } else if (!obj.Email.contains("@") || !obj.Email.contains(".")) {
            obj.signupMessage = "Invalid email address";
        } else if (!obj.Role.equalsIgnoreCase("Admin") &&
                   !obj.Role.equalsIgnoreCase("Instructor") &&
                   !obj.Role.equalsIgnoreCase("Client")) {
            obj.signupMessage = "Invalid role. Available roles: Admin, Instructor, Client";
        } else if (!obj.Password.equals(obj.ConfirmPassword)) {
            obj.signupMessage = "Passwords do not match";
        } else if (obj.usedEmails.contains(obj.Email)) {
            obj.signupMessage = "Email address is already in use";
        } else {
            obj.usedEmails.add(obj.Email);
            obj.signupMessage = "Account created successfully for " + obj.Role;
            obj.isLogedin = true;
        }
    }

    @Then("I should see {string}")
    public void iShouldSee(String expectedMessage) {
        assertEquals("Signup message does not match", expectedMessage, obj.signupMessage);
        System.out.println("Displayed message: " + obj.signupMessage);
    }
}
