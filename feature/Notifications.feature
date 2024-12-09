Feature: Notifications
  As a system
  I want to notify users about important updates
  So that they stay informed

  Scenario: Sending a schedule change notification
    Given an instructor updates a program schedule
    When the change is saved
    Then all enrolled clients should receive a notification

  Scenario: Announcing a new program
    Given an instructor creates a new program
    When the program is published
    Then all clients should receive a notification about the new program
