Feature: Instructor Management

  Scenario: Viewing all fitness programs
    Given I am logged in as an instructor
    When I type the command "view programs"
    Then I should see a list of all my active fitness programs displayed in the terminal

  Scenario: Adding a new fitness program
    Given I am logged in as an instructor
    When I type the command "add program" and Entered valid Data "Weight Loss Program"+"4 weeks"+"Cardio"
    Then the new program will be added to the program file

  Scenario: Editing an existing program
    Given I am logged in as an instructor
    And I have an existing program named "Strength Training"
    When I type the command "edit program Strength Training"
    And the admin updates the program details to "Strength Booster"+"6 weeks"+"Advanced Weights"
    And I submit the changes
    Then the program details should be updated in the program file

  Scenario: Deleting a fitness program
    Given I am logged in as an instructor
    And I have an active program named "Yoga Basics"
    When I type the command "delete program Yoga Basics"
    Then the program should be removed from the program file
    And the system should show a message "Program deleted successfully"

  Scenario: Viewing program details
    Given I am logged in as an instructor
    And I have an active program named "Advanced HIIT"
    When I type the command "view details Advanced HIIT"
    Then the system should display all details "Advanced HIIT"+"5 weeks"+"High Intensity"+"Athletes"

  Scenario: Updating a program's target audience
    Given I am logged in as an instructor
    And I have an active program named "Beginner Cardio"
    When I type the command "edit program Beginner Cardio"
    And I update the target audience to "Beginner Cardio"+"Senior Adults"
    Then the system should display a message "Program updated successfully"

  Scenario: Deactivating a program
    Given I am logged in as an instructor
    And I have an active program named "Strength Booster"
    When I type the command "deactivate program Strength Booster"
    Then the program should be moved to the inactive programs file
    And the system should show a message "Program deactivated successfully"
