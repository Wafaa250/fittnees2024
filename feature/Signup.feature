Feature: User Signup

  Scenario: Successful sign-up as Admin
    Given I am on the sign-up page
    When I enter a valid username "wafa"
    And I enter a valid email "wafa01@gmail.com"
    And I enter a valid role "Admin"
    And I enter a valid password "01234"
    And I confirm the password "01234"
    And I click the sign-up button
    Then I should see "Account created successfully for Admin"

  Scenario: Successful sign-up as Instructor
    Given I am on the sign-up page
    When I enter a valid username "rasmiya"
    And I enter a valid email "ras012@gmail.com"
    And I enter a valid role "Instructor"
    And I enter a valid password "01234"
    And I confirm the password "01234"
    And I click the sign-up button
    Then I should see "Account created successfully for Instructor"

  Scenario: Successful sign-up as Client
    Given I am on the sign-up page
    When I enter a valid username "hind"
    And I enter a valid email "hindma1@gmail.com"
    And I enter a valid role "Client"
    And I enter a valid password "01234A"
    And I confirm the password "01234A"
    And I click the sign-up button
    Then I should see "Account created successfully for Client"

  Scenario: Sign-up with invalid email
    Given I am on the sign-up page
    When I enter a valid username "hind"
    And I enter an invalid email "invalidemail.com"
    And I enter a valid role "Client"
    And I enter a valid password "0123"
    And I confirm the password "0123"
    And I click the sign-up button
    Then I should see "Invalid email address"

  Scenario: Passwords do not match
    Given I am on the sign-up page
    When I enter a valid username "jana"
    And I enter a valid email "jana@gmail.com"
    And I enter a valid role "Instructor"
    And I enter a valid password "01234"
    And I confirm the password "0123"
    And I click the sign-up button
    Then I should see "Passwords do not match"

  Scenario: Sign-up with invalid role
    Given I am on the sign-up page
    When I enter a valid username "hala"
    And I enter a valid email "hala123@gmail.com"
    And I enter an invalid role "Chef"
    And I enter a valid password "hala123"
    And I confirm the password "hala123"
    And I click the sign-up button
    Then I should see "Invalid role. Available roles: Admin, Instructor, Client"

  Scenario: Sign-up with already used email
    Given I am on the sign-up page
    When I enter a valid username "hindahmad"
    And I enter an already used email "hindma1@gmail.com"
    And I enter a valid role "Client"
    And I enter a valid password "011123"
    And I confirm the password "011123"
    And I click the sign-up button
    Then I should see "Email address is already in use"

  Scenario: Sign-up with invalid username
    Given I am on the sign-up page
    When I enter an invalid username "kamal@123"
    And I enter a valid email "kamalana@gmail.com"
    And I enter a valid role "Instructor"
    And I enter a valid password "0123kamal"
    And I confirm the password "0123kamal"
    And I click the sign-up button
    Then I should see "Invalid username. It must be alphanumeric and not exceed 15 characters"
