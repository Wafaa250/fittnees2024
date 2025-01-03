Feature: User Login

  Scenario: Successful login with valid details
    Given the user is on the login page
    When the user enters valid username and password "Wafaa"+"N002"
    And the user clicks the login button
    Then the user should be redirected to the dashboard


  Scenario: Unsuccessful login with invalid details
    Given the user is on the login page
    When the user enters an invalid username or password "Rasmiya"+"0000"
    And the user clicks the login button
    Then the user should see an error message indicating incorrect credentials

  Scenario: Unsuccessful login with missing details
    Given the user is on the login page
    When the user leaves the username or password field empty
    And the user clicks the login button
    Then the user should see an error message indicating that all fields are required
