Feature: Progress Tracking
  As a client
  I want to track my fitness progress and achievements
  So that I can stay motivated and monitor my improvements

  Scenario: Tracking personal milestones
    Given I am a client using the fitness tracking system
    And I have recorded my fitness data "Weight: 75kg", "BMI: 24.5", "Attendance: 12 sessions"
    When I type the command "view progress"
    Then I should see my milestones "Weight: 75kg", "BMI: 24.5", "Attendance: 12 sessions" displayed in the terminal

  Scenario: Viewing achievements for completing programs
    Given I am a client who has completed the program "Weight Loss Program"
    When I type the command "view achievements"
    Then I should see my achievement "Badge: Weight Loss Achiever" displayed in the terminal

  Scenario: Receiving badges for completing multiple programs
    Given I am a client who has completed the programs "Weight Loss Program" and "Advanced Yoga"
    When I type the command "view achievements"
    Then I should see my achievements "Badge: Weight Loss Achiever", "Badge: Yoga Expert" displayed in the terminal
