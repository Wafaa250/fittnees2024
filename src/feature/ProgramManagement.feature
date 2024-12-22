Feature: Program Management
  As an instructor, I want to manage fitness programs to offer personalized services to my clients.

  Scenario: Create a new fitness program successfully
    Given I am logged in as an instructor "Rasmiya"
    And I navigate to the "Create Program" page
    When I enter a valid program title "Yoga for Beginners"
    And I enter a duration of "4 weeks"
    And I define the goals as "Improve flexibility and reduce stress"
    And I set the price to "$50"
    And I save the program
    Then I should see a message "Program created successfully"

  Scenario: Edit an existing fitness program
    Given I am logged in as an instructor "Rasmiya"
    And I navigate to the "Manage Programs" page
    And I select the program "Yoga for Beginners"
    When I update the duration to "6 weeks"
    And I change the price to "$75"
    And I save the changes
    Then I should see a message "Program updated successfully"

  Scenario: Delete an existing fitness program
    Given I am logged in as an instructor "Rasmiya"
    And I navigate to the "Manage Programs" page
    And I select the program "Yoga for Beginners"
    When I click the delete button
    And I confirm the deletion
    Then I should see a message "Program deleted successfully"

  Scenario: Attempt to create a program without a title
    Given I am logged in as an instructor "Rasmiya"
    And I navigate to the "Create Program" page
    When I leave the program title field empty
    And I try to save the program
    Then I should see an error message "Program title is required"

  Scenario: Non-instructor trying to manage programs
    Given I am logged in as a client "Hiba"
    When I try to navigate to the "Manage Programs" page
    Then I should see a message "Access denied. Only instructors can manage programs"
