Feature: Client Interaction
  As an instructor
  I want to communicate and provide feedback to my clients
  So that I can support their progress and answer their questions

  Scenario: Sending a message to a client
    Given I am logged in as an instructor
    And I have an enrolled client named "Sondos"
    When I type the command "send message to Sondos"
    And I provide the message "Your next session is scheduled for tomorrow at 10 AM."
    Then the system should display "Message sent successfully"

  Scenario: Viewing client messages
    Given I am logged in as an instructor
    When I type the command "view messages from Maha"
    Then I should see all messages from "Maha" displayed in the terminal

  Scenario: Providing feedback
    Given I am logged in as an instructor
    And I have an enrolled client named "Sondos ramadan"
    When I type the command "provide feedback to Sondos "
    And I enter the feedback "Great progress on your strength training, keep it up!"
    Then the system should display "Feedback saved successfully"

  Scenario: Viewing client progress
    Given I am logged in as an instructor
    When I type the command "view progress report for Maha"
    Then the progress report for "Maha" should be displayed in the terminal

  Scenario: Responding to a discussion
    Given I am logged in as an instructor
    When I type the command "respond to discussion Nutrition Tips"
    And I provide the response "Balance protein intake with carbs for better results."
    Then the system should display "Response added successfully"
