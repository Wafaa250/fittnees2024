Feature: Client Interaction
  As an instructor, I want to interact with my clients to provide feedback and progress updates.

  Scenario: Sending a message to a client
    Given I am logged in as an instructor "Rasmiya"
    And I select the client "Hiba"
    When I send a message "Great progress this week! Keep it up!"
    Then the client "Hiba" should receive the message "Great progress this week! Keep it up!"

  Scenario: Viewing client messages
    Given I am logged in as an instructor "Rasmiya"
    And I select the client "Hiba"
    When I view the messages from the client
    Then I should see the client messages

  Scenario: Providing feedback to a client
    Given I am logged in as an instructor "Rasmiya"
    And I select the client "Hiba"
    When I provide feedback "You need to focus more on consistency in your training."
    Then the client "Hiba" should receive the feedback "You need to focus more on consistency in your training."

  Scenario: Viewing client progress
    Given I am logged in as an instructor "Rasmiya"
    And I select the client "Hiba"
    When I view the client progress
    Then I should see the progress details for "Hiba"

  Scenario: Responding to a discussion
    Given I am logged in as an instructor "Rasmiya"
    And I select the discussion with the client "Hiba"
    When I respond to the discussion with "I will adjust the program as needed."
    Then the client "Hiba" should see the response "I will adjust the program as needed."
