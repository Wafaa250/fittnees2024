Feature: Program Exploration and Enrollment
  As a client
  I want to browse and enroll in fitness programs
  So that I can find programs that suit my goals and schedule

  Scenario: Browsing programs by difficulty level
    Given I am a client browsing fitness programs
    When I apply the filter "Difficulty Level: Beginner"
    Then I should see a list of programs with "Beginner" difficulty displayed in the terminal

  Scenario: Browsing programs by focus area
    Given I am a client browsing fitness programs
    When I apply the filter "Focus Area: Weight Loss"
    Then I should see a list of programs focused on "Weight Loss" displayed in the terminal

  Scenario: Browsing programs by difficulty and focus area
    Given I am a client browsing fitness programs
    When I apply the filters "Difficulty Level: Advanced" and "Focus Area: Muscle Building"
    Then I should see a list of programs with "Advanced" difficulty focused on "Muscle Building" displayed in the terminal

  Scenario: Enrolling in a program
    Given I am a client browsing fitness programs
    And I have selected the program "Weight Loss Program"
    When I type the command "enroll in Weight Loss Program"
    Then I should be enrolled in the "Weight Loss Program"
    And the system should display "Enrollment successful"

  Scenario: Viewing the program schedule
    Given I am a client enrolled in the program "Advanced Yoga"
    When I type the command "view schedule for Advanced Yoga"
    Then I should see the schedule for "Advanced Yoga" displayed in the terminal
