Feature: Notifications and Updates
  As a client or instructor, I want to receive notifications and updates so that I stay informed about relevant activities.

  Scenario: Client receives notification about a new program
    Given I am logged in as a client "Hiba"
    When a new program "Yoga for Beginners" is added
    Then I should receive a notification "New program available: Yoga for Beginners"

  Scenario: Instructor receives notification about client enrollment
    Given I am logged in as an instructor "Rasmiya"
    When a client "Hiba" enrolls in the program "Yoga for Beginners"
    Then I should receive a notification "Client Hiba enrolled in Yoga for Beginners"

  Scenario: Client receives notification about program updates
    Given I am logged in as a client "Hiba"
    When the program "Yoga for Beginners" is updated
    Then I should receive a notification "Program updated: Yoga for Beginners"

  Scenario: Instructor receives notification about a client message
    Given I am logged in as an instructor "Rasmiya"
    When the client "Hiba" sends a message "I have a question about my schedule."
    Then I should receive a notification "New message from Hiba: I have a question about my schedule."

  Scenario: Client receives notification about program cancellation
    Given I am logged in as a client "Hiba"
    When the program "Yoga for Beginners" is canceled
    Then I should receive a notification "Program canceled: Yoga for Beginners"
