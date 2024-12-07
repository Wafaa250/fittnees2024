package fit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginsteps {
    public MyAppT obj;

    public loginsteps(MyAppT oobj) {
        super();
        this.obj = oobj;
    }

    @Given("I am not in system")
    public void iAmNotInSystem() {
        // Ensure the user is not logged in
        assertTrue(obj.isLogedin == false);
    }

    @When("set username {string} and pass {string}")
    public void setUsernameAndPass(String user_name, String pass) {
        // Check if fields are not empty
        if (user_name.isEmpty() || pass.isEmpty()) {
            throw new IllegalArgumentException("Fields cannot be empty");
        }

        // Check if the username and password are valid
        boolean isValid = false;
        for (User u : obj.up) {
            if (user_name.equals(u.getUser_name()) && u.getPass().equals(pass)) {
                isValid = true;
                break;
            }
        }

        // Validate the credentials
        assertTrue("Login failed: Invalid credentials", isValid);
        obj.isLogedin = true; // Update login status on success
    }

    @Then("login succeed")
    public void loginSucceed() {
        // Confirm login success
        assertTrue("Login should be successful", obj.isLogedin);
    }

    @Then("login failed")
    public void loginFailed() {
        // Confirm login failure
        assertFalse("Login should fail", obj.isLogedin);
    }

    @When("set invalid username {string} and pass {string}")
    public void setInvalidUsernameAndPass(String user_name, String pass) {
        // Check if fields are not empty
        if (user_name.isEmpty() || pass.isEmpty()) {
            throw new IllegalArgumentException("Fields cannot be empty");
        }

        // Check if the username and password are invalid
        boolean isValid = false;
        for (User u : obj.up) {
            if (user_name.equals(u.getUser_name()) && u.getPass().equals(pass)) {
                isValid = true;
                break;
            }
        }

        // Validate the credentials
        assertFalse("Login succeeded unexpectedly", isValid);
        obj.isLogedin = false; // Update login status on failure
    }

    @When("set missing username or password")
    public void setMissingUsernameOrPassword() {
        // Simulate missing details
        throw new IllegalArgumentException("Fields cannot be empty");
    }

    @Then("show error message {string}")
    public void showErrorMessage(String errorMessage) {
        // Display error message
        System.out.println("Error: " + errorMessage);
    }
}
