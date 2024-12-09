Feature: User Management
  As an admin
  I want to manage user accounts
  So that I can ensure system integrity and activity

  Scenario: Admin views all accounts
    Given an admin is logged into the Fitness Management System
    When the admin navigates to the User Management section
    Then the admin should see a list of all accounts

  Scenario: Admin adds a new instructor
    Given an admin is logged into the Fitness Management System
    When the admin presses "Add User"
    And the admin enters valid data "Ali"+"nablus"+"ali123@gmail.com"+"001"+"Instructor"
    Then a new instructor will be added to the database

  Scenario: Admin deactivates a client account
    Given an admin is logged into the Fitness Management System
    And a client account exists
    When the admin selects "Deactivate User"
    And the admin selects the client "hind"
    Then the system should update the account status to "Inactive"
    And a message should display "Account deactivated successfully"

  Scenario: Admin deletes an instructor account
    Given an admin is logged into the Fitness Management System
    When the admin selects "Delete User"
    And the admin selects the instructor account "Ali"
    Then the system should delete the account from the database
    And a message should display "Account deleted successfully"

  Scenario: Admin edits a user account
    Given an admin is logged into the Fitness Management System
    When the admin selects "Edit User"
    And the admin updates the account with "Ahmed@gmail.com"+"Ahmed"+"Instructor"+"jenin"+"A123"
    And the admin submits the changes
    Then the instructor account "Ahmed" should be updated with the new email and details

  Scenario: Admin edits a user's city
    Given an admin is in the User Management section
    When the admin selects "Edit User"
    And the admin updates the city to "Hebron"+"C789"
    Then the system should display a message "City updated successfully"
 
 Scenario: Admin approves a new instructor registration
  Given an admin is logged into the Fitness Management System
  When the admin navigates to the "Pending Registrations" section
  And the admin selects the instructor application "Amani"
  And the admin clicks "Approve"
  Then the instructor account should be activated
  And a message should display "Instructor registration approved"
  
  
  Scenario: Admin views user activity and statistics
  Given an admin is logged into the Fitness Management System
  When the admin navigates to the "User Activity" section
  Then the system should display a report with user activity and engagement statistics
  