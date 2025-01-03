Feature: User Sign Up
  As a user, I want to sign up with valid information to access the system.

  Scenario: Successful sign-up
    Given I am on the sign-up page
    When I enter a valid username "Khaled123"
    And I enter a valid email "khaled123@gmail.com"
    And I enter a valid role "Admin"
    And I enter a valid password "Khaled234"
    And I confirm the password "Khaled234"
    And I click the sign-up button
    Then I should see "Account created successfully"

  Scenario: Sign-up with invalid email
    Given I am on the sign-up page
    When I enter a valid username "Ahmed2023"
    And I enter an invalid email "ahmedemail.com"
    And I enter a valid role "Admin"
    And I enter a valid password "Ahmed@1234"
    And I confirm the password "Ahmed@1234"
    And I click the sign-up button
    Then I should see "Email must end with @gmail.com"

  Scenario: Sign-up with invalid password
    Given I am on the sign-up page
    When I enter a valid username "Mohammed123"
    And I enter a valid email "mohammed123@gmail.com"
    And I enter a valid role "Instructor"
    And I enter an invalid password "12345"
    And I confirm the password "12345"
    And I click the sign-up button
    Then I should see "Password must be at least 6 characters long and contain at least one letter"

  Scenario: Passwords do not match
    Given I am on the sign-up page
    When I enter a valid username "Sarah"
    And I enter a valid email "sarah@gmail.com"
    And I enter a valid role "Client"
    And I enter a valid password "Sarah@123"
    And I confirm the password "Sarah@124"
    And I click the sign-up button
    Then I should see "Passwords do not match. Please make sure to confirm correctly"

  Scenario: Sign-up with invalid role
    Given I am on the sign-up page
    When I enter a valid username "JohnDoe"
    And I enter a valid email "johndoe@gmail.com"
    And I enter an invalid role "Chef"
    And I enter a valid password "JohnDoe@123"
    And I confirm the password "JohnDoe@123"
    And I click the sign-up button
    Then I should see "Invalid role. Available roles are: Admin, Instructor, Client, Store Owner"
