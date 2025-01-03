Feature: Subscription Management
  As an admin
  I want to manage subscription plans
  So that I can provide better services to clients

  Scenario: Adding a subscription plan
    Given I am logged in as an admin
    When I add a new plan "Elite" with price 200
    Then the plan should be added

  Scenario: Deleting a subscription plan
    Given I am logged in as an admin
    And the plan "Basic" exists
    When I delete the plan "Basic"
    Then it should be removed

  Scenario: Rejecting a subscription upgrade request
    Given I am logged in as an admin
    And a client has requested an upgrade with email "client@gmail.com"
    When I reject the upgrade for client with email "client@gmail.com"
    Then the client's subscription should stay the same
    And the client should be notified
