Feature: Program Management
  As an instructor
  I want to create and manage fitness programs
  So that I can offer services to clients

  Scenario: Adding a new fitness program
    Given I am logged in as an instructor
    When I add a new program with details "Weight Loss Program"+"12345"+"Lose 10kg in 3 months"+"2024/01/01"+"3 months"+"30 sessions"+"true"
    Then the program is added successfully

  Scenario: Adding a program with missing data
    Given I am logged in as an instructor
    When I add a program with missing information "Cardio Program"+"12346"+"High-intensity workout"+"2024/01/01"+"3 months"+"0"+"true"
    Then the program is not added
    And an error message is displayed: "Missing data: Number of sessions cannot be zero"

  Scenario: Updating an existing program
    Given I am logged in as an instructor
    When I update a program with id "12345" and details "Advanced Weight Loss Program"+"12345"+"Lose 15kg in 3 months"+"2024/01/01"+"3 months"+"45 sessions"+"true"
    Then the program is updated successfully

  Scenario: Duplicate program ID
    Given I am logged in as an instructor
    When I attempt to add a program with an existing ID "12345"
    Then an error message is displayed: "Program ID already exists. Please choose a unique ID"

  Scenario: Removing a program
    Given I am logged in as an instructor
    When I remove the program with id "12345"
    Then the program is removed successfully
