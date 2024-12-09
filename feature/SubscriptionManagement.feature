Feature: Subscription Management
  As an admin
  I want to manage subscription plans
  So that I can provide better services to clients

  Scenario: Updating subscription pricing
    Given I am logged in as an admin
    When I update the price for the "Premium" plan
    Then the new price should be saved

  Scenario: Approving a subscription upgrade request
    Given I am logged in as an admin
    And a client has requested an upgrade
    When I approve the upgrade
    Then the client's subscription should be updated

  Scenario: Adding a subscription plan
    Given I am logged in as an admin
    When I add a new plan "Elite" with price "200"
    Then the plan should be added

  Scenario: Deleting a subscription plan
    Given I am logged in as an admin
    And the plan "Basic" exists
    When I delete the plan
    Then it should be removed

  Scenario: Viewing subscription plans
    Given I am logged in as an admin
    When I check the subscription list
    Then I should see all available plans

  Scenario: Rejecting a subscription upgrade request
    Given I am logged in as an admin
    And a client has requested an upgrade
    When I reject the upgrade
    Then the client's subscription should stay the same
    And the client should be notified
